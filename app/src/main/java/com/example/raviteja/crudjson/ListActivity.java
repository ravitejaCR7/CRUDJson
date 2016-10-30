package com.example.raviteja.crudjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] name,hostel;
    ArrayList<DataProvider> arrayList=new ArrayList<DataProvider>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        name= new String[]{"ravi", "teja", "kiran", "kumar"};
        hostel= new String[]{"umm","mmu","kjasd","ravi"};
        int i=0;
        for (String names : name )
        {
            DataProvider dataProvider= new DataProvider(names,hostel[i],R.mipmap.ic_launcher);
            arrayList.add(dataProvider);
            i++;
        }
        adapter= new AdapterClass(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
