package com.example.raviteja.crudjson;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Creation extends AppCompatActivity {

    EditText nameEdit,emailEdit;
    TextView checkingValue;
    String nameValue,emailValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        nameEdit= (EditText)findViewById(R.id.editText_nameCreate);
        emailEdit= (EditText)findViewById(R.id.editText_emailCreate);
        checkingValue= (TextView)findViewById(R.id.textView_SDCardCheck);

    }

    private void checkExternalMedia(){
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // Can read and write the media
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // Can only read the media
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            // Can't read or write
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
        checkingValue.append("\n\nExternal Media: readable="
                +mExternalStorageAvailable+" writable="+mExternalStorageWriteable);
    }
    public void checkSDCard(View v)
    {

        checkExternalMedia();
    }





    public void gettingTextFromEditText()
    {
        nameValue= nameEdit.getText().toString();
        emailValue= emailEdit.getText().toString();
    }
    public void creationButton(View v)
    {
        gettingTextFromEditText();
        Toast.makeText(getApplicationContext(),nameValue+" ...  "+emailValue,Toast.LENGTH_SHORT).show();
        JSONCreationClass jsonObj=new JSONCreationClass();
        //jsonObj.storinngInFile(getApplicationContext(),nameValue, emailValue);
        jsonObj.fastTrack(getApplicationContext());
        Log.e("file call","error after file");
        Toast.makeText(getApplicationContext(),"after",Toast.LENGTH_LONG).show();
    }
}
