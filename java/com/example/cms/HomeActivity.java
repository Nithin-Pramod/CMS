package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Button mBtn;
    Button mBtn2;
    FirebaseAuth mFireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mBtn = (Button)findViewById(R.id.button2);
        mBtn2 = (Button)findViewById(R.id.button3);
        final Spinner spinner = findViewById(R.id.spinner);
        final String comp;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent l = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(l);
            }
        });

}
    @Override
    public void onItemSelected(AdapterView<?> parent , View view, int i, long l) {
        final String text1 = parent.getItemAtPosition(i).toString();
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text1.contentEquals("Doctor"))
                {
                    Toast.makeText(HomeActivity.this,"Redirecting to Doctor's Page",Toast.LENGTH_SHORT).show();
                    Intent d = new Intent(HomeActivity.this,DoctorActivity.class);
                    startActivity(d);
                }
                else if(text1.contentEquals("Patient"))
                {
                    Toast.makeText(HomeActivity.this,"Redirecting to Patient's Page",Toast.LENGTH_SHORT).show();
                    Intent d2 = new Intent(HomeActivity.this,PatientActivity.class);
                    startActivity(d2);
                }
            }
        });
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
