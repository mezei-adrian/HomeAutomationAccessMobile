package com.example.adrian.homeautomationaccessmobile.mock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.example.adrian.homeautomationaccessmobile.network.ControlsApi;
import com.example.adrian.homeautomationaccessmobile.network.NetworkConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {


    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ControlsApi provideControlsApi(Retrofit retrofit) {
        return new MockControlsApi();
    }

}
