package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.School;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SchoolMapper {
    @Delete({
        "delete from school",
        "where school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer schoolId);

    @Insert({
        "insert into school (school_id, school_name)",
        "values (#{schoolId,jdbcType=INTEGER}, #{schoolName,jdbcType=VARCHAR})"
    })
    int insert(School record);

    @Select({
        "select",
        "school_id, school_name",
        "from school",
        "where school_id = #{schoolId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_name", property="schoolName", jdbcType=JdbcType.VARCHAR)
    })
    School selectByPrimaryKey(Integer schoolId);

    @Select({
        "select",
        "school_id, school_name",
        "from school"
    })
    @Results({
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_name", property="schoolName", jdbcType=JdbcType.VARCHAR)
    })
    List<School> selectAll();

    @Update({
        "update school",
        "set school_name = #{schoolName,jdbcType=VARCHAR}",
        "where school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(School record);
}