package com.example.imiapplication.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.imiapplication.Fragment.BlockedFragment;
import com.example.imiapplication.Fragment.IgnoredFragment;
import com.example.imiapplication.NavigationDrawer.IdSearchFragment;
import com.example.imiapplication.NavigationDrawer.SavedSearch;
import com.example.imiapplication.NavigationDrawer.SearchTabFragment;
import com.example.imiapplication.R;

public class SearchAdapter extends FragmentStatePagerAdapter{
    Context context;
    int totalTabs;
    public SearchAdapter(Context c, @NonNull FragmentManager fm, int behavior, int totalTabs) {
        super(fm, behavior);
        context = c;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SearchTabFragment searchTabFragment = new SearchTabFragment();
                return searchTabFragment;
            case 1:
                SavedSearch savedSearch = new SavedSearch();
                return savedSearch;
            case 2:
                IdSearchFragment idSearchFragment= new IdSearchFragment();
                return idSearchFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
