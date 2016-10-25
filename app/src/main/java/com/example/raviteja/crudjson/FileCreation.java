package com.example.raviteja.crudjson;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
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

/**
 * Created by RaviTeja on 11-10-2016.
 */
public class FileCreation {
    JSONObject mO = null;
    JSONObject jO = new JSONObject();
    int flag=0;
    Context c;
    List<String> textArray;

    public void fileCreationCall(Context ctx, String name, String h_name)
    {
        c=ctx;
        File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        String previousJson = null;
        if(!root.exists())
        {
            root.mkdirs();
        }
        File file = new File(root, "avinash1.json");
        if(file.exists())
        {
            previousJson= fileReader(file);
            Log.e("in if condition",previousJson);
        }
        else {
            previousJson = "{}";
        }
        try
        {
                mO = new JSONObject(previousJson);
                jO.put("name", name);
                jO.put("hostel", h_name);
                mO.accumulate("id", jO);
                //checkUnique(mO);
                Log.e("after", mO.toString());
                String jsonString = null;
                jsonString = mO.toString(4);
                Log.e("final result",jsonString);
        //        deletionJSON(mO,textArray,name);
                fileWriter(mO,file);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
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
