package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.SysViewDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.SysView;
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
public interface SysViewMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.897231+08:00", comments="Source Table: sys_view")
    BasicColumn[] selectList = BasicColumn.columnList(id, ip, createBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.895527+08:00", comments="Source Table: sys_view")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<SysView> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.895757+08:00", comments="Source Table: sys_view")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<SysView> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.895907+08:00", comments="Source Table: sys_view")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysViewResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysView> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.896092+08:00", comments="Source Table: sys_view")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysViewResult")
    Optional<SysView> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.896263+08:00", comments="Source Table: sys_view")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysView, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.896392+08:00", comments="Source Table: sys_view")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysView, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.896509+08:00", comments="Source Table: sys_view")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.896649+08:00", comments="Source Table: sys_view")
    default int insert(SysView row) {
        return MyBatis3Utils.insert(this::insert, row, sysView, c ->
            c.map(ip).toProperty("ip")
            .map(createBy).toProperty("createBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.896818+08:00", comments="Source Table: sys_view")
    default int insertMultiple(Collection<SysView> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, sysView, c ->
            c.map(ip).toProperty("ip")
            .map(createBy).toProperty("createBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.896969+08:00", comments="Source Table: sys_view")
    default int insertSelective(SysView row) {
        return MyBatis3Utils.insert(this::insert, row, sysView, c ->
            c.map(ip).toPropertyWhenPresent("ip", row::getIp)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.897338+08:00", comments="Source Table: sys_view")
    default Optional<SysView> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysView, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.897452+08:00", comments="Source Table: sys_view")
    default List<SysView> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysView, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.897561+08:00", comments="Source Table: sys_view")
    default List<SysView> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysView, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.897716+08:00", comments="Source Table: sys_view")
    default Optional<SysView> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.898869+08:00", comments="Source Table: sys_view")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysView, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.899075+08:00", comments="Source Table: sys_view")
    static UpdateDSL<UpdateModel> updateAllColumns(SysView row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ip).equalTo(row::getIp)
                .set(createBy).equalTo(row::getCreateBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.899282+08:00", comments="Source Table: sys_view")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysView row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ip).equalToWhenPresent(row::getIp)
                .set(createBy).equalToWhenPresent(row::getCreateBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.899468+08:00", comments="Source Table: sys_view")
    default int updateByPrimaryKey(SysView row) {
        return update(c ->
            c.set(ip).equalTo(row::getIp)
            .set(createBy).equalTo(row::getCreateBy)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.899777+08:00", comments="Source Table: sys_view")
    default int updateByPrimaryKeySelective(SysView row) {
        return update(c ->
            c.set(ip).equalToWhenPresent(row::getIp)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .where(id, isEqualTo(row::getId))
        );
    }
}