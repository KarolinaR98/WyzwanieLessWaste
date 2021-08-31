package com.example.wyzwanielesswaste;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth fAuth = FirebaseAuth.getInstance();


        if(fAuth.getCurrentUser() == null) {
            startActivity(new Intent(getApplicationContext(), Register.class));
            finish();
        }


        Manager manager = new Manager();

        Button buttonRW = (Button) findViewById(R.id.rozpocznijWyzwanie);
        Button myAccountBtm = (Button) findViewById(R.id.mojeKonto);
        Button makeSummary = (Button) findViewById(R.id.dokonajPodsumowania);
        Button ecoCity = (Button)findViewById(R.id.ekoLifestyle);



        buttonRW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity(2);
            }
        });

        myAccountBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity(3);
            }
        });

        makeSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity(4);
            }
        });

        ecoCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openNewActivity(1);            }
        });


        MyAlarmDailyAdvice();
        QuestionnarieBroadcastAlarm();

    }

    public void MyAlarmDailyAdvice() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), DailyAdviceBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }


    public void QuestionnarieBroadcastAlarm() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (calendar.getTime().compareTo((new Date())) < 0)
        {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        Intent intent = new Intent(getApplicationContext(), QuestionnarieBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if(alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }
    }


    public void openNewActivity(int activityNumber){
        if(activityNumber == 1){
        Intent intent = new Intent(this, EcoLifestyle.class);
        startActivity(intent);}
        else if (activityNumber == 2){
            Intent intent = new Intent(this, ChallengeStepsActivity.class);
            startActivity(intent);}
        else if (activityNumber == 3){
            Intent intent = new Intent(this, MyAccount.class);
            startActivity(intent);}
        else if (activityNumber == 4){
            Intent intent = new Intent(this, UpdateSummaries.class);
            startActivity(intent);}

        }



    }

