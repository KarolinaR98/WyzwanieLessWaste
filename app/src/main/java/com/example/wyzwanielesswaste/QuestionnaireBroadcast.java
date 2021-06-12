package com.example.wyzwanielesswaste;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FieldValue;

import java.util.HashMap;

import static android.content.ContentValues.TAG;
import static com.example.wyzwanielesswaste.Channel.CHANNEL_1_ID;

public class QuestionnaireBroadcast extends BroadcastReceiver {
    public static int challengeNum;
    public static int challengeDay;
    @Override
    public void onReceive(Context context, Intent intent) {




            String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
            DatabaseReference  myRef = FirebaseDatabase.getInstance().getReference().child(userID).child("CurrentChallenge");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int challengeNum_ = dataSnapshot.child("numOfActiveChallenge").getValue(Integer.class);
                    int challengeDay_ =dataSnapshot.child("numOfChallengeDay").getValue(Integer.class);

                    challengeDay = challengeDay_;
                    challengeNum = challengeNum_;

                    if(challengeNum != 0 && challengeDay != 0){
                        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

                        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, CHANNEL_1_ID )
                                .setSmallIcon(R.drawable.ic_stat_name)
                                .setContentTitle("Wyzwanie: " + challengeNum + " dzień: " + challengeDay)
                                .setContentText("Dokonaj podsumowania dla dnia " + challengeDay)
                                .setStyle(new NotificationCompat.BigTextStyle())
                                .setPriority(Notification.PRIORITY_MAX)
                                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                                .setAutoCancel(false);

                        v.vibrate(500);
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

                        notificationManager.notify(3, notification.build());

                    }


                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });


            if (challengeNum != 0 && challengeDay <= 6){
                myRef.child("numOfChallengeDay").setValue(ServerValue.increment(1));

            }

        }


}
