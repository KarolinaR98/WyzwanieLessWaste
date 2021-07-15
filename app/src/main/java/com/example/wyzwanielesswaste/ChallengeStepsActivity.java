package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

import static android.content.ContentValues.TAG;
import static com.example.wyzwanielesswaste.Channel.CHANNEL_1_ID;

public class ChallengeStepsActivity extends AppCompatActivity {


    public static int ContentId;

   public static  Button lesson2Button, lesson3Button, lesson4Button, lesson5Button, lesson6Button, lesson7Button, lesson8Button, lesson9Button, lesson10Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_steps_);

        Button challengeRules = (Button)findViewById(R.id.zasadyWyzwania);
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

        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child(userID);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean button1 = dataSnapshot.child("Challenge1").child("available").getValue(Boolean.class);
                boolean button2 = dataSnapshot.child("Challenge2").child("available").getValue(Boolean.class);
                boolean button3 = dataSnapshot.child("Challenge3").child("available").getValue(Boolean.class);
                boolean button4 = dataSnapshot.child("Challenge4").child("available").getValue(Boolean.class);
                boolean button5 = dataSnapshot.child("Challenge5").child("available").getValue(Boolean.class);
                boolean button6 = dataSnapshot.child("Challenge6").child("available").getValue(Boolean.class);
                boolean button7 = dataSnapshot.child("Challenge7").child("available").getValue(Boolean.class);
                boolean button8 = dataSnapshot.child("Challenge8").child("available").getValue(Boolean.class);
                boolean button9 = dataSnapshot.child("Challenge9").child("available").getValue(Boolean.class);
                boolean button10 = dataSnapshot.child("Challenge10").child("available").getValue(Boolean.class);

                if (button1 == true) lesson1Button.setEnabled(true); else lesson1Button.setEnabled(false);
                if (button2 == true) lesson2Button.setEnabled(true); else lesson2Button.setEnabled(false);
                if (button3 == true) lesson3Button.setEnabled(true); else lesson3Button.setEnabled(false);
                if (button4 == true) lesson4Button.setEnabled(true); else lesson4Button.setEnabled(false);
                if (button5 == true) lesson5Button.setEnabled(true); else lesson5Button.setEnabled(false);
                if (button6 == true) lesson6Button.setEnabled(true); else lesson6Button.setEnabled(false);
                if (button7 == true) lesson7Button.setEnabled(true); else lesson7Button.setEnabled(false);
                if (button8 == true) lesson8Button.setEnabled(true); else lesson8Button.setEnabled(false);
                if (button9 == true) lesson9Button.setEnabled(true); else lesson9Button.setEnabled(false);
                if (button10 == true) lesson10Button.setEnabled(true); else lesson10Button.setEnabled(false);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });




        challengeRules.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChallengeStepsActivity.this, ChallengeRules.class));
            }
        });


        lesson1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge1").child("wasPerformed").getValue(Long.class);
                        ContentId = 1;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                        }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
                }
               });

        lesson2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge2").child("wasPerformed").getValue(Long.class);
                        ContentId = 2;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        lesson3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge3").child("wasPerformed").getValue(Long.class);
                        ContentId = 3;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        lesson4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge4").child("wasPerformed").getValue(Long.class);
                        ContentId = 4;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        lesson5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge5").child("wasPerformed").getValue(Long.class);
                        ContentId = 5;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });


        lesson6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge6").child("wasPerformed").getValue(Long.class);
                        ContentId = 6;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        lesson7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge7").child("wasPerformed").getValue(Long.class);
                        ContentId = 7;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        lesson8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge8").child("wasPerformed").getValue(Long.class);
                        ContentId = 8;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        lesson9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge9").child("wasPerformed").getValue(Long.class);
                        ContentId = 9;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        lesson10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long wasPerformed = dataSnapshot.child("Challenge10").child("wasPerformed").getValue(Long.class);
                        ContentId = 10;
                        if(wasPerformed != 0) {
                            startActivity(new Intent(ChallengeStepsActivity.this, ChallengeContent.class));
                        }
                        else {
                            startActivity(new Intent(ChallengeStepsActivity.this, Manager.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });

        ;}


        public static int GetId() {
        return ContentId;
    }
}


