package com.example.sunset.listview;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> data = new ArrayList<>();
        SharedPreferences sp = getSharedPreferences("Memo", Activity.MODE_PRIVATE);
        ListView listview = (ListView)findViewById(R.id.listview);
        String json = sp.getString("Memo",null);
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    data.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditMemoActivity.class);
                String selected_item = (String)adapterView.getItemAtPosition(position);
                intent.putExtra("data", selected_item);
                intent.putExtra("position",position);
                Log.e("data ",selected_item);
                Log.e("position ",String.valueOf(position));
                startActivity(intent);
            }
        });
    }

    public void write(View V){
        Intent intent = new Intent(MainActivity.this, WriteMemo.class);
        startActivity(intent);
    }
}
