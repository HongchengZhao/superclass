package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Notification;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface NotificationMapper {
    @Delete({
        "delete from notification",
        "where notification_id = #{notificationId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer notificationId);

    @Insert({
        "insert into notification (notification_id, class_id, ",
        "notification)",
        "values (#{notificationId,jdbcType=INTEGER}, #{classId,jdbcType=INTEGER}, ",
        "#{notification,jdbcType=LONGVARCHAR})"
    })
    int insert(Notification record);

    @Select({
        "select",
        "notification_id, class_id, notification",
        "from notification",
        "where notification_id = #{notificationId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="notification_id", property="notificationId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="notification", property="notification", jdbcType=JdbcType.LONGVARCHAR)
    })
    Notification selectByPrimaryKey(Integer notificationId);

    @Select({
        "select",
        "notification_id, class_id, notification",
        "from notification"
    })
    @Results({
        @Result(column="notification_id", property="notificationId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="notification", property="notification", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Notification> selectAll();

    @Update({
        "update notification",
        "set class_id = #{classId,jdbcType=INTEGER},",
          "notification = #{notification,jdbcType=LONGVARCHAR}",
        "where notification_id = #{notificationId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notification record);
}