package com.example.sunset.intentgetextraputextra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NextActivity extends AppCompatActivity {
    private TextView result;
    ArrayList al = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        result = (TextView)findViewById(R.id.data);
        Intent intent = getIntent();
//        al.add(intent.getExtras());
        result.setText(
                "ID : "+intent.getExtras().getString("id")+"\n"+"Password : "+intent.getExtras().getString("password")
        );
    }
}
