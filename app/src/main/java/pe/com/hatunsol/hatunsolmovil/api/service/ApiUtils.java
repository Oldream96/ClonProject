package pe.com.hatunsol.hatunsolmovil.api.service;

import pe.com.hatunsol.hatunsolmovil.api.retrofit.ApiRetrofit;

public class ApiUtils {

    public ApiUtils() {
    }

    public static final String API_URL = "http://192.168.1.154:16616/";
//public static final String API_URL = "http://www.hatunsol.com.pe/ws_hatun_Testing/";
    public static Services getService(){
        return ApiRetrofit.getClient(API_URL).create(Services.class);
    }
}
