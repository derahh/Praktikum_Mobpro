package com.example.praktikan.jurnal4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HewanAdapter extends RecyclerView.Adapter<HewanAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Hewan> mData;
    private int mColorResId;

    public HewanAdapter(Context context, ArrayList<Hewan> mData, int mColorResId) {
        this.context = context;
        this.mData = mData;
        this.mColorResId = mColorResId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_kategori, parent, false);
        view.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), mColorResId, context.getTheme()));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hewan hewan = mData.get(position);
        holder.namaHewanTextView.setText(hewan.getNamaHewanWord());
        holder.namaLatinTextView.setText(hewan.getNamaLatinWord());
//        holder.imageView.setImageResource(w.getImageResId());
        if (hewan.hasImage()){
            holder.imageView.setVisibility(View.VISIBLE); //biar kelihatan gambarnya saat recycler
            holder.imageView.setImageResource(hewan.getImageResId());
        }else {
            holder.imageView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        final TextView namaHewanTextView;
        final TextView namaLatinTextView;
        final ImageView imageView;
        public ViewHolder (View itemView){
            super(itemView);
            namaHewanTextView = itemView.findViewById(R.id.namaHewan_textView);
            namaLatinTextView = itemView.findViewById(R.id.namaLatin_textView);
            imageView = itemView.findViewById(R.id.gambarHewan_imageView);
        }
    }
}
