/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<ArrayList<Earthquake>> {

    private RecyclerView recyclerView;
    private String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2019-04-10&endtime=2019-04-18&limit=10";
    private ArrayList<Earthquake> data;
    private EarthquakeAdapter adapter;
    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        recyclerView = findViewById(R.id.recyler);
        data = new ArrayList<>();
//        data = Utils.extractEarthquakes();

        adapter = new EarthquakeAdapter(this, data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<ArrayList<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        return new earthquakeLoader(this, USGS_URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Earthquake>> loader, ArrayList<Earthquake> earthquakeActivities) {
        adapter.swapQursor(earthquakeActivities);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Earthquake>> loader) {
        adapter.clear();
    }
}
