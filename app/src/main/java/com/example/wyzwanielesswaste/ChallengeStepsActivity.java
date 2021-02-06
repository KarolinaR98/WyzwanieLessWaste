package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChallengeStepsActivity extends AppCompatActivity {


    public static int ContentId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_steps_);

        Button myAccountButton = (Button)findViewById(R.id.myAccount);
        Button lesson1Button = (Button)findViewById(R.id.lesson1);
        Button lesson2Button = (Button)findViewById(R.id.lesson2);
        Button lesson3Button = (Button)findViewById(R.id.lesson3);
        Button lesson4Button = (Button)findViewById(R.id.lesson4);
        Button lesson5Button = (Button)findViewById(R.id.lesson5);
        Button lesson6Button = (Button)findViewById(R.id.lesson6);
        Button lesson7Button = (Button)findViewById(R.id.lesson7);
        Button lesson8Button = (Button)findViewById(R.id.lesson8);
        Button lesson9Button = (Button)findViewById(R.id.lesson9);
        Button lesson10Button = (Button)findViewById(R.id.lesson10);

        SummaryOfTheWeek summaryOfTheWeek = new SummaryOfTheWeek();

        lesson2Button.setActivated(true);
        lesson3Button.setActivated(true);
        lesson4Button.setActivated(true);
        lesson5Button.setActivated(true);
        lesson6Button.setActivated(true);
        lesson7Button.setActivated(true);
        lesson8Button.setActivated(true);
        lesson9Button.setActivated(true);
        lesson10Button.setActivated(true);

        myAccountButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChallengeStepsActivity.this, MyAccount.class));


            }
        });


        lesson1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentId = 1;
                startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                summaryOfTheWeek.SetContextForQuestions(1);}


        });

        lesson2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson2Button.isActivated()){
                    ContentId = 2;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(2);}
                else {
                    showToast();

                }}


        });

        lesson3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson3Button.isActivated()){
                    ContentId = 3;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(3);}
                else {

                    showToast();

                }}


        });

        lesson4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson4Button.isActivated()){
                    ContentId = 4;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(4);}
                else{
                    showToast();
                }}


        });

        lesson5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson5Button.isActivated()){
                    ContentId = 5;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(5);}
                else {
                    showToast();}}

        });


        lesson6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson6Button.isActivated()){
                    ContentId = 6;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(6);}
                else {
                    showToast();
                }}

        });

        lesson7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson7Button.isActivated()){
                    ContentId = 7;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(7);}
                else {
                    showToast();
                }}


        });

        lesson8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson8Button.isActivated()){
                    ContentId = 8;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(8);}
                else {
                    showToast();
                }}


        });

        lesson9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson9Button.isActivated()){
                    ContentId = 9;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(9);}
                else {
                    showToast();
                }}


        });

        lesson10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson10Button.isActivated()){
                    ContentId = 10;
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    summaryOfTheWeek.SetContextForQuestions(10);}
                else {
                    showToast();
                }}
        });

        ;}


        public static int GetId() {
        return ContentId;
    }

    private void showToast() {
        Toast.makeText(getApplicationContext(), "Wyzwanie nieodblokowane", Toast.LENGTH_SHORT).show();
    }

}


