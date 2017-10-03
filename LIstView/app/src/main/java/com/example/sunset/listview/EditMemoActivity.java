package com.example.sunset.listview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class EditMemoActivity extends AppCompatActivity {
    private EditText edit;
    private static int position;
    private ArrayList<String> arraylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_memo);
        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
        edit = (EditText)findViewById(R.id.edittext);
        edit.setText(intent.getExtras().getString("data"));
    }

    public void save(View V){
        Intent intent = new Intent(EditMemoActivity.this, MainActivity.class);
        edit = (EditText)findViewById(R.id.edittext);
        SharedPreferences sp = getSharedPreferences("Memo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        String json = sp.getString("Memo", null);
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

        arraylist.set(position, edit.getText().toString());

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
        startActivity(intent);
    }

    public void delete(View V){
        final Intent intent = new Intent(EditMemoActivity.this, MainActivity.class);
        final SharedPreferences sp = getSharedPreferences("Memo", Activity.MODE_PRIVATE);

        AlertDialog.Builder ab = new AlertDialog.Builder(EditMemoActivity.this);
        ab.setMessage("정말 이 메모를 삭제하시겠습니까?");
        ab.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences.Editor editor = sp.edit();
                arraylist.remove(position);

                if (arraylist != null && !arraylist.isEmpty()) {

                    JSONArray a = new JSONArray();

                    for (int j = 0; j < arraylist.size(); j++) {

                        a.put(arraylist.get(j));
                    }

                    editor.putString("Memo", a.toString());
                }
                else {
                    editor.putString("Memo", null);
                }
                editor.apply();
                startActivity(intent);
            }
        });
        ab.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        ab.show();

        String json = sp.getString("Memo", null);
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




    }
}
