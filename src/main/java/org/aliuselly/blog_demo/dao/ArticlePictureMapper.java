package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.ArticlePictureDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.ArticlePicture;
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
public interface ArticlePictureMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971233+08:00", comments="Source Table: tbl_article_picture")
    BasicColumn[] selectList = BasicColumn.columnList(id, articleId, pictureUrl, createBy, modifiedBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.970353+08:00", comments="Source Table: tbl_article_picture")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<ArticlePicture> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.970495+08:00", comments="Source Table: tbl_article_picture")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ArticlePicture> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.970589+08:00", comments="Source Table: tbl_article_picture")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticlePictureResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.BIGINT),
        @Result(column="picture_url", property="pictureUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_by", property="modifiedBy", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ArticlePicture> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.970715+08:00", comments="Source Table: tbl_article_picture")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticlePictureResult")
    Optional<ArticlePicture> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.97077+08:00", comments="Source Table: tbl_article_picture")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, articlePicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.970817+08:00", comments="Source Table: tbl_article_picture")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, articlePicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.970859+08:00", comments="Source Table: tbl_article_picture")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.970907+08:00", comments="Source Table: tbl_article_picture")
    default int insert(ArticlePicture row) {
        return MyBatis3Utils.insert(this::insert, row, articlePicture, c ->
            c.map(articleId).toProperty("articleId")
            .map(pictureUrl).toProperty("pictureUrl")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971014+08:00", comments="Source Table: tbl_article_picture")
    default int insertMultiple(Collection<ArticlePicture> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, articlePicture, c ->
            c.map(articleId).toProperty("articleId")
            .map(pictureUrl).toProperty("pictureUrl")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971085+08:00", comments="Source Table: tbl_article_picture")
    default int insertSelective(ArticlePicture row) {
        return MyBatis3Utils.insert(this::insert, row, articlePicture, c ->
            c.map(articleId).toPropertyWhenPresent("articleId", row::getArticleId)
            .map(pictureUrl).toPropertyWhenPresent("pictureUrl", row::getPictureUrl)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(modifiedBy).toPropertyWhenPresent("modifiedBy", row::getModifiedBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971281+08:00", comments="Source Table: tbl_article_picture")
    default Optional<ArticlePicture> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, articlePicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971326+08:00", comments="Source Table: tbl_article_picture")
    default List<ArticlePicture> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, articlePicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971357+08:00", comments="Source Table: tbl_article_picture")
    default List<ArticlePicture> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, articlePicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971386+08:00", comments="Source Table: tbl_article_picture")
    default Optional<ArticlePicture> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.97143+08:00", comments="Source Table: tbl_article_picture")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, articlePicture, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971484+08:00", comments="Source Table: tbl_article_picture")
    static UpdateDSL<UpdateModel> updateAllColumns(ArticlePicture row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(articleId).equalTo(row::getArticleId)
                .set(pictureUrl).equalTo(row::getPictureUrl)
                .set(createBy).equalTo(row::getCreateBy)
                .set(modifiedBy).equalTo(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.97159+08:00", comments="Source Table: tbl_article_picture")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArticlePicture row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(articleId).equalToWhenPresent(row::getArticleId)
                .set(pictureUrl).equalToWhenPresent(row::getPictureUrl)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(modifiedBy).equalToWhenPresent(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971699+08:00", comments="Source Table: tbl_article_picture")
    default int updateByPrimaryKey(ArticlePicture row) {
        return update(c ->
            c.set(articleId).equalTo(row::getArticleId)
            .set(pictureUrl).equalTo(row::getPictureUrl)
            .set(createBy).equalTo(row::getCreateBy)
            .set(modifiedBy).equalTo(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.971802+08:00", comments="Source Table: tbl_article_picture")
    default int updateByPrimaryKeySelective(ArticlePicture row) {
        return update(c ->
            c.set(articleId).equalToWhenPresent(row::getArticleId)
            .set(pictureUrl).equalToWhenPresent(row::getPictureUrl)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(modifiedBy).equalToWhenPresent(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }
}