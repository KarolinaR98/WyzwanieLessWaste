package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        MyDBHandler myDBHandler = new MyDBHandler(MyAccount.this, null, null,3);


        TextView scoreWeek1 = (TextView)findViewById(R.id.percent1);
        TextView scoreWeek2 = (TextView)findViewById(R.id.percent2);
        TextView scoreWeek3 = (TextView)findViewById(R.id.percent3);
        TextView scoreWeek4 = (TextView)findViewById(R.id.percent4);
        TextView scoreWeek5 = (TextView)findViewById(R.id.percent5);
        TextView scoreWeek6 = (TextView)findViewById(R.id.percent6);
        TextView scoreWeek7 = (TextView)findViewById(R.id.percent7);
        TextView scoreWeek8 = (TextView)findViewById(R.id.percent8);
        TextView scoreWeek9 = (TextView)findViewById(R.id.percent9);
        TextView scoreWeek10 = (TextView)findViewById(R.id.percent10);

        scoreWeek1.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(1))) + " %");
        scoreWeek2.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(2)))+ " %");
        scoreWeek3.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(3)))+ " %");
        scoreWeek4.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(4)))+ " %");
        scoreWeek5.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(5)))+ " %");
        scoreWeek6.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(6)))+ " %");
        scoreWeek7.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(7)))+ " %");
        scoreWeek8.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(8)))+ " %");
        scoreWeek9.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(9)))+ " %");
        scoreWeek10.setText(String.format("%.0f",(myDBHandler.loadChallengeScore(10)))+ " %");












    }
}