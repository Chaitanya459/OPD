
package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;


public class DocActivity extends AppCompatActivity {
    static Switch s1,s2,s3,s4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        s1=(Switch)findViewById(R.id.docpun);
        s2=(Switch)findViewById(R.id.switch2);
        s3=(Switch)findViewById(R.id.switch3);
        s4=(Switch)findViewById(R.id.switch4);

    }

    public static final boolean getStatus1() {
        if (s1.isChecked()){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean gettatus2(){
        return s2.isChecked();
    }
    public boolean getStatus3(){
        return s3.isChecked();
    }
    public boolean getStatus4(){
        return s4.isChecked();
    }
}
