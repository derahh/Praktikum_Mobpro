package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.viewHolder> {

    private Context mContext;
    private ArrayList<Earthquake> mData;

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> data) {
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.earthquake_list_item, parent, false);
        return new  viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final Earthquake currentEarthquake = mData.get(position);

        String formattedMagnitude = formatmagnitude(currentEarthquake.getMagnitude());

        Date dateObject = new Date(currentEarthquake.getTimeInMilliSeconds());
        String formattedDate = formatDate(dateObject);
        String foramttedTime = formatTime(dateObject);

        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation, locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)){
            String[]parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }else {
            locationOffset = "Near the";
            primaryLocation = originalLocation;
        }

        holder.magniude.setText(formattedMagnitude);
        holder.locayionOffset.setText(locationOffset);
        holder.primaryLocation.setText(primaryLocation);
        holder.date.setText(formattedDate);
        holder.time.setText(foramttedTime);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        final TextView magniude, locayionOffset, primaryLocation, date, time;

        public viewHolder(View itemView) {
            super(itemView);
            magniude = itemView.findViewById(R.id.magnitude);
            locayionOffset = itemView.findViewById(R.id.location_offset);
            primaryLocation = itemView.findViewById(R.id.primary_location);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatmagnitude (Double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    void swapQursor(ArrayList<Earthquake> earthquakes){
        mData = earthquakes;
        notifyDataSetChanged();
    }

    void clear(){
        mData = null;
    }
}
