package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static android.view.View.*;
public class CheckUpActivity extends AppCompatActivity {
    public static final String EXTRA_NUM = "com.example.cms.EXTRA_NUM";
    private questions theqn = new questions();


    TextView scoreView;
    TextView questionView;
    Button choiceView1;
    Button choiceView2;
    TextView textView;

    public int mscore = 0;
    public int mqno = 0;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_up);

        scoreView = (TextView) findViewById(R.id.score);
        questionView = (TextView) findViewById(R.id.question);
        choiceView1 = (Button) findViewById(R.id.choice1);
        choiceView2 = (Button) findViewById(R.id.choice2);
        // textView=(TextView)findViewById(R.id.info1);

        choiceView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mscore = mscore + 1;
                updateQuestion();
                updateScore(mscore);

            }
        });

        choiceView2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
                updateScore(mscore);

            }
        });

        do{
            setbutton();
        }
        while(mqno>10);
    }


    public void setbutton(){
        btn =(Button) findViewById(R.id.nxt_finish);
        btn.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){

                scoreView = (TextView) findViewById(R.id.score);
                int number = Integer.parseInt(scoreView.getText().toString());
                Intent intent = new Intent(CheckUpActivity.this, activity_2.class);
                intent.putExtra(EXTRA_NUM, number);
                startActivity(intent);
            }
        });
    }

    private void updateQuestion() {
        questionView.setText(theqn.getquestion(mqno));
        choiceView1.setText(theqn.getchoice1(mqno));
        choiceView2.setText(theqn.getchoice2(mqno));
        mqno++;

    }
    private void updateScore(int point) {
        scoreView.setText(""+mscore);
    }


}
