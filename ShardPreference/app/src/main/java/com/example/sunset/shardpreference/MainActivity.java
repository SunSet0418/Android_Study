package com.example.sunset.shardpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView view;
    private EditText write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (TextView)findViewById(R.id.view);
        SharedPreferences preferences = getSharedPreferences("Memo", Activity.MODE_PRIVATE);
        view.setText(preferences.getString("Memo", "메모가 없습니다"));
    }

    public void save(View V){
        view = (TextView)findViewById(R.id.view);
        write = (EditText)findViewById(R.id.write);
        SharedPreferences preferences = getSharedPreferences("Memo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("Memo",write.getText().toString());
        edit.commit();
        view.setText(preferences.getString("Memo", "메모가 없습니다"));
    }
}
