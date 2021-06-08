package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class adminactivity extends AppCompatActivity {

    TextView t1;
    EditText e1,e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminactivity);
        t1=(TextView)findViewById(R.id.tv);
        e1=(EditText)findViewById(R.id.adminid);
        e2=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(adminactivity.this,DocActivity.class);
                startActivity(i);
            }
        });
    }
}
