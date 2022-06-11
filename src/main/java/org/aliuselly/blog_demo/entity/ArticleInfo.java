package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class ArticleInfo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.91905+08:00", comments="Source field: tbl_article_info.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919227+08:00", comments="Source field: tbl_article_info.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919378+08:00", comments="Source field: tbl_article_info.summary")
    private String summary;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919517+08:00", comments="Source field: tbl_article_info.is_top")
    private Boolean isTop;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919652+08:00", comments="Source field: tbl_article_info.traffic")
    private Integer traffic;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919794+08:00", comments="Source field: tbl_article_info.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919945+08:00", comments="Source field: tbl_article_info.modified_by")
    private Date modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919122+08:00", comments="Source field: tbl_article_info.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919181+08:00", comments="Source field: tbl_article_info.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919282+08:00", comments="Source field: tbl_article_info.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919334+08:00", comments="Source field: tbl_article_info.title")
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919425+08:00", comments="Source field: tbl_article_info.summary")
    public String getSummary() {
        return summary;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919474+08:00", comments="Source field: tbl_article_info.summary")
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919561+08:00", comments="Source field: tbl_article_info.is_top")
    public Boolean getIsTop() {
        return isTop;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919608+08:00", comments="Source field: tbl_article_info.is_top")
    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919701+08:00", comments="Source field: tbl_article_info.traffic")
    public Integer getTraffic() {
        return traffic;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.91975+08:00", comments="Source field: tbl_article_info.traffic")
    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919846+08:00", comments="Source field: tbl_article_info.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919898+08:00", comments="Source field: tbl_article_info.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.919993+08:00", comments="Source field: tbl_article_info.modified_by")
    public Date getModifiedBy() {
        return modifiedBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.920044+08:00", comments="Source field: tbl_article_info.modified_by")
    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}