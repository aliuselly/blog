package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class ArticleCategory {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.959881+08:00", comments="Source field: tbl_article_category.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.959997+08:00", comments="Source field: tbl_article_category.category_id")
    private Long categoryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960085+08:00", comments="Source field: tbl_article_category.article_id")
    private Long articleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960171+08:00", comments="Source field: tbl_article_category.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960259+08:00", comments="Source field: tbl_article_category.modified_by")
    private Date modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.959923+08:00", comments="Source field: tbl_article_category.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.959966+08:00", comments="Source field: tbl_article_category.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960027+08:00", comments="Source field: tbl_article_category.category_id")
    public Long getCategoryId() {
        return categoryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960059+08:00", comments="Source field: tbl_article_category.category_id")
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960113+08:00", comments="Source field: tbl_article_category.article_id")
    public Long getArticleId() {
        return articleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960142+08:00", comments="Source field: tbl_article_category.article_id")
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960202+08:00", comments="Source field: tbl_article_category.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960232+08:00", comments="Source field: tbl_article_category.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960289+08:00", comments="Source field: tbl_article_category.modified_by")
    public Date getModifiedBy() {
        return modifiedBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960319+08:00", comments="Source field: tbl_article_category.modified_by")
    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}