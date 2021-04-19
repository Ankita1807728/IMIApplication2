package com.example.imiapplication.NavigationDrawer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.imiapplication.R;

public class AccountSettingFragment extends Fragment implements View.OnClickListener {
    private TextView tv_changePassword, hide;
    Context context;

    public AccountSettingFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view= inflater.inflate(R.layout.account_setting, container, false);

        tv_changePassword = (TextView)view.findViewById(R.id.tv_changePassword);
        tv_changePassword.setOnClickListener(this);

        hide = (TextView)view.findViewById(R.id.hide);
        hide.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.tv_changePassword:
               Fragment fragment = new ChangePassword();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
              break;

            case R.id.hide:
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Hide Account");
                builder.setMessage("Are you sure you want to hide your account? ").setPositiveButton("Yes", null).setNegativeButton("No", null);
                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
    }
}
