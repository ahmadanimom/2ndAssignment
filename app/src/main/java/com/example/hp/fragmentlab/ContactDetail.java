package com.example.hp.fragmentlab;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.fragmentlab.Events.MyEventData;
import com.example.hp.fragmentlab.model.MyContacts;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ContactDetail extends AppCompatActivity {

    private TextView txtShowName;
    private TextView txtShowPhone;
    private ImageView showImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        txtShowName = (TextView) findViewById(R.id.show_detail_name);
        txtShowPhone = (TextView) findViewById(R.id.show_detail_phone);
        showImage = (ImageView) findViewById(R.id.show_detail_image);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true, priority = 1)
    public void onEventBusEvent(MyContacts stickyEvent) {
        txtShowName.setText(stickyEvent.getName());
        txtShowPhone.setText(stickyEvent.getPhoen());
        showImage.setImageResource(stickyEvent.getImgId());
    }




    // Called in the background thread
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessage(MyEventData event) {
        txtShowName.setText(event.getData());
        Toast.makeText(this , "onMessage" , Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onEvent (MyEventData event) {
        txtShowName.setText(event.getData());
        Toast.makeText(this , "onEvent" , Toast.LENGTH_SHORT).show();
    }


    @Subscribe
    public void handleSomethingElse(MyEventData event) {
        txtShowName.setText("My Event is this");
        Toast.makeText(this , "onEndelSomethingElse" , Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MyEventData event) {
        txtShowName.setText("My Event is this");
        txtShowPhone.setText("0000000000");

        Toast.makeText(this , "onMsgEvent" , Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
