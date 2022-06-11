package org.aliuselly.blog_demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.aliuselly.blog_demo.config.UserConfig;
import org.aliuselly.blog_demo.dto.ArticleDto;
import org.aliuselly.blog_demo.entity.CategoryInfo;
import org.aliuselly.blog_demo.entity.Comment;
import org.aliuselly.blog_demo.entity.User;
import org.aliuselly.blog_demo.service.ArticleService;
import org.aliuselly.blog_demo.service.CategoryService;
import org.aliuselly.blog_demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 后台控制器
 */
@RestController
@RequestMapping("/admin")
// 由于在拦截器那边是 sesion 获取的，因此呢，这里通过注解与 session 同步
@SessionAttributes("user")
public class BackstageController extends UserConfig {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CategoryService categoryService;

//    后台登录帐号密码
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";

    /**
     * 注意，POST 请求的 405 和 get 请求的 404 是差不多的，都是找不到页面
     * 搞了大半天，终于明白了
     * 这个 view 视图类呢，默认是返回 forward 的，但是呢，由于默认的前缀的问题
     * 他们已经被更改了
     * 就是引入 thy 之类的后，没有引入默认也是其他类型的前缀，但是，可以通过 mvc.prefix 进行修改
     * 如果想要静态与动态页面结合，那么，默认返回视图的时候就是使用动态的
     * 但是呢，想要返回静态页面的话，就是可以使用 redirect: xxxx 即可了
     * 同时呢，要注意的是，是返回视图，不是请求 url，视图名是里面要有的，就是 html文件
     * 所以呢，不是 url 的视图，那个是地址
     *
     * 不过呢，如果引入了 thy，那么视图的配置选项，thy 的配置就会优先的了，因此呢，要去改 thy 的配置
     *
     * 弄了一下午，sb 了，视图呢，如果要获取服务端的数据呢，才是使用视图进行返回的
     * 但是呢，我们现在返回静态页面啊，根本就不需要视图，直接访问即可，即服务器通过重定向即可了
     * 但是呢，有一些需要服务端数据的，直接将其变为视图进行返回即可，所以，我一开始的思考方向错了
     * 想要不想将静态页面变为视图，让其是静态的访问，还想让其有服务端的数据，那么只能够通过 ajax 之类的访问了
     * 不过呢，是静态的
     *
     * @param user
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @PostMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request, HttpServletResponse response, @SessionAttribute(value = "requestPath", required = false) String requestPath) throws IOException {
//        如果没有写视图名，那么默认就是该 url 下的视图名
        ModelAndView mv = new ModelAndView("login");
        if (USERNAME.equals(user.getUsername()) && PASSWORD.equals(user.getPassword()))
        {
            if (requestPath != null)
            {
//            获取从拦截器截取到的 uri，注意啊，在方法上写了 @sessionAttribute，默认是 require = true 的
//            但是呢，经过拦截器肯定有数据，没有经过，肯定没有，因此呢，这里为了 /toLogin 的安全，就 false 了
//            同时呢，这个注解是获取 session 中的数据的

//            接下来是猜测
//            同时呢，注意啊，可能是 mv 的问题，boot 应用没了以后，他也没了，因此，里边的数据可能就清除了，因此，其是同步到 session 那边的，因此呢，mv 也会将关联的数据也清除的吧
//            但是呢，拦截器，是直接通过 request 的 session 方式来设置的，因此呢，当服务器重启了，但是呢，浏览器觉得之前的 session 还在，还是访问同一个网站，因此呢，直接使用原本的 session 进行访问
//            所以呢，里面还有之前残留的数据，这里的 requestPath 就是这样的问题，先访问 admin/index.html 重启服务器后
//            访问 toLogin 明明没有经过拦截器，里边却有上一次访问的数据
                mv.setViewName("redirect:" + requestPath);
                request.getSession().removeAttribute("requestPath");
            }
            else
            {
                mv.setViewName("redirect:/admin/index.html");
            }
            mv.addObject("user", user);
        }
        else
        {
            mv.addObject("msg", "用户名或密码不正确！");
        }
        return mv;
    }



//    =============================文章=============================

    @ApiOperation("增加一篇文章")
    @ApiImplicitParams({@ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
                        @ApiImplicitParam(name = "summary", value = "文章简介", required = true, dataType = "String"),
                        @ApiImplicitParam(name = "isTop", value = "文章是否置顶", required = true, dataType = "Boolean"),
                        @ApiImplicitParam(name = "categoryId", value = "文章分类对应 ID", required = true, dataType = "Long"),
                        @ApiImplicitParam(name = "content", value = "文章 md 源码", required = true, dataType = "String"),
                        @ApiImplicitParam(name = "pictureUrl", value = "文章题图 Url", required = true, dataType = "String")
    })
    @PostMapping("/article")
    public String addArticle(@RequestBody ArticleDto articleDto)
    {
        articleService.addArticle(articleDto);
//        return null;
        return "添加文章成功！";
    }

    /**
     * 删除一篇文章
     * @param id
     * @return
     */
    @ApiOperation("删除一篇文章")
    @ApiImplicitParam(name = "id", value = "文章 ID", required = true, dataType = "Long")
    @DeleteMapping("/article/{id}")
    public String deleteArticle(@PathVariable Long id)
    {
//        这里也可能有问题，因为呢，仅仅删除了文章分类关联表，但是，并没有对分类信息的数量进行删减
//        同时呢，里面删除的时候呢，会对要删除的文章先进行访问量 + 1,因为调用了 getOneById 方法
//        把问题解决了，让其数量 - 1
        articleService.deleteArticleById(id);
//        这里还是有问题的，文章删除了，但是呢，留言怎么办
//        虽然评论列表确实没有了，系统管理页面会显示所有的评论，到时候这条数据岂不是很什么？
//        分类问题也是，如果分类删除了，那么这个分类下面的所有评论岂不是都没用了？所以呢，这里也是个逻辑错误
//        不过，先不改了

        return "删除文章成功！";
    }

