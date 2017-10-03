package com.example.sunset.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final double i = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView one = (TextView) findViewById(R.id.textView);
        for(;;){
            i = i+0.00001;
            one.setText("%d", i);
        }
    }
}
