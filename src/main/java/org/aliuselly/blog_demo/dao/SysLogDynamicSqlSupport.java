package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SysLogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.882827+08:00", comments="Source Table: sys_log")
    public static final SysLog sysLog = new SysLog();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.883425+08:00", comments="Source field: sys_log.id")
    public static final SqlColumn<Long> id = sysLog.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.883722+08:00", comments="Source field: sys_log.ip")
    public static final SqlColumn<String> ip = sysLog.ip;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.884015+08:00", comments="Source field: sys_log.create_by")
    public static final SqlColumn<Date> createBy = sysLog.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.884298+08:00", comments="Source field: sys_log.remark")
    public static final SqlColumn<String> remark = sysLog.remark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.884616+08:00", comments="Source field: sys_log.operate_url")
    public static final SqlColumn<String> operateUrl = sysLog.operateUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.884986+08:00", comments="Source field: sys_log.operate_by")
    public static final SqlColumn<String> operateBy = sysLog.operateBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.883146+08:00", comments="Source Table: sys_log")
    public static final class SysLog extends AliasableSqlTable<SysLog> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> ip = column("ip", JDBCType.VARCHAR);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public final SqlColumn<String> remark = column("remark", JDBCType.VARCHAR);

        public final SqlColumn<String> operateUrl = column("operate_url", JDBCType.VARCHAR);

        public final SqlColumn<String> operateBy = column("operate_by", JDBCType.VARCHAR);

        public SysLog() {
            super("sys_log", SysLog::new);
        }
    }
}