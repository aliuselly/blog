package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

public class SysLog {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.880764+08:00", comments="Source field: sys_log.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881122+08:00", comments="Source field: sys_log.ip")
    private String ip;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.8814+08:00", comments="Source field: sys_log.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881632+08:00", comments="Source field: sys_log.remark")
    private String remark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.88193+08:00", comments="Source field: sys_log.operate_url")
    private String operateUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.882264+08:00", comments="Source field: sys_log.operate_by")
    private String operateBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.880923+08:00", comments="Source field: sys_log.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881031+08:00", comments="Source field: sys_log.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881218+08:00", comments="Source field: sys_log.ip")
    public String getIp() {
        return ip;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881313+08:00", comments="Source field: sys_log.ip")
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

//    使用 jsonjack 对返回 json 进行格式化，不然，前端显示得很难看，毕竟存进数据库再查出来
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881482+08:00", comments="Source field: sys_log.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881558+08:00", comments="Source field: sys_log.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881716+08:00", comments="Source field: sys_log.remark")
    public String getRemark() {
        return remark;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.881825+08:00", comments="Source field: sys_log.remark")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.882036+08:00", comments="Source field: sys_log.operate_url")
    public String getOperateUrl() {
        return operateUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.882152+08:00", comments="Source field: sys_log.operate_url")
    public void setOperateUrl(String operateUrl) {
        this.operateUrl = operateUrl == null ? null : operateUrl.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.882381+08:00", comments="Source field: sys_log.operate_by")
    public String getOperateBy() {
        return operateBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.882504+08:00", comments="Source field: sys_log.operate_by")
    public void setOperateBy(String operateBy) {
        this.operateBy = operateBy == null ? null : operateBy.trim();
    }
}