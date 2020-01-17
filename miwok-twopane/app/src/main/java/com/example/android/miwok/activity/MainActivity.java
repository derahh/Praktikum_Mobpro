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
package com.example.android.miwok.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.android.miwok.fragment.CategoryFragment;
import com.example.android.miwok.fragment.PhrasesFragment;
import com.example.android.miwok.fragment.ColorsFragment;
import com.example.android.miwok.fragment.FamilyFragment;
import com.example.android.miwok.fragment.NumbersFragment;
import com.example.android.miwok.R;

public class MainActivity extends AppCompatActivity implements CategoryFragment.ActionListener {

    private boolean isTablet;
    private Fragment fragment;
    private int selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        isTablet = findViewById(R.id.frame_word) != null;

        if (isTablet){
            if (savedInstanceState != null) selectedCategory = savedInstanceState.getInt(WordActivity.EXTRA_CATEGORY);
            else selectedCategory = R.string.category_numbers;
        }

        actionListener(selectedCategory);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (isTablet) outState.putInt(WordActivity.EXTRA_CATEGORY, selectedCategory);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void actionListener(int category) {
        FragmentManager fm = getSupportFragmentManager();
        selectedCategory = category;
        if (isTablet){
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
            fm.beginTransaction().replace(R.id.frame_word, fragment).commit();
        } else {
            Intent intent = new Intent(this, WordActivity.class);
            intent.putExtra(WordActivity.EXTRA_CATEGORY, category);
            startActivity(intent);
        }
    }
}
