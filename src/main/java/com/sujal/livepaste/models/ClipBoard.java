package com.sujal.livepaste.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clipboards")
public class ClipBoard {

    @Id
    private String id;
    private String paste;
    private String url;

    public ClipBoard() {
    }
    public ClipBoard(String id,String paste, String url) {
        this.id=id;
        this.paste = paste;
        this.url = url;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPaste() {
        return paste;
    }
    public void setPaste(String paste) {
        this.paste = paste;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
