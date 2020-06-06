package com.example.cms;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientActivity extends AppCompatActivity {
    ListView mListViewP;
    EditText mSearchDoctor;
    Button mButtonP;
    ArrayList<String> myArrayList = new ArrayList<>();
    DatabaseReference mDataBase;
    ConstraintLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        mButtonP = (Button)findViewById(R.id.button5);
        mainLayout = (ConstraintLayout) findViewById(R.id.myLinearLayout);
        mSearchDoctor = (EditText)findViewById(R.id.editText2);
        mListViewP = (ListView)findViewById(R.id.DoctorList);
        final ArrayAdapter<String> myArrayAdaptor = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myArrayList);
        mListViewP.setAdapter(myArrayAdaptor);
        mButtonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myArrayAdaptor.clear();
                mDataBase = FirebaseDatabase.getInstance().getReference().child(mSearchDoctor.getText().toString());
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                assert imm != null;
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
                mDataBase.addChildEventListener(new ChildEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        String DoctorValues = Objects.requireNonNull(dataSnapshot.getValue()).toString();
                        myArrayList.add(" Doctor available at "+ mSearchDoctor.getText().toString() + "\n\n"+ DoctorValues);
                        myArrayAdaptor.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        myArrayAdaptor.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
