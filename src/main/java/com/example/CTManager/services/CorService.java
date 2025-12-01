package com.example.CTManager.services;

import com.example.CTManager.dto.CorDTO;
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

    public Cor salvarCor(CorDTO cor){
        Cor novaCor = fromDTO(cor);
        return corRepository.save(novaCor);
    }

    public List<CorDTO> listarCorPorChat(Long idChat){
        Imagem img = imagemRepository.findImagemByChat_id(idChat)
                .orElseThrow(() ->new RuntimeException("Nenumas imagem encontrada para o chat de ID "+idChat));

        return corRepository.findByImagem_Chat_Id(img.getId())
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<Cor> listarCores(){
        return corRepository.findAll();
    }

    public Optional<Cor> mostrarCorPorId(Long corId){
        return corRepository.findById(corId);
    }

    public Cor atualizarCor(Long corId, Long imagemId, CorDTO cor){
        Cor novaCor = fromDTO(cor);
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

    private Cor fromDTO(CorDTO corDTO){
        Cor novaCor = new Cor();
        Imagem img = imagemRepository.findById(corDTO.getImagem_id())
                .orElseThrow(() -> new RuntimeException("Nenhuma imagem encontrada para o id "+corDTO.getImagem_id()));

        novaCor.setImagem(img);
        novaCor.setHexcode(corDTO.getHexcode());
        novaCor.setId(corDTO.getId());
        return novaCor;
    }

    private CorDTO toDTO(Cor cor){
        CorDTO corDTO = new CorDTO();

        corDTO.setHexcode(cor.getHexcode());
        corDTO.setId(cor.getId());
        corDTO.setImagem_id(cor.getImagem().getId());

        return corDTO;

    }
}
