package com.godston.st_assessment

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ST_ViewModel : ViewModel() {

     private var bankCode: String? = ""

    private

    fun generate9DigitsNumber(): Int {
        val random = Random(System.currentTimeMillis())
        return random.nextInt(100000000, 1000000000)
    }

    fun calculate() {
        bankCode = "anyBankCode"
        var result = bankCode ?: "011"
//        val number = "$result${generate9DigitsNumber()}".toList()
        val number = arrayOf(Integer.parseInt("$result${generate9DigitsNumber()}".toList().toString()))
        val mFactor = arrayOf(Integer.parseInt("373373373373".toList().toString()))
        println(number)
        println(mFactor)
//        val stBCode = ""
//        for (i in number) {
//           for (j in mFactor){
//              result =
//           }
//        }
    }
}
