package com.example.CTManager.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UsuarioDTO {

    Long id;

    @NotBlank(message = "Email não pode ser vazio")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
