package com.pharogrammer.fedora.damanhour.homiversity.http.module;

import com.pharogrammer.fedora.damanhour.homiversity.http.api.LecturesApiService;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fedora on 14/02/18.
 */

@Module
public class LecturesServiceModule {
    private static final String BASE_URL = "http://medobase.esy.es";

    @Provides
    OkHttpClient provideClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    Retrofit provideRetrofit(String baseUrl, OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    LecturesApiService provideLecturesApiService(){
        return provideRetrofit(BASE_URL, provideClient())
                .create(LecturesApiService.class);
    }
}
