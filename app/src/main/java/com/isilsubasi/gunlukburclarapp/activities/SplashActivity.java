package com.isilsubasi.gunlukburclarapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.isilsubasi.gunlukburclarapp.R;
import com.isilsubasi.gunlukburclarapp.activities.ListeActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();

    }

    private void init(){
        CountDownTimer countDownTimer=new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                openScreen();

            }
        };
        countDownTimer.start();
    }


    private void openScreen(){
        Intent intent=new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(intent);
        finish();
    }


}