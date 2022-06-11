package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class SysView {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.89323+08:00", comments="Source field: sys_view.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.893527+08:00", comments="Source field: sys_view.ip")
    private String ip;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.893765+08:00", comments="Source field: sys_view.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.893289+08:00", comments="Source field: sys_view.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.893451+08:00", comments="Source field: sys_view.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.893603+08:00", comments="Source field: sys_view.ip")
    public String getIp() {
        return ip;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.893686+08:00", comments="Source field: sys_view.ip")
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.893848+08:00", comments="Source field: sys_view.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.893941+08:00", comments="Source field: sys_view.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }
}