    /**
     * 编辑/更新一篇文章
     * 同时，PathVariable 注解呢，默认不写 name 的值就是对应参数上的，要一样
     *
     * @param id
     * @param articleDto
     * @return
     */
    @ApiOperation("编辑/更新一篇文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "summary", value = "文章简介", required = true, dataType = "String"),
            @ApiImplicitParam(name = "isTop", value = "文章是否置顶", required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "categoryId", value = "文章分类对应 ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "content", value = "文章 md 源码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pictureUrl", value = "文章题图 Url", required = true, dataType = "String")
    })
    @PutMapping("/article/{id}")
    public String updateArticle(@PathVariable Long id, @RequestBody ArticleDto articleDto)
    {
        articleDto.setId(id);
//        这里可能出现一些问题
//        弄好了
        articleService.updateArticle(articleDto);
//        return null;
        return "更新文章完成！";
    }

    /**
     * 改变某一篇文章的分类
     * @param id
     * @param categoryId
     * @return
     */
    @ApiOperation("改变文章分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章 ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "categoryId", value = "分类 ID", required = true, dataType = "Long")
    })
    @PutMapping("/article/category/{id}")
    public String changeArticleCategory(@PathVariable Long id, Long categoryId)
    {
        articleService.updateArticleCategory(id, categoryId);
//        return null;
        return "更新文章分类成功！";
    }

    /**
     * 通过文章 ID 更改题图信息
     * @param id
     * @param pictureUrl
     * @return
     */
    @ApiOperation("更新文章题图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章 ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pictureUrl", value = "题图 Url", required = true, dataType = "String")
    })
    @PutMapping("/article/picture/{id}")
    public String updateArticlePicture(@PathVariable Long id, String pictureUrl)
    {
        ArticleDto articleDto = articleService.getOneById(id);
        articleDto.setPictureUrl(pictureUrl);
        articleService.updateArticle(articleDto);

        return "更新文章题图完成！";
    }

    /**
     * 通过 ID 获取一篇文章，内容为 MD 源码格式
     * @param id
     * @return
     */
    @ApiOperation("获取一篇文章，内容为 md 源码格式")
    @ApiImplicitParam(name = "id", value = "文章 ID", required = true, dataType = "Long")
    @GetMapping("/article/{id}")
    public ArticleDto getArticleDtoById(@PathVariable Long id)
    {
        return articleService.getOneById(id);
    }



