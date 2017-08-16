package com.example.sunset.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.nio.file.attribute.UserPrincipalLookupService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View V){
        User user;
        EditText getusername = (EditText)findViewById(R.id.username) ;
        EditText getid = (EditText)findViewById(R.id.id);
        EditText getpassword = (EditText)findViewById(R.id.password);
        final TextView responseview = (TextView)findViewById(R.id.response);

        String username = getusername.getText().toString();
        String id = getid.getText().toString();
        String password = getpassword.getText().toString();

        Log.e("Username ",username);
        Log.e("ID ",id);
        Log.e("Password ",password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitInter.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final RetrofitInter apiRequest = retrofit.create(RetrofitInter.class);

        apiRequest.register(username, id, password).enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("Response Username",response.body().getusername());
                Log.e("Response ID",response.body().getid());
                Log.e("Response Password",response.body().getpassword());
                Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                responseview.setText("Username : "+response.body().getusername()+"\n"+"ID : "+response.body().getid()+"\n"+"Password : "+response.body().getpassword());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Register Fail", Toast.LENGTH_SHORT).show();
                Log.e("Response ","Fail");
            }

        });

    }
}
