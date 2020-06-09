package com.example.dietkuy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dietkuy.retrofit.ApiClient;
import com.example.dietkuy.retrofit.JsonPlaceHolderApi;
import com.example.dietkuy.retrofit.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    TextView username, height, weight, ttl;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    Integer id;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        sharedPreferences = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
        id = sharedPreferences.getInt("id", -1);
//        Bundle bundle = getActivity().getIntent().getExtras();
//        id = bundle.getInt("id");

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        username = rootView.findViewById(R.id.profile_name);
        height = rootView.findViewById(R.id.profile_height);
        weight = rootView.findViewById(R.id.profile_weight);
        ttl = rootView.findViewById(R.id.profile_ttl);

        jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);

        getData();
        return rootView;


    }

    private void getData(){
        Call<User> dataUser = jsonPlaceHolderApi.getUser(id);
        System.out.println("SASAS");
        dataUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println(response.code());
                username.setText(response.body().getUsername());
                height.setText(Integer.toString(response.body().getHeight()));
                weight.setText(Integer.toString(response.body().getWeight()));
                ttl.setText(response.body().getTtl());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}
