package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.ArticleCategoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.ArticleCategory;
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
public interface ArticleCategoryMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.963642+08:00", comments="Source Table: tbl_article_category")
    BasicColumn[] selectList = BasicColumn.columnList(id, categoryId, articleId, createBy, modifiedBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961542+08:00", comments="Source Table: tbl_article_category")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<ArticleCategory> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961666+08:00", comments="Source Table: tbl_article_category")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ArticleCategory> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961753+08:00", comments="Source Table: tbl_article_category")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticleCategoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_by", property="modifiedBy", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ArticleCategory> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961873+08:00", comments="Source Table: tbl_article_category")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticleCategoryResult")
    Optional<ArticleCategory> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961929+08:00", comments="Source Table: tbl_article_category")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, articleCategory, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.961977+08:00", comments="Source Table: tbl_article_category")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, articleCategory, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.962019+08:00", comments="Source Table: tbl_article_category")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.962064+08:00", comments="Source Table: tbl_article_category")
    default int insert(ArticleCategory row) {
        return MyBatis3Utils.insert(this::insert, row, articleCategory, c ->
            c.map(categoryId).toProperty("categoryId")
            .map(articleId).toProperty("articleId")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.96337+08:00", comments="Source Table: tbl_article_category")
    default int insertMultiple(Collection<ArticleCategory> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, articleCategory, c ->
            c.map(categoryId).toProperty("categoryId")
            .map(articleId).toProperty("articleId")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.96349+08:00", comments="Source Table: tbl_article_category")
    default int insertSelective(ArticleCategory row) {
        return MyBatis3Utils.insert(this::insert, row, articleCategory, c ->
            c.map(categoryId).toPropertyWhenPresent("categoryId", row::getCategoryId)
            .map(articleId).toPropertyWhenPresent("articleId", row::getArticleId)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(modifiedBy).toPropertyWhenPresent("modifiedBy", row::getModifiedBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.963706+08:00", comments="Source Table: tbl_article_category")
    default Optional<ArticleCategory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, articleCategory, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.96376+08:00", comments="Source Table: tbl_article_category")
    default List<ArticleCategory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, articleCategory, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.963807+08:00", comments="Source Table: tbl_article_category")
    default List<ArticleCategory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, articleCategory, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.963855+08:00", comments="Source Table: tbl_article_category")
    default Optional<ArticleCategory> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.96391+08:00", comments="Source Table: tbl_article_category")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, articleCategory, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.963961+08:00", comments="Source Table: tbl_article_category")
    static UpdateDSL<UpdateModel> updateAllColumns(ArticleCategory row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(categoryId).equalTo(row::getCategoryId)
                .set(articleId).equalTo(row::getArticleId)
                .set(createBy).equalTo(row::getCreateBy)
                .set(modifiedBy).equalTo(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.964072+08:00", comments="Source Table: tbl_article_category")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArticleCategory row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(categoryId).equalToWhenPresent(row::getCategoryId)
                .set(articleId).equalToWhenPresent(row::getArticleId)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(modifiedBy).equalToWhenPresent(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.964177+08:00", comments="Source Table: tbl_article_category")
    default int updateByPrimaryKey(ArticleCategory row) {
        return update(c ->
            c.set(categoryId).equalTo(row::getCategoryId)
            .set(articleId).equalTo(row::getArticleId)
            .set(createBy).equalTo(row::getCreateBy)
            .set(modifiedBy).equalTo(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.964272+08:00", comments="Source Table: tbl_article_category")
    default int updateByPrimaryKeySelective(ArticleCategory row) {
        return update(c ->
            c.set(categoryId).equalToWhenPresent(row::getCategoryId)
            .set(articleId).equalToWhenPresent(row::getArticleId)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(modifiedBy).equalToWhenPresent(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }
}