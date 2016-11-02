package com.example.raviteja.crudjson;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    //Toolbar toolbar;
    List<String> textArray_name,textArray_hostel;
    String previousJson = null;
    JSONObject jsonObject;
    File file= null;
    File root= null;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] name,hostel;
    ArrayList<DataProvider> arrayList=new ArrayList<DataProvider>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        fileChecking();
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        for (int i=0;i<textArray_name.size();i++)
        {
            DataProvider dataProvider= new DataProvider(textArray_name.get(i),textArray_hostel.get(i),R.mipmap.ic_launcher);
            arrayList.add(dataProvider);
        }
        adapter= new AdapterClass(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //toolbar= (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

    }
    public void fileChecking()
    {
        root = new File(Environment.getExternalStorageDirectory().getAbsolutePath());

        if(!root.exists())
        {
            root.mkdirs();
        }
        file = new File(root, "avinash1.json");
        if(file.exists())
        {
            previousJson= fileReader(file);
            Log.e("in U if condition",previousJson);
            try {
                jsonObject= new JSONObject(previousJson);
                retrieveValues(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"virgin application",Toast.LENGTH_SHORT).show();
            Intent returnIntent = new Intent(this,MainActivity.class);
            startActivity(returnIntent);
        }
    }
    public String fileReader(File f)
    {
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
        }
        Log.e("wtffff",text.toString());
        return  text.toString();
    }
    public void retrieveValues(JSONObject json)
    {
        textArray_name = new ArrayList<String>();
        textArray_hostel= new ArrayList<String>();
        try {
            JSONArray json_array= json.getJSONArray("id");
            for(int i=0;i<json_array.length();i++)
            {
                String checkValue = json_array.getJSONObject(i).getString("name");
                textArray_name.add(checkValue);
                textArray_hostel.add(json_array.getJSONObject(i).getString("hostel"));
            }
            Log.e("arraylist in U",textArray_name.toString());
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
