package com.example.sunset.fragmentviewpager.Adapter;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;
import android.app.Fragment;

import com.example.sunset.fragmentviewpager.Fragment.ChannelFragment;
import com.example.sunset.fragmentviewpager.Fragment.ChatFragment;
import com.example.sunset.fragmentviewpager.Fragment.SettingFragment;
import com.example.sunset.fragmentviewpager.Fragment.UserListFragment;

/**
 * Created by SunSet on 2017. 10. 5..
 */

public class pagerAdapter extends FragmentStatePagerAdapter
{
    public pagerAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                return new UserListFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new ChannelFragment();
            case 3:
                return new SettingFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount()
    {
        return 4;
    }
}
