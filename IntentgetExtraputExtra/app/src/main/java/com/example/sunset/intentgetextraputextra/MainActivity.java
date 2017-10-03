package com.example.sunset.intentgetextraputextra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText id;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View V){
        id = (EditText)findViewById(R.id.id);
        password = (EditText)findViewById(R.id.password);
        Intent login = new Intent(MainActivity.this, NextActivity.class);
        login.putExtra("id", id.getText().toString());
        login.putExtra("password", password.getText().toString());
        Log.e("ID ",id.getText().toString());
        Log.e("Password ",password.getText().toString());
        startActivity(login);

    }
}
