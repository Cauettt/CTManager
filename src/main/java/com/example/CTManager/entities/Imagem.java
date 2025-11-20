package com.example.CTManager.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "imagem")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;
    @OneToOne
    @JoinColumn(name="imagem_chat",nullable = false)
    private Chat chat;

    public Imagem(Long id, String path, Chat chat) {
        this.id = id;
        this.path = path;
        this.chat = chat;
    }

    public Imagem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
