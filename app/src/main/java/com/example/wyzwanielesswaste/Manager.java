package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Calendar;

public class Manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        MyDBHandler myDBHandler = new MyDBHandler(this, null, null, 6);
        ChallengeStepsActivity challengeStepsActivity = new ChallengeStepsActivity();


        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(500);
        fadeOut.setDuration(2000);

        ImageView image = (ImageView) findViewById(R.id.logoImage);

        image.setAnimation(fadeOut);




        int id = challengeStepsActivity.GetId();
        int activation = myDBHandler.loadIsActivated(id);

        if(activation == 0){
            SetQuestionnaireReminder();
            myDBHandler.updateChallengeWeek(id);
            myDBHandler.updateActivation(1,id);
        }


        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Manager.this, ChallengeContent.class));
            }
        }, 2000);
    }


        void SetQuestionnaireReminder () {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(Calendar.DAY_OF_WEEK, 1); //Minutes
            AlarmManager alarmManager = (AlarmManager) this.getSystemService(ALARM_SERVICE);
            Intent alarmIntent = new Intent(this, QuestionnaireBroadcast.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        }
    }