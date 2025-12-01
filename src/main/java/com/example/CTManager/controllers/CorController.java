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
    private CorService corService;

    @Autowired
    private ImagemService imagemService;

    @GetMapping("chat/{id}")
    private List<CorDTO> listarCoresporChat(@PathVariable("id") Long idChat){
            return corService.listarCorPorChat(idChat);
    }

    @PostMapping
    private Cor criarCor(@RequestBody CorDTO cor){
        return corService.salvarCor(cor);
    }

    @PutMapping("/{id}")
    private Cor atualizarCor(@PathVariable Long corId, @PathParam("imagemId") Long imagemId, @RequestBody CorDTO cor){
        return corService.atualizarCor(corId,imagemId,cor);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarCor(@PathVariable Long id){
        corService.deletarCor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
