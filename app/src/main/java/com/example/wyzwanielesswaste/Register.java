package com.example.wyzwanielesswaste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {



    EditText mFullName, mEmail, mPassword, mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    FirebaseDatabase rootNode;
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.email);
        mPhone = findViewById(R.id.phoneNumber);
        mPassword = findViewById(R.id.password_);
        mRegisterBtn = findViewById(R.id.buttonLogin);
        mLoginBtn = findViewById(R.id.goCreate);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String fullName = mFullName.getText().toString();
                String phoneNumber = mPhone.getText().toString();

                if (email.isEmpty()) {
                    mEmail.setError("Wprowadź adres email");
                }

                if (fullName.isEmpty()) {
                    mFullName.setError("Wprowadź imię i nazwisko");
                }
                if (phoneNumber.isEmpty()) {
                    mPhone.setError("Wprowadź numer telefonu");
                }

                if (password.isEmpty()) {
                    mPassword.setError("Wprowadź hasło");
                }

                if(password.length() < 6) {
                    mPassword.setError("Hasło musi zawierać conajmniej 6 znaków");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {

                            FirebaseUser user = fAuth.getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Register.this, "Email weryfikujący konto został wysłany", Toast.LENGTH_LONG).show();
                                    userID = fAuth.getCurrentUser().getUid();
                                    DocumentReference documentReference =fStore.collection("users").document(userID);
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("fName", fullName);
                                    user.put("email", email);
                                    user.put("phone", phoneNumber);
                                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(null, "OnSuccess: user profile created for " + userID);

                                        }
                                    });

                                    rootNode = FirebaseDatabase.getInstance();
                                    dbRef = rootNode.getReference(userID.toString());

                                    CurrentChallengeHelper helperCurrent = new CurrentChallengeHelper(0);
                                    ChallengeHelper helperChallenge1 = new ChallengeHelper(0,0,0,0,0,0,0, false, false, false, false, false, false, false,
                                            0, true, false, false,
                                            false, false, false, false, false);
                                    ChallengeHelper helperChallenge = new ChallengeHelper(0,0,0,0,0,0,0, false, false, false, false, false, false,
                                            false, 0, false, false, false, false, false, false, false, false);
                                    dbRef.child("CurrentChallenge").setValue(helperCurrent);
                                    dbRef.child("Challenge1").setValue(helperChallenge1);
                                    dbRef.child("Challenge2").setValue(helperChallenge);
                                    dbRef.child("Challenge3").setValue(helperChallenge);
                                    dbRef.child("Challenge4").setValue(helperChallenge);
                                    dbRef.child("Challenge5").setValue(helperChallenge);
                                    dbRef.child("Challenge6").setValue(helperChallenge);
                                    dbRef.child("Challenge7").setValue(helperChallenge);
                                    dbRef.child("Challenge8").setValue(helperChallenge);
                                    dbRef.child("Challenge9").setValue(helperChallenge);
                                    dbRef.child("Challenge10").setValue(helperChallenge);


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(null,"onFailure: Email nie został wysłany " + e.getMessage());
                                }
                            });



                            
                            Toast.makeText(Register.this, "Konto zostało utworzone.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                        else {

                            Toast.makeText(Register.this, "Błąd!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });



            }
        });


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}