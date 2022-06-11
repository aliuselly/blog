package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class Comment {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.94102+08:00", comments="Source field: tbl_comment.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941174+08:00", comments="Source field: tbl_comment.content")
    private String content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941329+08:00", comments="Source field: tbl_comment.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941476+08:00", comments="Source field: tbl_comment.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.94161+08:00", comments="Source field: tbl_comment.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941719+08:00", comments="Source field: tbl_comment.ip")
    private String ip;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941826+08:00", comments="Source field: tbl_comment.is_effective")
    private Boolean isEffective;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941088+08:00", comments="Source field: tbl_comment.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941138+08:00", comments="Source field: tbl_comment.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941221+08:00", comments="Source field: tbl_comment.content")
    public String getContent() {
        return content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941292+08:00", comments="Source field: tbl_comment.content")
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941403+08:00", comments="Source field: tbl_comment.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941443+08:00", comments="Source field: tbl_comment.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941531+08:00", comments="Source field: tbl_comment.email")
    public String getEmail() {
        return email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941575+08:00", comments="Source field: tbl_comment.email")
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941646+08:00", comments="Source field: tbl_comment.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941686+08:00", comments="Source field: tbl_comment.name")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941755+08:00", comments="Source field: tbl_comment.ip")
    public String getIp() {
        return ip;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941794+08:00", comments="Source field: tbl_comment.ip")
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.94186+08:00", comments="Source field: tbl_comment.is_effective")
    public Boolean getIsEffective() {
        return isEffective;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.941896+08:00", comments="Source field: tbl_comment.is_effective")
    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }

    @Override
    public String     toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createBy=" + createBy +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", isEffective=" + isEffective +
                '}';
    }
}