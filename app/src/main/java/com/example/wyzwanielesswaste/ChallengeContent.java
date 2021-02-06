package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChallengeContent extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_content);

        TextView titleText = (TextView)findViewById(R.id.ChallengeTitle);
        TextView contentText = (TextView)findViewById(R.id.ChallengeContent);
        TextView challengeText = (TextView)findViewById(R.id.Challege);
        Button quizButton = (Button)findViewById(R.id.quizButton);

        MyDBHandler myDBHandler = new MyDBHandler( ChallengeContent.this, null, null,3);
        ChallengeStepsActivity challengeStepsActivity = new ChallengeStepsActivity();

        quizButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChallengeContent.this, SummaryOfTheWeek.class));


            }
        });

        int id = challengeStepsActivity.GetId();

        titleText.setText(myDBHandler.loadChallengeTitle(id));
        contentText.setText(myDBHandler.loadChallengeContent(id));
        challengeText.setText(myDBHandler.loadChallenge(id));


    }




}