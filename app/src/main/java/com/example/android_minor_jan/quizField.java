package com.example.android_minor_jan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class quizField extends AppCompatActivity {

    TextView userName;
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
    };
    String answers[] = {"main method","this","public","import pkg.*","None of the mentioned"};
    String opt[] = {
            "finalize method","main method","static method","private method",
            "import","this","catch","abstract",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_field);

        final TextView score = (TextView)findViewById(R.id.textView4);
        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.quitButton);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.optionButton1);
        rb2=(RadioButton)findViewById(R.id.optionButton2);
        rb3=(RadioButton)findViewById(R.id.optionButton3);
        rb4=(RadioButton)findViewById(R.id.optionButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),result.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),result.class);
                startActivity(intent);
            }
        });

        userName = (TextView) findViewById(R.id.userName);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        userName.setText("Hello "+str);

    }
}