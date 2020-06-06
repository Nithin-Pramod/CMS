package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StartingActivity extends AppCompatActivity {
    TextView mStart,mDnM,mHC;
    ImageView mDnmI,mHMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        mStart = (TextView)findViewById(R.id.textView6);
        mDnM = (TextView)findViewById(R.id.textView7);
        mHC = (TextView)findViewById(R.id.textView8);
        mDnmI = (ImageView)findViewById(R.id.imageView5);
        mHMI = (ImageView)findViewById(R.id.imageView6);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StartingActivity.this,"redirecting to login page",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StartingActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        mDnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StartingActivity.this,"Doctors near me",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StartingActivity.this,PatientActivity.class);
                startActivity(i);
            }
        });
        mHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StartingActivity.this,"Health Checkup",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StartingActivity.this,CheckUpActivity.class);
                startActivity(i);
            }
        });
        mDnmI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StartingActivity.this,"Doctors near me",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StartingActivity.this,PatientActivity.class);
                startActivity(i);
            }
        });
        mHMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StartingActivity.this,"Health Checkup",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StartingActivity.this,CheckUpActivity.class);
                startActivity(i);
            }
        });
    }
}
