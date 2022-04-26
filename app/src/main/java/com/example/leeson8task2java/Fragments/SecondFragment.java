package com.example.leeson8task2java.Fragments;

import android.content.Context;
import android.location.GnssAntennaInfo;
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

import com.example.leeson8task2java.Models.User;
import com.example.leeson8task2java.R;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private SecondListener listener;
    TextView tv_second;
    String TAG = SecondFragment.class.toString();
    ArrayList<User> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        initViews(view);
        return view;
    }

    void initViews(View view){
        tv_second = view.findViewById(R.id.tv_second);
        Button b_second = view.findViewById(R.id.b_second);
        b_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    public void getData(){
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Mark", 21));
        Log.d(TAG,list.toString());
        tv_second.setText(list.toString());
        listener.onSecondSend(list);
    }

    public SecondFragment(ArrayList<User> list, SecondListener listener) {
        this.list = list;
        this.listener = (SecondListener) listener;
    }

    public SecondFragment(int contentLayoutId, ArrayList<User> list, SecondListener listener) {
        super(contentLayoutId);
        this.list = list;
        this.listener = listener;
    }

    public SecondFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof SecondListener){
            listener = (SecondListener) context;
        }else{
            throw new RuntimeException(context + " must implement SecondListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void updateSecondText(ArrayList<User> data){
        tv_second.setText(data.toString());
    }

    public interface SecondListener{
        void onSecondSend(ArrayList<User> list);
    }
}
