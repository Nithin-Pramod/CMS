package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_2 extends AppCompatActivity {
    private info info=new info();
    TextView mBackHome;
    Button mButtonHome;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView=(TextView)findViewById(R.id.textView) ;
        mBackHome = (TextView)findViewById(R.id.textView9);
        mButtonHome = (Button)findViewById(R.id.button8);
        Intent intent=getIntent();
        int number=intent.getIntExtra(CheckUpActivity.EXTRA_NUM,0);
        textView.setText(info.gettext(number));

        mButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_2.this,"redirecting to Main page",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(activity_2.this,StartingActivity.class);
                startActivity(i);
            }
        });
        mBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_2.this,"redirecting to Main page",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(activity_2.this,StartingActivity.class);
                startActivity(i);
            }
        });
    }
}
