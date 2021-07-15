package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

import static android.content.ContentValues.TAG;
import static com.example.wyzwanielesswaste.Channel.CHANNEL_1_ID;

public class Manager extends AppCompatActivity {

    public static int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        ChallengeStepsActivity challengeStepsActivity = new ChallengeStepsActivity();
        Date date = new Date();

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(500);
        fadeOut.setDuration(2000);

        ImageView image = (ImageView) findViewById(R.id.logoImage);

        image.setAnimation(fadeOut);

        id = challengeStepsActivity.GetId();

        SetAlarm(id);

        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child(userID);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                boolean isAvailable = dataSnapshot.child("Challenge" + String.valueOf(id)).child("available").getValue(Boolean.class);

                if(isAvailable == true) {
                    myRef.child("Challenge" + String.valueOf(id)).child("wasPerformed").setValue(date.getTime());
                    myRef.child("CurrentChallenge").child("numOfActiveChallenge").setValue(id);


                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });







        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(Manager.this, "Wyzwanie zostało aktywowane !", Toast.LENGTH_LONG);
                toast.show();
                startActivity(new Intent(Manager.this, ChallengeContent.class));
            }
        }, 1000);


    }


    public void MyAlarmChallenge1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge1Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge2Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge3() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge3Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge4Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge5() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge5Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge6() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge6Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge7() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge7Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge8() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge8Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge9() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge9Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void MyAlarmChallenge10() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), WeekChallenge10Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }

    public void SetAlarm (int id) {
        switch(id) {
            case 1:
                MyAlarmChallenge1();
                break;
            case 2:
                MyAlarmChallenge2();
                break;
            case 3:
                MyAlarmChallenge3();
                break;
            case 4:
                MyAlarmChallenge4();
                break;
            case 5:
                MyAlarmChallenge5();
                break;
            case 6:
                MyAlarmChallenge6();
                break;
            case 7:
                MyAlarmChallenge7();
                break;
            case 8:
                MyAlarmChallenge8();
                break;
            case 9:
                MyAlarmChallenge9();
                break;
            case 10:
                MyAlarmChallenge10();
                break;
            default:
               break;
        }

    }


    }