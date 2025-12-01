package com.example.CTManager.controllers;

import com.example.CTManager.dto.ImagemDTO;
import com.example.CTManager.entities.Imagem;
import com.example.CTManager.services.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("imagem")
public class ImagemController {

    @Autowired
    public ImagemService imagemService;

    @GetMapping
    public List<Imagem> lsitarImagens(){
        return imagemService.listarImagens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagem> buscarImagem(@PathVariable("id") Long id){
        return imagemService.mostrarImagemPorId(id)
                .map(imagem -> new ResponseEntity<>(imagem,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Imagem criarImagem(@RequestBody ImagemDTO imagem){
        return  imagemService.criarImagem(imagem);
    }

    @PutMapping("/{id}")
    public Imagem atualizarImagem(@PathVariable("id") Long id, @RequestBody ImagemDTO imagem){
        return imagemService.atualizarImagem(id, imagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarImagem(@PathVariable Long id){
        imagemService.deletarImagem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
