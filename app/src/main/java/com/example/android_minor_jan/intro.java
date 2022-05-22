package com.example.android_minor_jan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class intro extends AppCompatActivity {

    Button startButton , aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        startButton = findViewById(R.id.StartButton);
        aboutButton = findViewById(R.id.AboutButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 start();
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                about();
            }
        });

    }

    public void start()
    {
        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(intent);
    }

    public void about()
    {
        Intent intent = new Intent(getApplicationContext() , about.class);
        startActivity(intent);
    }
}