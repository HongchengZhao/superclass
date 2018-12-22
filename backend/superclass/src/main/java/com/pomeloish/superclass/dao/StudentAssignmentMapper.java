package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.StudentAssignment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface StudentAssignmentMapper {
    @Delete({
        "delete from student_assignment",
        "where uploaded_id = #{uploadedId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer uploadedId);

    @Insert({
        "insert into student_assignment (uploaded_id, assignment_id, ",
        "file_path, grade, ",
        "user_id)",
        "values (#{uploadedId,jdbcType=INTEGER}, #{assignmentId,jdbcType=INTEGER}, ",
        "#{filePath,jdbcType=VARCHAR}, #{grade,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    int insert(StudentAssignment record);

    @Select({
        "select",
        "uploaded_id, assignment_id, file_path, grade, user_id",
        "from student_assignment",
        "where uploaded_id = #{uploadedId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="uploaded_id", property="uploadedId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="assignment_id", property="assignmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    StudentAssignment selectByPrimaryKey(Integer uploadedId);

    @Select({
        "select",
        "uploaded_id, assignment_id, file_path, grade, user_id",
        "from student_assignment"
    })
    @Results({
        @Result(column="uploaded_id", property="uploadedId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="assignment_id", property="assignmentId", jdbcType=JdbcType.INTEGER),
        @Result(column="file_path", property="filePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<StudentAssignment> selectAll();

    @Update({
        "update student_assignment",
        "set assignment_id = #{assignmentId,jdbcType=INTEGER},",
          "file_path = #{filePath,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where uploaded_id = #{uploadedId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentAssignment record);
}