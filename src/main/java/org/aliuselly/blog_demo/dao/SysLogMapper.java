package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.SysLogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.SysLog;
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
public interface SysLogMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.886946+08:00", comments="Source Table: sys_log")
    BasicColumn[] selectList = BasicColumn.columnList(id, ip, createBy, remark, operateUrl, operateBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.885219+08:00", comments="Source Table: sys_log")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<SysLog> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.885461+08:00", comments="Source Table: sys_log")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<SysLog> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.885673+08:00", comments="Source Table: sys_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysLogResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_url", property="operateUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_by", property="operateBy", jdbcType=JdbcType.VARCHAR)
    })
    List<SysLog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.885885+08:00", comments="Source Table: sys_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysLogResult")
    Optional<SysLog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.886006+08:00", comments="Source Table: sys_log")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.886117+08:00", comments="Source Table: sys_log")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.886248+08:00", comments="Source Table: sys_log")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.88636+08:00", comments="Source Table: sys_log")
    default int insert(SysLog row) {
        return MyBatis3Utils.insert(this::insert, row, sysLog, c ->
            c.map(ip).toProperty("ip")
            .map(createBy).toProperty("createBy")
            .map(remark).toProperty("remark")
            .map(operateUrl).toProperty("operateUrl")
            .map(operateBy).toProperty("operateBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.886528+08:00", comments="Source Table: sys_log")
    default int insertMultiple(Collection<SysLog> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, sysLog, c ->
            c.map(ip).toProperty("ip")
            .map(createBy).toProperty("createBy")
            .map(remark).toProperty("remark")
            .map(operateUrl).toProperty("operateUrl")
            .map(operateBy).toProperty("operateBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.886692+08:00", comments="Source Table: sys_log")
    default int insertSelective(SysLog row) {
        return MyBatis3Utils.insert(this::insert, row, sysLog, c ->
            c.map(ip).toPropertyWhenPresent("ip", row::getIp)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(remark).toPropertyWhenPresent("remark", row::getRemark)
            .map(operateUrl).toPropertyWhenPresent("operateUrl", row::getOperateUrl)
            .map(operateBy).toPropertyWhenPresent("operateBy", row::getOperateBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.887063+08:00", comments="Source Table: sys_log")
    default Optional<SysLog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.887201+08:00", comments="Source Table: sys_log")
    default List<SysLog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.887304+08:00", comments="Source Table: sys_log")
    default List<SysLog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.887461+08:00", comments="Source Table: sys_log")
    default Optional<SysLog> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.887588+08:00", comments="Source Table: sys_log")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.887698+08:00", comments="Source Table: sys_log")
    static UpdateDSL<UpdateModel> updateAllColumns(SysLog row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ip).equalTo(row::getIp)
                .set(createBy).equalTo(row::getCreateBy)
                .set(remark).equalTo(row::getRemark)
                .set(operateUrl).equalTo(row::getOperateUrl)
                .set(operateBy).equalTo(row::getOperateBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.887911+08:00", comments="Source Table: sys_log")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysLog row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ip).equalToWhenPresent(row::getIp)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(remark).equalToWhenPresent(row::getRemark)
                .set(operateUrl).equalToWhenPresent(row::getOperateUrl)
                .set(operateBy).equalToWhenPresent(row::getOperateBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.88813+08:00", comments="Source Table: sys_log")
    default int updateByPrimaryKey(SysLog row) {
        return update(c ->
            c.set(ip).equalTo(row::getIp)
            .set(createBy).equalTo(row::getCreateBy)
            .set(remark).equalTo(row::getRemark)
            .set(operateUrl).equalTo(row::getOperateUrl)
            .set(operateBy).equalTo(row::getOperateBy)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.888336+08:00", comments="Source Table: sys_log")
    default int updateByPrimaryKeySelective(SysLog row) {
        return update(c ->
            c.set(ip).equalToWhenPresent(row::getIp)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(remark).equalToWhenPresent(row::getRemark)
            .set(operateUrl).equalToWhenPresent(row::getOperateUrl)
            .set(operateBy).equalToWhenPresent(row::getOperateBy)
            .where(id, isEqualTo(row::getId))
        );
    }
}