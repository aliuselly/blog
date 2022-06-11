package org.aliuselly.blog_demo.service;

import org.aliuselly.blog_demo.dto.ArticleCommentDto;
import org.aliuselly.blog_demo.entity.ArticleComment;
import org.aliuselly.blog_demo.entity.Comment;

import java.util.List;

/**
 * 留言 service
 */
public interface CommentService {

    void addComment(Comment comment);

    void addArticleComment(ArticleCommentDto articleCommentDto);

    void deleteCommentById(Long id);

    void deleteArticleCommentById(Long id);

    Comment getCommentById(Long id);

    List<Comment> listAllComment();

    List<ArticleComment> listAllArticleComment();

    List<ArticleCommentDto> listAllArticleCommentById(Long id);
}
