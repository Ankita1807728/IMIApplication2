package com.example.imiapplication.Adapter;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.imiapplication.Fragment.BlockedFragment;
import com.example.imiapplication.Fragment.IgnoredFragment;

public class ProfileAdapter extends FragmentStatePagerAdapter {
    Context context;
    int totalTabs;

    public ProfileAdapter(Context c, @NonNull FragmentManager fm, int behavior,int totalTabs) {
        super(fm, behavior);
        context = c;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Log.v("------",""+"BlockedFragment");
                BlockedFragment blockedFragment = new BlockedFragment();
                return blockedFragment;
            case 1:
                Log.v("------",""+"IgnoredFragment");
                IgnoredFragment ignoredFragment = new IgnoredFragment();
                return ignoredFragment;
            default:
                Log.v("------",""+"default");
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

}
