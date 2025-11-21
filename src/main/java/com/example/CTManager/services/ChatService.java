package com.example.CTManager.services;

import com.example.CTManager.entities.Chat;
import com.example.CTManager.entities.Usuario;
import com.example.CTManager.repositories.ChatRepository;
import com.example.CTManager.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    public ChatRepository chatRepository;

    @Autowired
    public UsuarioRepository usuarioRepository;

    public Chat criarChat(Chat novoChat){
        return chatRepository.save(novoChat);
    }

    public List<Chat> listarChatsPorUsuario(Long usuarioId){
        return chatRepository.findChatByUsuario_id(usuarioId);
    }

    public List<Chat> listarChats(){
        return chatRepository.findAll();
    }

    public Optional<Chat> mostarChatPorId(Long idChat){
        return chatRepository.findById(idChat);
    }

    public Chat atualizarChat(Long idChat, Long idUsuario){
        Chat chatAtual = chatRepository.findById(idChat)
                .orElseThrow(() -> new RuntimeException("Chat não encontrado"));
        Usuario usuarioNovo = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Nenhum usuário com o id "+idUsuario+" encontrado"));

        chatAtual.setUsuario(usuarioNovo);

        return chatRepository.save(chatAtual);
    }

    public void deletarChat(Long id){
        chatRepository.deleteById(id);
    }
}
