package com.example.praktikan.jurnal4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class TernakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ternak);

        ArrayList<Hewan> data =new ArrayList<>();
        data.add(new Hewan("Angsa", "Cygnus olor", R.drawable.angsa));
        data.add(new Hewan("Ayam", "Gallus gallus", R.drawable.ayam));
        data.add(new Hewan("Bebek", "Cairina moschata", R.drawable.bebek));
        data.add(new Hewan("Domba", "Ovis ammon", R.drawable.domba));
        data.add(new Hewan("Kalkun", "Meleagris gallopavo", R.drawable.kalkun));
        data.add(new Hewan("Kambing", "Capricornis sumatrensis", R.drawable.kambing));
        data.add(new Hewan("Kelinci", "Oryctolagus cuniculus", R.drawable.kelinci));
        data.add(new Hewan("Kerbau", "Bubalus bubalis", R.drawable.kerbau));
        data.add(new Hewan("Kuda", "Equus caballus", R.drawable.kuda));
        data.add(new Hewan("Sapi", "Bos taurus", R.drawable.sapi));

        RecyclerView recyclerView = findViewById(R.id.word_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        HewanAdapter adapter = new HewanAdapter(this, data, R.color.kategori_ternak);
        recyclerView.setAdapter(adapter);

//        ListView listView = findViewById(R.id.word_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(adapter);
    }
}
