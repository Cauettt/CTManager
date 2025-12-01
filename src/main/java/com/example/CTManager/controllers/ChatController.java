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
    public ChatService chatService;

    @PostMapping
    public Chat criarChat(@RequestBody  ChatDTO chat){
        return chatService.criarChat(chat);
    }

    @GetMapping("/usuario/{userId}")
    public List<Chat> buscarChatPorUsuario(@PathVariable Long userId){
        return chatService.listarChatsPorUsuario(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chat> buscarChatPorId(@PathVariable Long chatId){
        return chatService.mostarChatPorId(chatId)
                .map(chat -> new ResponseEntity<>(chat, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Chat> listarChats(){
        return chatService.listarChats();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chat> atualizarChat(@PathVariable Long id, @RequestBody ChatDTO chatDTO){
        Chat novoChat = chatService.atualizarChat(id,chatDTO);
        return ResponseEntity.ok(novoChat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirChat(@PathVariable Long id){
        chatService.deletarChat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
