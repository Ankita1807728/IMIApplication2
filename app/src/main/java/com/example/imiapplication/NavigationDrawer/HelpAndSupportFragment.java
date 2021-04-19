package com.example.imiapplication.NavigationDrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.imiapplication.Fragment.AboutUsFragment;
import com.example.imiapplication.Fragment.ContactUsFragment;
import com.example.imiapplication.Fragment.FeedbackFragment;
import com.example.imiapplication.Fragment.TermsAndCondition;
import com.example.imiapplication.R;

public class HelpAndSupportFragment extends Fragment implements View.OnClickListener {
    private TextView feedback, contact, chat, terms;
    public HelpAndSupportFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view;
      view = inflater.inflate(R.layout.help_and_support, container, false);
      feedback = (TextView)view.findViewById(R.id.feedback);
      feedback.setOnClickListener(this);

        contact = (TextView)view.findViewById(R.id.contact);
        contact.setOnClickListener(this);

        chat = (TextView)view.findViewById(R.id.chat);
        chat.setOnClickListener(this);

        terms = (TextView)view.findViewById(R.id.terms_and_conditions);
        terms.setOnClickListener(this);
      return view;
    }

    @Override
    public void onClick(View v) {
        Fragment selectedFragment = null;
        switch (v.getId()) {
            case R.id.feedback:
                selectedFragment = new FeedbackFragment();
                break;

            case R.id.contact:
                selectedFragment = new ContactUsFragment();
                break;

            case R.id.chat:
                selectedFragment = new AboutUsFragment();
                break;

            case R.id.terms_and_conditions:
                selectedFragment = new TermsAndCondition();
                break;
        }
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, selectedFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
        }
    }

