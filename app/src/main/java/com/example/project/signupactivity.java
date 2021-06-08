package com.example.project;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.Tag;


public class signupactivity extends AppCompatActivity{
    Button submit;
    EditText name,last,dob,number,email,password,repass;

    FirebaseAuth fireauth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        fireauth=FirebaseAuth.getInstance();
        name=findViewById(R.id.firstname);
        last=findViewById(R.id.lastname);
        dob=findViewById(R.id.dob);
        number=findViewById(R.id.phone);
        email=(EditText) findViewById(R.id.email);
        password=findViewById(R.id.password);
        repass=findViewById(R.id.password1);
        submit=(Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==submit) {
                    ru();
                }


            }
        });
    }

        public void ru(){
        String s1=email.getText().toString().trim();
        String s2=password.getText().toString().trim();
        if(!(s1.isEmpty() && s2.isEmpty())) {
            fireauth.createUserWithEmailAndPassword(s1, s2)
                    .addOnCompleteListener(signupactivity.this, new OnCompleteListener<AuthResult>() {


                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!(task.isSuccessful())) {


                                Toast.makeText(signupactivity.this, "Registered UnSuccessfully", Toast.LENGTH_LONG).show();
                            } else {

                                Toast.makeText(signupactivity.this, "Registered UnSuccessfully", Toast.LENGTH_LONG).show();
                                Intent intenta=new Intent(signupactivity.this,MainActivity.class);
                                startActivity(intenta);
                            }

                        }


                    });
        }

    }




}
