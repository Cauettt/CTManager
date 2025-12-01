package com.example.CTManager.services;

import com.example.CTManager.dto.ImagemDTO;
import com.example.CTManager.entities.Chat;
import com.example.CTManager.entities.Imagem;
import com.example.CTManager.repositories.ChatRepository;
import com.example.CTManager.repositories.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    public ImagemRepository imagemRepository;

    @Autowired
    public ChatRepository chatRepository;

    public Imagem criarImagem(ImagemDTO novaImagem){
        return  imagemRepository.save(fromDTO(novaImagem));
    }

    public List<Imagem> listarImagens(){
        return imagemRepository.findAll();
    }

    public Optional<Imagem> mostrarImagemPorId(Long id){
        return imagemRepository.findById(id);
    }

    public Optional<Imagem> mostarImagemPorChatId(Long idChat){
        return  imagemRepository.findImagemByChat_id(idChat);
    }

    public Imagem atualizarImagem(Long idImagem, ImagemDTO imagemNova){
        Imagem imagemAtual = imagemRepository.findById(idImagem)
                .orElseThrow(() -> new RuntimeException("Nenhuma imagem encontrada para o chat "+idChat));
        Imagem imagemAtualizada = fromDTO(imagemNova);

        imagemAtual.setChat(imagemAtualizada.getChat());
        imagemAtual.setPath(imagemAtualizada.getPath());
        return imagemRepository.save(imagemAtual);
    }

    public void deletarImagem(Long id){
        imagemRepository.deleteById(id);
    }

    private Imagem fromDTO(ImagemDTO imagem){
        Chat chat = chatRepository.findById(imagem.getChatId())
                .orElseThrow(() -> new RuntimeException("Nenhum chat encontrado para o id "+imagem.getChatId()));

        return new Imagem(imagem.getId(),imagem.getPath(),chat);
    }

}
