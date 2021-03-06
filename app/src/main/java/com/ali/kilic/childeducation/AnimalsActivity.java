package com.ali.kilic.childeducation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalsActivity extends AppCompatActivity {


    RecyclerView animalsListView;
    AnimalsAdapter animalsAdapter;
    IAnimasAdapterClicks animasAdapterClicks = new IAnimasAdapterClicks() {
        @Override
        public void animalItemCLick(String animalName) {
            MusicHelper.getInstance().play("file:///android_asset/" + animalName + ".mp3",
                    getApplicationContext());
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        init();

    }

    private void init() {
        ArrayList<Integer> animals = new ArrayList<>();
        animals.add(R.drawable.cat);
        animals.add(R.drawable.dog);
        animals.add(R.drawable.cow);
        animals.add(R.drawable.chick);
        animals.add(R.drawable.donkey);
        animals.add(R.drawable.horse);
        animals.add(R.drawable.sheep);
        animals.add(R.drawable.cockpng);
        animalsListView = findViewById(R.id.animalsListView);
        animalsAdapter = new AnimalsAdapter(getApplicationContext(), animals);
        animalsAdapter.animasAdapterClicks = animasAdapterClicks;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        animalsListView.setLayoutManager(gridLayoutManager);
        animalsListView.setAdapter(animalsAdapter);

    }
}
