package com.example.hp.fragmentlab.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hp.fragmentlab.R;
import com.example.hp.fragmentlab.adapter.RecycleAdapter;
import com.example.hp.fragmentlab.model.MyContacts;

import java.util.ArrayList;

public class RecyleViewMainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecycleAdapter mAdapter;
    private ArrayList arrayList;

    int [] img_id = {R.drawable.javed,R.drawable.bg,
            R.drawable.r1,
            R.drawable.ra2,R.drawable.ra3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyle_view_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        arrayList = new ArrayList();
    /*    for(int i=1 ; i<1000 ; i++){
            arrayList.add(new MyContacts("Name "+i , "phone "+ i ));
        }
        */

        for(int i=1 ; i<1000 ; i++){
            arrayList.add(new MyContacts("Name "+i , "phone "+ i, img_id[0] ));
        }

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new RecycleAdapter(arrayList ,this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
