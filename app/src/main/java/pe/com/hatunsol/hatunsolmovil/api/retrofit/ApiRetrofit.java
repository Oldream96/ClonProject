package pe.com.hatunsol.hatunsolmovil.api.retrofit;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;


import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.MINUTES;

public class ApiRetrofit {
    //Correcion de Retrofit
    private static Retrofit instance ;

    public static Retrofit getClient(String url){
        if (instance==null){
            Gson gson = new GsonBuilder()
                   // .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                 //   .excludeFieldsWithoutExposeAnnotation()
                    .create();
            instance=new Retrofit.Builder()
                    .client(getClient()).baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return instance;
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder().connectTimeout(1, MINUTES).readTimeout(1, MINUTES)
                .build();
    }
}