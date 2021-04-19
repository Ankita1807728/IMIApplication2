package com.example.imiapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imiapplication.AdapterCallback;
import com.example.imiapplication.NavigationDrawer.AccountSettingFragment;
import com.example.imiapplication.NavigationDrawer.MailBoxFragment;
import com.example.imiapplication.NavigationDrawer.MatchesFragment;
import com.example.imiapplication.NavigationDrawer.NotificationFragment;
import com.example.imiapplication.NavigationDrawer.SearchFragment;
import com.example.imiapplication.R;
import com.example.imiapplication.Settings.ModelSettingClass;
import com.example.imiapplication.Adapter.SettingsRecyclerAdapter;
import com.example.imiapplication.Settings.PrivacyFragment;

import java.util.ArrayList;
import java.util.List;

public class Recyclerfragment extends Fragment {
    public Recyclerfragment() {
    }

    RecyclerView recyclerView;
    List<ModelSettingClass> itemlist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclermain, container, false);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //initData();
        recyclerView.setAdapter(new SettingsRecyclerAdapter(initData(), new AdapterCallback() {
            @Override
            public void onAddClick(int position) {
                if (position==0)
                //Log.i("----onclick called----",""+"");
                // Toast.makeText(getContext(), "recycler view", Toast.LENGTH_SHORT).show();
                    movetoNext(new NotificationFragment());
                else if (position==1)
                    movetoNext(new PrivacyFragment());
                else if (position==2)
                    movetoNext(new MatchesFragment());
                else if (position==3)
                    movetoNext(new SearchFragment());
                else if (position==4)
                    movetoNext(new MailBoxFragment());
                else if (position==5)
                    movetoNext(new AccountSettingFragment());


            }
        }));
        return view;
    }

    private void movetoNext(Fragment destFragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment, destFragment, "NewFragmentTag");
        ft.addToBackStack(null);
        ft.commit();
    }

    private List<ModelSettingClass> initData() {
        itemlist = new ArrayList<>();
        itemlist.add(new ModelSettingClass(R.drawable.notification, "Notification settings"));
        itemlist.add(new ModelSettingClass(R.drawable.privacy, "Privacy Settings"));
        itemlist.add(new ModelSettingClass(R.drawable.call_prefrence, "call Prefrences"));
        itemlist.add(new ModelSettingClass(R.drawable.ic_contactbook, "Contact Settings"));
        itemlist.add(new ModelSettingClass(R.drawable.profile_setting, "Profile Settings"));
        itemlist.add(new ModelSettingClass(R.drawable.account_setting, "Account Settings"));
        return itemlist;
    }
}
