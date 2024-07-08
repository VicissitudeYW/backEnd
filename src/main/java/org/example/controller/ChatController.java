package org.example.controller;

import org.example.dto.getChatHistoryDTO;
import org.example.pojo.ChatHistory;
import org.example.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/api/getChatHistory")
    public List<ChatHistory> getChatHistory(@RequestBody getChatHistoryDTO gchDTO) {
        String pid = gchDTO.getPatientId(), did = gchDTO.getDoctorId();

        List<ChatHistory> chatHistory = chatService.getChatHistory(pid, did);

        if (chatHistory == null) {
            chatHistory = new ArrayList<>();
        }

        return chatHistory;
    }
}
