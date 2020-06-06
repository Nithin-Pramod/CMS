package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorActivity extends AppCompatActivity {
    TextView txtDetails;
    EditText inputName, inputPhoneNumber , inputPlace;
    Button btnSave,mButtonBa;
    private DatabaseReference mDatabase;

//    FirebaseDatabase database;
//    private void writeNewUser( String name, String number, String place) {
//        User user = new User(name, number, place);
//
//        mDatabase.child("user").setValue(user);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        inputName = (EditText)findViewById(R.id.DoctorName);
        mButtonBa = (Button)findViewById(R.id.button7);
        inputPhoneNumber = (EditText)findViewById(R.id.DoctorNumber);
        inputPlace = (EditText)findViewById(R.id.Place);
        btnSave = (Button)findViewById(R.id.DoctorButton);
        final String name = inputName.getText().toString();
        final String number = inputPhoneNumber.getText().toString();
        final String place = inputPlace.getText().toString();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DoctorActivity.this,"sent",Toast.LENGTH_SHORT).show();
                mDatabase.child(inputPlace.getText().toString()).child(inputName.getText().toString()).child("number").setValue(inputPhoneNumber.getText().toString());
                mDatabase.child(inputPlace.getText().toString()).child(inputName.getText().toString()).child("name").setValue(inputName.getText().toString());
                Toast.makeText(DoctorActivity.this,"You are added",Toast.LENGTH_SHORT).show();
                Intent e = new Intent(DoctorActivity.this,EndActivity.class);
                startActivity(e);
            }
        });
        mButtonBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hb = new Intent(DoctorActivity.this,HomeActivity.class);
                startActivity(hb);
            }
        });



    }
}
