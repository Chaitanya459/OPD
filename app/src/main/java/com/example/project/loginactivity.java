package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import org.w3c.dom.Text;

public class loginactivity extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    EditText e1,e2;
    TextView t1,t2,t3,t4;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        mFirebaseAuth=FirebaseAuth.getInstance();
        final Button login,signup,skip,admin;
        t4=(TextView)findViewById(R.id.textView13) ;
        admin=(Button)findViewById(R.id.button7) ;
        e1=(EditText)findViewById(R.id.etname);
        e2=(EditText)findViewById(R.id.etpassword);
        t3=(TextView)findViewById(R.id.newsign);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.sign);
        skip=(Button)findViewById(R.id.skip);
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser=mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser!=null){
                    Toast.makeText(loginactivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(loginactivity.this,MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(loginactivity.this,"Please Login",Toast.LENGTH_SHORT).show();
                }
            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String pwd=e2.getText().toString();
                if(email.isEmpty()){
                    e1.setError("Please enter email id");
                    e1.requestFocus();
                }
                else if(pwd.isEmpty()){
                    e2.setError("Please enter your password");
                    e2.requestFocus();

                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(loginactivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(loginactivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(loginactivity.this,"Login Error,Please Login again",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent intToHome=new Intent(loginactivity.this,MainActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(loginactivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                }

                Intent intenta=new Intent(loginactivity.this,MainActivity.class);

                startActivity(intenta);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentb=new Intent(loginactivity.this,signupactivity.class);
                startActivity(intentb);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentc=new Intent(loginactivity.this,MainActivity.class);
                startActivity(intentc);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentd=new Intent(loginactivity.this,adminactivity.class);
                startActivity(intentd);
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
