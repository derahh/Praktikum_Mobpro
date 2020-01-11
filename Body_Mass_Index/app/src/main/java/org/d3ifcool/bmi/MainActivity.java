package org.d3ifcool.bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> data = new ArrayList<>();
        data.add(getString(R.string.ideal_judul_0));
        data.add(getString(R.string.ideal_judul_1));
        data.add(getString(R.string.ideal_judul_2));
        data.add(getString(R.string.ideal_judul_3));
        data.add(getString(R.string.ideal_judul_4));
        data.add(getString(R.string.ideal_judul_5));
        data.add(getString(R.string.ideal_judul_6));
        data.add(getString(R.string.ideal_judul_7));

//        ListView listView = findViewById(R.id.listview);
        RecyclerView recyclerView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(adapter);
    }
}
