package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ArticlePictureDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.968934+08:00", comments="Source Table: tbl_article_picture")
    public static final ArticlePicture articlePicture = new ArticlePicture();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.96942+08:00", comments="Source field: tbl_article_picture.id")
    public static final SqlColumn<Long> id = articlePicture.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.969677+08:00", comments="Source field: tbl_article_picture.article_id")
    public static final SqlColumn<Long> articleId = articlePicture.articleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.969874+08:00", comments="Source field: tbl_article_picture.picture_url")
    public static final SqlColumn<String> pictureUrl = articlePicture.pictureUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.970065+08:00", comments="Source field: tbl_article_picture.create_by")
    public static final SqlColumn<Date> createBy = articlePicture.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.97022+08:00", comments="Source field: tbl_article_picture.modified_by")
    public static final SqlColumn<Date> modifiedBy = articlePicture.modifiedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.969169+08:00", comments="Source Table: tbl_article_picture")
    public static final class ArticlePicture extends AliasableSqlTable<ArticlePicture> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> articleId = column("article_id", JDBCType.BIGINT);

        public final SqlColumn<String> pictureUrl = column("picture_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> modifiedBy = column("modified_by", JDBCType.TIMESTAMP);

        public ArticlePicture() {
            super("tbl_article_picture", ArticlePicture::new);
        }
    }
}