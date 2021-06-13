package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SummarySteps extends AppCompatActivity {

    public static int challengeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_steps);

        Button challenge1 = (Button) findViewById(R.id.lesson1_);
        Button challenge2 = (Button) findViewById(R.id.lesson2_);
        Button challenge3 = (Button) findViewById(R.id.lesson3_);
        Button challenge4 = (Button) findViewById(R.id.lesson4_);
        Button challenge5 = (Button) findViewById(R.id.lesson5_);
        Button challenge6 = (Button) findViewById(R.id.lesson6_);
        Button challenge7 = (Button) findViewById(R.id.lesson7_);
        Button challenge8 = (Button) findViewById(R.id.lesson8_);
        Button challenge9 = (Button) findViewById(R.id.lesson9_);
        Button challenge10 = (Button) findViewById(R.id.lesson10_);

        challenge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 1;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 2;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 3;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 4;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 5;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 6;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 7;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 8;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 9;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

        challenge10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                challengeID = 10;
                startActivity(new Intent(getApplicationContext(), WeekTemplate.class));
            }
        });

    }

    public int GetID(){
        return challengeID;
    }
}