package com.sujal.livepaste.dto;

public class ResponseDTO {

    public String url;
    public String paste;

    public ResponseDTO(String url, String paste) {
        this.url = url;
        this.paste = paste;
    }

    public String getUrl() {
        return url;
    }

    public String getPaste() {
        return paste;
    }
}
