package com.example.adrian.homeautomationaccessmobile.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder().baseUrl(NetworkConfig.ENDPOINT_ADDRESS).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @Singleton
    public ControlsApi provideControlsApi(Retrofit retrofit){
        return retrofit.create(ControlsApi.class);
    }
}
