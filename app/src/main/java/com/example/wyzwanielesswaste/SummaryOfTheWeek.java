package com.example.wyzwanielesswaste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.squareup.okhttp.Challenge;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.example.wyzwanielesswaste.Channel.CHANNEL_1_ID;

public class SummaryOfTheWeek extends AppCompatActivity {

    public static String question1, question2, question3, question4, question5, question6, question7;


    public static int id, DayID;


    public static CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_of_the_week);

        WeekTemplate weekTemplate = new WeekTemplate();

        id = weekTemplate.GetID();
        DayID = weekTemplate.GetDayID();

        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox)findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox)findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox)findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox)findViewById(R.id.checkBox7);




        if(id == 1 || id == 4 || id == 5 || id == 8){
            checkBox5.setVisibility(View.VISIBLE);
            checkBox6.setVisibility(View.VISIBLE);

        }
        else if (id == 2 || id == 7 || id == 9){
            checkBox5.setVisibility(View.VISIBLE);
        }
        else if (id == 6){
            checkBox5.setVisibility(View.VISIBLE);
            checkBox6.setVisibility(View.VISIBLE);
            checkBox7.setVisibility(View.VISIBLE);
        }

        Button confirmationButton = (Button)findViewById(R.id.ConfirmationButton);



        TextView Question1 = (TextView)findViewById(R.id.Q1);
        TextView Question2 = (TextView)findViewById(R.id.Q2);
        TextView Question3 = (TextView)findViewById(R.id.Q3);
        TextView Question4 = (TextView)findViewById(R.id.Q4);
        TextView Question5 = (TextView)findViewById(R.id.Q5);
        TextView Question6 = (TextView)findViewById(R.id.Q6);
        TextView Question7 = (TextView)findViewById(R.id.Q7);

        Question1.setText(question1);
        Question2.setText(question2);
        Question3.setText(question3);
        Question4.setText(question4);
        Question5.setText(question5);
        Question6.setText(question6);
        Question7.setText(question7);




       confirmationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child(userID);
                MyDBHandler myDBHandler = new MyDBHandler(SummaryOfTheWeek.this, null, null, MyDBHandler.DB_VERSION);


                float activeCheckMarks;
                float checkedCheckMarks;
                float result;
                activeCheckMarks = (float)(ReturnNumOfQuestions());
                checkedCheckMarks = (float)ReturnNumOfCheckedQuestions();
                result = (checkedCheckMarks/activeCheckMarks) * 100;

                myRef.child("Challenge" + String.valueOf(id)).child("score" + String.valueOf(DayID)).setValue(ServerValue.increment(result));
                myRef.child("Challenge" + String.valueOf(id)).child("summaryPerformed" + String.valueOf(DayID)).setValue(true);

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        boolean wasPerformed1 = snapshot.child("Challenge" + String.valueOf(id)).child("summaryPerformed1").getValue(Boolean.class);
                        boolean wasPerformed2 = snapshot.child("Challenge" + String.valueOf(id)).child("summaryPerformed2").getValue(Boolean.class);
                        boolean wasPerformed3 = snapshot.child("Challenge" + String.valueOf(id)).child("summaryPerformed3").getValue(Boolean.class);
                        boolean wasPerformed4 = snapshot.child("Challenge" + String.valueOf(id)).child("summaryPerformed4").getValue(Boolean.class);
                        boolean wasPerformed5 = snapshot.child("Challenge" + String.valueOf(id)).child("summaryPerformed5").getValue(Boolean.class);
                        boolean wasPerformed6 = snapshot.child("Challenge" + String.valueOf(id)).child("summaryPerformed6").getValue(Boolean.class);
                        boolean wasPerformed7 = snapshot.child("Challenge" + String.valueOf(id)).child("summaryPerformed7").getValue(Boolean.class);


                        if(wasPerformed1 == true && wasPerformed2 == true && wasPerformed3 == true &&
                            wasPerformed4 == true && wasPerformed5 == true && wasPerformed6 == true && wasPerformed7 == true){

                            myRef.child("CurrentChallenge").child("numOfActiveChallenge").setValue(ServerValue.increment(0));

                            SetAlarmCancel(id);

                            if(id < 10) {
                                myRef.child("Challenge" + String.valueOf(id + 1)).child("available").setValue(true);
                                toastMsg();
                            }
                        }
                        else {
                            toastMsg2();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                startActivity(new Intent(SummaryOfTheWeek.this, MainActivity.class));



            }
        });


    }

    void SetContextForQuestions(int id){
        switch(id) {
            case 1:


                question1 = "•\tKrótki prysznic zamiast kąpieli";
                question2 = "•\tMycie naczyń w zmywarce jeżeli jest w pełni zapełniona lub mycie naczyń sposobem napełnionej miski z wodą, namydlaniem a następnie spłukiwaniem wszystkiego na raz.";
                question3 = "•\tZakręcanie wody podczas mycia zębów, namydlania rąk, mycia twarzy itp.";
                question4 = "•\tPonowne wykorzystywanie wody – np. mycie warzyw/ owoców nad miską a następnie wykorzystanie tej wody do mycia naczyń lub podlania kwiatów, wykorzystanie wody po gotowaniu jajek, ryżu itp. do mycia naczyń.";
                question5 = "•\tNastawianie zawsze pełnej pralki\n";
                question6 = "•\tWykorzystuj deszczówkę";
                question7 = "";

                break;
            case 2:
                question1 = "•\tSegregowanie śmieci – papier, plastik i metal, szkło, bioodpady";
                question2 = "•\tZbieranie korków i zorientowanie się gdzie w mieście znajdują się punkty odbioru";
                question3 = "•\tNie śmiecenie na ulicy – zawsze wyrzucać śmieci i NIEDOPAŁKI PO PAPIEROSACH do śmietnika, a jeżeli to możliwe  - do kontenera na dany typ odpadu.";
                question4 = "•\tW miarę możliwości, w przypadku napotkania śmiecia na ulicy, w lesie, parku itp. podniesienie go i wyrzucenie do śmietnika";
                question5 = "•\tNie wyrzucanie śmieci do toalety ! – typu waciki, podpaski, chusteczki, papierki po cukierkach, patyczki do uszu, tampony itp.";
                question6 = "";
                question7 = "";

                break;
            case 3:
                question1 = "•\tJeśli to możliwe – korzystaj z transportu miejskiego";
                question2 = "•\tStosuj technikę jazdy ekologicznej";
                question3 = "•\tPrzesiądź się na rower";
                question4 = "•\tJeśli to możliwe, przemieszczaj się pieszo";
                question5 = "";
                question6 = "";
                question7 = "";

                break;
            case 4:
                question1 = "•\tPosiadanie swojego wielorazowego kubka";
                question2 = "•\tNie korzystanie z jednorazowych słomek, mieszadełek, pokrywek, sztućców, kubków, plastikowych talerzy";
                question3 = "•\tJedzenie na miejscu a w przypadku niedojedzenia potrawy – prośba o spakowanie jedzenia do własnych pojemników";
                question4 = "•\tWybieranie szklanych opcji napojów, a jeżeli to możliwe – proszenie o wodę z kranu";
                question5 = "•\tW przypadku zamawiania jedzenia na wynos warto wspomnieć o niedodawaniu serwetek, sztućców itp. ";
                question6 = "•\tWykazywanie aprobaty w przypadku gdy restauracja/kawiarnia posiada bardziej ekologiczne alternatywy typu papierowe słomki, jadalne naczynia, kartonowe pojemniki";
                question7 = "";

                break;
            case 5:
                question1 = "•\tZaopatrzenie się w wielorazowy kubek/ bidon / butelka na wodę";
                question2 = "•\tDzbanek filtrujący wodę";
                question3 = "•\tZaopatrzenie się w zestaw wielorazowych sztućców i słomki do wykorzystania w przypadku jedzenia na mieście";
                question4 = "•\tPojemniki na jedzenie – najlepiej szklane, można też wykorzystywać słoiki";
                question5 = "•\tSzmaciane torby na zakupy, siatki na warzywa i owoce, lniane woreczki na chleb";
                question6 = "•\tWoskowijki";
                question7 = "";

                break;
            case 6:
                question1 = "•\tPrzed zakupem czegokolwiek zastanów się dwa razy czy na pewno tego potrzebujesz";
                question2 = "•\tZnajdź twoje ulubione produkty w bardziej ekologicznej alternatywie np. w szklanej butelce/ papierowym kartonie, metalowej puszce";
                question3 = "•\tKupuj w większych opakowaniach np. mydło w płynie w dużym opakowaniu do przelewania/ olej, detergenty itp. w baniakach 5 litrowych";
                question4 = "•\tKupuj ubrania z drugiej ręki lub w lumpeksach ";
                question5 = "•\tNie kupuj ubrań pod wpływem impulsu lub promocji – istnieje możliwość że  nigdy ich nie wykorzystasz";
                question6 = "•\tZwracaj uwagę na skład – wspieraj uczciwe firmy i unikaj takich składników jak olej palmowy ";
                question7 = "•\tKupuj papier toaletowy który wyprodukowany został z makulatury\n";

                break;
            case 7:
                question1 = "•\tKupuj tyle ile potrzebujesz";
                question2 = "•\tPrzed zakupami sporządź listę zakupów i zaplanuj posiłki na przód, najlepiej w taki sposób aby wykorzystać wszystkie składniki";
                question3 = "•\tNie wyrzucaj jedzenia – mroź, oddawaj do jadłodzielni, wekuj, ogłoś na internecie";
                question4 = "•\tZwracaj uwagę na datę produktów";
                question5 = "•\tWykorzystuj resztki – np. z obierek zrób bulion, suche pieczywo wykorzystaj na bułkę tartą";
                question6 = "";
                question7 = "";

                break;
            case 8:
                question1 = "•\tKupuj samotne banany";
                question2 = "•\tWspieraj lokalne sklepy i warzywniaki";
                question3 = "•\tZwracaj uwagę na to z czego zostały wyprodukowane Twoje ubrania";
                question4 = "•\tKupuj szampony i odżywki w kostkach, zwracaj uwagę aby mydło posiadało papierowe opakowanie";
                question5 = "•\tZnajdź sklep gdzie produkty typu kasza, orzechy, ryż można kupować na wagę – do ich pakowania wykorzystuj  własne słoiki";
                question6 = "•\tGdy kupujesz coś na wagę – wędlina, ser – poproś sprzedawcę o zapakowanie produktu do własnego pojemnika – bez używania zbędnych folii i opakowań\n";
                question7 = "";

                break;
            case 9:
                question1 = "•\tKup szczoteczkę bambusową";
                question2 = "•\tZaopatrz się w wielorazową maszynkę do golenia";
                question3 = "•\tKubek menstruacyjny, wielorazowe podpaski";
                question4 = "•\tMyjka konopna do naczyń, myjka do demakijażu";
                question5 = "•\tPapierowe patyczki do uszu";
                question6 = "";
                question7 = "";


                break;
            case 10:
                question1 = "•\tOgranicz mięso lub stopniowo z niego zrezygnuj";
                question2 = "•\tUwzględniajmy ślad wodny wybierając produkty";
                question3 = "•\tKupuj jak najmniej przetworzone produkty";
                question4 = "•\tKupuj produkty które nie znajdują się w plastikowych opakowaniach – szczególnie owoce, warzywa";
                question5 = "";
                question6 = "";
                question7 = "";

                break;

            default:
                break;
        }

    }

    public int ReturnNumOfQuestions(){
        int numOfQuestions = 0;
        if(checkBox1.isShown()){
            numOfQuestions++;
        }
        if(checkBox2.isShown()){
            numOfQuestions++;
        }
        if(checkBox3.isShown()){
            numOfQuestions++;
        }
        if(checkBox4.isShown()){
            numOfQuestions++;
        }
        if(checkBox5.isShown()){
            numOfQuestions++;
        }
        if(checkBox6.isShown()){
            numOfQuestions++;
        }
        if(checkBox7.isShown()){
            numOfQuestions++;
        }

        return numOfQuestions;
    }

    public int ReturnNumOfCheckedQuestions(){
        int numOfQuestions = 0;
        if(checkBox1.isChecked()){
            numOfQuestions++;
        }
        if(checkBox2.isChecked()){
            numOfQuestions++;
        }
        if(checkBox3.isChecked()){
            numOfQuestions++;
        }
        if(checkBox4.isChecked()){
            numOfQuestions++;
        }
        if(checkBox5.isChecked()){
            numOfQuestions++;
        }
        if(checkBox6.isChecked()){
            numOfQuestions++;
        }
        if(checkBox7.isChecked()){
            numOfQuestions++;
        }

        return numOfQuestions;
    }

    public void toastMsg() {
        Toast toast = Toast.makeText(this, "Gratulację ! Odblokowałeś nowe wyzwanie !", Toast.LENGTH_LONG);
        toast.show();
    }

    public void toastMsg2() {
        Toast toast = Toast.makeText(this, "Podsumowanie dnia zostało wykonane !", Toast.LENGTH_LONG);
        toast.show();
    }

    public void SetID (int id) {
        id = id;
    }

    public void CancelAlarm1(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge1Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void CancelAlarm2(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge2Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void CancelAlarm3(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge3Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void CancelAlarm4(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge4Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void CancelAlarm5(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge5Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void CancelAlarm6(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge6Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void CancelAlarm7(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge7Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }


    public void CancelAlarm8(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge8Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void CancelAlarm9(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge9Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void CancelAlarm10(){
        Intent intent = new Intent(getApplicationContext(), WeekChallenge10Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 101, intent, PendingIntent.FLAG_NO_CREATE);
        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
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


