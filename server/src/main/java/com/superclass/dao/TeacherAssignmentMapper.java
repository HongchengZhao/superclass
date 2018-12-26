package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.TeacherAssignment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TeacherAssignmentMapper {
    @Delete({
        "delete from teacher_assignment",
        "where assignment_id = #{assignmentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer assignmentId);

    @Insert({
        "insert into teacher_assignment (assignment_id, class_id, ",
        "title, deadline, ",
        "content)",
        "values (#{assignmentId,jdbcType=INTEGER}, #{classId,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{deadline,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(TeacherAssignment record);

    @Select({
        "select",
        "assignment_id, class_id, title, deadline, content",
        "from teacher_assignment",
        "where assignment_id = #{assignmentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="assignment_id", property="assignmentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="deadline", property="deadline", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    TeacherAssignment selectByPrimaryKey(Integer assignmentId);

    @Select({
        "select",
        "assignment_id, class_id, title, deadline, content",
        "from teacher_assignment"
    })
    @Results({
        @Result(column="assignment_id", property="assignmentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="deadline", property="deadline", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TeacherAssignment> selectAll();

    @Update({
        "update teacher_assignment",
        "set class_id = #{classId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "deadline = #{deadline,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where assignment_id = #{assignmentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TeacherAssignment record);
}