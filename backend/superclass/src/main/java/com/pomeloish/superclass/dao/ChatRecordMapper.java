package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.ChatRecord;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ChatRecordMapper {
    @Delete({
        "delete from chat_record",
        "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer messageId);

    @Insert({
        "insert into chat_record (message_id, class_id, ",
        "user_id, message_type, ",
        "send_time, message_content)",
        "values (#{messageId,jdbcType=INTEGER}, #{classId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{messageType,jdbcType=INTEGER}, ",
        "#{sendTime,jdbcType=TIMESTAMP}, #{messageContent,jdbcType=LONGVARBINARY})"
    })
    int insert(ChatRecord record);

    @Select({
        "select",
        "message_id, class_id, user_id, message_type, send_time, message_content",
        "from chat_record",
        "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="message_id", property="messageId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="message_type", property="messageType", jdbcType=JdbcType.INTEGER),
        @Result(column="send_time", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="message_content", property="messageContent", jdbcType=JdbcType.LONGVARBINARY)
    })
    ChatRecord selectByPrimaryKey(Integer messageId);

    @Select({
        "select",
        "message_id, class_id, user_id, message_type, send_time, message_content",
        "from chat_record"
    })
    @Results({
        @Result(column="message_id", property="messageId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="message_type", property="messageType", jdbcType=JdbcType.INTEGER),
        @Result(column="send_time", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="message_content", property="messageContent", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<ChatRecord> selectAll();

    @Update({
        "update chat_record",
        "set class_id = #{classId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "message_type = #{messageType,jdbcType=INTEGER},",
          "send_time = #{sendTime,jdbcType=TIMESTAMP},",
          "message_content = #{messageContent,jdbcType=LONGVARBINARY}",
        "where message_id = #{messageId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ChatRecord record);
}