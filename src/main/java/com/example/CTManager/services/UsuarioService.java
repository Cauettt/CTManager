package com.example.CTManager.services;

import com.example.CTManager.dto.UsuarioDTO;
import com.example.CTManager.entities.Usuario;
import com.example.CTManager.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioDTO toDto(Usuario usuario){
        return new UsuarioDTO(usuario.getId(),usuario.getEmail());
    }

    public UsuarioDTO criarUsuario(Usuario usuario){
        return toDto(usuarioRepository.save(usuario));
    }

    public List<UsuarioDTO> listarUsuarios(){
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<UsuarioDTO> buscarPorId(Long id){
        return usuarioRepository.findById(id)
                .map(this::toDto);
    }

    public void excluirUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO updateUsuario(Long id , Usuario updateUsuario){
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setEmail(updateUsuario.getEmail());
            usuario.setSenha(updateUsuario.getSenha());

            return toDto(usuarioRepository.save(usuario));
    }).orElseThrow(() -> new RuntimeException("cliente não existe"));
    }
}
