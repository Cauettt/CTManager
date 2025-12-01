package com.example.CTManager.dto;

public class ChatDTO {

    private Long id;
    private Long usuario_id;
    private String titulo;

    public ChatDTO(Long id, Long usuario_id, String titulo) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
