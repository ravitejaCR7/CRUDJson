package com.example.raviteja.crudjson;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by RaviTeja on 11-10-2016.
 */
public class PermissionsClass {
    private static final int PERMISSION_REQUEST_CODE1 = 1;
    private static final int PERMISSION_REQUEST_CODE2 = 2;
    private Context con;
    PermissionsClass(Context c)
    {
        con=c;
    }
    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(con, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    public boolean checkPermission1()
    {
        int result = ContextCompat.checkSelfPermission(con, Manifest.permission.INTERNET);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    public void requestPermission1() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) con, Manifest.permission.INTERNET)) {
            Toast.makeText(con, "Internet permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions((Activity) con, new String[]{Manifest.permission.INTERNET}, PERMISSION_REQUEST_CODE2);
        }
    }

    public void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) con, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(con, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions((Activity) con, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE1);
        }
    }


    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use storage");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
            case PERMISSION_REQUEST_CODE2:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use internet");
                } else {
                    Log.e("value", "Permission Denied, You cannot use net .");
                }
                break;
        }
    }
}
