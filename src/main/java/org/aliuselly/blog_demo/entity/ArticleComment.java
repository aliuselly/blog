package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class ArticleComment {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930256+08:00", comments="Source field: tbl_article_comment.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930432+08:00", comments="Source field: tbl_article_comment.article_id")
    private Long articleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930556+08:00", comments="Source field: tbl_article_comment.comment_id")
    private Long commentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930682+08:00", comments="Source field: tbl_article_comment.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930813+08:00", comments="Source field: tbl_article_comment.is_effective")
    private Boolean isEffective;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930337+08:00", comments="Source field: tbl_article_comment.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930391+08:00", comments="Source field: tbl_article_comment.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930474+08:00", comments="Source field: tbl_article_comment.article_id")
    public Long getArticleId() {
        return articleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930516+08:00", comments="Source field: tbl_article_comment.article_id")
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930597+08:00", comments="Source field: tbl_article_comment.comment_id")
    public Long getCommentId() {
        return commentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930642+08:00", comments="Source field: tbl_article_comment.comment_id")
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930727+08:00", comments="Source field: tbl_article_comment.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930773+08:00", comments="Source field: tbl_article_comment.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930856+08:00", comments="Source field: tbl_article_comment.is_effective")
    public Boolean getIsEffective() {
        return isEffective;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.930901+08:00", comments="Source field: tbl_article_comment.is_effective")
    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }
}