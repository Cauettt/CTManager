package com.example.CTManager.repositories;

import com.example.CTManager.entities.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
    Optional<Imagem> findImageByChat(Long chatId);
}
