package com.example.CTManager.controllers;

import com.example.CTManager.dto.UsuarioDTO;
import com.example.CTManager.entities.Usuario;
import com.example.CTManager.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private UsuarioDTO criarUsuario(@RequestBody Usuario usuario){
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/id")
    private Optional<UsuarioDTO> buscarUsuario(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @GetMapping
    private List<UsuarioDTO> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PutMapping("/id")
    private UsuarioDTO updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.updateUsuario(id,usuario);
    }

    @DeleteMapping("/id")
    private ResponseEntity<Void> excluirUsuario(@PathVariable Long id){
        usuarioService.excluirUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
