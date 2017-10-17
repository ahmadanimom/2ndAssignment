package com.example.hp.fragmentlab.Events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.fragmentlab.R;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventMain extends AppCompatActivity {

    private TextView showMessage ;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_main);
         showMessage= (TextView) findViewById(R.id.txt_show_event);
        image = (ImageView) findViewById(R.id.image_picaso);

        Picasso.with(this).load(R.drawable.bg) .resize(50, 50)
                .centerCrop().into(image);

/*
        Picasso.with(this).load(R.drawable.bg) .resize(50, 50)
                .centerCrop().into(image);
        */
// .transform(new PRoundedCornersTransformation(30, 0, PRoundedCornerTransformation.CornerType.ALL))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MyEventData event) {
     //   Toast.makeText(this,"Some Event is in Main" , Toast.LENGTH_SHORT).show();

        showMessage.setText("My Event is this");
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
