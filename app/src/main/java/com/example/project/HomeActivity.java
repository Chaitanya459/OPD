package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        LogoLauncher logoLauncher=new LogoLauncher();
        logoLauncher.start();
    }

    private class LogoLauncher extends Thread {
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {

            }

            Intent intent1 = new Intent(HomeActivity.this, loginactivity.class);
            startActivity(intent1);
            HomeActivity.this.finish();
        }
    }
}