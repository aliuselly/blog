package org.aliuselly.blog_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.annotation.Generated;

/**
 * 这里我做了修改，给 name 的列，数据库那边
 * 加上了一个 unique 唯一键
 * 因为呢，作者本身就想他是唯一的，不重复的分类名，不如唯一，然后就不用在 service 层判断了，直接报错
 */
public class CategoryInfo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951039+08:00", comments="Source field: tbl_category_info.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951156+08:00", comments="Source field: tbl_category_info.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951253+08:00", comments="Source field: tbl_category_info.number")
    private Byte number;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951343+08:00", comments="Source field: tbl_category_info.create_by")
    private Date createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951434+08:00", comments="Source field: tbl_category_info.modified_by")
    private Date modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951086+08:00", comments="Source field: tbl_category_info.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951125+08:00", comments="Source field: tbl_category_info.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951187+08:00", comments="Source field: tbl_category_info.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951222+08:00", comments="Source field: tbl_category_info.name")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951283+08:00", comments="Source field: tbl_category_info.number")
    public Byte getNumber() {
        return number;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951315+08:00", comments="Source field: tbl_category_info.number")
    public void setNumber(Byte number) {
        this.number = number;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951376+08:00", comments="Source field: tbl_category_info.create_by")
    public Date getCreateBy() {
        return createBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951407+08:00", comments="Source field: tbl_category_info.create_by")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951466+08:00", comments="Source field: tbl_category_info.modified_by")
    public Date getModifiedBy() {
        return modifiedBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951497+08:00", comments="Source field: tbl_category_info.modified_by")
    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}