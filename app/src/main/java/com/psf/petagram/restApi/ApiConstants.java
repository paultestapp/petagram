package com.psf.petagram.restApi;

/**
 * Created by paulsalcedo on 18/2/18.
 */

public final class ApiConstants {



    public static final String ACCESS_TOKEN = "7130947973.e0ca64d.b2a1c21b5fca4910a1d5f8d2e52d8d5d";

    public static final String VERSION = "v1/";
    public static final String ROOT_URL = "https://api.instagram.com/";

    // https://api.instagram.com/v1/users/search?q=paul.apptest&access_token=
    public static final String SEARCH_USER = VERSION + "users/search?access_token=" + ACCESS_TOKEN;

    // https://api.instagram.com/v1/users/7135910775/media/recent/?access_token=7130947973.e0ca64d.b2a1c21b5fca4910a1d5f8d2e52d8d5d
    public static final String MEDIA_RECENT = VERSION + "users/{id}/media/recent/?access_token=" + ACCESS_TOKEN;


}