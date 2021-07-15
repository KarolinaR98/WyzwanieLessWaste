package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


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

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Statistics extends AppCompatActivity {

    public static int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        StatisticSteps statisticSteps = new StatisticSteps();
        ID = statisticSteps.ReturnID();


        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child(userID).child("Challenge" + String.valueOf(ID));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                long score1 =  dataSnapshot.child("score1").getValue(Long.class);
                long score2 =  dataSnapshot.child("score2").getValue(Long.class);
                long score3 =  dataSnapshot.child("score3").getValue(Long.class);
                long score4 =  dataSnapshot.child("score4").getValue(Long.class);
                long score5 =  dataSnapshot.child("score5").getValue(Long.class);
                long score6 =  dataSnapshot.child("score6").getValue(Long.class);
                long score7 =  dataSnapshot.child("score7").getValue(Long.class);

                int intScore1 = (int) score1;
                int intScore2 = (int) score2;
                int intScore3 = (int) score3;
                int intScore4 = (int) score4;
                int intScore5 = (int) score5;
                int intScore6 = (int) score6;
                int intScore7 = (int) score7;



                BarChart barChart = findViewById(R.id.barChart);

                ArrayList<BarEntry> summariesScores = new ArrayList<>();

                summariesScores.add(new BarEntry(1, intScore1));
                summariesScores.add(new BarEntry(2, intScore2));
                summariesScores.add(new BarEntry(3, intScore3));
                summariesScores.add(new BarEntry(4, intScore4));
                summariesScores.add(new BarEntry(5, intScore5));
                summariesScores.add(new BarEntry(6, intScore6));
                summariesScores.add(new BarEntry(7, intScore7));



                BarDataSet barDataSet = new BarDataSet(summariesScores, "Wynik podsumowania w procentach");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                BarData barData = new BarData(barDataSet);

                barChart.setFitBars(true);
                barChart.setData(barData);
                barChart.getDescription().setText("Wyniki podsumowań dla Wyzwania " + ID);
                barChart.animateY(2000);
            }



            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }



}