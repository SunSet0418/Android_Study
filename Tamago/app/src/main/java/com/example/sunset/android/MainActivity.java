package com.example.sunset.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int tap = 20;
    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = (TextView)findViewById(R.id.count);
        count.setText(String.valueOf(tap));
    }

    public void tap(View V){
        if(tap == 0){
            Toast.makeText(this, "알깨짐", Toast.LENGTH_SHORT).show();
        }
        else{
            tap--;
            count = (TextView)findViewById(R.id.count);
            count.setText(String.valueOf(tap));
        }

    }


}
