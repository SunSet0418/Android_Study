package com.example.sunset.listview;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
//ArrayList SharedPreference 데이터 저장방법
//https://gist.github.com/stack07142/44e3faf4b4f4632b5d3ac7194674cc74
public class WriteMemo extends AppCompatActivity {
    private EditText write;
    private ArrayList<String> arraylist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_memo);

    }
    public void save(View V){
        write = (EditText)findViewById(R.id.writememo);
        Intent intent = new Intent(WriteMemo.this, MainActivity.class);
        SharedPreferences sp = getSharedPreferences("Memo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        String json = sp.getString("Memo",null);
        if(json!=null){
            try{
                JSONArray a = new JSONArray(json);
                for(int i =0;i<a.length();i++){
                    String url = a.optString(i);
                    arraylist.add(url);
                }
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }

        arraylist.add(write.getText().toString());

        if (arraylist != null && !arraylist.isEmpty()) {

            JSONArray a = new JSONArray();

            for (int i = 0; i < arraylist.size(); i++) {

                a.put(arraylist.get(i));
            }

            editor.putString("Memo", a.toString());
        }
        else {
            editor.putString("Memo", null);
        }
        editor.apply();

        Log.e("LOG ",sp.getString("Memo", "").toString());

        startActivity(intent);

    }
}
