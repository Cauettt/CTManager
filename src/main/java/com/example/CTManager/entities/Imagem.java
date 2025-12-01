package com.example.CTManager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "imagem")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String path;
    @OneToOne
    @JoinColumn(name="imagem_chat",nullable = false)
    private Chat chat;

    @OneToMany(mappedBy = "imagem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Cor> cores;

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

    public List<Cor> getCores() { return cores; }
    public void setCores(List<Cor> cores) { this.cores = cores; }
}
