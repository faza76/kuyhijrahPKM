package com.example.pkm.kuyhijrahpkm;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class SholatWajib extends AppCompatActivity {

    ListView lvWajib;
    String[] itemW = {"Subuh","Dzuhur","Ashar","Maghrib","Isya"};
    String[] itemS = {"Shalat Qobla Shubuh", "Shalat Qobla Dzuhur","Shalat Ba'da Dzuhur","Shalat Ba'da Maghrib"};
    String[] itemsSS = {"Shalat Dhuha","Shalat Sukru Wudhu", "Shalat Tahajud", "Shalat Tasbih","Shalat Taubat", "Shalat Witir", "Shalat Qiyamul Lail/Tarawih","Shalat Suruk"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholat_wajib);
        Intent intent = getIntent();
        int value = intent.getIntExtra("pilihan",0);

        lvWajib = (ListView) findViewById(R.id.lvWajib);

        switch (value){
            case 1 :
                ArrayAdapter<String> adapterW = new ArrayAdapter<String>(this,R.layout.lvsholat,itemW);
                lvWajib.setAdapter(adapterW);
                break;
            case 2 :
                ArrayAdapter<String> adapterS = new ArrayAdapter<String>(this,R.layout.lvsholat,itemS);
                lvWajib.setAdapter(adapterS);
                break;
            case 3 :
                ArrayAdapter<String> adapterSS = new ArrayAdapter<String>(this,R.layout.lvsholat,itemsSS);
                lvWajib.setAdapter(adapterSS);
                break;
        }

        lvWajib.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(SholatWajib.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_set,null);
                final TextView teks = (TextView) mView.findViewById(R.id.eTeks);
                final NumberPicker nPick = (NumberPicker) mView.findViewById(R.id.value);
                teks.setText(itemW[position]);
                Button mSet = (Button) mView.findViewById(R.id.btn_set);
                 mSet.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         String values = nPick.toString();
                         Toast.makeText(SholatWajib.this,values,Toast.LENGTH_SHORT).show();
                     }
                 });

                 mbuilder.setView(mView);
                 AlertDialog dialog = mbuilder.create();
                 dialog.show();
            }
        });

    }
}
