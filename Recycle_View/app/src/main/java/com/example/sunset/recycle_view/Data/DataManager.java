package com.example.sunset.recycle_view.Data;

import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by SunSet on 2017. 10. 4..
 */

public class DataManager {

    public ArrayList<String> StringToArrayList(String data){
        ArrayList<String> arraylist = new ArrayList<>();
        String json = data;
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
        return arraylist;
    }

    public void ArrayListToString(ArrayList<String> arraylist , SharedPreferences.Editor editor){
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
    }


}
