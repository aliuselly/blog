package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.ArticleCommentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.ArticleComment;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ArticleCommentMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934573+08:00", comments="Source Table: tbl_article_comment")
    BasicColumn[] selectList = BasicColumn.columnList(id, articleId, commentId, createBy, isEffective);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.933245+08:00", comments="Source Table: tbl_article_comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<ArticleComment> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.933482+08:00", comments="Source Table: tbl_article_comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ArticleComment> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.933687+08:00", comments="Source Table: tbl_article_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticleCommentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_effective", property="isEffective", jdbcType=JdbcType.BIT)
    })
    List<ArticleComment> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.933867+08:00", comments="Source Table: tbl_article_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticleCommentResult")
    Optional<ArticleComment> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.933969+08:00", comments="Source Table: tbl_article_comment")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, articleComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934044+08:00", comments="Source Table: tbl_article_comment")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, articleComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934106+08:00", comments="Source Table: tbl_article_comment")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934167+08:00", comments="Source Table: tbl_article_comment")
    default int insert(ArticleComment row) {
        return MyBatis3Utils.insert(this::insert, row, articleComment, c ->
            c.map(articleId).toProperty("articleId")
            .map(commentId).toProperty("commentId")
            .map(createBy).toProperty("createBy")
            .map(isEffective).toProperty("isEffective")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934282+08:00", comments="Source Table: tbl_article_comment")
    default int insertMultiple(Collection<ArticleComment> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, articleComment, c ->
            c.map(articleId).toProperty("articleId")
            .map(commentId).toProperty("commentId")
            .map(createBy).toProperty("createBy")
            .map(isEffective).toProperty("isEffective")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934377+08:00", comments="Source Table: tbl_article_comment")
    default int insertSelective(ArticleComment row) {
        return MyBatis3Utils.insert(this::insert, row, articleComment, c ->
            c.map(articleId).toPropertyWhenPresent("articleId", row::getArticleId)
            .map(commentId).toPropertyWhenPresent("commentId", row::getCommentId)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(isEffective).toPropertyWhenPresent("isEffective", row::getIsEffective)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934665+08:00", comments="Source Table: tbl_article_comment")
    default Optional<ArticleComment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, articleComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934731+08:00", comments="Source Table: tbl_article_comment")
    default List<ArticleComment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, articleComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934787+08:00", comments="Source Table: tbl_article_comment")
    default List<ArticleComment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, articleComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934839+08:00", comments="Source Table: tbl_article_comment")
    default Optional<ArticleComment> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.93491+08:00", comments="Source Table: tbl_article_comment")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, articleComment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.934972+08:00", comments="Source Table: tbl_article_comment")
    static UpdateDSL<UpdateModel> updateAllColumns(ArticleComment row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(articleId).equalTo(row::getArticleId)
                .set(commentId).equalTo(row::getCommentId)
                .set(createBy).equalTo(row::getCreateBy)
                .set(isEffective).equalTo(row::getIsEffective);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.93513+08:00", comments="Source Table: tbl_article_comment")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArticleComment row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(articleId).equalToWhenPresent(row::getArticleId)
                .set(commentId).equalToWhenPresent(row::getCommentId)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(isEffective).equalToWhenPresent(row::getIsEffective);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.935266+08:00", comments="Source Table: tbl_article_comment")
    default int updateByPrimaryKey(ArticleComment row) {
        return update(c ->
            c.set(articleId).equalTo(row::getArticleId)
            .set(commentId).equalTo(row::getCommentId)
            .set(createBy).equalTo(row::getCreateBy)
            .set(isEffective).equalTo(row::getIsEffective)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.93542+08:00", comments="Source Table: tbl_article_comment")
    default int updateByPrimaryKeySelective(ArticleComment row) {
        return update(c ->
            c.set(articleId).equalToWhenPresent(row::getArticleId)
            .set(commentId).equalToWhenPresent(row::getCommentId)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(isEffective).equalToWhenPresent(row::getIsEffective)
            .where(id, isEqualTo(row::getId))
        );
    }
}