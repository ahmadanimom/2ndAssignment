package com.example.hp.fragmentlab;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SampleFragment.OnFragmentInteractionListener {

    private static final String TAG = "MTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onButtonPress(String name) {
        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
        //  Log.d(TAG,"My Tag");
    }
}
