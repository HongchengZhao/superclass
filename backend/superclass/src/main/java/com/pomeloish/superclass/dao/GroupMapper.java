package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Group;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface GroupMapper {
    @Delete({
        "delete from group",
        "where class_id = #{classId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer classId);

    @Insert({
        "insert into group (class_id, group_name)",
        "values (#{classId,jdbcType=INTEGER}, #{groupName,jdbcType=VARCHAR})"
    })
    int insert(Group record);

    @Select({
        "select",
        "class_id, group_name",
        "from group",
        "where class_id = #{classId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR)
    })
    Group selectByPrimaryKey(Integer classId);

    @Select({
        "select",
        "class_id, group_name",
        "from group"
    })
    @Results({
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR)
    })
    List<Group> selectAll();

    @Update({
        "update group",
        "set group_name = #{groupName,jdbcType=VARCHAR}",
        "where class_id = #{classId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Group record);
}