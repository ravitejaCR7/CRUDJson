package com.example.raviteja.crudjson;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RaviTeja on 02-10-2016.
 */
public class JSONCreationClass {
   /* public static void storinngInFile(Context context,String name,String email)
    {
        JSONObject mainObject= new JSONObject();
        try {
            mainObject.put("name", name);
            mainObject.put("email", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        File root = android.os.Environment.getExternalStorageDirectory();
        System.out.println("\nExternal file system root: "+root);

        // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder

        File dir = new File (root.getAbsolutePath() + "/download1122");
        dir.mkdirs();
        File file = new File(dir, "avinash.json");

        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println(mainObject.toString());
            pw.flush();
            pw.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("******* File not found. Did you" +
                    " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\nFile written to "+file);

        System.out.print(mainObject.toString());

    }*/
   public static void fastTrack(Context context) {

       JSONObject obj = new JSONObject();

       try {
           obj.put("age", new Integer(100));
           obj.put("name", "Ravi");
       } catch (JSONException e) {
           e.printStackTrace();
       }

       JSONArray list1 = new JSONArray();
       JSONObject pnObj = new JSONObject();
       try {
           pnObj.put("num", "99009900");
           pnObj.put("type", "mhgchmc");
           list1.put(pnObj);
           obj.put("phoneNumber", list1);

       } catch (JSONException e) {
           e.printStackTrace();
       }

       File root = android.os.Environment.getExternalStorageDirectory();
       System.out.println("\nExternal file system root: "+root);

       // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder

       File dir = new File (root.getAbsolutePath() + "/downl");
       dir.mkdirs();
       File file = new File(dir, "avinash.json");

       try {
           FileOutputStream f = new FileOutputStream(file);
           PrintWriter pw = new PrintWriter(f);
           pw.println(obj.toString());
           pw.flush();
           pw.close();
           f.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
           System.out.println("******* File not found. Did you" +
                   " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
       } catch (IOException e) {
           e.printStackTrace();
       }
       System.out.println("\n\nFile written to "+file);

       System.out.print(obj.toString());
   }

}
