package com.example.sunset.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInter {
    String BaseUrl = "http://soylatte.kr:3000";

    @FormUrlEncoded
    @POST("/login")
    Call<User> login(@Field("id") String id, @Field("password") String password);

    @FormUrlEncoded
    @POST("/register")
    Call<User> register(@Field("username") String username, @Field("id") String id, @Field("password") String password);
}
