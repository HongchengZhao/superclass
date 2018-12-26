package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.SigninRecord;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface SigninRecordMapper {
    @Delete({
        "delete from signin_record",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and signin_id = #{signinId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("signinId") Integer signinId);

    @Insert({
        "insert into signin_record (user_id, signin_id)",
        "values (#{userId,jdbcType=INTEGER}, #{signinId,jdbcType=INTEGER})"
    })
    int insert(SigninRecord record);

    @Select({
        "select",
        "user_id, signin_id",
        "from signin_record"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="signin_id", property="signinId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<SigninRecord> selectAll();
}