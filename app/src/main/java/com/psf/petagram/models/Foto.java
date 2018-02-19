package com.psf.petagram.models;

/**
 * Created by paulsalcedo on 13/2/18.
 */

public class Foto {
    private String foto_url;
    private int foto;
    private int likes;

    public Foto(int foto, int likes) {
        this.foto = foto;
        this.likes = likes;
    }

    public Foto(String foto_url, int likes) {
        this.foto_url = foto_url;
        this.likes = likes;
    }

    public Foto() {}

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
