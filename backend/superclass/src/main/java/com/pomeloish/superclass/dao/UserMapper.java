package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Insert({
        "insert into user (username, gender, ",
        "avatar_url, edu_id, ",
        "phone_number, school_id, ",
        "password, real_name, ",
        "is_teacher, current_year, ",
        "current_semester)",
        "values (#{username,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
        "#{avatarUrl,jdbcType=VARCHAR}, #{eduId,jdbcType=INTEGER}, ",
        "#{phoneNumber,jdbcType=VARCHAR}, #{schoolId,jdbcType=INTEGER}, ",
        "#{password,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{isTeacher,jdbcType=BIT}, #{currentYear,jdbcType=DATE}, ",
        "#{currentSemester,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Integer.class)
    int insert(User record);

    @Select({
        "select",
        "user_id, username, gender, avatar_url, edu_id, phone_number, school_id, password, ",
        "real_name, is_teacher, current_year, current_semester",
        "from user"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar_url", property="avatarUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_id", property="eduId", jdbcType=JdbcType.INTEGER),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_teacher", property="isTeacher", jdbcType=JdbcType.BIT),
        @Result(column="current_year", property="currentYear", jdbcType=JdbcType.DATE),
        @Result(column="current_semester", property="currentSemester", jdbcType=JdbcType.TINYINT)
    })
    List<User> selectAll();

    @Select({
            "select *",
            "from user",
            "where user_id=#{userId}"
    })
    @Results({
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
            @Result(column="avatar_url", property="avatarUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="edu_id", property="eduId", jdbcType=JdbcType.INTEGER),
            @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
            @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
            @Result(column="is_teacher", property="isTeacher", jdbcType=JdbcType.BIT),
            @Result(column="current_year", property="currentYear", jdbcType=JdbcType.DATE),
            @Result(column="current_semester", property="currentSemester", jdbcType=JdbcType.TINYINT)
    })
    User findById(Integer userId);
}