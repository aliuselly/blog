package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CategoryInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951591+08:00", comments="Source Table: tbl_category_info")
    public static final CategoryInfo categoryInfo = new CategoryInfo();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.951891+08:00", comments="Source field: tbl_category_info.id")
    public static final SqlColumn<Long> id = categoryInfo.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.952061+08:00", comments="Source field: tbl_category_info.name")
    public static final SqlColumn<String> name = categoryInfo.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.952231+08:00", comments="Source field: tbl_category_info.number")
    public static final SqlColumn<Byte> number = categoryInfo.number;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.952409+08:00", comments="Source field: tbl_category_info.create_by")
    public static final SqlColumn<Date> createBy = categoryInfo.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.952567+08:00", comments="Source field: tbl_category_info.modified_by")
    public static final SqlColumn<Date> modifiedBy = categoryInfo.modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.95175+08:00", comments="Source Table: tbl_category_info")
    public static final class CategoryInfo extends AliasableSqlTable<CategoryInfo> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Byte> number = column("number", JDBCType.TINYINT);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> modifiedBy = column("modified_by", JDBCType.TIMESTAMP);

        public CategoryInfo() {
            super("tbl_category_info", CategoryInfo::new);
        }
    }
}