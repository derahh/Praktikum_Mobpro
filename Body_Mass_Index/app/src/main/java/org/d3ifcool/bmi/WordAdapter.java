package org.d3ifcool.bmi;

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

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Word> mData;
    private int mBackground;

    WordAdapter(Context context, ArrayList<Word> data, int colorResId) {
        this.mContext = context;
        this.mData = data;
        this.mBackground = ResourcesCompat.getColor(
                context.getResources(), colorResId, context.getTheme());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.activity_main, parent, false);
        view.setBackgroundColor(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word word = mData.get(position);
        holder.saran.setText(word.getSaran());
        holder.deskripsi.setText(word.getDeskripsi());
        holder.gambar.setImageResource(word.getImageResId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView saran, deskripsi;
        final ImageView gambar;

        ViewHolder(View itemView) {
            super(itemView);

            saran = itemView.findViewById(R.id.saran);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            gambar = itemView.findViewById(R.id.gambar);

            itemView.setClickable(true);
            itemView.setFocusable(true);
        }
    }

}
