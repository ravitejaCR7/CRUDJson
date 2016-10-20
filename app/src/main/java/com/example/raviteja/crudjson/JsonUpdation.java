package com.example.raviteja.crudjson;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUpdation extends AppCompatActivity {
    List<String> textArray;
    String previousJson = null;
    JSONObject jsonObject;
    File file= null;
    File root= null;
    EditText editText_key,editText_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_updation);
        fileChecking();
        editText_key=(EditText)findViewById(R.id.editText_key);
        editText_value=(EditText)findViewById(R.id.editText_value);
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
        textArray = new ArrayList<String>();
        try {
            JSONArray json_array= json.getJSONArray("id");
            for(int i=0;i<json_array.length();i++)
            {
                String checkValue = json_array.getJSONObject(i).getString("name");
                textArray.add(checkValue);
            }
            Log.e("arraylist in U",textArray.toString());
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void updationCall(View v)
    {
        String x= editText_key.getText().toString();
        int matchId= matchingValues(textArray,editText_key.getText().toString());
        try {
            JSONObject updatedJson= jsonObject.getJSONArray("id").getJSONObject(matchId);
            //updatedJson.put(editText_key.getText().toString(),editText_value.getText().toString());
            updatedJson.remove("name");
            updatedJson.remove("hostel");
            updatedJson.put("name",editText_key.getText().toString());
            updatedJson.put("hostel",editText_value.getText().toString());
            Log.e("updated u json",updatedJson.toString());
            Log.e("old main json",jsonObject.toString());
            fileWriter(jsonObject,file);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //testing for matchId
        /*
        if (matchId>=0)
        {
            try {
                Toast.makeText(getApplicationContext(),jsonObject.getJSONArray("id").getString(matchId).toString(),Toast.LENGTH_SHORT).show();
                String x1=jsonObject.getJSONArray("id").getString(matchId).toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"invalid key",Toast.LENGTH_SHORT).show();
        }*/
    }
    public int matchingValues(List<String> array,String key)
    {
        int m=-1;
        for (int i=0;i<array.size();i++)
        {
            if (array.get(i).equals(key))
            {
                m=i;
                break;
            }
        }
        return m;
    }
    public void fileWriter(JSONObject json,File f)
    {
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(json.toString());
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
