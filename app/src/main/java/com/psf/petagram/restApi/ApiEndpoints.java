package com.psf.petagram.restApi;

import com.psf.petagram.restApi.models.FotoResponse;
import com.psf.petagram.restApi.models.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public interface ApiEndpoints {

    @GET(ApiConstants.SEARCH_USER)
    Call<UsuarioResponse> getUsuario(@Query("q") String username);

    @GET(ApiConstants.MEDIA_RECENT)
    Call<FotoResponse> getMedia(@Path("id") String id);

}
