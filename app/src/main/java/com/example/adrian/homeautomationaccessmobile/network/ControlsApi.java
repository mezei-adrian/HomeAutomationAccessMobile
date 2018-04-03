package com.example.adrian.homeautomationaccessmobile.network.controls;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ControlsApi {
    @GET("search")
    Call<ArtistsResult> getArtists(@Query("query") String artist,
                                   @Query("type") String type,
                                   @Query("offset") int offset,
                                   @Query("limit") int limit);
}
