package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class feedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final RatingBar rb=(RatingBar)findViewById(R.id.ratingBar);
        final TextView tv=(TextView)findViewById(R.id.textView15);
        Button b1=(Button)findViewById(R.id.button8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float r=rb.getRating();
                tv.setText("Your rating is"+r);
            }
        });
    }
}
