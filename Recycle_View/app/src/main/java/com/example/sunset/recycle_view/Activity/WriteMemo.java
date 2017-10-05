package com.example.sunset.recycle_view.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.sunset.recycle_view.Data.DataManager;
import com.example.sunset.recycle_view.R;

import java.util.ArrayList;

public class WriteMemo extends AppCompatActivity {
    private EditText getmemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_memo);
    }

    public void save(View V){
        DataManager dm = new DataManager();
        SharedPreferences sp = getSharedPreferences("Memo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        ArrayList<String> arraylist = new ArrayList<>();
        Intent intent = new Intent(WriteMemo.this, MainActivity.class);

        getmemo = (EditText)findViewById(R.id.memo);
        String data = sp.getString("Memo",null);
        String memo = getmemo.getText().toString();

        Log.e("Before Data ", sp.getString("Memo", null));

        arraylist = dm.StringToArrayList(data);

        arraylist.add(memo);

        Log.e("After Data ", arraylist.toString());

        dm.ArrayListToString(arraylist, editor);

        startActivity(intent);

    }
}
