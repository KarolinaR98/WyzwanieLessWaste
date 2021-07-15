package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatisticSteps extends AppCompatActivity {

    public static int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic_steps);

        Button stat1 = (Button) findViewById(R.id.stat1);
        Button stat2 = (Button) findViewById(R.id.stat2);
        Button stat3 = (Button) findViewById(R.id.stat3);
        Button stat4 = (Button) findViewById(R.id.stat4);
        Button stat5 = (Button) findViewById(R.id.stat5);
        Button stat6 = (Button) findViewById(R.id.stat6);
        Button stat7 = (Button) findViewById(R.id.stat7);
        Button stat8 = (Button) findViewById(R.id.stat8);
        Button stat9 = (Button) findViewById(R.id.stat9);
        Button stat10 = (Button) findViewById(R.id.stat10);

        stat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 1;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 2;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 3;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 4;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 5;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 6;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 7;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 8;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 9;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        stat10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = 10;
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

    }

    public int ReturnID () {
        return ID;
    }
}