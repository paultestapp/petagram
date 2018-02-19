package com.psf.petagram.restApi.models;

import com.psf.petagram.models.Usuario;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public class UsuarioResponse {

    private Usuario[] data;

    public Usuario[] getData() {
        return data;
    }

    public void setData(Usuario[] data) {
        this.data = data;
    }
}