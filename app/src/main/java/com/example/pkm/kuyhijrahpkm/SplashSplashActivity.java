package com.example.pkm.kuyhijrahpkm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashSplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_splash);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashSplashActivity.this,MainActivity.class));
                    finish();
                }
            }

        };
        thread.start();
    }
}