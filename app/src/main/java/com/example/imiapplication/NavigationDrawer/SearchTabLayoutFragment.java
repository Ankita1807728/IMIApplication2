package com.example.imiapplication.NavigationDrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.imiapplication.Adapter.ProfileAdapter;
import com.example.imiapplication.Adapter.SearchAdapter;
import com.example.imiapplication.R;
import com.google.android.material.tabs.TabLayout;

public class SearchTabLayoutFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    public SearchTabLayoutFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.search_tab, container, false);
        tabLayout = view.findViewById(R.id.search_tab);
        viewPager = view.findViewById(R.id.search_viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("SEARCH"));
        tabLayout.addTab(tabLayout.newTab().setText("SEARCH BY ID"));
        tabLayout.addTab(tabLayout.newTab().setText("SAVED SEARCH"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        SearchAdapter adapter = new SearchAdapter(getContext(), getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        //tabLayout.setupWithViewPager(viewPager,true);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.v("---tab.getPosition()---", "" + tab.getPosition());
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        return view;
    }
}
