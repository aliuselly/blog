package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CommentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.942009+08:00", comments="Source Table: tbl_comment")
    public static final Comment comment = new Comment();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.942468+08:00", comments="Source field: tbl_comment.id")
    public static final SqlColumn<Long> id = comment.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.94292+08:00", comments="Source field: tbl_comment.content")
    public static final SqlColumn<String> content = comment.content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.943226+08:00", comments="Source field: tbl_comment.create_by")
    public static final SqlColumn<Date> createBy = comment.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.943472+08:00", comments="Source field: tbl_comment.email")
    public static final SqlColumn<String> email = comment.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.943712+08:00", comments="Source field: tbl_comment.name")
    public static final SqlColumn<String> name = comment.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.943994+08:00", comments="Source field: tbl_comment.ip")
    public static final SqlColumn<String> ip = comment.ip;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.944197+08:00", comments="Source field: tbl_comment.is_effective")
    public static final SqlColumn<Boolean> isEffective = comment.isEffective;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.942219+08:00", comments="Source Table: tbl_comment")
    public static final class Comment extends AliasableSqlTable<Comment> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> ip = column("ip", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isEffective = column("is_effective", JDBCType.BIT);

        public Comment() {
            super("tbl_comment", Comment::new);
        }
    }
}