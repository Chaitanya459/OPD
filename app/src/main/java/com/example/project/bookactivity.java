package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class bookactivity extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5;
    String s1, s2, s3, s4, s5;
    TextView t1, t2;
    Button b1;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookactivity);
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        e5 = (EditText) findViewById(R.id.editText5);
        b1 = (Button) findViewById(R.id.button6);
        r2=findViewById(R.id.rb1);
        r3=findViewById(R.id.rb2);
        radioGroup=findViewById(R.id.radioGroup);
        t1 = (TextView) findViewById(R.id.textView8);
        Intent i = getIntent();
        String s11 = i.getStringExtra("doctor");
        t1.setText("Doctor Details:  " + s11);

        t2 = findViewById(R.id.display);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(bookactivity.this, bookingactivity.class);
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();
                s5 = e5.getText().toString();
                if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s3) || TextUtils.isEmpty(s4) || TextUtils.isEmpty(s5)) {
                    Intent intenta = new Intent(bookactivity.this, bookactivity.class);
                    Toast.makeText(getApplicationContext(), "Please Enter Your Details Again", Toast.LENGTH_LONG).show();
                    startActivity(intenta);
                }
                Bundle bundle = new Bundle();
                bundle.putString("1", s1);
                bundle.putString("2", s2);
                bundle.putString("3", s3);
                bundle.putString("4", s4);
                bundle.putString("5", s5);
                bundle.putString("6","3.00 PM");
                intent2.putExtras(bundle);
                startActivity(intent2);
                Toast toast = Toast.makeText(getApplicationContext(), "Booking Confirmed", Toast.LENGTH_LONG);
                toast.show();
            }
        });




    }

    public void checkButton(View v) {
        int radioID = radioGroup.getCheckedRadioButtonId();
        r1 = findViewById(radioID);

       if(r1==r2){
           t2.setText("Available");
       }
       else{
           t2.setText("Un Available");
       }
    }
}
