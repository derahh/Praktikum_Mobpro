package com.example.praktikan.jurnal4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HutanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ternak);

        ArrayList<Hewan> data =new ArrayList<>();
        data.add(new Hewan("Berang-Berang", "Lutra sumatrana", R.drawable.berang));
        data.add(new Hewan("Katak", "Rana macrodon", R.drawable.katak));
        data.add(new Hewan("Koala", "Phascolartus cinereus", R.drawable.koala));
        data.add(new Hewan("Kudanil", "Hippotamus amphibius", R.drawable.kudanil));
        data.add(new Hewan("Laba-Laba", "Heteropoda venatoria", R.drawable.laba));
        data.add(new Hewan("Landak", "Hystrix brachyura", R.drawable.landak));
        data.add(new Hewan("Monyet", "Macaca fascicularis", R.drawable.monyet));
        data.add(new Hewan("Rakun", "Proyon lotor", R.drawable.rakun));
        data.add(new Hewan("Rubah", "Vulpes vulpes", R.drawable.rubah));
        data.add(new Hewan("Tupai", "Tupaia javanica", R.drawable.tupai));

        RecyclerView recyclerView = findViewById(R.id.word_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        HewanAdapter adapter = new HewanAdapter(this, data, R.color.kategori_hutan);
        recyclerView.setAdapter(adapter);
    }
}
