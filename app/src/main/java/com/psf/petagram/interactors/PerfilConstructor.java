package com.psf.petagram.interactors;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.psf.petagram.R;
import com.psf.petagram.models.Foto;
import com.psf.petagram.models.Usuario;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public class PerfilConstructor {

    private Context context;
    private Resources resources;
    private SharedPreferences preferences;

    public PerfilConstructor(Context context) {
        this.context = context;
        this.resources = context.getResources();

        preferences = context.getSharedPreferences(resources.getString(R.string.tag_preferences_name), Context.MODE_PRIVATE);
    }

    public String getUsername() {
        return preferences.getString(resources.getString(R.string.tab_name_account), null);
    }

    public void saveUsuario(Usuario usuario) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(resources.getString(R.string.tab_user_id), usuario.getId());
        editor.putString(resources.getString(R.string.tab_user_fullname), usuario.getFull_name());
        editor.putString(resources.getString(R.string.tab_user_photo), usuario.getProfile_picture());
        editor.apply();
    }

    public Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(preferences.getString(resources.getString(R.string.tab_user_id), ""));
        usuario.setFull_name(preferences.getString(resources.getString(R.string.tab_user_fullname), ""));
        usuario.setProfile_picture(preferences.getString(resources.getString(R.string.tab_user_photo), ""));
        return usuario;
    }


    public ArrayList<Foto> getFotos() {

        ArrayList<Foto> fotos = new ArrayList<>();
        fotos.add(new Foto(R.drawable.pet_5, 5));
        fotos.add(new Foto(R.drawable.pet_5, 0));
        fotos.add(new Foto(R.drawable.pet_5, 3));
        fotos.add(new Foto(R.drawable.pet_5, 4));
        fotos.add(new Foto(R.drawable.pet_5, 1));
        fotos.add(new Foto(R.drawable.pet_5, 3));
        fotos.add(new Foto(R.drawable.pet_5, 2));
        fotos.add(new Foto(R.drawable.pet_5, 0));
        fotos.add(new Foto(R.drawable.pet_5, 5));
        fotos.add(new Foto(R.drawable.pet_5, 3));
        fotos.add(new Foto(R.drawable.pet_5, 2));
        fotos.add(new Foto(R.drawable.pet_5, 5));

        return fotos;
    }



}
