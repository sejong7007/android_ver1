package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context _this = MainActivity.this;

        findViewById(R.id.calcbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"계산기로 이동",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(_this, CalculatorActivity.class));
            }
        });

        findViewById(R.id.gradebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"성적계산기로 이동",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(_this, GradeActivity.class));
            }
        });

        findViewById(R.id.schedulebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(_this, SchaduleActivity.class));
            }
        });


    }
}
