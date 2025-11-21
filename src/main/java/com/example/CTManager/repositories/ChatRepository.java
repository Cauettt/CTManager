package com.example.CTManager.repositories;

import com.example.CTManager.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository  extends JpaRepository<Chat, Long> {
    List<Chat> findChatByUsuario_id(Long userId);
}
