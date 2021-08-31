package com.example.wyzwanielesswaste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.wyzwanielesswaste.Channel.CHANNEL_1_ID;

public class UpdateSummaries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_summaries);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(500);
        fadeOut.setDuration(2000);

        ImageView image = (ImageView) findViewById(R.id.logoImage_);

        setSummaries(1);
        setSummaries(2);
        setSummaries(3);
        setSummaries(4);
        setSummaries(5);
        setSummaries(6);
        setSummaries(7);
        setSummaries(8);
        setSummaries(9);
        setSummaries(10);


        image.setAnimation(fadeOut);

    final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(UpdateSummaries.this, SummarySteps.class));
            }
        }, 1000);
    }


    private void setSummaries(int ID) {
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long today = snapshot.child("CurrentDate").getValue(Long.class);
                long startChallengeDate = snapshot.child(userID).child("Challenge" + String.valueOf(ID)).child("wasPerformed").getValue(Long.class);

                if(startChallengeDate != 0) {

                    long difference = today - startChallengeDate;
                    long differenceInDays = difference / (1000 * 3600 * 24);


                    if (differenceInDays >= 7) {
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active7").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active6").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active5").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active4").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active3").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active2").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active1").setValue(true);

                    }
                    else if (differenceInDays >= 6) {
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active7").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active6").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active5").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active4").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active3").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active2").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active1").setValue(true);
                    }
                    else if (differenceInDays >= 5){
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active7").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active6").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active5").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active4").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active3").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active2").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active1").setValue(true);
                    }
                    else if (differenceInDays >= 4) {
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active7").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active6").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active5").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active4").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active3").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active2").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active1").setValue(true);
                    }
                    else if (differenceInDays >= 3) {
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active7").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active6").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active5").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active4").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active3").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active2").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active1").setValue(true);
                    }
                    else if (differenceInDays >= 2) {
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active7").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active6").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active5").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active4").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active3").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active2").setValue(true);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active1").setValue(true);
                    }
                    else if (differenceInDays >= 1) {
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active7").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active6").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active5").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active4").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active3").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active2").setValue(false);
                        myRef.child(userID).child("Challenge" + String.valueOf(ID)).child("active1").setValue(true);
                    }


                }

                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}