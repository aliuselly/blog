package org.aliuselly.blog_demo.dao;

import static org.aliuselly.blog_demo.dao.CommentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.aliuselly.blog_demo.entity.Comment;
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
public interface CommentMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946171+08:00", comments="Source Table: tbl_comment")
    BasicColumn[] selectList = BasicColumn.columnList(id, content, createBy, email, name, ip, isEffective);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.944376+08:00", comments="Source Table: tbl_comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<Comment> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.944648+08:00", comments="Source Table: tbl_comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Comment> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.944857+08:00", comments="Source Table: tbl_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CommentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_effective", property="isEffective", jdbcType=JdbcType.BIT)
    })
    List<Comment> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.945128+08:00", comments="Source Table: tbl_comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CommentResult")
    Optional<Comment> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.945547+08:00", comments="Source Table: tbl_comment")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.945648+08:00", comments="Source Table: tbl_comment")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.945711+08:00", comments="Source Table: tbl_comment")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.945771+08:00", comments="Source Table: tbl_comment")
    default int insert(Comment row) {
        return MyBatis3Utils.insert(this::insert, row, comment, c ->
            c.map(content).toProperty("content")
            .map(createBy).toProperty("createBy")
            .map(email).toProperty("email")
            .map(name).toProperty("name")
            .map(ip).toProperty("ip")
            .map(isEffective).toProperty("isEffective")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.945889+08:00", comments="Source Table: tbl_comment")
    default int insertMultiple(Collection<Comment> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, comment, c ->
            c.map(content).toProperty("content")
            .map(createBy).toProperty("createBy")
            .map(email).toProperty("email")
            .map(name).toProperty("name")
            .map(ip).toProperty("ip")
            .map(isEffective).toProperty("isEffective")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.945982+08:00", comments="Source Table: tbl_comment")
    default int insertSelective(Comment row) {
        return MyBatis3Utils.insert(this::insert, row, comment, c ->
            c.map(content).toPropertyWhenPresent("content", row::getContent)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(email).toPropertyWhenPresent("email", row::getEmail)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(ip).toPropertyWhenPresent("ip", row::getIp)
            .map(isEffective).toPropertyWhenPresent("isEffective", row::getIsEffective)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946228+08:00", comments="Source Table: tbl_comment")
    default Optional<Comment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946286+08:00", comments="Source Table: tbl_comment")
    default List<Comment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946336+08:00", comments="Source Table: tbl_comment")
    default List<Comment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946388+08:00", comments="Source Table: tbl_comment")
    default Optional<Comment> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946459+08:00", comments="Source Table: tbl_comment")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946517+08:00", comments="Source Table: tbl_comment")
    static UpdateDSL<UpdateModel> updateAllColumns(Comment row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(content).equalTo(row::getContent)
                .set(createBy).equalTo(row::getCreateBy)
                .set(email).equalTo(row::getEmail)
                .set(name).equalTo(row::getName)
                .set(ip).equalTo(row::getIp)
                .set(isEffective).equalTo(row::getIsEffective);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946651+08:00", comments="Source Table: tbl_comment")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Comment row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(content).equalToWhenPresent(row::getContent)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(email).equalToWhenPresent(row::getEmail)
                .set(name).equalToWhenPresent(row::getName)
                .set(ip).equalToWhenPresent(row::getIp)
                .set(isEffective).equalToWhenPresent(row::getIsEffective);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946785+08:00", comments="Source Table: tbl_comment")
    default int updateByPrimaryKey(Comment row) {
        return update(c ->
            c.set(content).equalTo(row::getContent)
            .set(createBy).equalTo(row::getCreateBy)
            .set(email).equalTo(row::getEmail)
            .set(name).equalTo(row::getName)
            .set(ip).equalTo(row::getIp)
            .set(isEffective).equalTo(row::getIsEffective)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-18T12:15:21.946929+08:00", comments="Source Table: tbl_comment")
    default int updateByPrimaryKeySelective(Comment row) {
        return update(c ->
            c.set(content).equalToWhenPresent(row::getContent)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(email).equalToWhenPresent(row::getEmail)
            .set(name).equalToWhenPresent(row::getName)
            .set(ip).equalToWhenPresent(row::getIp)
            .set(isEffective).equalToWhenPresent(row::getIsEffective)
            .where(id, isEqualTo(row::getId))
        );
    }
}