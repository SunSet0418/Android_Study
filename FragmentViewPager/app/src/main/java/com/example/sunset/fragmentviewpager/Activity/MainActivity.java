package com.example.sunset.fragmentviewpager.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sunset.fragmentviewpager.Adapter.pagerAdapter;
import com.example.sunset.fragmentviewpager.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Friend = (Button)findViewById(R.id.friend);
        Button Chat = (Button)findViewById(R.id.chat);
        Button Channel = (Button)findViewById(R.id.channel);
        Button Setting = (Button)findViewById(R.id.setting);

        Friend.setOnClickListener(movePageListener);
        Chat.setOnClickListener(movePageListener);
        Channel.setOnClickListener(movePageListener);
        Setting.setOnClickListener(movePageListener);

        Friend.setTag(0);
        Chat.setTag(1);
        Channel.setTag(2);
        Setting.setTag(3);

        vp = (ViewPager)findViewById(R.id.vp);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

    }

    View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            vp.setCurrentItem(tag);
        }
    };

}
