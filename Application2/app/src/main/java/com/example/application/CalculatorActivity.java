package com.example.application;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final Context ctx = CalculatorActivity.this;
        final EditText etext = findViewById(R.id.etext);
        final TextView result = findViewById(R.id.result);

        class Calc{
            int numOne;
            int getNumOne(){return numOne;}
            void setNumOne(int numOne){this.numOne=numOne;}
        }

        final Calc c = new Calc();

        findViewById(R.id.btn_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setNumOne(Integer.parseInt(etext.getText().toString()));
                etext.setText("");
                Toast.makeText(CalculatorActivity.this, "입력된 숫자"+ c.getNumOne() +"",Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.btn_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorActivity.this,"토스트 성공2",Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.btn_multy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorActivity.this,"토스트 성공3",Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.btn_divid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorActivity.this,"토스트 성공4",Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalculatorActivity.this,"토스트 성공=",Toast.LENGTH_LONG).show();
                int val = Integer.parseInt(etext.getText().toString());
                etext.setText("");
                result.setText((c.getNumOne()+val)+"");
            }
        });
    }
}
