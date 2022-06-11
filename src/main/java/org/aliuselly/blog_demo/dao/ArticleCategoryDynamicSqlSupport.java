package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ArticleCategoryDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960418+08:00", comments="Source Table: tbl_article_category")
    public static final ArticleCategory articleCategory = new ArticleCategory();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960756+08:00", comments="Source field: tbl_article_category.id")
    public static final SqlColumn<Long> id = articleCategory.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960968+08:00", comments="Source field: tbl_article_category.category_id")
    public static final SqlColumn<Long> categoryId = articleCategory.categoryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961115+08:00", comments="Source field: tbl_article_category.article_id")
    public static final SqlColumn<Long> articleId = articleCategory.articleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961266+08:00", comments="Source field: tbl_article_category.create_by")
    public static final SqlColumn<Date> createBy = articleCategory.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961427+08:00", comments="Source field: tbl_article_category.modified_by")
    public static final SqlColumn<Date> modifiedBy = articleCategory.modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.960593+08:00", comments="Source Table: tbl_article_category")
    public static final class ArticleCategory extends AliasableSqlTable<ArticleCategory> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> categoryId = column("category_id", JDBCType.BIGINT);

        public final SqlColumn<Long> articleId = column("article_id", JDBCType.BIGINT);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> modifiedBy = column("modified_by", JDBCType.TIMESTAMP);

        public ArticleCategory() {
            super("tbl_article_category", ArticleCategory::new);
        }
    }
}