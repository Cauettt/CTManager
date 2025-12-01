package com.example.CTManager.services;

import com.example.CTManager.dto.ChatDTO;
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

    public Chat criarChat(ChatDTO novoChat) {
        Chat chat = fromDTO(novoChat);

        if (chat.getTitulo() == null || chat.getTitulo().trim().isEmpty()) {
            chat.setTitulo("Projeto Sem Nome");
        }

        return chatRepository.save(chat);
    }

    public List<Chat> listarChatsPorUsuario(Long usuarioId) {
        return chatRepository.findChatByUsuario_id(usuarioId);
    }

    public List<Chat> listarChats() {
        return chatRepository.findAll();
    }

    public Optional<Chat> mostarChatPorId(Long idChat) {
        return chatRepository.findById(idChat);
    }

    public Chat atualizarChat(Long idChat, ChatDTO chatDTO) {
        Chat chatAtual = chatRepository.findById(idChat)
                .orElseThrow(() -> new RuntimeException("Chat não encontrado com ID: " + idChat));

        if (chatDTO.getTitulo() != null && !chatDTO.getTitulo().trim().isEmpty()) {
            chatAtual.setTitulo(chatDTO.getTitulo());
        }
        return chatRepository.save(chatAtual);
    }

    public void deletarChat(Long id) {
        chatRepository.deleteById(id);
    }

    private Chat fromDTO(ChatDTO chatDTO) {
        Usuario user = usuarioRepository.findById(chatDTO.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + chatDTO.getUsuario_id()));

        return new Chat(chatDTO.getId(), user, chatDTO.getTitulo());
    }
}