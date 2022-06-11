package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ArticleContentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.90793+08:00", comments="Source Table: tbl_article_content")
    public static final ArticleContent articleContent = new ArticleContent();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.908478+08:00", comments="Source field: tbl_article_content.id")
    public static final SqlColumn<Long> id = articleContent.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.908786+08:00", comments="Source field: tbl_article_content.content")
    public static final SqlColumn<String> content = articleContent.content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.909075+08:00", comments="Source field: tbl_article_content.article_id")
    public static final SqlColumn<Long> articleId = articleContent.articleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.909559+08:00", comments="Source field: tbl_article_content.create_by")
    public static final SqlColumn<Date> createBy = articleContent.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.910026+08:00", comments="Source field: tbl_article_content.modified_by")
    public static final SqlColumn<Date> modifiedBy = articleContent.modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.908202+08:00", comments="Source Table: tbl_article_content")
    public static final class ArticleContent extends AliasableSqlTable<ArticleContent> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

        public final SqlColumn<Long> articleId = column("article_id", JDBCType.BIGINT);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> modifiedBy = column("modified_by", JDBCType.TIMESTAMP);

        public ArticleContent() {
            super("tbl_article_content", ArticleContent::new);
        }
    }
}