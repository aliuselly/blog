package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.ArticleInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.ArticleInfo;
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
public interface ArticleInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924226+08:00", comments="Source Table: tbl_article_info")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, summary, isTop, traffic, createBy, modifiedBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.922986+08:00", comments="Source Table: tbl_article_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<ArticleInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.92314+08:00", comments="Source Table: tbl_article_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ArticleInfo> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.923252+08:00", comments="Source Table: tbl_article_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticleInfoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.BIT),
        @Result(column="traffic", property="traffic", jdbcType=JdbcType.INTEGER),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_by", property="modifiedBy", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ArticleInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.923416+08:00", comments="Source Table: tbl_article_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticleInfoResult")
    Optional<ArticleInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.923501+08:00", comments="Source Table: tbl_article_info")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, articleInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.923582+08:00", comments="Source Table: tbl_article_info")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, articleInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.923644+08:00", comments="Source Table: tbl_article_info")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.923716+08:00", comments="Source Table: tbl_article_info")
    default int insert(ArticleInfo row) {
        return MyBatis3Utils.insert(this::insert, row, articleInfo, c ->
            c.map(title).toProperty("title")
            .map(summary).toProperty("summary")
            .map(isTop).toProperty("isTop")
            .map(traffic).toProperty("traffic")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.923869+08:00", comments="Source Table: tbl_article_info")
    default int insertMultiple(Collection<ArticleInfo> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, articleInfo, c ->
            c.map(title).toProperty("title")
            .map(summary).toProperty("summary")
            .map(isTop).toProperty("isTop")
            .map(traffic).toProperty("traffic")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924018+08:00", comments="Source Table: tbl_article_info")
    default int insertSelective(ArticleInfo row) {
        return MyBatis3Utils.insert(this::insert, row, articleInfo, c ->
            c.map(title).toPropertyWhenPresent("title", row::getTitle)
            .map(summary).toPropertyWhenPresent("summary", row::getSummary)
            .map(isTop).toPropertyWhenPresent("isTop", row::getIsTop)
            .map(traffic).toPropertyWhenPresent("traffic", row::getTraffic)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(modifiedBy).toPropertyWhenPresent("modifiedBy", row::getModifiedBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924294+08:00", comments="Source Table: tbl_article_info")
    default Optional<ArticleInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, articleInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924385+08:00", comments="Source Table: tbl_article_info")
    default List<ArticleInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, articleInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924462+08:00", comments="Source Table: tbl_article_info")
    default List<ArticleInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, articleInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924523+08:00", comments="Source Table: tbl_article_info")
    default Optional<ArticleInfo> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924594+08:00", comments="Source Table: tbl_article_info")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, articleInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924662+08:00", comments="Source Table: tbl_article_info")
    static UpdateDSL<UpdateModel> updateAllColumns(ArticleInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalTo(row::getTitle)
                .set(summary).equalTo(row::getSummary)
                .set(isTop).equalTo(row::getIsTop)
                .set(traffic).equalTo(row::getTraffic)
                .set(createBy).equalTo(row::getCreateBy)
                .set(modifiedBy).equalTo(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.924811+08:00", comments="Source Table: tbl_article_info")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArticleInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalToWhenPresent(row::getTitle)
                .set(summary).equalToWhenPresent(row::getSummary)
                .set(isTop).equalToWhenPresent(row::getIsTop)
                .set(traffic).equalToWhenPresent(row::getTraffic)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(modifiedBy).equalToWhenPresent(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.92499+08:00", comments="Source Table: tbl_article_info")
    default int updateByPrimaryKey(ArticleInfo row) {
        return update(c ->
            c.set(title).equalTo(row::getTitle)
            .set(summary).equalTo(row::getSummary)
            .set(isTop).equalTo(row::getIsTop)
            .set(traffic).equalTo(row::getTraffic)
            .set(createBy).equalTo(row::getCreateBy)
            .set(modifiedBy).equalTo(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.925169+08:00", comments="Source Table: tbl_article_info")
    default int updateByPrimaryKeySelective(ArticleInfo row) {
        return update(c ->
            c.set(title).equalToWhenPresent(row::getTitle)
            .set(summary).equalToWhenPresent(row::getSummary)
            .set(isTop).equalToWhenPresent(row::getIsTop)
            .set(traffic).equalToWhenPresent(row::getTraffic)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(modifiedBy).equalToWhenPresent(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }
}