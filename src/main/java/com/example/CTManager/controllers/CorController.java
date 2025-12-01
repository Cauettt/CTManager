package com.example.CTManager.controllers;

import com.example.CTManager.dto.CorDTO;
import com.example.CTManager.entities.Cor;
import com.example.CTManager.entities.Imagem;
import com.example.CTManager.services.CorService;
import com.example.CTManager.services.ImagemService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cor")
public class CorController {

    @Autowired
    public CorService corService;

    @Autowired
    public ImagemService imagemService;

    @GetMapping("chat/{id}")
    public List<CorDTO> listarCoresporChat(@PathVariable("id") Long idChat){
            return corService.listarCorPorChat(idChat);
    }

    @PostMapping
    public Cor criarCor(@RequestBody CorDTO cor){
        return corService.salvarCor(cor);
    }

    @PutMapping("/{id}")
    public Cor atualizarCor(@PathVariable Long corId, @PathParam("imagemId") Long imagemId, @RequestBody CorDTO cor){
        return corService.atualizarCor(corId,imagemId,cor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCor(@PathVariable Long id){
        corService.deletarCor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
