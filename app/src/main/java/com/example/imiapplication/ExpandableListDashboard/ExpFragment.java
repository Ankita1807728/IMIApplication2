package com.example.imiapplication.ExpandableListDashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.imiapplication.R;

public class ExpFragment extends Fragment {
    private ExpandableListView elv;

    private static final String[] groupname = {"New Matches",
            "Interest Received",
            "Mail Received",
            "Request Received",
            "Reminders Received",
            "Contact Viewed",
            "Recent Visitors",
            "Shortlisted Me",
            "Photo Viewed",
            "Pending Mail Replies",
            "Pending Interest"};

    private static final String[][] data = {{"A", "B","C"},
            {"Alok Giri", "Tarzen Daniel", "Nidant Ayyer"},
            {"a", "b", "c"},
            {"1", "2", "3"},
            {"A", "B", "C"},
            {"Alok Giri", "Tarzen Daniel", "Nidant Ayyer"},
            {"a", "b", "c"},
            {"1", "2", "3"},
            {"A", "B", "C"},
            {"Alok Giri", "Tarzen Daniel", "Nidant Ayyer"},
            {"a", "b", "c"}};

    private static final String[][] listinfo = {{"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"},
            {"03-DEC-2020", "03-DEC-2020", "03-DEC-2020"}};


    private static final int[] ImgBckgrnd = {R.drawable.ic_ellipse_1__1_,
            R.drawable.ic_ellipse_1__2_,
            R.drawable.ic_ellipse_1__3_,
            R.drawable.ic_ellipse_1__4_,
            R.drawable.ic_ellipse_1__5_,
            R.drawable.ic_ellipse_1__6_,
            R.drawable.ic_ellipse_1__7_,
            R.drawable.ic_ellipse_1__8_,
            R.drawable.ic_ellipse_1__9_,
            R.drawable.ic_ellipse_1__10_,
            R.drawable.ic_ellipse_1__12_};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expandable_list_dashboard, container, false);
        elv = (ExpandableListView)view.findViewById(R.id.lvExp1);
        elv.setFocusable(false);

        //Toast.makeText(getApplicationContext(),"main activity",Toast.LENGTH_SHORT).show();
        /**
         * THIS CAN BE USED IN ACTIVITY OR FRAGMENTS
         * **/

        elv.setAdapter(new CustomELVAdapter(getContext(), getActivity(),
                groupname, ImgBckgrnd, listinfo, data));


        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                /**
                 * TODO:return true to enable group click
                 */

                // DO SOMETHING

                return false;
            }
        });

    return view;
    }
}
