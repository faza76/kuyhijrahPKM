package com.example.pkm.kuyhijrahpkm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    CardView mainProfile;
    CardView mainAbout;
    CardView mainJadwal;
    CardView mainCalendar;
    CardView mainTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid =(GridLayout)findViewById(R.id.mainGrid);

//        setToogleEvent(mainGrid);
        mainProfile = (CardView) findViewById(R.id.mainProfile);
        mainJadwal = (CardView) findViewById(R.id.mainJadwal);
        mainCalendar = (CardView) findViewById(R.id.mainKalendar);
        mainTodo = (CardView) findViewById(R.id.mainTodo);

        mainCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(MainActivity.this, Activity_calendar.class);
                startActivity(profile);
            }
        });

        mainTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(MainActivity.this, Activity_todo.class);
                startActivity(profile);
            }
        });



    }
}
