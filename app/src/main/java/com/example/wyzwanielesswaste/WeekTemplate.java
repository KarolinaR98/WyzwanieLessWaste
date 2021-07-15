package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class WeekTemplate extends AppCompatActivity {

    public static boolean active1, active2, active3, active4, active5, active6, active7;
    public static boolean summaryPerformed1, summaryPerformed2, summaryPerformed3, summaryPerformed4, summaryPerformed5, summaryPerformed6, summaryPerformed7;

    public static int id_, DayID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_template);

        SummarySteps summarySteps = new SummarySteps();
        id_ = summarySteps.GetID();

        ImageView check = (ImageView) findViewById(R.id.check);
        ImageView check2 = (ImageView) findViewById(R.id.check2);
        ImageView check3 = (ImageView) findViewById(R.id.check3);
        ImageView check4 = (ImageView) findViewById(R.id.check4);
        ImageView check5 = (ImageView) findViewById(R.id.check5);
        ImageView check6 = (ImageView) findViewById(R.id.check6);
        ImageView check7 = (ImageView) findViewById(R.id.check7);

        TextView summaryDay1 = (TextView) findViewById(R.id.openSummary);
        TextView summaryDay2 = (TextView) findViewById(R.id.openSummary2);
        TextView summaryDay3 = (TextView) findViewById(R.id.openSummary3);
        TextView summaryDay4 = (TextView) findViewById(R.id.openSummary4);
        TextView summaryDay5 = (TextView) findViewById(R.id.openSummary5);
        TextView summaryDay6 = (TextView) findViewById(R.id.openSummary6);
        TextView summaryDay7 = (TextView) findViewById(R.id.openSummary7);


        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child(userID).child("Challenge" + String.valueOf(id_));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                SummaryOfTheWeek summaryOfTheWeek = new SummaryOfTheWeek();


                active1 = dataSnapshot.child("active1").getValue(Boolean.class);
                active2 = dataSnapshot.child("active2").getValue(Boolean.class);
                active3 = dataSnapshot.child("active3").getValue(Boolean.class);
                active4 = dataSnapshot.child("active4").getValue(Boolean.class);
                active5 = dataSnapshot.child("active5").getValue(Boolean.class);
                active6 = dataSnapshot.child("active6").getValue(Boolean.class);
                active7 = dataSnapshot.child("active7").getValue(Boolean.class);

                summaryPerformed1 = dataSnapshot.child("summaryPerformed1").getValue(Boolean.class);
                summaryPerformed2 = dataSnapshot.child("summaryPerformed2").getValue(Boolean.class);
                summaryPerformed3 = dataSnapshot.child("summaryPerformed3").getValue(Boolean.class);
                summaryPerformed4 = dataSnapshot.child("summaryPerformed4").getValue(Boolean.class);
                summaryPerformed5 = dataSnapshot.child("summaryPerformed5").getValue(Boolean.class);
                summaryPerformed6 = dataSnapshot.child("summaryPerformed6").getValue(Boolean.class);
                summaryPerformed7 = dataSnapshot.child("summaryPerformed7").getValue(Boolean.class);

                if (summaryPerformed1 == true) {
                    check.setVisibility(View.VISIBLE);
                    summaryDay1.setVisibility(View.INVISIBLE);
                    summaryDay1.setClickable(false);
                } else {
                    check.setVisibility(View.INVISIBLE);

                }

                if (summaryPerformed2 == true) {
                    check2.setVisibility(View.VISIBLE);
                    summaryDay2.setVisibility(View.INVISIBLE);
                    summaryDay2.setClickable(false);
                } else {
                    check2.setVisibility(View.INVISIBLE);
                }

                if (summaryPerformed3 == true) {
                    check3.setVisibility(View.VISIBLE);
                    summaryDay3.setVisibility(View.INVISIBLE);
                    summaryDay3.setClickable(false);
                } else {
                    check3.setVisibility(View.INVISIBLE);

                }

                if (summaryPerformed4 == true) {
                    check4.setVisibility(View.VISIBLE);
                    summaryDay4.setVisibility(View.INVISIBLE);
                    summaryDay4.setClickable(false);
                } else {
                    check4.setVisibility(View.INVISIBLE);
                }

                if (summaryPerformed5 == true) {
                    check5.setVisibility(View.VISIBLE);
                    summaryDay5.setVisibility(View.INVISIBLE);
                    summaryDay5.setClickable(false);
                } else {
                    check5.setVisibility(View.INVISIBLE);
                }

                if (summaryPerformed6 == true) {
                    check6.setVisibility(View.VISIBLE);
                    summaryDay6.setVisibility(View.INVISIBLE);
                    summaryDay6.setClickable(false);
                } else {
                    check6.setVisibility(View.INVISIBLE);
                }

                if (summaryPerformed7 == true) {
                    check7.setVisibility(View.VISIBLE);
                    summaryDay7.setVisibility(View.INVISIBLE);
                    summaryDay7.setClickable(false);
                } else {
                    check7.setVisibility(View.INVISIBLE);
                }

                if (active1 == true && summaryPerformed1 == false) {
                    summaryDay1.setText("Dokonaj podsumowania");


                } else {
                    summaryDay1.setText("Podsumowanie niedostępne");

                }

                if (active2 == true && summaryPerformed2 == false) {
                    summaryDay2.setText("Dokonaj podsumowania");


                } else {
                    summaryDay2.setText("Podsumowanie niedostępne");
                }

                if (active3 == true && summaryPerformed3 == false) {
                    summaryDay3.setText("Dokonaj podsumowania");

                } else {
                    summaryDay3.setText("Podsumowanie niedostępne");
                }

                if (active4 == true && summaryPerformed4 == false) {
                    summaryDay4.setText("Dokonaj podsumowania");

                } else {
                    summaryDay4.setText("Podsumowanie niedostępne");
                }

                if (active5 == true && summaryPerformed5 == false) {
                    summaryDay5.setText("Dokonaj podsumowania");

                } else {
                    summaryDay5.setText("Podsumowanie niedostępne");
                }

                if (active6 == true && summaryPerformed6 == false) {
                    summaryDay6.setText("Dokonaj podsumowania");

                } else {
                    summaryDay6.setText("Podsumowanie niedostępne");
                }

                if (active7 == true && summaryPerformed7 == false) {
                    summaryDay7.setText("Dokonaj podsumowania");


                } else {
                    summaryDay7.setText("Podsumowanie niedostępne");
                }


                if (summaryPerformed1 == false && active1 == true) {

                    summaryDay1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            summaryOfTheWeek.SetContextForQuestions(id_);
                            summaryOfTheWeek.SetID(id_);
                            DayID = 1;
                            startActivity(new Intent(WeekTemplate.this, SummaryOfTheWeek.class));
                        }
                    });


                }


                if (summaryPerformed2 == false && active2 == true) {

                    summaryDay2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            summaryOfTheWeek.SetContextForQuestions(id_);
                            DayID =2;
                            startActivity(new Intent(WeekTemplate.this, SummaryOfTheWeek.class));
                        }
                    });


                }


                if (summaryPerformed3 == false && active3 == true) {

                    summaryDay3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            summaryOfTheWeek.SetContextForQuestions(id_);
                            summaryOfTheWeek.SetID(id_);
                            DayID = 3;
                            startActivity(new Intent(WeekTemplate.this, SummaryOfTheWeek.class));
                        }
                    });


                }

                if (summaryPerformed4 == false && active4 == true) {

                    summaryDay4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            summaryOfTheWeek.SetContextForQuestions(id_);
                            summaryOfTheWeek.SetID(id_);
                            DayID = 4;
                            startActivity(new Intent(WeekTemplate.this, SummaryOfTheWeek.class));
                        }
                    });


                }

                if (summaryPerformed5 == false && active5 == true) {

                    summaryDay5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            summaryOfTheWeek.SetContextForQuestions(id_);
                            summaryOfTheWeek.SetID(id_);
                            DayID = 5;
                            startActivity(new Intent(WeekTemplate.this, SummaryOfTheWeek.class));
                        }
                    });


                }


                if (summaryPerformed6 == false && active6 == true) {

                    summaryDay6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            summaryOfTheWeek.SetContextForQuestions(id_);
                            summaryOfTheWeek.SetID(id_);
                            DayID = 6;
                            startActivity(new Intent(WeekTemplate.this, SummaryOfTheWeek.class));
                        }
                    });


                }

                if (summaryPerformed7 == false && active7 == true) {

                    summaryDay7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            summaryOfTheWeek.SetContextForQuestions(id_);
                            summaryOfTheWeek.SetID(id_);
                            DayID = 7;
                            startActivity(new Intent(WeekTemplate.this, SummaryOfTheWeek.class));
                        }
                    });


                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        }


        public int GetID(){
        return id_;
        }

        public int GetDayID(){
        return DayID;
        }

}