package com.example.leeson8task2java.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.leeson8task2java.Activities.MainActivity;
import com.example.leeson8task2java.Models.User;
import com.example.leeson8task2java.R;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    ArrayList<User> list;
    private FirstListener listener;
    TextView tv_first;
    private static final String TAG = "Message";

    public FirstFragment(ArrayList<User> list, FirstListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public FirstFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initViews(view);
        return view;
    }

    void initViews(View view){
        tv_first = view.findViewById(R.id.tv_first);
        Button b_first = view.findViewById(R.id.b_first);
        b_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             getData();
            }
        });
    }

    public void getData(){
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Nick", 20));
        Log.d(TAG,list.toString());
        tv_first.setText(list.toString());
        listener.onFirstSend(list);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  FirstListener){
            listener = (FirstListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement FirstListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void updateFirstText(ArrayList<User> data){
        tv_first.setText(data.toString());
    }

    public interface FirstListener{
        void onFirstSend(ArrayList<User>list);
    }
}
