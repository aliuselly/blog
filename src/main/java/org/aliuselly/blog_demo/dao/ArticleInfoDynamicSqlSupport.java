package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ArticleInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.920184+08:00", comments="Source Table: tbl_article_info")
    public static final ArticleInfo articleInfo = new ArticleInfo();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.920726+08:00", comments="Source field: tbl_article_info.id")
    public static final SqlColumn<Long> id = articleInfo.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.920974+08:00", comments="Source field: tbl_article_info.title")
    public static final SqlColumn<String> title = articleInfo.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.921213+08:00", comments="Source field: tbl_article_info.summary")
    public static final SqlColumn<String> summary = articleInfo.summary;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.921475+08:00", comments="Source field: tbl_article_info.is_top")
    public static final SqlColumn<Boolean> isTop = articleInfo.isTop;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.922028+08:00", comments="Source field: tbl_article_info.traffic")
    public static final SqlColumn<Integer> traffic = articleInfo.traffic;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.922453+08:00", comments="Source field: tbl_article_info.create_by")
    public static final SqlColumn<Date> createBy = articleInfo.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.922772+08:00", comments="Source field: tbl_article_info.modified_by")
    public static final SqlColumn<Date> modifiedBy = articleInfo.modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.920484+08:00", comments="Source Table: tbl_article_info")
    public static final class ArticleInfo extends AliasableSqlTable<ArticleInfo> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> summary = column("summary", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isTop = column("is_top", JDBCType.BIT);

        public final SqlColumn<Integer> traffic = column("traffic", JDBCType.INTEGER);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> modifiedBy = column("modified_by", JDBCType.TIMESTAMP);

        public ArticleInfo() {
            super("tbl_article_info", ArticleInfo::new);
        }
    }
}