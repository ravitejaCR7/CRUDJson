package com.example.raviteja.crudjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//ON CLICK METHOS
    public void creationClick(View v)
    {
        //calling the callingActivityCreation() method
        callingActivityCreation();
    }
    public void retrievingClick(View v)
    {
        //calling the callingActivityCreation() method
        callingActivityRetrieving();
    }
//INTENT CALLING METHODS
    public void callingActivityCreation()
    {
        Intent i = new Intent(this, Creation.class);
        startActivity(i);
    }
    public void callingActivityRetrieving()
    {
        Intent i = new Intent(this, Retrieving.class);
        startActivity(i);
    }


}
