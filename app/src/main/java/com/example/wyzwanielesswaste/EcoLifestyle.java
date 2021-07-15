package com.example.wyzwanielesswaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EcoLifestyle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco_lifestyle);

        Button ecoCity = (Button) findViewById(R.id.ecoMiasto);
        Button kupony = (Button) findViewById(R.id.kupony);

        ecoCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChooseCity.class));
            }
        });


    }
}