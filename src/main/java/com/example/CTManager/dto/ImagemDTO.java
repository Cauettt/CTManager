package com.example.CTManager.dto;

public class ImagemDTO {
    private Long id;
    private Long chatId;
    private String path;

    public ImagemDTO(Long id, Long chatId, String path) {
        this.id = id;
        this.chatId = chatId;
        this.path = path;
    }

    public ImagemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
