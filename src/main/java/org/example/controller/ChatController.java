package org.example.controller;

import org.example.dto.getChatHistoryDTO;
import org.example.pojo.ChatHistory;
import org.example.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/session")
    public List<ChatHistory> getChatHistory(@RequestBody getChatHistoryDTO gchDTO) {
        String pid = gchDTO.getPatientId(), did = gchDTO.getDoctorId();

        return chatService.getChatHistory(pid, did);
    }
}
