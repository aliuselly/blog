package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SysViewDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.894117+08:00", comments="Source Table: sys_view")
    public static final SysView sysView = new SysView();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.894639+08:00", comments="Source field: sys_view.id")
    public static final SqlColumn<Long> id = sysView.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.89496+08:00", comments="Source field: sys_view.ip")
    public static final SqlColumn<String> ip = sysView.ip;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.895263+08:00", comments="Source field: sys_view.create_by")
    public static final SqlColumn<Date> createBy = sysView.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.894398+08:00", comments="Source Table: sys_view")
    public static final class SysView extends AliasableSqlTable<SysView> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> ip = column("ip", JDBCType.VARCHAR);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public SysView() {
            super("sys_view", SysView::new);
        }
    }
}