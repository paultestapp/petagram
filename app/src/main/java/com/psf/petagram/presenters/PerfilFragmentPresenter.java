package com.psf.petagram.presenters;

import android.content.Context;
import android.content.res.Resources;

import com.psf.petagram.interactors.PerfilConstructor;
import com.psf.petagram.models.Foto;
import com.psf.petagram.models.Usuario;
import com.psf.petagram.restApi.ApiEndpoints;
import com.psf.petagram.restApi.adapters.RestApiAdapter;
import com.psf.petagram.restApi.models.FotoResponse;
import com.psf.petagram.views.fragments.PerfilFragmentInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public class PerfilFragmentPresenter implements PerfilFragmentPresenterInterface {


    private PerfilFragmentInterface perfilFragmentInterface;
    private Context context;
    private Resources resources;

    private PerfilConstructor constructor;
    private ArrayList<Foto> fotos;

    public PerfilFragmentPresenter(PerfilFragmentInterface perfilFragmentInterface, Context context) {
        this.perfilFragmentInterface = perfilFragmentInterface;
        this.context = context;
        resources = context.getResources();

        constructor = new PerfilConstructor(context);
        getFotos();
    }

    @Override
    public Usuario getUsuario() {
        return constructor.getUsuario();
    }

    @Override
    public void getFotos() {
        if(!getUsuario().getId().isEmpty()) {
            perfilFragmentInterface.onLoadPhotos();
            RestApiAdapter apiAdapter = new RestApiAdapter();
            ApiEndpoints endpoints = apiAdapter.connectRestApi(apiAdapter.GsonFotosDeserializer());

            Call<FotoResponse> fotoResponse = endpoints.getMedia(getUsuario().getId());
            fotoResponse.enqueue(new Callback<FotoResponse>() {
                @Override
                public void onResponse(Call<FotoResponse> call, Response<FotoResponse> response) {
                    if(response.isSuccessful()) {
                        perfilFragmentInterface.onLoadPhotosSuccess();
                        fotos = response.body().getFotos();
                        showFotos();
                    } else {
                        perfilFragmentInterface.onLoadPhotosFail("");
                    }
                }

                @Override
                public void onFailure(Call<FotoResponse> call, Throwable t) {
                    perfilFragmentInterface.onLoadPhotosFail("");
                }
            });
        }

//        fotos = constructor.getFotos();
//        showFotos();
    }

    @Override
    public void showFotos() {
        perfilFragmentInterface.setAdapter(perfilFragmentInterface.makeAdapter(fotos));
        perfilFragmentInterface.makeRecyclerLayout();
    }
}
