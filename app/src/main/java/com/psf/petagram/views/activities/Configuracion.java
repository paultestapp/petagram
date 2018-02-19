package com.psf.petagram.views.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.psf.petagram.R;
import com.psf.petagram.interactors.PerfilConstructor;
import com.psf.petagram.restApi.ApiEndpoints;
import com.psf.petagram.restApi.adapters.RestApiAdapter;
import com.psf.petagram.restApi.models.UsuarioResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Configuracion extends AppCompatActivity {

    private PerfilConstructor constructor;

    private Resources resources;
    private SharedPreferences preferences;
    private TextInputEditText tie_usuario;
    private ProgressBar pb_config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        Toolbar mainActionbar = findViewById(R.id.main_actionbar);
        if(mainActionbar != null) setSupportActionBar(mainActionbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        resources = getResources();
        preferences = getSharedPreferences(resources.getString(R.string.tag_preferences_name), Context.MODE_PRIVATE);
        constructor = new PerfilConstructor(this);

        tie_usuario = findViewById(R.id.tie_usuario);
        pb_config = findViewById(R.id.pb_config);
        pb_config.setVisibility(View.GONE);
    }

    public void btnSaveAction(View view) {
        String account = tie_usuario.getText().toString().trim();

        if (!account.isEmpty()) {

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(resources.getString(R.string.tab_name_account), account);
            editor.apply();

            loadUsuario(view);
        } else {
            Snackbar.make(view, resources.getString(R.string.error_empty_field), Snackbar.LENGTH_LONG).show();
        }
    }

    public void loadUsuario(View view) {
        final View v = view;
        view.setEnabled(false);
        pb_config.setVisibility(View.VISIBLE);
        RestApiAdapter apiAdapter = new RestApiAdapter();
        ApiEndpoints endpoints = apiAdapter.connectRestApi();
        Call<UsuarioResponse> usuarioRequest = endpoints.getUsuario(constructor.getUsername());

        usuarioRequest.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                if (response.isSuccessful()) {
                    pb_config.setVisibility(View.GONE);
                    constructor.saveUsuario(response.body().getData()[0]);
                    Snackbar.make(v, resources.getString(R.string.success_save_account), Snackbar.LENGTH_LONG).show();
                } else {
                    pb_config.setVisibility(View.GONE);
                    Snackbar.make(v, resources.getString(R.string.error_connection), Snackbar.LENGTH_LONG).show();
                }
                v.setEnabled(true);
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                pb_config.setVisibility(View.GONE);
                Snackbar.make(v, resources.getString(R.string.error_connection), Snackbar.LENGTH_LONG).show();
                v.setEnabled(true);
                Log.e("PerfilPresenter", t.toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        String account = preferences.getString(resources.getString(R.string.tab_name_account), "");

        if (!account.isEmpty()) {
            tie_usuario.setText(account);
        }
    }
}
