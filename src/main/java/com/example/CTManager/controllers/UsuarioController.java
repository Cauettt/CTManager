package com.example.CTManager.controllers;

import com.example.CTManager.dto.LoginRequest;
import com.example.CTManager.dto.UsuarioDTO;
import com.example.CTManager.entities.Usuario;
import com.example.CTManager.services.UsuarioService;
import jakarta.validation.Valid;
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
    public UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO criarUsuario(@RequestBody Usuario usuario){
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioDTO> buscarUsuario(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PutMapping("/{id}")
    public UsuarioDTO updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.updateUsuario(id,usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id){
        usuarioService.excluirUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest.email(), loginRequest.senha());
    }
}
