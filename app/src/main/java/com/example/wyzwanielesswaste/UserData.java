package com.example.wyzwanielesswaste;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class UserData extends AppCompatActivity {

    TextView fullName, email, phoneNumber, resendCode, verifyMsg;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    Button logoutBtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        phoneNumber = findViewById(R.id.phoneNum);
        fullName = findViewById(R.id.yourName);
        email = findViewById(R.id.adresEmail);
        logoutBtm = findViewById(R.id.logoutBtm);
        resendCode = findViewById(R.id.verifyNow);
        verifyMsg = findViewById(R.id.profileVerification);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();
        FirebaseUser user = fAuth.getCurrentUser();



        if(!user.isEmailVerified()){
            verifyMsg.setVisibility(View.VISIBLE);
            resendCode.setVisibility(View.VISIBLE);

            resendCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(UserData.this, "Email weryfikujący konto został wysłany", Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(null,"onFailure: Emial nie został wysłany " + e.getMessage());
                        }
                    });

                }
            });
        } else {
            verifyMsg.setVisibility(View.INVISIBLE);
            resendCode.setVisibility(View.INVISIBLE);
        }



        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                phoneNumber.setText(documentSnapshot.getString("phone"));
                fullName.setText(documentSnapshot.getString("fName"));
                email.setText(documentSnapshot.getString("email"));
            }
        });


        logoutBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = fAuth.getCurrentUser();
                if(user!=null) {
                    String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child(userID).child("CurrentChallenge");
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            int currentChallenge = dataSnapshot.child("numOfActiveChallenge").getValue(Integer.class);

                            if (currentChallenge !=0) {
                                SetAlarmCancel(currentChallenge);
                            }

                        }



                        @Override
                        public void onCancelled(DatabaseError error) {
                            Log.w(TAG, "Failed to read value.", error.toException());
                        }
                    });
                    fAuth.signOut();
                    Intent intent = new Intent(UserData.this, Register.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();}

            }
        });
    }

    public void CancelAlarm1(){
        Intent intent = new Intent(this, WeekChallenge1Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();

    }

    public void CancelAlarm2(){
        Intent intent = new Intent(this, WeekChallenge2Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void CancelAlarm3(){
        Intent intent = new Intent(this, WeekChallenge3Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void CancelAlarm4(){
        Intent intent = new Intent(this, WeekChallenge4Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void CancelAlarm5(){
        Intent intent = new Intent(this, WeekChallenge5Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void CancelAlarm6(){
        Intent intent = new Intent(this, WeekChallenge6Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void CancelAlarm7(){
        Intent intent = new Intent(this, WeekChallenge7Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }


    public void CancelAlarm8(){
        Intent intent = new Intent(this, WeekChallenge8Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void CancelAlarm9(){
        Intent intent = new Intent(this, WeekChallenge9Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void CancelAlarm10(){
        Intent intent = new Intent(this, WeekChallenge10Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                101, intent, 0);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public void SetAlarmCancel (int id) {
        switch(id) {
            case 1:
                CancelAlarm1();
                break;
            case 2:
                CancelAlarm2();
                break;
            case 3:
                CancelAlarm3();
                break;
            case 4:
                CancelAlarm4();
                break;
            case 5:
                CancelAlarm5();
                break;
            case 6:
                CancelAlarm6();
                break;
            case 7:
                CancelAlarm7();
                break;
            case 8:
                CancelAlarm8();
                break;
            case 9:
                CancelAlarm9();
                break;
            case 10:
                CancelAlarm10();
                break;
            default:
                break;
        }

    }
}
