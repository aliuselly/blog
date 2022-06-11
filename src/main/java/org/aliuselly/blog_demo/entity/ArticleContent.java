package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class ArticleContent {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.906767+08:00", comments="Source field: tbl_article_content.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.906964+08:00", comments="Source field: tbl_article_content.content")
    private String content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907124+08:00", comments="Source field: tbl_article_content.article_id")
    private Long articleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.90733+08:00", comments="Source field: tbl_article_content.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.9076+08:00", comments="Source field: tbl_article_content.modified_by")
    private Date modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.90685+08:00", comments="Source field: tbl_article_content.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.906909+08:00", comments="Source field: tbl_article_content.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907016+08:00", comments="Source field: tbl_article_content.content")
    public String getContent() {
        return content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907073+08:00", comments="Source field: tbl_article_content.content")
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907178+08:00", comments="Source field: tbl_article_content.article_id")
    public Long getArticleId() {
        return articleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907234+08:00", comments="Source field: tbl_article_content.article_id")
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907406+08:00", comments="Source field: tbl_article_content.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907517+08:00", comments="Source field: tbl_article_content.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907675+08:00", comments="Source field: tbl_article_content.modified_by")
    public Date getModifiedBy() {
        return modifiedBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.907736+08:00", comments="Source field: tbl_article_content.modified_by")
    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}