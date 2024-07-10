package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.ChatHistory;

import java.util.List;

@Mapper
public interface ChatMapper {
    @Select("select from_id as fromId, to_id as toId, from_role as fromRole, " +
            "to_role as toRole, message, chat_time as chatTime " +
            "from chat_history " +
            "where (from_id = #{fromId} and to_id = #{toId}) " +
            "or (from_id = #{toId} and to_id = #{fromId})" +
            "order by chat_time")
    List<ChatHistory> selectChatHistory(@Param("fromId") String fromId,
                                        @Param("toId") String toId);

    @Insert("insert into chat_history (from_id, to_id, from_role, to_role, message, chat_time)" +
            "values (#{fromId}, #{toId}, #{fromRole}, #{toRole}, #{message}, #{chatTime})")
    void insertChatHistory(ChatHistory chatHistory);
}
