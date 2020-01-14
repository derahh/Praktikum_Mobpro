package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String location;
    private long timeInMilliSeconds;
    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliSeconds, String mUrl) {
        this.magnitude = magnitude;
        this.location = location;
        this.timeInMilliSeconds = timeInMilliSeconds;
        this.mUrl = mUrl;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMilliSeconds() {
        return timeInMilliSeconds;
    }

    public String getmUrl() {
        return mUrl;
    }
}