//    =============================分类=============================

    /**
     * 增加一条分类信息数据
     * @param categoryInfo
     * @return
     */
    @ApiOperation("增加分类信息")
    @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
    @PostMapping("/category")
    public String addCategoryInfo(@RequestBody CategoryInfo categoryInfo)
    {
        categoryService.addCategory(categoryInfo);
        return "增加分类完成！";
    }

    /**
     * 更新/编辑一条分类信息
     * @param id
     * @param categoryInfo
     * @return
     */
    @ApiOperation("更新/编辑分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类 ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
    })
    @PutMapping("/category/{id}")
    public String updateCategoryInfo(@PathVariable Long id, @RequestBody CategoryInfo categoryInfo)
    {
//        注意，应该会将 id 也封装进去这个对象的，不然这里会报错，到时候看看吧
//        System.out.println(id + "----" + categoryInfo.getName() + "---" + categoryInfo.getId());
//        注意，不会装填进去的，客户端那边是路径： xxxx + id  body: name 这么提交的，因此呢，是分开的，所以呢，要组合回去
        categoryInfo.setId(id);
        categoryService.updateCategory(categoryInfo);
        return "更新分类完成！";
    }

    /**
     * 根据 ID 删除分类信息
     * @param id
     * @return
     */
    @ApiOperation("删除分类信息")
    @ApiImplicitParam(name = "id", value = "分类 ID", required = true, dataType = "Long")
    @DeleteMapping("/category/{id}")
    public String deleteCategoryInfo(@PathVariable Long id)
    {
        categoryService.deleteCategoryById(id);
        return "删除分类完成！";
    }

    /**
     * 通过 id 获取一条分类信息
     * @param id
     * @return
     */
    @ApiOperation("获取某一条分类信息")
    @ApiImplicitParam(name = "id", value = "分类 ID", required = true, dataType = "Long")
    @GetMapping("/category/{id}")
    public CategoryInfo getCategoryInfo(@PathVariable Long id)
    {
        return categoryService.getOneById(id);
    }
//    注意，这里少了一个部分，就是在分类页面更新分类下面的文章，不过在文章那边已经有一个了，虽然这边也可以多一个



//    =============================评论=============================

    /**
     * 通过评论 id 删除文章评论信息
     * @param id
     * @return
     */
    @ApiOperation("删除文章评论信息")
    @ApiImplicitParam(name = "id", value = "评论 ID", required = true, dataType = "Long")
    @DeleteMapping("/comment/article/{id}")
    public String deleteArticleComment(@PathVariable Long id)
    {
//        用于评论某篇文章的表
        commentService.deleteArticleCommentById(id);
        return "删除文章评论完成！";
    }

    /**
     * 通过 id 删除某一条留言
     * @param id
     * @return
     */
    @ApiOperation("删除一条留言")
    @ApiImplicitParam(name = "id", value = "评论/留言 ID", required = true, dataType = "Long")
    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable Long id)
    {
//        有些问题，如果我直接删除了这条留言，这里是总表的，但是呢，service 层并没有对文章评论那边做修改，如果文章引用了，那么这里删除了，肯定是个问题的
//        这里应该没有问题的，因为呢，这个是用于总表的，也就是说，用于没有文章引用的，用于评论总博客的表
        commentService.deleteCommentById(id);
        return "删除评论完成！";
    }

    /**
     * 回复留言/评论，通过 id 去找到对应的 email
     * @param id
     * @return
     */
    @ApiOperation("回复留言/评论")
    @ApiImplicitParam(name = "id", value = "评论/留言 ID", required = true, dataType = "Long")
    @GetMapping("/comment/reply/{id}")
    public String replyComment(@PathVariable Long id)
    {
//        很明显，作者并没有完成，我的做法的话，就是新建一个回复表，里边有主键(id)，name, email，content, ip, createBy 即可
//        然后呢，再通过关联表，里边有 article Id 以及 reply Id 关联起来即可，这里是和 comment 总表分开，即回复一个表，评论一个表
//        当然，你也可以全部评论以及回复都放进去 comment 表中
        return "回复评论完成！";
    }

    /**
     * 通过 id 获取某一条评论/留言
     * @param id
     * @return
     */
    @ApiOperation("获取某一条评论/留言")
    @ApiImplicitParam(name = "id", value = "评论/留言 ID", required = true, dataType = "Long")
    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable Long id)
    {
//        这里作者没有实现，我自己加吧
        return commentService.getCommentById(id);
    }
//    同时呢，这里没有添加评论，以及添加文章评论的，猜测，在管理页面做这些不合适吧
//    在普通页面做了
}
