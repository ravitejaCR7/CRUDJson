package com.example.raviteja.crudjson;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by talarir on 10/27/2016.
 */

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.RecyclerViewHolder> {
    private ArrayList<DataProvider> arrayList=new ArrayList<DataProvider>();

    public AdapterClass(ArrayList<DataProvider> arrayList)
    {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element,parent,false);
        RecyclerViewHolder recyclerViewHolder= new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position)
    {
        DataProvider dataProvider=arrayList.get(position);
        holder.img.setImageResource(dataProvider.getImages());
        holder.tx_name.setText(dataProvider.getName());
        holder.tx_hostel.setText(dataProvider.getHostel());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tx_name,tx_hostel;
        public RecyclerViewHolder(View itemView)
        {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageView2);
            tx_name=(TextView)itemView.findViewById(R.id.name);
            tx_hostel=(TextView)itemView.findViewById(R.id.hostel);
        }
    }
}
