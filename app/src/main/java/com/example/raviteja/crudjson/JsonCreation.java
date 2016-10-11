package com.example.raviteja.crudjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonCreation extends AppCompatActivity {

    EditText eName,eHostel;
    public String n,h;
    FileCreation fileObj;
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


        JSONObject mainObj = new JSONObject();
        try {
            mainObj.put("name",n);
            mainObj.put("hostel",h);
            Toast.makeText(getApplicationContext(),eName.getText()+"  "+eHostel.getText(),Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("error",n+"   "+h);
        fileObj.fileCreationCall(mainObj);
        Toast.makeText(getApplicationContext(),"check ES explorer",Toast.LENGTH_SHORT).show();
    }
}
