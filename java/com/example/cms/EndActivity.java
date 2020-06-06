package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class EndActivity extends AppCompatActivity {

    Button mButtonEnd , mButtonBack ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        mButtonEnd = (Button)findViewById(R.id.button4);
        mButtonBack = (Button)findViewById(R.id.button6);
        mButtonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent l = new Intent(EndActivity.this,LoginActivity.class);
                startActivity(l);
            }
        });
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gb = new Intent(EndActivity.this,DoctorActivity.class);
                startActivity(gb);
            }
        });
    }
}
