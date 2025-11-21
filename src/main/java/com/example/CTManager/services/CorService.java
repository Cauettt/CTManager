package com.example.CTManager.services;

import com.example.CTManager.entities.Cor;
import com.example.CTManager.entities.Imagem;
import com.example.CTManager.repositories.CorRepository;
import com.example.CTManager.repositories.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorService {

    @Autowired
    public CorRepository corRepository;

    @Autowired
    public ImagemRepository imagemRepository;

    public Cor salvarCor(Cor novaCor){
        return corRepository.save(novaCor);
    }

    public List<Cor> listarCorPorImagem(Long imagemId){
        return corRepository.findCorByImagem_id(imagemId);
    }

    public List<Cor> listarCores(){
        return corRepository.findAll();
    }

    public Optional<Cor> mostrarCorPorId(Long corId){
        return corRepository.findById(corId);
    }

    public Cor atualizarCor(Long corId, Long imagemId, Cor novaCor){
        Cor corAtual = corRepository.findById(corId)
                .orElseThrow(() -> new RuntimeException("Nenhuma cor encontrada com o id "+corId));
        Imagem img = imagemRepository.findById(imagemId)
                .orElseThrow(() -> new RuntimeException("Nenhuma imagem encontrada com o id "+imagemId ));

        corAtual.setHexcode(novaCor.getHexcode());
        corAtual.setImagem(img);

        return corRepository.save(corAtual);
    }

    public void deletarCor(Long id){
        corRepository.deleteById(id);
    }
}
