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

    public static boolean TurnOnOffButton1, TurnOnOffButton2,TurnOnOffButton3,TurnOnOffButton4,TurnOnOffButton5,TurnOnOffButton6,TurnOnOffButton7,TurnOnOffButton8,TurnOnOffButton9,TurnOnOffButton10;

    public static int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_content);



        TextView titleText = (TextView)findViewById(R.id.ChallengeTitle);
        TextView contentText = (TextView)findViewById(R.id.ChallengeContent);
        TextView challengeText = (TextView)findViewById(R.id.Challege);
        Button quizButton = (Button)findViewById(R.id.quizButton);

        MyDBHandler myDBHandler = new MyDBHandler( ChallengeContent.this, null, null,4);
        ChallengeStepsActivity challengeStepsActivity = new ChallengeStepsActivity();
        SummaryOfTheWeek summaryOfTheWeek = new SummaryOfTheWeek();

        id = challengeStepsActivity.GetId();

        if(id == 1){
            if(TurnOnOffButton1 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if (id == 2){
            if(TurnOnOffButton2 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if (id == 3){
            if(TurnOnOffButton3 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if (id == 4){
            if(TurnOnOffButton4 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if(id == 5){
            if(TurnOnOffButton5 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if (id == 6){
            if(TurnOnOffButton6 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if (id == 7){
            if(TurnOnOffButton7 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if (id == 8){
            if(TurnOnOffButton8 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if (id == 9){

            if(TurnOnOffButton9 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }
        }
        else if (id == 10){
            if(TurnOnOffButton10 == true){
                quizButton.setEnabled(true);
            }
            else {
                quizButton.setEnabled(false);
            }

        }



        quizButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int id = challengeStepsActivity.GetId();
                summaryOfTheWeek.SetContextForQuestions(id);
                startActivity(new Intent(ChallengeContent.this, SummaryOfTheWeek.class));


            }
        });



        titleText.setText(myDBHandler.loadChallengeTitle(id));
        contentText.setText(myDBHandler.loadChallengeContent(id));
        challengeText.setText(myDBHandler.loadChallenge(id));



    }




}