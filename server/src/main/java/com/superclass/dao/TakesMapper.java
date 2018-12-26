package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Takes;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface TakesMapper {
    @Delete({
        "delete from takes",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and class_id = #{classId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("classId") Integer classId);

    @Insert({
        "insert into takes (user_id, class_id)",
        "values (#{userId,jdbcType=INTEGER}, #{classId,jdbcType=INTEGER})"
    })
    int insert(Takes record);

    @Select({
        "select",
        "user_id, class_id",
        "from takes"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<Takes> selectAll();
}