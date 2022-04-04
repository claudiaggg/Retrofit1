package com.vogella.java.retrofitgerrit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

public interface TracksAPI {
    @GET("tracks")
    Call<List<Track>> findAllTracks();

    @GET("tracks/{id}")
    Call<Track> findOne(@Path("id") String id);

    @POST("tracks")
    Call<Track> addTrack(@Body Track t);

    @DELETE("tracks/{id}")
    Call<Track> deleteTrack(@Path("id") String id);

    @PUT("tracks")
    Call<Track> updateTrack(@Body Track t);
}
