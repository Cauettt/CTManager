package com.example.CTManager.controllers;

import com.example.CTManager.dto.ChatDTO;
import com.example.CTManager.entities.Chat;
import com.example.CTManager.entities.Usuario;
import com.example.CTManager.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    private Chat criarChat(@RequestBody  ChatDTO chat){
        return chatService.criarChat(chat);
    }

    @GetMapping("/usuario/{userId}")
    private List<Chat> buscarChatPorUsuario(@PathVariable Long userId){
        return chatService.listarChatsPorUsuario(userId);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Chat> buscarChatPorId(@PathVariable Long chatId){
        return chatService.mostarChatPorId(chatId)
                .map(chat -> new ResponseEntity<>(chat, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    private List<Chat> lisarChats(){
        return chatService.listarChats();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Chat> atualizarChat(@PathVariable Long chatId, @RequestBody ChatDTO chatDTO){
        Chat novoChat = chatService.atualizarChat(chatId,chatDTO);
        return ResponseEntity.ok(novoChat);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirChat(@PathVariable Long id){
        chatService.deletarChat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
