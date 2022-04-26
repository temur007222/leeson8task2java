package com.example.leeson8task2java.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.leeson8task2java.Fragments.FirstFragment;
import com.example.leeson8task2java.Fragments.SecondFragment;
import com.example.leeson8task2java.R;

public class RunTimeActivity extends AppCompatActivity implements FirstFragment.FirstListener, SecondFragment.SecondListener {

    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime);
        initViews();
    }

    @Override
    public void onFirstSend(String str) {
        secondFragment.updateSecondText(str);
    }

    @Override
    public void onSecondSend(String str) {
        firstFragment.updateFirstText(str);
    }

    void initViews(){
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameFirst,firstFragment)
                .replace(R.id.frameSecond,secondFragment)
                .commit();
    }

}
