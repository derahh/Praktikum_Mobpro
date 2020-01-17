package com.example.android.miwok.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.android.miwok.R;
import com.example.android.miwok.fragment.ColorsFragment;
import com.example.android.miwok.fragment.FamilyFragment;
import com.example.android.miwok.fragment.NumbersFragment;
import com.example.android.miwok.fragment.PhrasesFragment;

public class WordActivity extends AppCompatActivity {

    static final String EXTRA_CATEGORY = "category";
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        FragmentManager fm = getSupportFragmentManager();
        int category = getIntent().getIntExtra(EXTRA_CATEGORY, 0);
        switch (category){
            case R.string.category_numbers:
                fragment = new NumbersFragment();
                break;
            case R.string.category_family:
                fragment = new FamilyFragment();
                break;
            case R.string.category_colors:
                fragment = new ColorsFragment();
                break;
            case  R.string.category_phrases:
                fragment = new PhrasesFragment();
                break;
        }
        fm.beginTransaction().add(R.id.frame_word, fragment).commit();
    }
}
