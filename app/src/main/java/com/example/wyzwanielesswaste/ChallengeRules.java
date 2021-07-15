package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ChallengeRules extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_rules);

        TextView titleTV = (TextView)findViewById(R.id.titleTV);
        TextView contentsTV = (TextView)findViewById(R.id.contentsTV);


        titleTV.setText("Zasady wyzwania");
        contentsTV.setText("Aplikacja Wyzwanie Less Waste pomaga w prosty sposób wypracować nawyki zgodne z ekologiczną myślą. Podejmij dziesięciotygodniowe wyzwanie ! – każdy tydzień to szansa na zapoznanie się z danym problemem (np. marnowanie wody, segregowanie śmieci) oraz podjęcie wobec niego konkretnych działań. Każdego dnia otrzymasz powiadomienie z ekoporadą oraz zadaniami odpowiednimi dla danego wyzwania. Dokumentuj swój postęp wypełniając codzienne podsumowanie wyzwania. Kontroluj swój postęp w zakładce Moje konto > Statystyki.");
    }
}