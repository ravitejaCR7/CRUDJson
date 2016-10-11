package com.example.raviteja.crudjson;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    Context context;
    FileCreation fcreate= new FileCreation();
    PermissionsClass pc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pc= new PermissionsClass(MainActivity.this);
    }
    public void onClick(View v)
    {
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (pc.checkPermission())
            {
                Log.e("ans", "Permission Granted, Now you can use internet");
                // Code for above or equal 23 API Oriented Device
                // Create a common Method for both
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();

            } else {
               pc.requestPermission();
                Log.e("ans1", "Permission Granted, Now you can use internet.");
            }
        }
        else
        {
            Log.e("ans2", "Permission Granted, Now you can use internet");

            // Code for Below 23 API Oriented Device
            // Create a common Method for both
        }
    }
    public void onCreateCall(View v)
    {
        Intent i = new Intent(this,JsonCreation.class);
        startActivity(i);
    }
}

