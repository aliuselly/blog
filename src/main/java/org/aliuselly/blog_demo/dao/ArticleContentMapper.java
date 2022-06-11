package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.ArticleContentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.ArticleContent;
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
public interface ArticleContentMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911505+08:00", comments="Source Table: tbl_article_content")
    BasicColumn[] selectList = BasicColumn.columnList(id, content, articleId, createBy, modifiedBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.91031+08:00", comments="Source Table: tbl_article_content")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<ArticleContent> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.910492+08:00", comments="Source Table: tbl_article_content")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ArticleContent> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.910618+08:00", comments="Source Table: tbl_article_content")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticleContentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_by", property="modifiedBy", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ArticleContent> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.910763+08:00", comments="Source Table: tbl_article_content")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticleContentResult")
    Optional<ArticleContent> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.910838+08:00", comments="Source Table: tbl_article_content")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, articleContent, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.910917+08:00", comments="Source Table: tbl_article_content")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, articleContent, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.910984+08:00", comments="Source Table: tbl_article_content")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911053+08:00", comments="Source Table: tbl_article_content")
    default int insert(ArticleContent row) {
        return MyBatis3Utils.insert(this::insert, row, articleContent, c ->
            c.map(content).toProperty("content")
            .map(articleId).toProperty("articleId")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911171+08:00", comments="Source Table: tbl_article_content")
    default int insertMultiple(Collection<ArticleContent> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, articleContent, c ->
            c.map(content).toProperty("content")
            .map(articleId).toProperty("articleId")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911296+08:00", comments="Source Table: tbl_article_content")
    default int insertSelective(ArticleContent row) {
        return MyBatis3Utils.insert(this::insert, row, articleContent, c ->
            c.map(content).toPropertyWhenPresent("content", row::getContent)
            .map(articleId).toPropertyWhenPresent("articleId", row::getArticleId)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(modifiedBy).toPropertyWhenPresent("modifiedBy", row::getModifiedBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911621+08:00", comments="Source Table: tbl_article_content")
    default Optional<ArticleContent> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, articleContent, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911699+08:00", comments="Source Table: tbl_article_content")
    default List<ArticleContent> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, articleContent, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911766+08:00", comments="Source Table: tbl_article_content")
    default List<ArticleContent> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, articleContent, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911828+08:00", comments="Source Table: tbl_article_content")
    default Optional<ArticleContent> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911907+08:00", comments="Source Table: tbl_article_content")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, articleContent, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.911979+08:00", comments="Source Table: tbl_article_content")
    static UpdateDSL<UpdateModel> updateAllColumns(ArticleContent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(content).equalTo(row::getContent)
                .set(articleId).equalTo(row::getArticleId)
                .set(createBy).equalTo(row::getCreateBy)
                .set(modifiedBy).equalTo(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.912135+08:00", comments="Source Table: tbl_article_content")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArticleContent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(content).equalToWhenPresent(row::getContent)
                .set(articleId).equalToWhenPresent(row::getArticleId)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(modifiedBy).equalToWhenPresent(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.912294+08:00", comments="Source Table: tbl_article_content")
    default int updateByPrimaryKey(ArticleContent row) {
        return update(c ->
            c.set(content).equalTo(row::getContent)
            .set(articleId).equalTo(row::getArticleId)
            .set(createBy).equalTo(row::getCreateBy)
            .set(modifiedBy).equalTo(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.912467+08:00", comments="Source Table: tbl_article_content")
    default int updateByPrimaryKeySelective(ArticleContent row) {
        return update(c ->
            c.set(content).equalToWhenPresent(row::getContent)
            .set(articleId).equalToWhenPresent(row::getArticleId)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(modifiedBy).equalToWhenPresent(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }
}