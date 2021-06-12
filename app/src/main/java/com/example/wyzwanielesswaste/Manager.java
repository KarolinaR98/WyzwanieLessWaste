package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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

import static android.content.ContentValues.TAG;
import static com.example.wyzwanielesswaste.Channel.CHANNEL_1_ID;

public class Manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        MyDBHandler myDBHandler = new MyDBHandler(this, null, null, MyDBHandler.DB_VERSION);
        ChallengeStepsActivity challengeStepsActivity = new ChallengeStepsActivity();


        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(500);
        fadeOut.setDuration(2000);

        ImageView image = (ImageView) findViewById(R.id.logoImage);

        image.setAnimation(fadeOut);




        int id = challengeStepsActivity.GetId();


        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child(userID);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                boolean isAvailable = dataSnapshot.child("Challenge" + String.valueOf(id)).child("available").getValue(Boolean.class);

                if(isAvailable == true) {
                    myRef.child("Challenge" + String.valueOf(id)).child("wasPerformed").setValue(true);
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
                startActivity(new Intent(Manager.this, ChallengeContent.class));
            }
        }, 2000);

        Toast toast = Toast.makeText(this, "Wyzawnie zostało aktywowane", Toast.LENGTH_LONG);
        toast.show();

    }



    }