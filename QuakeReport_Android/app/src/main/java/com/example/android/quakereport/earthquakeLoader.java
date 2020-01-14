package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

public class earthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {
    private String mUrl;
    public earthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        ArrayList<Earthquake> earthquakes = Utils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
