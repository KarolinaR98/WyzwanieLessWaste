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

    public static boolean wasPerformed1 , wasPerformed2 ,wasPerformed3,
            wasPerformed4 ,wasPerformed5 ,wasPerformed6,wasPerformed7,wasPerformed8,wasPerformed9 ,wasPerformed10;

    public static boolean  isActive2,isActive3,isActive4,isActive5,isActive6,isActive7,isActive8,isActive9,isActive10;

    public static int ContentId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_steps_);

        MyDBHandler myDBHandler = new MyDBHandler(this, null, null, 4);
        MainActivity mainActivity = new MainActivity();

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


        if(isActive2 == true){
            lesson2Button.setEnabled(true);
        }
        else {
            lesson2Button.setEnabled(false);
        }
        if(isActive3 == true){
            lesson3Button.setEnabled(true);
        }
        else {
            lesson3Button.setEnabled(false);
        }
        if(isActive4 == true){
            lesson4Button.setEnabled(true);
        }
        else {
            lesson4Button.setEnabled(false);
        }
        if(isActive5 == true){
            lesson5Button.setEnabled(true);
        }
        else {
            lesson5Button.setEnabled(false);
        }
        if(isActive6 == true){
            lesson6Button.setEnabled(true);
        }
        else {
            lesson6Button.setEnabled(false);
        }
        if(isActive7 == true){
            lesson7Button.setEnabled(true);
        }
        else {
            lesson7Button.setEnabled(false);
        }
        if(isActive8 == true){
            lesson8Button.setEnabled(true);
        }
        else {
            lesson8Button.setEnabled(false);
        }
        if(isActive9 == true){
            lesson9Button.setEnabled(true);
        }
        else {
            lesson9Button.setEnabled(false);
        }
        if(isActive10 == true){
            lesson10Button.setEnabled(true);
        }
        else {
            lesson10Button.setEnabled(false);
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
                if(wasPerformed1 == false){
                    SetQuestionnaireReminder();
                    mainActivity.SetChallengeWeek(ContentId);
                    wasPerformed1 = true;}

                startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));



                }


        });

        lesson2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson2Button.isEnabled()){
                    ContentId = 2;
                    if(wasPerformed2 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed2 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    }
            }


        });

        lesson3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson3Button.isEnabled()){
                    ContentId = 3;
                    if(wasPerformed3 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed3 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    }
                }


        });

        lesson4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson4Button.isEnabled()){
                    ContentId = 4;
                    if(wasPerformed4 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed4 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    }
               }


        });

        lesson5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson5Button.isEnabled()){
                    ContentId = 5;
                    if(wasPerformed5 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed5 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));}
                }

        });


        lesson6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson6Button.isEnabled()){
                    ContentId = 6;
                    if(wasPerformed6 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed6 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class)); }
               }

        });

        lesson7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson7Button.isEnabled()){
                    ContentId = 7;
                    if(wasPerformed7 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed7 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class)); }
                }


        });

        lesson8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson8Button.isEnabled()){
                    ContentId = 8;
                    if(wasPerformed8 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed8 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class)); }
               }


        });

        lesson9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson9Button.isEnabled()){
                    ContentId = 9;
                    if(wasPerformed9 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed9 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class)); }
               }


        });

        lesson10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lesson10Button.isEnabled()){
                    ContentId = 10;
                    if(wasPerformed10 == false){
                        SetQuestionnaireReminder();
                        mainActivity.SetChallengeWeek(ContentId);
                        wasPerformed10 = true;}
                    startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                    }
                }
        });

        ;}


        public static int GetId() {
        return ContentId;
    }

    private void showToast() {
        Toast.makeText(getApplicationContext(), "Wyzwanie nieodblokowane", Toast.LENGTH_SHORT).show();
    }


    void SetQuestionnaireReminder(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.DAY_OF_MONTH, 1); //Minutes
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(this, QuestionnaireBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);

    }


}


