package com.example.praktikan.jurnal4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LangkaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ternak);

        ArrayList<Hewan> data =new ArrayList<>();
        data.add(new Hewan("Berang-Berang", "Anoa depressicornis"));
        data.add(new Hewan("Bekantan", "Nasalis larvatus"));
        data.add(new Hewan("Jalak Bali", "Leucopsar rotschildi"));
        data.add(new Hewan("Enggang Gading", "Rhinoplax vigil"));
        data.add(new Hewan("Maleo Senkawor", "Macrocephalon maleo"));
        data.add(new Hewan("Mandar Dengkur", "Aramidopsis plateni"));
        data.add(new Hewan("Mentilin", "Tarsius bancanus"));
        data.add(new Hewan("Pesut Mahakam", "Orcaella brevirostris"));
        data.add(new Hewan("Rusa Timor", "Cervus timorensis"));
        data.add(new Hewan("Tangkasi", "Tarsius tarsier"));

        RecyclerView recyclerView = findViewById(R.id.word_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        HewanAdapter adapter = new HewanAdapter(this, data, R.color.kategori_langka);
        recyclerView.setAdapter(adapter);
    }
}
