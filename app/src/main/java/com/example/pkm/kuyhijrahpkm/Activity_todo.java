package com.example.pkm.kuyhijrahpkm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Activity_todo extends AppCompatActivity {

    CardView bWajib;
    CardView bSunnah;
    CardView bSunnahR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

    bWajib = (CardView) findViewById(R.id.sWajib);
    bSunnahR = (CardView) findViewById(R.id.sSunnahR);
    bSunnah = (CardView) findViewById(R.id.sSunnah);

                bWajib.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent Sholat = new Intent(Activity_todo.this, SholatWajib.class);
            Sholat.putExtra("pilihan",1);
            startActivity(Sholat);
        }
    });

    bSunnahR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Sholat = new Intent(Activity_todo.this, SholatWajib.class);
                Sholat.putExtra("pilihan",2);
                startActivity(Sholat);
            }
        });

    bSunnah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Sholat = new Intent(Activity_todo.this, SholatWajib.class);
                Sholat.putExtra("pilihan",3);
                startActivity(Sholat);
            }
        });


    }


}
