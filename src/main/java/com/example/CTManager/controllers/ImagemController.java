package com.example.CTManager.controllers;

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
    private ImagemService imagemService;

    @GetMapping
    private List<Imagem> lsitarImagens(){
        return imagemService.listarImagens();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Imagem> buscarImagem(@PathVariable("id") Long id){
        return imagemService.mostrarImagemPorId(id)
                .map(imagem -> new ResponseEntity<>(imagem,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private Imagem criarImagem(@RequestBody Imagem imagem){
        return  imagemService.criarImagem(imagem);
    }

    @PutMapping("/{idChat}")
    private Imagem atualizarImagem(@PathVariable("idChat") Long id, @RequestBody Imagem imagem){
        return imagemService.atualizarImagem(id, imagem);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarImagem(@PathVariable Long id){
        imagemService.deletarImagem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
