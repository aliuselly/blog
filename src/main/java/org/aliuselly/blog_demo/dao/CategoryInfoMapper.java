package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.CategoryInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.CategoryInfo;
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
public interface CategoryInfoMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.953928+08:00", comments="Source Table: tbl_category_info")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, number, createBy, modifiedBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.952689+08:00", comments="Source Table: tbl_category_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<CategoryInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.952828+08:00", comments="Source Table: tbl_category_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<CategoryInfo> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.952915+08:00", comments="Source Table: tbl_category_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CategoryInfoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.TINYINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_by", property="modifiedBy", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CategoryInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.953035+08:00", comments="Source Table: tbl_category_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CategoryInfoResult")
    Optional<CategoryInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.953098+08:00", comments="Source Table: tbl_category_info")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, categoryInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.953146+08:00", comments="Source Table: tbl_category_info")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, categoryInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.953195+08:00", comments="Source Table: tbl_category_info")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.953248+08:00", comments="Source Table: tbl_category_info")
    default int insert(CategoryInfo row) {
        return MyBatis3Utils.insert(this::insert, row, categoryInfo, c ->
            c.map(name).toProperty("name")
            .map(number).toProperty("number")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.953359+08:00", comments="Source Table: tbl_category_info")
    default int insertMultiple(Collection<CategoryInfo> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, categoryInfo, c ->
            c.map(name).toProperty("name")
            .map(number).toProperty("number")
            .map(createBy).toProperty("createBy")
            .map(modifiedBy).toProperty("modifiedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.953587+08:00", comments="Source Table: tbl_category_info")
    default int insertSelective(CategoryInfo row) {
        return MyBatis3Utils.insert(this::insert, row, categoryInfo, c ->
            c.map(name).toPropertyWhenPresent("name", row::getName)
            .map(number).toPropertyWhenPresent("number", row::getNumber)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(modifiedBy).toPropertyWhenPresent("modifiedBy", row::getModifiedBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954027+08:00", comments="Source Table: tbl_category_info")
    default Optional<CategoryInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, categoryInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954099+08:00", comments="Source Table: tbl_category_info")
    default List<CategoryInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, categoryInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954152+08:00", comments="Source Table: tbl_category_info")
    default List<CategoryInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, categoryInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954202+08:00", comments="Source Table: tbl_category_info")
    default Optional<CategoryInfo> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954267+08:00", comments="Source Table: tbl_category_info")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, categoryInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954325+08:00", comments="Source Table: tbl_category_info")
    static UpdateDSL<UpdateModel> updateAllColumns(CategoryInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(row::getName)
                .set(number).equalTo(row::getNumber)
                .set(createBy).equalTo(row::getCreateBy)
                .set(modifiedBy).equalTo(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954465+08:00", comments="Source Table: tbl_category_info")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CategoryInfo row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(row::getName)
                .set(number).equalToWhenPresent(row::getNumber)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(modifiedBy).equalToWhenPresent(row::getModifiedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954593+08:00", comments="Source Table: tbl_category_info")
    default int updateByPrimaryKey(CategoryInfo row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(number).equalTo(row::getNumber)
            .set(createBy).equalTo(row::getCreateBy)
            .set(modifiedBy).equalTo(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.954716+08:00", comments="Source Table: tbl_category_info")
    default int updateByPrimaryKeySelective(CategoryInfo row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(number).equalToWhenPresent(row::getNumber)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(modifiedBy).equalToWhenPresent(row::getModifiedBy)
            .where(id, isEqualTo(row::getId))
        );
    }
}