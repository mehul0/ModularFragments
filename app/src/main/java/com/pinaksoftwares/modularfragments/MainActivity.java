package com.pinaksoftwares.modularfragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int i) {

        android.app.FragmentManager manager = getFragmentManager();
        FragmentDetail fragmentDetail = (FragmentDetail) manager.findFragmentById(R.id.fragment2);
        if (i != -1){
            fragmentDetail.changeData(i);
        }
    }
}
