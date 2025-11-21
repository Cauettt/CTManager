package com.example.CTManager.services;

import com.example.CTManager.entities.Chat;
import com.example.CTManager.entities.Imagem;
import com.example.CTManager.repositories.ChatRepository;
import com.example.CTManager.repositories.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    public ImagemRepository imagemRepository;

    @Autowired
    public ChatRepository chatRepository;

    public Imagem criarImagem(Imagem novaImagem){
        return  imagemRepository.save(novaImagem);
    }

    public List<Imagem> listarImagens(){
        return imagemRepository.findAll();
    }

    public Optional<Imagem> mostrarImagemPorId(Long id){
        return imagemRepository.findById(id);
    }

    public Imagem atualizarImagem(Long idChat, Imagem imagemNova){
        Imagem imagemAtual = imagemRepository.findImagemByChat_id(idChat)
                .orElseThrow(() -> new RuntimeException("Nenhuma imagem encontrada para o chat "+idChat));

        Chat chat = chatRepository.findById(idChat)
                .orElseThrow(() -> new RuntimeException("Nenhum chat encontrado com o id "+idChat));

        imagemAtual.setChat(chat);
        imagemAtual.setPath(imagemNova.getPath());
        return imagemRepository.save(imagemAtual);
    }

    public void deletarImagem(Long id){
        imagemRepository.deleteById(id);
    }

}
