package com.example.CTManager.dto;

public class CorDTO {

    private Long id;
    private Long imagem_id;
    private String hexcode;

    public CorDTO(Long id, Long imagem_id, String hexcode) {
        this.id = id;
        this.imagem_id = imagem_id;
        this.hexcode = hexcode;
    }

    public CorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImagem_id() {
        return imagem_id;
    }

    public void setImagem_id(Long imagem_id) {
        this.imagem_id = imagem_id;
    }

    public String getHexcode() {
        return hexcode;
    }

    public void setHexcode(String hexcode) {
        this.hexcode = hexcode;
    }
}
