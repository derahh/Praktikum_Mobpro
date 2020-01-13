package com.example.praktikan.jurnal4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] jenisHewan = {"TERNAK", "HUTAN", "LANGKA", "LAUT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ternakTextView = findViewById(R.id.ternak);
        ternakTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TernakActivity.class);
                startActivity(i);
            }
        });

        TextView hutanTextView = findViewById(R.id.hutan);
        hutanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HutanActivity.class);
                startActivity(i);
            }
        });

        TextView lautTextView = findViewById(R.id.laut);
        lautTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LautActivity.class);
                startActivity(i);
            }
        });

        TextView langkaTextView = findViewById(R.id.langka);
        langkaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LangkaActivity.class);
                startActivity(i);
            }
        });
    }
}
