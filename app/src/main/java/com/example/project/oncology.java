package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class oncology extends AppCompatActivity {

TextView t1;
String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oncology);
        Button b1;
        t1=(TextView)findViewById(R.id.textView9) ;
        b1=(Button)findViewById(R.id.buttonbook);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(oncology.this,bookactivity.class);
                s1=t1.getText().toString();
                intent.putExtra("doctor",s1);
                startActivity(intent);
            }
        });

    }
}
