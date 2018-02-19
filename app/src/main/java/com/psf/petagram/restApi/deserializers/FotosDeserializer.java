package com.psf.petagram.restApi.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.psf.petagram.models.Foto;
import com.psf.petagram.restApi.JsonKeys;
import com.psf.petagram.restApi.models.FotoResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public class FotosDeserializer implements JsonDeserializer<FotoResponse> {


    @Override
    public FotoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        FotoResponse fotoResponse = gson.fromJson(json, FotoResponse.class);

        JsonArray data = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        fotoResponse.setFotos(deserializarFotosJson(data));

        return fotoResponse;
    }

    private ArrayList<Foto> deserializarFotosJson(JsonArray dataArray) {
        ArrayList<Foto> fotos = new ArrayList<>();

        for (int i=0; i < dataArray.size(); i++) {
            JsonObject data = dataArray.get(i).getAsJsonObject();

            JsonObject user = data.getAsJsonObject(JsonKeys.USER);
            String id = user.get(JsonKeys.USER_ID).getAsString();
            String full_name = user.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject image = data.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject standar_resolution = image.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String foto_url = standar_resolution.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likes = data.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes_count = likes.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Foto foto = new Foto();
            foto.setFoto_url(foto_url);
            foto.setLikes(likes_count);

            fotos.add(foto);
        }

        return fotos;
    }
}
