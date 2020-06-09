package com.example.dietkuy.retrofit;

import com.example.dietkuy.retrofit.model.AuthUser;
import com.example.dietkuy.retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @FormUrlEncoded
    @POST("auth/login/")
    Call<AuthUser> AuthUser(@Field("username") String username,
                            @Field("password") String password);

    @GET("auth/user/{id}")
    Call<User> getUser(@Path("id") int id);
}
