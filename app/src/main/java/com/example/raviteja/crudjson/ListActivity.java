package com.example.raviteja.crudjson;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class ListActivity extends AppCompatActivity {

    //Toolbar toolbar;
    int imgValue=0;
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
            imgValue=imageSetter(textArray_name.get(i));
            if (imgValue>=0)
            {
                DataProvider dataProvider= new DataProvider(textArray_name.get(i),textArray_hostel.get(i),imgValue);
                arrayList.add(dataProvider);
            }
        }
        adapter= new AdapterClass(arrayList);
        recyclerView.setHasFixedSize(true);
        //layoutManager= new StaggeredGridLayoutManager(2,1);
        layoutManager= new LinearLayoutManager(this);

        recyclerView.setItemAnimator(new SlideInLeftAnimator());
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
    private int imageSetter(String name) {
        int imgResult = 0;
        if (String.valueOf(name.charAt(0)).equals("a") || String.valueOf(name.charAt(0)).equals("A")) {
            imgResult = R.drawable.a;
        } else if (String.valueOf(name.charAt(0)).equals("b") || String.valueOf(name.charAt(0)).equals("B")) {
            imgResult = R.drawable.b;
        } else if (String.valueOf(name.charAt(0)).equals("c")|| String.valueOf(name.charAt(0)).equals("C")) {
            imgResult = R.drawable.c;
        }
        else if (String.valueOf(name.charAt(0)).equals("d") || String.valueOf(name.charAt(0)).equals("D")) {
            imgResult = R.drawable.d;
        }
        else if (String.valueOf(name.charAt(0)).equals("e")|| String.valueOf(name.charAt(0)).equals("E")) {
            imgResult = R.drawable.e;
        }
        else if (String.valueOf(name.charAt(0)).equals("f")|| String.valueOf(name.charAt(0)).equals("F")) {
            imgResult = R.drawable.f;
        }
        else if (String.valueOf(name.charAt(0)).equals("g") || String.valueOf(name.charAt(0)).equals("G")) {
            imgResult = R.drawable.g;
        }
        else if (String.valueOf(name.charAt(0)).equals("h")|| String.valueOf(name.charAt(0)).equals("H")) {
            imgResult = R.drawable.h;
        }
        else if (String.valueOf(name.charAt(0)).equals("i") || String.valueOf(name.charAt(0)).equals("I")) {
            imgResult = R.drawable.i;
        }
        else if (String.valueOf(name.charAt(0)).equals("j") || String.valueOf(name.charAt(0)).equals("J")) {
            imgResult = R.drawable.j;
        }
        else if (String.valueOf(name.charAt(0)).equals("k") || String.valueOf(name.charAt(0)).equals("K")) {
            imgResult = R.drawable.k;
        }
        else if (String.valueOf(name.charAt(0)).equals("l") || String.valueOf(name.charAt(0)).equals("L")) {
            imgResult = R.drawable.l;
        }
        else if (String.valueOf(name.charAt(0)).equals("m") || String.valueOf(name.charAt(0)).equals("M"))
        {
            imgResult=R.drawable.m;
        }
        else if(String.valueOf(name.charAt(0)).equals("n")||String.valueOf(name.charAt(0)).equals("N"))
        {
            imgResult=R.drawable.n;
        }
        else if(String.valueOf(name.charAt(0)).equals("o")||String.valueOf(name.charAt(0)).equals("O"))
        {
            imgResult=R.drawable.o;
        }
        else if(String.valueOf(name.charAt(0)).equals("p")||String.valueOf(name.charAt(0)).equals("P"))
        {
            imgResult=R.drawable.p;
        }
        else if(String.valueOf(name.charAt(0)).equals("q")||String.valueOf(name.charAt(0)).equals("Q"))
        {
            imgResult=R.drawable.q;
        }
        else if(String.valueOf(name.charAt(0)).equals("r")||String.valueOf(name.charAt(0)).equals("R"))
        {
            imgResult=R.drawable.r;
        }
        else if(String.valueOf(name.charAt(0)).equals("s")||String.valueOf(name.charAt(0)).equals("S"))
        {
            imgResult=R.drawable.s;
        }
        else if(String.valueOf(name.charAt(0)).equals("t")||String.valueOf(name.charAt(0)).equals("T"))
        {
            imgResult=R.drawable.t;
        }
        else if(String.valueOf(name.charAt(0)).equals("u")||String.valueOf(name.charAt(0)).equals("U"))
        {
            imgResult=R.drawable.u;
        }
        else if(String.valueOf(name.charAt(0)).equals("v")||String.valueOf(name.charAt(0)).equals("V"))
        {
            imgResult=R.drawable.v;
        }
        else if(String.valueOf(name.charAt(0)).equals("w")||String.valueOf(name.charAt(0)).equals("W"))
        {
            imgResult=R.drawable.w;
        }
        else if(String.valueOf(name.charAt(0)).equals("x")||String.valueOf(name.charAt(0)).equals("X"))
        {
            imgResult=R.drawable.x;
        }
        else if(String.valueOf(name.charAt(0)).equals("y")||String.valueOf(name.charAt(0)).equals("Y"))
        {
            imgResult=R.drawable.y;
        }
        else if(String.valueOf(name.charAt(0)).equals("z")||String.valueOf(name.charAt(0)).equals("Z"))
        {
            imgResult=R.drawable.z;
        }
        else
        {
            imgResult= -1;
        }
          return  imgResult;
    }
}
