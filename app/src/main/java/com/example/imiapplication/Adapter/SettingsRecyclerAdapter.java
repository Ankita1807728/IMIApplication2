package com.example.imiapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imiapplication.AdapterCallback;
import com.example.imiapplication.R;
import com.example.imiapplication.Settings.ModelSettingClass;

import java.util.List;

public class SettingsRecyclerAdapter extends RecyclerView.Adapter<SettingsRecyclerAdapter.ViewHolder> {
    private AdapterCallback adapterCallback;
    List<ModelSettingClass> itemList1;
    Context context;
    SettingsRecyclerAdapter.RecyclerViewClickListener listener;

    public SettingsRecyclerAdapter(List<ModelSettingClass> itemlist, AdapterCallback adapterCallback1 ) {
        this.itemList1=itemlist;
        this.adapterCallback=adapterCallback1;
    }

    public SettingsRecyclerAdapter() {

    }

    @NonNull
    @Override
    public SettingsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item,parent,false);
           ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull SettingsRecyclerAdapter.ViewHolder holder, int position) {
       holder.imageView.setImageResource(itemList1.get(position).getImageIcon());
       holder.textView.setText(itemList1.get(position).getText());
       holder.textView.setOnClickListener(v -> adapterCallback.onAddClick(position));

    }

    @Override
    public int getItemCount() {

        return itemList1.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.text);

        }

    }
}


