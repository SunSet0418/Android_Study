package com.example.sunset.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plus(View V){
        Log.e("PLUS"," ACCESS");
        Toast.makeText(this, "더하기", Toast.LENGTH_SHORT).show();

        EditText firstdata = (EditText)findViewById(R.id.firstdata);
        EditText seconddata = (EditText)findViewById(R.id.seconddata);
        TextView resultdata = (TextView)findViewById(R.id.result);

        Log.e("FirstData ",firstdata.getText().toString());
        Log.e("SecondData ",seconddata.getText().toString());

        int first = Integer.parseInt(firstdata.getText().toString());
        int second = Integer.parseInt(seconddata.getText().toString());

        String result = Integer.toString(first+second);

        Log.e("Result ",Integer.toString(first+second));

        resultdata.setText(result);
    }

    public void minus(View V){
        Log.e("MINUS"," ACCESS");
        Toast.makeText(this, "빼기", Toast.LENGTH_SHORT).show();

        EditText firstdata = (EditText)findViewById(R.id.firstdata);
        EditText seconddata = (EditText)findViewById(R.id.seconddata);
        TextView resultdata = (TextView)findViewById(R.id.result);

        Log.e("FirstData ",firstdata.getText().toString());
        Log.e("SecondData ",seconddata.getText().toString());

        int first = Integer.parseInt(firstdata.getText().toString());
        int second = Integer.parseInt(seconddata.getText().toString());

        String result = Integer.toString(first-second);

        Log.e("Result ",Integer.toString(first-second));

        resultdata.setText(result);
    }

    public void gop(View V){
        Log.e("GOP"," ACCESS");

        Toast.makeText(this, "곱하기", Toast.LENGTH_SHORT).show();

        EditText firstdata = (EditText)findViewById(R.id.firstdata);
        EditText seconddata = (EditText)findViewById(R.id.seconddata);
        TextView resultdata = (TextView)findViewById(R.id.result);

        Log.e("FirstData ",firstdata.getText().toString());
        Log.e("SecondData ",seconddata.getText().toString());

        int first = Integer.parseInt(firstdata.getText().toString());
        int second = Integer.parseInt(seconddata.getText().toString());

        String result = Integer.toString(first*second);

        Log.e("Result ",Integer.toString(first*second));

        resultdata.setText(result);
    }

    public void na(View V){
        Log.e("NA"," ACCESS");

        Toast.makeText(this, "나누기", Toast.LENGTH_SHORT).show();

        EditText firstdata = (EditText)findViewById(R.id.firstdata);
        EditText seconddata = (EditText)findViewById(R.id.seconddata);
        TextView resultdata = (TextView)findViewById(R.id.result);

        Log.e("FirstData ",firstdata.getText().toString());
        Log.e("SecondData ",seconddata.getText().toString());

        int first = Integer.parseInt(firstdata.getText().toString());
        int second = Integer.parseInt(seconddata.getText().toString());

        String result = Integer.toString(first/second);

        Log.e("Result ",Integer.toString(first/second));

        resultdata.setText(result);
    }

}
