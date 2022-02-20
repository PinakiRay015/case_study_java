package com.example.android_minor_jan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + quizField.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + quizField.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + quizField.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        quizField.correct=0;
        quizField.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });

    }
}