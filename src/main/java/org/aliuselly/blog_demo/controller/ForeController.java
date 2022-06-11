package org.aliuselly.blog_demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.aliuselly.blog_demo.dto.ArticleCommentDto;
import org.aliuselly.blog_demo.dto.ArticleDto;
import org.aliuselly.blog_demo.dto.ArticleWithPictureDto;
import org.aliuselly.blog_demo.entity.ArticleComment;
import org.aliuselly.blog_demo.entity.CategoryInfo;
import org.aliuselly.blog_demo.entity.Comment;
import org.aliuselly.blog_demo.service.ArticleService;
import org.aliuselly.blog_demo.service.CategoryService;
import org.aliuselly.blog_demo.service.CommentService;
import org.aliuselly.blog_demo.util.Markdown2HtmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 前台控制器
 */
@RestController
@RequestMapping("/api")
public class ForeController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;

    /*
    这里主要用于测试的，注意啊
    现在导入了 thymeleaf 了，因此呢，如果 templates 文件夹下
    有一个 error.html 那么全部错误都会过去的
    而 error 文件夹中则是对应的错误码进行编写的
    @GetMapping("/test")
    public String test()
    {
        int i = 1 / 0;
        return "hello";
    }
    */

    /**
     * 获取所有文章列表
     * @return
     */
    @ApiOperation("获取所有文章")
    @GetMapping("/article/list")
    public List<ArticleWithPictureDto> listAllArticleInfo()
    {
        return articleService.listAll();
    }

    /**
     * 获取某一个分类下的所有文章
     * @param id
     * @return
     */
    @ApiOperation("获取某一个分类下的所有文章")
    @ApiImplicitParam(name = "id", value = "分类 ID", required = true, dataType = "Long")
    @GetMapping("/article/list/category/{id}")
    public List<ArticleWithPictureDto> listArticleInfo(@PathVariable Long id)
    {
        return articleService.listByCategoryId(id);
    }

    /**
     * 获取最新的文章
     * @return
     */
    @ApiOperation("获取最新的几篇文章")
    @GetMapping("/article/list/last")
    public List<ArticleWithPictureDto> listLastArticle()
    {
        return articleService.listLast();
    }

    /**
     * 通过文章 ID 获取对应的文章信息，注意，这里的 content 是转为 html 格式的了，admin 那边的是 md 源码形式的
     * @param id
     * @return
     */
    @ApiOperation("通过文章 ID 获取文章信息")
    @ApiImplicitParam(name = "id", value = "文章 ID", required = true, dataType = "Long")
    @GetMapping("/article/{id}")
    public ArticleDto getArticleById(@PathVariable Long id)
    {
        ArticleDto articleDto = articleService.getOneById(id);
        articleDto.setContent(Markdown2HtmlUtil.markdown2Html(articleDto.getContent()));
        return articleDto;
    }

    /**
     * 获取所有分类信息
     * @return
     */
    @ApiOperation("获取所有分类信息")
    @GetMapping("/category/list")
    public List<CategoryInfo> listAllCategoryInfo()
    {
        return categoryService.listAllCategory();
    }

    /**
     * 获取所有的留言信息
     * @return
     */
    @ApiOperation("获取所有的留言信息")
    @GetMapping("/comment/list")
    public List<Comment> listAllComment()
    {
        return commentService.listAllComment();
    }

    /**
     * 获取评论，但这些评论中不包含文章中的评论，仅仅用于评论整个博客的评论
     * @return
     */
    @GetMapping("/comment/common")
    public List<Comment> listNoArticleComment() {
        List<Comment> comments = commentService.listAllComment();
        List<ArticleComment> articleComments = commentService.listAllArticleComment();
        /*
        * 这里使用 noneMatch 匹配，注意，所有的 comment 都会与 articleComment 进行匹配的
        * noneMatch 表示，如果是 articleComments 中没有的就会返回 true，返回就会被 filter 过滤到了
        *
        * 任意匹配，不要使用 allMatch 是表示全部都要符合条件的，noneMatch 没有符合条件的，anyMatch 是任意符合条件的
        * 如果使用 anyMatch，则表示只要 articleComment 中的即可，除非你在其的前面加上 ! 非即可
        *
        * 这里用 anyMatch 吧，比较好理解，表示任意匹配上的，然后 ！就行了
        * 用 noneMatch 也是可以的，表示没有匹配的才是返回 true
        * */
        List<Comment> result = comments.stream().filter(comment -> !articleComments.stream().anyMatch(articleComment -> articleComment.getCommentId().equals(comment.getId()))).collect(Collectors.toList());
        return result;
    }

    /**
     * 通过文章 ID 获取某一篇文章的评论信息
     * @param id
     * @return
     */
    @ApiOperation("获取某一篇文章的评论信息")
    @ApiImplicitParam(name = "id", value = "文章 ID", required = true, dataType = "Long")
    @GetMapping("/comment/article/{id}")
    public List<ArticleCommentDto> listMessageByArticleId(@PathVariable Long id)
    {
//        注意，这里主要将有效的给查询出来的，如果无效的，那么是不会进行装填的
        return commentService.listAllArticleCommentById(id);
    }

    /**
     * 给文章增加一条评论信息
     * @param id
     * @param articleCommentDto
     * @param request
     * @return
     */
    @ApiOperation("给文章中增加一条评论信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章 ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "content", value = "评论信息", required = true, dataType = "String"),
            @ApiImplicitParam(name = "email", value = "Email 地址，用于回复", required = false, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "用户自定义的名称", required = true, dataType = "String")
    })
    @PostMapping("/comment/article/{id}")
    public String addArticleComment(@PathVariable Long id, @RequestBody ArticleCommentDto articleCommentDto, HttpServletRequest request)
    {
        String ip = request.getRemoteAddr();
        articleCommentDto.setIp(ip);
        articleCommentDto.setArticleId(id);

        commentService.addArticleComment(articleCommentDto);
        return "文章评论成功！";
    }

    @ApiOperation("增加一条留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content", value = "评论信息", required = true, dataType = "String"),
            @ApiImplicitParam(name = "email", value = "Email 地址，用于回复", required = false, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "用户自定义的名称", required = true, dataType = "String")
    })
    @PostMapping("/comment")
    public String addMessage(@RequestBody Comment comment, HttpServletRequest request)
    {
        String ip = request.getRemoteAddr();
        comment.setIp(ip);
        commentService.addComment(comment);

        return "留言成功！";
    }
}
