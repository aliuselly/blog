package org.aliuselly.blog_demo.service.impl;

import org.aliuselly.blog_demo.dao.ArticleCommentDynamicSqlSupport;
import org.aliuselly.blog_demo.dao.ArticleCommentMapper;
import org.aliuselly.blog_demo.dao.CommentDynamicSqlSupport;
import org.aliuselly.blog_demo.dao.CommentMapper;
import org.aliuselly.blog_demo.dto.ArticleCommentDto;
import org.aliuselly.blog_demo.entity.ArticleComment;
import org.aliuselly.blog_demo.entity.Comment;
import org.aliuselly.blog_demo.service.CommentService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 留言/评论 service 实现类
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    /**
     * 增加一条留言信息
     * @param comment
     */
    @Override
    public void addComment(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    /**
     * 增加一条文化脏评论信息
     * @param articleCommentDto
     */
    @Override
    public void addArticleComment(ArticleCommentDto articleCommentDto) {
//        先增加 comment 留言数据
        Comment comment = new Comment();
        comment.setIp(articleCommentDto.getIp());
        comment.setName(articleCommentDto.getName());
        comment.setEmail(articleCommentDto.getEmail());
        comment.setContent(articleCommentDto.getContent());
        addComment(comment);

//        再更新 tbl_article_comment 作关联
//        注意，上面插入了一条数据了
        Long lastCommentId = commentMapper.select(c -> c.orderBy(CommentDynamicSqlSupport.id.descending())).get(0).getId();

        ArticleComment articleComment = new ArticleComment();
        articleComment.setCommentId(lastCommentId);
        articleComment.setArticleId(articleCommentDto.getArticleId());
        articleCommentMapper.insertSelective(articleComment);
    }

    /**
     * 通过留言 ID 删除一条数据
     * 说明：并不是直接删除数据库中的数据，而是将 isEffective 字段设置为 false
     * @param id
     */
    @Override
    public void deleteCommentById(Long id) {
//        一开始我是想，直接设置 comment 中，把 id 也设置进去即可，然后更新，但是，我没有想到，如果数据库中没有这条数据怎么办，这个可是一个漏洞啊，因此呢，要先查询
//        不过这里也有问题，看 controller 那边
//        应该没有问题的，毕竟总表的
        Comment comment = commentMapper.selectByPrimaryKey(id).get();
        comment.setIsEffective(false);
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    /**
     * 删除文章评论
     * 说明：和上面一样，设置 ifEffective 为 false，两个表的字段都有
     * 注意：这里需要设置两个表的字段
     * @param id
     */
    @Override
    public void deleteArticleCommentById(Long id) {
//        设置 ArticleComment 表中的字段为 false
//        注意，是先查询 articleComment 表中的
        ArticleComment articleComment = articleCommentMapper.selectByPrimaryKey(id).get();
        articleComment.setIsEffective(false);
        articleCommentMapper.updateByPrimaryKeySelective(articleComment);

//        删除 comment 表中的对应数据
        deleteCommentById(articleComment.getCommentId());
    }

    /**
     * 通过 id 获取评论
     * @param id
     * @return
     */
    @Override
    public Comment getCommentById(Long id) {
        return commentMapper.selectByPrimaryKey(id).get();
    }

    /**
     * 列举返回所有的留言信息
     * @return
     */
    @Override
    public List<Comment> listAllComment() {
//        无条件查询即返回所有
        return commentMapper.select(c -> c.where());
    }

    /**
     * 列举所有的文章评论信息
     * @return
     */
    @Override
    public List<ArticleComment> listAllArticleComment() {
        return articleCommentMapper.select(c -> c.where());
    }

    /**
     * 获取对应文章下的所有评论信息
     * 说明：需要返回一个自己封装好的用来与前端交互的 ArticleCommentDto 集合
     * @param id  文章 ID
     * @return
     */
    @Override
    public List<ArticleCommentDto> listAllArticleCommentById(Long id) {
        List<ArticleCommentDto> articleCommentDtos = new ArrayList<>();

//        一个文章下有多个评论
        List<ArticleComment> articleComments = articleCommentMapper.select(c -> c.where(ArticleCommentDynamicSqlSupport.articleId, SqlBuilder.isEqualTo(id)));
//        填充对应的评论信息
        for (ArticleComment articleComment : articleComments)
        {
            if (true == articleComment.getIsEffective())
            {
//                查询对应的评论信息
                Comment comment = commentMapper.selectByPrimaryKey(articleComment.getCommentId()).get();

                ArticleCommentDto articleCommentDto = ArticleCommentDto.builder()
                        .id(comment.getId())
                        .content(comment.getContent())
                        .email(comment.getEmail())
                        .ip(comment.getIp())
                        .name(comment.getName())
//                        articleComment
                        .articleCommentId(articleComment.getId())
                        .articleId(articleComment.getArticleId())
                        .createBy(articleComment.getCreateBy())
                        .build();

                articleCommentDtos.add(articleCommentDto);
            }
        }
        return articleCommentDtos;
    }
}
