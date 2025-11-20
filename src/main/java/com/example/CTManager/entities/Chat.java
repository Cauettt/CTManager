package com.example.CTManager.entities;

import jakarta.persistence.*;

@Entity
@Table(name="chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="chat_usuario", nullable = false)
    private Usuario usuario;

    public Chat(Long id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Chat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
