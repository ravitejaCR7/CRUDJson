package com.example.raviteja.crudjson;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by RaviTeja on 23-10-2016.
 */
public class CheckingNetwork {
    public void connectivityCheck(Context ctx)
    {
        ConnectivityManager connectivityManager=(ConnectivityManager)ctx.getSystemService(ctx.CONNECTIVITY_SERVICE);
        if (connectivityManager!=null&&((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.CONNECTED)||(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()==NetworkInfo.State.CONNECTED)))
        {
            Log.e("net","yessssssss");
        }
        else if (connectivityManager!=null&&((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.DISCONNECTED)||(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()==NetworkInfo.State.DISCONNECTED)))
        {
            Log.e("no net","noooooo");
        }
    }
}
