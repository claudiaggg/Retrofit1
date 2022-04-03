package com.vogella.java.retrofitgerrit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TracksAPI {
    @GET("tracks")
    Call<List<Track>> findAllTracks();

    @GET("tracks/{id}")
    Call<Track> findOne(@Path("id") String id);

    @POST("tracks")
    Call<Track> addTrack(@Body Track t);
}
