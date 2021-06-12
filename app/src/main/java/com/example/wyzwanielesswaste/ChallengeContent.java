package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.PendingIntent;

import java.util.Calendar;

public class ChallengeContent extends AppCompatActivity  {


    public static int id;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ChallengeStepsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_content);



        TextView titleText = (TextView)findViewById(R.id.ChallengeTitle);
        TextView contentText = (TextView)findViewById(R.id.ChallengeContent);
        TextView challengeText = (TextView)findViewById(R.id.Challege);


        MyDBHandler myDBHandler = new MyDBHandler( ChallengeContent.this, null, null,MyDBHandler.DB_VERSION);
        ChallengeStepsActivity challengeStepsActivity = new ChallengeStepsActivity();

        id = challengeStepsActivity.GetId();


        titleText.setText(myDBHandler.loadChallengeTitle(id));
        contentText.setText(myDBHandler.loadChallengeContent(id));
        challengeText.setText(myDBHandler.loadChallenge(id));



    }




}