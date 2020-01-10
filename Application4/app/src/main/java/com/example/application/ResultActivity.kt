package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    val lottoImageId = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result = intent.getIntegerArrayListExtra("result")
        Toast.makeText(this,result.toString(),Toast.LENGTH_SHORT).show()
        updateLottoBallImage(result.sortedBy{it})
    }

    fun updateLottoBallImage(result: List<Int>){
        imageView1.setImageResource(lottoImageId+(result[0]-1))
        imageView2.setImageResource(lottoImageId+(result[1]-1))
        imageView3.setImageResource(lottoImageId+(result[2]-1))
        imageView4.setImageResource(lottoImageId+(result[3]-1))
        imageView5.setImageResource(lottoImageId+(result[4]-1))
        imageView6.setImageResource(lottoImageId+(result[5]-1))
    }
}
