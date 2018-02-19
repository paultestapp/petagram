package com.psf.petagram.restApi.adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.psf.petagram.restApi.ApiConstants;
import com.psf.petagram.restApi.ApiEndpoints;
import com.psf.petagram.restApi.deserializers.FotosDeserializer;
import com.psf.petagram.restApi.models.FotoResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public class RestApiAdapter {

    public ApiEndpoints connectRestApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiEndpoints.class);
    }

    public ApiEndpoints connectRestApi(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(ApiEndpoints.class);
    }

    public Gson GsonFotosDeserializer() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(FotoResponse.class, new FotosDeserializer());

        return builder.create();
    }

}
