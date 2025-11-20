package com.example.CTManager.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "cores")
public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cor_imagem")
    private Imagem imagem;

    private String hexcode;

    public Cor(Long id, Imagem imagem, String hexcode) {
        this.id = id;
        this.imagem = imagem;
        this.hexcode = hexcode;
    }

    public Cor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    public String getHexcode() {
        return hexcode;
    }

    public void setHexcode(String hexcode) {
        this.hexcode = hexcode;
    }
}
