package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class ChallengeStepsActivity extends AppCompatActivity {


    public static int ContentId;
    public static int isActive;

   public static  Button lesson2Button, lesson3Button, lesson4Button, lesson5Button, lesson6Button, lesson7Button, lesson8Button, lesson9Button, lesson10Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_steps_);

       MyDBHandler myDBHandler = new MyDBHandler(this, null, null, 6);


        Button myAccountButton = (Button)findViewById(R.id.myAccount);
        Button lesson1Button = (Button)findViewById(R.id.lesson1);
        lesson2Button = (Button)findViewById(R.id.lesson2);
        lesson3Button = (Button)findViewById(R.id.lesson3);
        lesson4Button = (Button)findViewById(R.id.lesson4);
        lesson5Button = (Button)findViewById(R.id.lesson5);
        lesson6Button = (Button)findViewById(R.id.lesson6);
        lesson7Button = (Button)findViewById(R.id.lesson7);
        lesson8Button = (Button)findViewById(R.id.lesson8);
        lesson9Button = (Button)findViewById(R.id.lesson9);
        lesson10Button = (Button)findViewById(R.id.lesson10);


        int activationB2, activationB3, activationB4, activationB5, activationB6, activationB7, activationB8, activationB9, activationB10;
        activationB2 = myDBHandler.loadButtonActivation(2);
        activationB3 = myDBHandler.loadButtonActivation(3);
        activationB4 = myDBHandler.loadButtonActivation(4);
        activationB5 = myDBHandler.loadButtonActivation(5);;
        activationB6 = myDBHandler.loadButtonActivation(6);;
        activationB7 = myDBHandler.loadButtonActivation(7);;
        activationB8 = myDBHandler.loadButtonActivation(8);;
        activationB9 = myDBHandler.loadButtonActivation(9);;
        activationB10 = myDBHandler.loadButtonActivation(10);


        if(activationB2 == 0){
            lesson2Button.setEnabled(false);
        }
        else {
            lesson2Button.setEnabled(true);
        }

        if(activationB3 == 0){
            lesson3Button.setEnabled(false);
        }
        else {
            lesson3Button.setEnabled(true);
        }

        if(activationB4 == 0){
            lesson4Button.setEnabled(false);
        }
        else {
            lesson4Button.setEnabled(true);
        }

        if(activationB5 == 0){
            lesson5Button.setEnabled(false);
        }
        else {
            lesson5Button.setEnabled(true);
        }

        if(activationB6 == 0){
            lesson6Button.setEnabled(false);
        }
        else {
            lesson6Button.setEnabled(true);
        }

        if(activationB7 == 0){
            lesson7Button.setEnabled(false);
        }
        else {
            lesson7Button.setEnabled(true);
        }

        if(activationB8 == 0){
            lesson8Button.setEnabled(false);
        }
        else {
            lesson8Button.setEnabled(true);
        }

        if(activationB9 == 0){
            lesson9Button.setEnabled(false);
        }
        else {
            lesson9Button.setEnabled(true);
        }

        if(activationB10 == 0){
            lesson10Button.setEnabled(false);
        }
        else {
            lesson10Button.setEnabled(true);
        }

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
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }

                }});

        lesson2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ContentId = 2;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
}}


        });

        lesson3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ContentId = 3;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }}



        });

        lesson4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ContentId = 4;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }}



        });

        lesson5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    ContentId = 5;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }}


        });


        lesson6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ContentId = 6;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }}


        });

        lesson7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ContentId = 7;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }}


        });

        lesson8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ContentId = 8;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }}


        });

        lesson9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ContentId = 9;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }}


        });

        lesson10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ContentId = 10;
                isActive = myDBHandler.loadIsActivated(ContentId);
                if(isActive == 0){
                    startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                }
                else {
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                }}

        });

        ;}


        public static int GetId() {
        return ContentId;
    }
}


