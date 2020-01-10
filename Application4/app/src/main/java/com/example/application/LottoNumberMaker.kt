package com.example.application

import android.util.Log
import java.util.*

object LottoNumberMaker{

    fun getRandomLottoNumbers(): MutableList<Int>{
        val lottoNumbers = mutableListOf<Int>()
        for(i in 1..6){
            var number = 0
            do{
                number = getRandomLottoNumber()
            }while (lottoNumbers.contains(number))
            lottoNumbers.add(number)
        }
        Log.d("로또 번호들 : ",lottoNumbers.toString())
        return lottoNumbers
    }

    fun getRandomLottoNumber(): Int{
        return Random().nextInt(45)+1
    }
}