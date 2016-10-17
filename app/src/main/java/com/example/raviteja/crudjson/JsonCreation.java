package com.example.raviteja.crudjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonCreation extends AppCompatActivity {

    EditText eName,eHostel;
    public String n,h;
    FileCreation fileObj;
    List<String> textArray = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_creation);
        fileObj= new FileCreation();

    }

    public void onJSONClick(View v)
    {
        eName= (EditText)findViewById(R.id.editText_name);
        eHostel= (EditText) findViewById(R.id.editText_hostel);
        n= eName.getText().toString();
        h= eHostel.getText().toString();
        int flag=1;
        int s = textArray.size();
        if (textArray.size()==0)
        {
            textArray.add(n);
            fileObj.fileCreationCall(getApplicationContext(),n,h);
        }
        else
        {
            for (int i=0; i< textArray.size();i++)
            {
                if (textArray.get(i).equals(n))
                {
                    flag++;
                    Toast.makeText(getApplicationContext(),"redundancy",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            if (flag==1)
            {
                textArray.add(n);
                fileObj.fileCreationCall(getApplicationContext(),n,h);
                Toast.makeText(getApplicationContext(),"check ES explorer",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onTesting(View v)
    {

    }
}
