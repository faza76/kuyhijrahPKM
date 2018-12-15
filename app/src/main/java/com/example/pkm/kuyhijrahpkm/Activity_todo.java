package com.example.pkm.kuyhijrahpkm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class Activity_todo extends AppCompatActivity {

    private static final String TAG = "Activity_todo";

    static Activity_todo activity_todo;

    private ArrayList<String> mTodos = new ArrayList<>();
    private ArrayList<String> mCb = new ArrayList<>();

    public ProgressBar pBar;

    CardView bWajib;
    CardView bSunnah;
    CardView bSunnahR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

     activity_todo = this;

    pBar = (ProgressBar) findViewById(R.id.progressBar);
    pBar.setMax(5);
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

        inittodos();

    }

    private void inittodos(){
        Log.d(TAG, "inittodos: ");

        mTodos.add("qwer");
        mCb.add("0");
        Log.d(TAG, "inittodos: 1");
        mTodos.add("asdf");
        mCb.add("1");
        Log.d(TAG, "inittodos: 2");
        mTodos.add("zxcv");
        mCb.add("0");
        Log.d(TAG, "inittodos: 3");
        mTodos.add(" ");
        mCb.add("0");

        mTodos.add("1");
        mCb.add("1");

        initrecyclerview();

    }

        private void initrecyclerview(){
            Log.d(TAG, "initrecyclerview: ");

            RecyclerView recyclerView = findViewById(R.id.recycler_view_todo);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(mCb,mTodos,this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


        public static Activity_todo getInstance(){
            return activity_todo;
        }

        public void changePbar(int status){
            pBar.setProgress(status);
        }




}
