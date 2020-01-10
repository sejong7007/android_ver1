package com.example.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnImageLotto.setOnClickListener{
            //Toast.makeText(this,"로또번호 생성",Toast.LENGTH_LONG).show()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result",
                ArrayList(LottoNumberMaker.getRandomLottoNumbers())
            )
            startActivity(intent)
        }
    }
}
