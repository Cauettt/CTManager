package com.example.CTManager.repositories;

import com.example.CTManager.entities.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorRepository extends JpaRepository<Cor, Long> {
    List<Cor> findCorByImagem_id(Long imagemId);
}
