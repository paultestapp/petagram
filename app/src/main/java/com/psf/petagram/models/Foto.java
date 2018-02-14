package com.psf.petagram.models;

/**
 * Created by paulsalcedo on 13/2/18.
 */

public class Foto {
    private int foto;
    private int likes;

    public Foto(int foto, int likes) {
        this.foto = foto;
        this.likes = likes;
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
