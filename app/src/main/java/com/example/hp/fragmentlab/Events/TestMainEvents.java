package com.example.hp.fragmentlab.Events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hp.fragmentlab.ContactDetail;
import com.example.hp.fragmentlab.R;
import com.example.hp.fragmentlab.model.MyContacts;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TestMainEvents extends AppCompatActivity {
    private Button btnEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main_events);
        btnEvent = (Button) findViewById(R.id.btn_test_event);

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   EventBus.getDefault().post(new MyEventData("TestmainEvent"));

                EventBus.getDefault().postSticky(new MyEventData("stickyEventData"));
                Intent intent = new Intent(TestMainEvents.this , ContactDetail.class);
                startActivity(intent);

            }
        });
    }


}
