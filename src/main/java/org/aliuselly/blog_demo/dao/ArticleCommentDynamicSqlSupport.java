package org.aliuselly.blog_demo.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ArticleCommentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.931034+08:00", comments="Source Table: tbl_article_comment")
    public static final ArticleComment articleComment = new ArticleComment();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.9316+08:00", comments="Source field: tbl_article_comment.id")
    public static final SqlColumn<Long> id = articleComment.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.931985+08:00", comments="Source field: tbl_article_comment.article_id")
    public static final SqlColumn<Long> articleId = articleComment.articleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.932283+08:00", comments="Source field: tbl_article_comment.comment_id")
    public static final SqlColumn<Long> commentId = articleComment.commentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.932654+08:00", comments="Source field: tbl_article_comment.create_by")
    public static final SqlColumn<Date> createBy = articleComment.createBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.932956+08:00", comments="Source field: tbl_article_comment.is_effective")
    public static final SqlColumn<Boolean> isEffective = articleComment.isEffective;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.931267+08:00", comments="Source Table: tbl_article_comment")
    public static final class ArticleComment extends AliasableSqlTable<ArticleComment> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> articleId = column("article_id", JDBCType.BIGINT);

        public final SqlColumn<Long> commentId = column("comment_id", JDBCType.BIGINT);

        public final SqlColumn<Date> createBy = column("create_by", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> isEffective = column("is_effective", JDBCType.BIT);

        public ArticleComment() {
            super("tbl_article_comment", ArticleComment::new);
        }
    }
}