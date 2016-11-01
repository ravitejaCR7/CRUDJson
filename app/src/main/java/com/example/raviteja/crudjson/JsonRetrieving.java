package com.example.raviteja.crudjson;

import android.content.Intent;
import android.os.Environment;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class JsonRetrieving extends AppCompatActivity {

    List<String> textArray_name,textArray_hostel;
    String previousJson = null;
    JSONObject jsonObject;
    File file= null;
    File root= null;
    TextView tv_name,tv_hostel;
    //private Firebase mRef;
    //Firebase mRefChild;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef,mainRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_retrieving);
        Firebase.setAndroidContext(this);
        //mRef= new Firebase("https://crudjson.firebaseio.com/");
        tv_name=(TextView)findViewById(R.id.textView_name);
        tv_hostel=(TextView)findViewById(R.id.textView_hostel);
        mainRef = database.getReference("Root");
        mainRef.removeValue();
        fileChecking();

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
        textArray_hostel = new ArrayList<String>();
        try {
            JSONArray json_array= json.getJSONArray("id");
            for(int i=0;i<json_array.length();i++)
            {
                String checkName = json_array.getJSONObject(i).getString("name");
                String checkHostel = json_array.getJSONObject(i).getString("hostel");
                textArray_name.add(checkName);
                textArray_hostel.add(checkHostel);
            }
            Log.e("names in R",textArray_name.toString());
            Log.e("hostels in R",textArray_hostel.toString());
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void onUploadClick(View v)
    {
        //Firebase x[]= new Firebase[textArray_name.size()];
        for (int i=0;i<textArray_name.size();i++)
        {
            //mRefChild = mRef.child(textArray_name.get(i));
            //mRefChild.setValue(textArray_hostel.get(i));
            myRef = mainRef.child(textArray_name.get(i));
            myRef.setValue(textArray_hostel.get(i));
        }
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("wowwwwwwww", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("thussssssss", "Failed to read value.", error.toException());
            }
        });
    }

}
