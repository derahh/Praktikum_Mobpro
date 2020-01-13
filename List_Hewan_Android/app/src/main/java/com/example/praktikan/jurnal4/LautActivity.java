package com.example.praktikan.jurnal4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LautActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ternak);

        ArrayList<Hewan> data =new ArrayList<>();
        data.add(new Hewan("Anjing Laut", "Monachus monachus", R.drawable.anjing));
        data.add(new Hewan("Beruang Laut", "Ursus maritimus", R.drawable.beruang));
        data.add(new Hewan("Gurita", "Octopus vulgaris", R.drawable.gurita));
        data.add(new Hewan("Hiu", "Prionace glauca", R.drawable.hiu));
        data.add(new Hewan("Kepiting", "Scyda serrata", R.drawable.kepiting));
        data.add(new Hewan("Kerang", "Pinctada maxima", R.drawable.kerang));
        data.add(new Hewan("Kuda Laut", "Hippocampus sp.", R.drawable.kudalaut));
        data.add(new Hewan("Lumba-Lumba", "Delphinus capensis", R.drawable.lumba));
        data.add(new Hewan("Paus", "Balaenoptera musculus", R.drawable.paus));
        data.add(new Hewan("Penyu", "Chelonia midas", R.drawable.penyu));

        RecyclerView recyclerView = findViewById(R.id.word_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        HewanAdapter adapter = new HewanAdapter(this, data, R.color.kategori_laut);
        recyclerView.setAdapter(adapter);
    }
}
