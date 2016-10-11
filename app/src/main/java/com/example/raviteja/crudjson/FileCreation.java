package com.example.raviteja.crudjson;

import android.os.Environment;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by RaviTeja on 11-10-2016.
 */
public class FileCreation {

    public void fileCreationCall(JSONObject obj)
    {
        File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        if(!root.exists())
        {
            root.mkdirs();
        }
        File file = new File(root, "avinash1.txt");
        try {
            if (file.exists()) {file.delete ();}
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(obj.toString());
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
