package com.vogella.java.retrofitgerrit;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<Track>>{
    static final String BASE_URL = "http://localhost:8080/dsaApp/";

    public void start() {

        System.out.println("Start!!!!");

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        System.out.println("111111!!!!");

        TracksAPI tracksAPI = retrofit.create(TracksAPI.class);
////////Funcion all tracks
        Call<List<Track>> call = tracksAPI.findAllTracks();
        call.enqueue(this);
//        call.enqueue(new Callback<List<Track>>() {
//            @Override
//            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Track>> call, Throwable t) {
//
//            }
        //});

////////Funcion encuentra 1 track
        Call<Track> call2 = tracksAPI.findOne("JvmV3Za84262772");
        call2.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                Track t =response.body();
                System.out.println("Funcion find one");
                System.out.println("xxxxxx " + t.getTitle());
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                t.printStackTrace();
            }
        });

        //////////Funcion añadir cancion
        Track t2 = new Track();
        t2.setId("123");
        t2.setSinger("fcgvhj");
        t2.setTitle("cgvhj");

        Call<Track> call3 = tracksAPI.addTrack(t2);
        call3.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                System.out.println("Añadida correctamente");
                //Track t =response.body();
                //System.out.println("xxxxxx"+t.getSinger());

            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {

            }
        });

    }

    @Override
    public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
        //response.code()==201
        System.out.println("Funcion all tracks");
        if(response.isSuccessful()) {
            List<Track> changesList = response.body();
            changesList.forEach(change -> System.out.println(change.id+ " "+change.title));
        } else {
            System.out.println(response.errorBody());
        }
    }


    @Override
    public void onFailure(Call<List<Track>> call, Throwable t) {
        t.printStackTrace();
    }
}
