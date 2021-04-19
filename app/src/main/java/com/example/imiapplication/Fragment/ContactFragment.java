package com.example.imiapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.imiapplication.NavigationDrawer.ChangePassword;
import com.example.imiapplication.R;

public class ContactFragment extends Fragment implements View.OnClickListener {
    private ImageView icon1, icon2;

    public ContactFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.contact_setting, container, false);
        icon1 = (ImageView) view.findViewById(R.id.icon1);
        icon1.setOnClickListener(this);

      //  icon2 = (ImageView) view.findViewById(R.id.icon2);
        // icon2.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.icon1:
        Fragment fragment = new EditContact();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


}
    }
}