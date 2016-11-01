package com.example.raviteja.crudjson;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by RaviTeja on 23-10-2016.
 */
public class CheckingNetwork {
    public int connectivityCheck(Context ctx)
    {
        int result=0;
        ConnectivityManager connectivityManager=(ConnectivityManager)ctx.getSystemService(ctx.CONNECTIVITY_SERVICE);
        if (connectivityManager!=null&&((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.CONNECTED)||(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()==NetworkInfo.State.CONNECTED)))
        {
            result=1;
            Log.e("net","yessssssss "+result);
        }
        else if (connectivityManager!=null&&((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.DISCONNECTED)||(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()==NetworkInfo.State.DISCONNECTED)))
        {
            result=0;
            Log.e("no net","noooooo "+result);
        }
        return result;
    }
}
