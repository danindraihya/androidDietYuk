package com.example.dietkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dietkuy.retrofit.ApiClient;
import com.example.dietkuy.retrofit.JsonPlaceHolderApi;
import com.example.dietkuy.retrofit.model.AuthUser;
import com.example.dietkuy.retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText username, password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction t = manager.beginTransaction();
        final KenaikanFragment fKenaikan = new KenaikanFragment();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lusername = username.getText().toString();
                String lpassword = password.getText().toString();

                final JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);
                Call<AuthUser> login = jsonPlaceHolderApi.AuthUser(lusername, lpassword);
                login.enqueue(new Callback<AuthUser>() {
                    @Override
                    public void onResponse(Call<AuthUser> call, Response<AuthUser> response) {
                        if(response.code() == 202){
                            sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt("id", response.body().getId());
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", response.body().getId());
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthUser> call, Throwable t) {

                    }
                });
            }
        });

    }
}