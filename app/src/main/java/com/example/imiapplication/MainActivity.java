package com.example.imiapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imiapplication.Adapter.SettingsRecyclerAdapter;
import com.example.imiapplication.Dashboard.CardViewFragment;
import com.example.imiapplication.ExpandableListDashboard.ExpFragment;
import com.example.imiapplication.Fragment.ProfileFragment;
import com.example.imiapplication.Fragment.Recyclerfragment;
import com.example.imiapplication.NavigationDrawer.AccountSettingFragment;
import com.example.imiapplication.NavigationDrawer.HelpAndSupportFragment;
import com.example.imiapplication.NavigationDrawer.MatchesFragment;
import com.example.imiapplication.NavigationDrawer.OffersFragment;
import com.example.imiapplication.NavigationDrawer.SearchFragment;
import com.example.imiapplication.NavigationDrawer.SearchTabLayoutFragment;
import com.example.imiapplication.NavigationDrawer.Settings;
import com.example.imiapplication.NavigationDrawer.WeddingServices;
import com.example.imiapplication.Settings.ModelSettingClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView nav;
    RecyclerView recyclerView;

    ImageView imageView;
    TextView textView;

    ArrayList<ModelSettingClass> modelSettingClasses;
    SettingsRecyclerAdapter settingsRecyclerAdapter;
    private SettingsRecyclerAdapter.RecyclerViewClickListener listener;

    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);

        nav = findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer_navigation, R.string.close_drawer_navigation);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);



    }

    LinearLayoutManager layoutmanager = new LinearLayoutManager(
            MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

    void setOnClickListener() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        settingsRecyclerAdapter = new SettingsRecyclerAdapter();
        recyclerView.setAdapter(settingsRecyclerAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.mail:
                selectedFragment = new ExpFragment();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.notification:
                selectedFragment = new CardViewFragment();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.match:
                selectedFragment = new ProfileFragment();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.chat:
                selectedFragment = new AccountSettingFragment();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.search:
                selectedFragment = new SearchTabLayoutFragment();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.setting:
                selectedFragment = new Settings();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.help:
                selectedFragment = new HelpAndSupportFragment();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.offer:
                selectedFragment = new OffersFragment();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.wedding:
                selectedFragment = new WeddingServices();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedFragment).commit();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.mail:
                    selectedFragment = new ExpFragment();
                    break;
                case R.id.notification:
                    selectedFragment = new CardViewFragment();
                    break;
                case R.id.match:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.chat:
                    selectedFragment = new AccountSettingFragment();
                    break;
                case R.id.search:
                    selectedFragment = new SearchTabLayoutFragment();
                    break;


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedFragment).commit();
            return true;
        }
    };


}
