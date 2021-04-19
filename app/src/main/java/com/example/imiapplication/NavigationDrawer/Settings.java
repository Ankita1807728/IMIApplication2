package com.example.imiapplication.NavigationDrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.imiapplication.R;
import com.example.imiapplication.Settings.PrivacyFragment;

public class Settings extends Fragment implements View.OnClickListener {
    private TextView notification,
    privacy,
    call,
    contact,
    profile,
    account;

    public Settings() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.settings, container, false);

        notification = (TextView) view.findViewById(R.id.notification);
        privacy = (TextView) view.findViewById(R.id.privacy);
        call = (TextView) view.findViewById(R.id.call);
        contact = (TextView) view.findViewById(R.id.contact);
        profile = (TextView) view.findViewById(R.id.profile);
        account = (TextView) view.findViewById(R.id.account);

        notification.setOnClickListener(this);
        privacy.setOnClickListener(this);
        call.setOnClickListener(this);
        contact.setOnClickListener(this);
        profile.setOnClickListener(this);
        account.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment selectedFragment = null;
        switch (v.getId()) {
            case R.id.notification:
                selectedFragment= new NotificationFragment();
                break;

            case R.id.privacy:
                selectedFragment = new PrivacyFragment();
                break;

            case R.id.call:
                selectedFragment = new MatchesFragment();
                break;

            case R.id.contact:
                selectedFragment = new MailBoxFragment();
                break;

            case R.id.profile:
                selectedFragment = new PrivacyFragment();
                break;

            case R.id.account:
                selectedFragment = new AccountSettingFragment();
                break;
        }
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, selectedFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
        }
    }

