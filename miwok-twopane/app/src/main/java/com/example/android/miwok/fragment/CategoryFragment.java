package com.example.android.miwok.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.miwok.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener{

    private TextView tvNumber, tvColor, tvPhrase, tvFamily;

    public interface ActionListener{
        void actionListener(int category);
    }

    private ActionListener listener;

    @Override
    public void onAttach(Context context) {
        try{
            listener = (ActionListener) context;
        } catch (Exception e){
            throw new ClassCastException();
        }
        super.onAttach(context);
    }

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNumber = view.findViewById(R.id.numbers);
        tvColor = view.findViewById(R.id.colors);
        tvPhrase = view.findViewById(R.id.phrases);
        tvFamily = view.findViewById(R.id.family);

        tvNumber.setOnClickListener(this);
        tvColor.setOnClickListener(this);
        tvPhrase.setOnClickListener(this);
        tvFamily.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numbers:
                listener.actionListener(R.string.category_numbers);
                break;
            case R.id.colors:
                listener.actionListener(R.string.category_colors);
                break;
            case R.id.phrases:
                listener.actionListener(R.string.category_phrases);
                break;
            case R.id.family:
                listener.actionListener(R.string.category_family);
                break;
        }
    }

}
