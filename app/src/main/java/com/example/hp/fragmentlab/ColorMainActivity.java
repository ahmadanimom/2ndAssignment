package com.example.hp.fragmentlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ColorMainActivity extends AppCompatActivity implements ColorFragment.OnFragmentInteractionListener {
    TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_main);
        txtDisplay = (TextView) findViewById(R.id.display_message);
    }

    @Override
    public void onButtonPress(String name) {

        if (name.equals("red")) {
            Toast.makeText(ColorMainActivity.this, name, Toast.LENGTH_SHORT).show();
            txtDisplay.setText(name);
            txtDisplay.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        } else if (name.equals("Green")) {
            Toast.makeText(ColorMainActivity.this, name, Toast.LENGTH_SHORT).show();
            txtDisplay.setText(name);
            txtDisplay.setBackgroundColor(getResources().getColor(R.color.colorGreen));
        } else if (name.equals("Yellow")) {
            Toast.makeText(ColorMainActivity.this, name, Toast.LENGTH_SHORT).show();
            txtDisplay.setText(name);
            txtDisplay.setBackgroundColor(getResources().getColor(R.color.colorYellow));
        }
    }
}
