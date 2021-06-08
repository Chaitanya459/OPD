package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class bookingactivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingactivity);
        t1=(TextView)findViewById(R.id.textView7);
        t2=(TextView)findViewById(R.id.textView9);
        t3=(TextView)findViewById(R.id.textView10);
        t4=(TextView)findViewById(R.id.textView11);
        t5=(TextView)findViewById(R.id.textView12);
        t6=(TextView)findViewById(R.id.textView13);
        Intent i=getIntent();
        String s2=i.getStringExtra("1");
        String s3=i.getStringExtra("2");
        String s4=i.getStringExtra("3");
        String s5=i.getStringExtra("4");
        String s6=i.getStringExtra("5");
        String s7=i.getStringExtra("6");
            t2.setText("Name: " + (s3 + " " + s2));
            t3.setText("Age: " + s4);
            t4.setText("Email: " + s5);
            t5.setText("Phone Number: " + s6);
            t6.setText("Booking Time"+ s7);


    }
}
