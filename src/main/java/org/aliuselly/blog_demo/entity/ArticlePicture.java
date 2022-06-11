package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class ArticlePicture {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968425+08:00", comments="Source field: tbl_article_picture.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968529+08:00", comments="Source field: tbl_article_picture.article_id")
    private Long articleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968602+08:00", comments="Source field: tbl_article_picture.picture_url")
    private String pictureUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968661+08:00", comments="Source field: tbl_article_picture.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968735+08:00", comments="Source field: tbl_article_picture.modified_by")
    private Date modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968469+08:00", comments="Source field: tbl_article_picture.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968504+08:00", comments="Source field: tbl_article_picture.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968554+08:00", comments="Source field: tbl_article_picture.article_id")
    public Long getArticleId() {
        return articleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968576+08:00", comments="Source field: tbl_article_picture.article_id")
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968621+08:00", comments="Source field: tbl_article_picture.picture_url")
    public String getPictureUrl() {
        return pictureUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968643+08:00", comments="Source field: tbl_article_picture.picture_url")
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968681+08:00", comments="Source field: tbl_article_picture.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968702+08:00", comments="Source field: tbl_article_picture.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968764+08:00", comments="Source field: tbl_article_picture.modified_by")
    public Date getModifiedBy() {
        return modifiedBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968801+08:00", comments="Source field: tbl_article_picture.modified_by")
    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}