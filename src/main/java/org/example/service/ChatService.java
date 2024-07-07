package org.example.service;

import org.example.mapper.ChatMapper;
import org.example.pojo.ChatHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatMapper chatMapper;

    public void saveChatHistory(ChatHistory chatHistory) {
        chatMapper.insertChatHistory(chatHistory);
    }

    public List<ChatHistory> getChatHistory(String fromId, String toId) {
        return chatMapper.selectChatHistory(fromId, toId);
    }
}