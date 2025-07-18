package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread background = new Thread(){
            public void run (){
                try {
                    sleep(3*1000);
                    Intent myIntent = new Intent(getBaseContext(),FirstActivity.class);
                    startActivity(myIntent);
                    finish();
                }catch (Exception e){

                }
            }

        };
        background.start();


    }
}