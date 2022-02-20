package com.example.android_minor_jan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEntry;
    Button startButton , aboutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEntry = (EditText) findViewById(R.id.nameEntry);
        startButton = (Button) findViewById(R.id.StartButton);
        aboutButton = (Button) findViewById(R.id.AboutButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = nameEntry.getText().toString().trim();
                if (str.isEmpty()||str.length()==0 || str.equals("")||str==null)
                {
                    Toast.makeText(getApplicationContext(), "Please Enter your name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this , quizField.class);
                    intent.putExtra("name" , str);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Welcome "+str+" best of luck for quiz", Toast.LENGTH_LONG).show();
                }
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , about.class);
                startActivity(intent);
            }
        });
    }
}