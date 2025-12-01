package com.example.CTManager.dto;

public class ChatDTO {

    private Long id;
    private Long usuario_id;

    public ChatDTO(Long id, Long usuario_id) {
        this.id = id;
        this.usuario_id = usuario_id;
    }

    public ChatDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
}
