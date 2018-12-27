package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from superclass..user",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and phone_number = #{phoneNumber,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("phoneNumber") String phoneNumber);

    @Insert({
        "insert into superclass..user (user_id, phone_number, ",
        "username, gender, ",
        "avatar_url, edu_id, ",
        "school_id, password, ",
        "real_name, is_teacher, ",
        "current_year, current_semester)",
        "values (#{userId,jdbcType=INTEGER}, #{phoneNumber,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
        "#{avatarUrl,jdbcType=VARCHAR}, #{eduId,jdbcType=INTEGER}, ",
        "#{schoolId,jdbcType=INTEGER}, #{password,jdbcType=VARCHAR}, ",
        "#{realName,jdbcType=VARCHAR}, #{isTeacher,jdbcType=BIT}, ",
        "#{currentYear,jdbcType=DATE}, #{currentSemester,jdbcType=TINYINT})"
    })
    int insert(User record);

    @Select({
        "select",
        "user_id, phone_number, username, gender, avatar_url, edu_id, school_id, password, ",
        "real_name, is_teacher, current_year, current_semester",
        "from superclass..user",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and phone_number = #{phoneNumber,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar_url", property="avatarUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_id", property="eduId", jdbcType=JdbcType.INTEGER),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_teacher", property="isTeacher", jdbcType=JdbcType.BIT),
        @Result(column="current_year", property="currentYear", jdbcType=JdbcType.DATE),
        @Result(column="current_semester", property="currentSemester", jdbcType=JdbcType.TINYINT)
    })
    User selectByPrimaryKey(@Param("userId") Integer userId, @Param("phoneNumber") String phoneNumber);

    @Select({
        "select",
        "user_id, phone_number, username, gender, avatar_url, edu_id, school_id, password, ",
        "real_name, is_teacher, current_year, current_semester",
        "from superclass..user"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar_url", property="avatarUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_id", property="eduId", jdbcType=JdbcType.INTEGER),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_teacher", property="isTeacher", jdbcType=JdbcType.BIT),
        @Result(column="current_year", property="currentYear", jdbcType=JdbcType.DATE),
        @Result(column="current_semester", property="currentSemester", jdbcType=JdbcType.TINYINT)
    })
    List<User> selectAll();

    @Update({
        "update superclass..user",
        "set username = #{username,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=VARCHAR},",
          "avatar_url = #{avatarUrl,jdbcType=VARCHAR},",
          "edu_id = #{eduId,jdbcType=INTEGER},",
          "school_id = #{schoolId,jdbcType=INTEGER},",
          "password = #{password,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "is_teacher = #{isTeacher,jdbcType=BIT},",
          "current_year = #{currentYear,jdbcType=DATE},",
          "current_semester = #{currentSemester,jdbcType=TINYINT}",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and phone_number = #{phoneNumber,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}