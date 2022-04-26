package com.example.leeson8task2java.Activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.leeson8task2java.R;

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.toString();
    int LAUNCH_DETAIL = 1001;
    TextView tv_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Log.d(TAG, "MainActivity onCreate");
    }

    void initViews() {
        tv_home = findViewById(R.id.tv_home);
        Button b_detail = findViewById(R.id.b_detail);
        b_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  openFragmentActivity();
                openRuntimeActivity();
            }
        });
    }

    ActivityResultLauncher<Intent> detailLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        assert data != null;
                        String text = data.getStringExtra("result");
                        Log.d(TAG, text);
                        tv_home.setText(text);
                    }
                }
            });

    void openFragmentActivity() {
        Intent intent = new Intent(this, FragmentActivity.class);
        startActivity(intent);
    }

    void openRuntimeActivity() {
        Intent intent = new Intent(this, RunTimeActivity.class);
        startActivity(intent);
    }
}