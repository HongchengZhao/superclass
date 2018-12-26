package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.RollCall;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface RollCallMapper {
    @Delete({
        "delete from roll_call",
        "where signin_id = #{signinId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer signinId);

    @Insert({
        "insert into roll_call (signin_id, class_id, ",
        "date, longtitude, latitude)",
        "values (#{signinId,jdbcType=INTEGER}, #{classId,jdbcType=INTEGER}, ",
        "#{date,jdbcType=DATE}, #{longtitude,jdbcType=DOUBLE}, #{latitude,jdbcType=DOUBLE})"
    })
    int insert(RollCall record);

    @Select({
        "select",
        "signin_id, class_id, date, longtitude, latitude",
        "from roll_call",
        "where signin_id = #{signinId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="signin_id", property="signinId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.DATE),
        @Result(column="longtitude", property="longtitude", jdbcType=JdbcType.DOUBLE),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.DOUBLE)
    })
    RollCall selectByPrimaryKey(Integer signinId);

    @Select({
        "select",
        "signin_id, class_id, date, longtitude, latitude",
        "from roll_call"
    })
    @Results({
        @Result(column="signin_id", property="signinId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.DATE),
        @Result(column="longtitude", property="longtitude", jdbcType=JdbcType.DOUBLE),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.DOUBLE)
    })
    List<RollCall> selectAll();

    @Update({
        "update roll_call",
        "set class_id = #{classId,jdbcType=INTEGER},",
          "date = #{date,jdbcType=DATE},",
          "longtitude = #{longtitude,jdbcType=DOUBLE},",
          "latitude = #{latitude,jdbcType=DOUBLE}",
        "where signin_id = #{signinId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RollCall record);
}