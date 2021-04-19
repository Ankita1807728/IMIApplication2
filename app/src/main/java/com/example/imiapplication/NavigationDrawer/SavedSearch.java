package com.example.imiapplication.NavigationDrawer;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.imiapplication.R;

public class SavedSearch extends Fragment {
    private TextView textView;
    public SavedSearch() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.saved_search, container, false);

     textView = (TextView)view.findViewById(R.id.matrimoni_id);

        String t1 = getColoredSpanned("Matrimoni ID", "#000000");
        String t2 = getColoredSpanned("*","#FF0000");

        textView.setText(Html.fromHtml(t1+" "+t2));
        return view;
    }

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }
}
