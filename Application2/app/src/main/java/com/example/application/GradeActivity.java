package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        final Context _this = GradeActivity.this;
        final EditText kor = findViewById(R.id.score_kor);
        final EditText math = findViewById(R.id.score_math);
        final EditText eng = findViewById(R.id.score_eng);
        final TextView result = findViewById(R.id.score_avg);

        findViewById(R.id.btn_avg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kor.getText().toString());
                int b = Integer.parseInt(math.getText().toString());
                int c = Integer.parseInt(eng.getText().toString());
                int d = (a+b+c)/3;

                result.setText("평균점수 : "+d);
            }
        });
    }
}
