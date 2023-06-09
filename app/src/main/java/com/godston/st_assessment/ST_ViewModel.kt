package com.godston.st_assessment

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ST_ViewModel : ViewModel() {
    var accountList = emptyList<AccountDataClass>().toMutableList()
    private var bankCode: String? = null
    private var code: String = ""
    var total = 0

    fun generate9DigitsNumber(): Int {
        val random = Random(System.currentTimeMillis())
        return random.nextInt(100000000, 1000000000)
    }

    fun calculate() {
        code = if (bankCode == null) {
            "011"
        } else {
            bankCode.toString()
        }
        val randomNo = generate9DigitsNumber()
        val number = "$code$randomNo".toList()
        val mFactor = 373373373373.toString().toList()
        val list: MutableList<Int> = mutableListOf()
        println(number)
        println(mFactor)

        val mappedList = number.mapIndexed { index, num -> num to mFactor.getOrNull(index) }
        mappedList.forEach { (numA, numB) ->
            list.add(Integer.parseInt(numA.toString()) * Integer.parseInt(numB.toString()))
            total += Integer.parseInt(numA.toString()) * Integer.parseInt(numB.toString())
        }
        val randomNumber = "$randomNo"
        val codeAndRandomNumber = "$number".filter { it.isDigit() }
        val _mFactor = "$mFactor".filter { it.isDigit() }
        val mappedNumber = "$list"
        val _total = "$total"
        val modulo = "${total % 10}"
        val chkDgt = if (modulo == "0") modulo
        else "${10 - (total % 10)}"
        println("$number${10 - (total % 10)}")
        val acctNo = if (modulo == "0") "$randomNo$modulo"
        else "$randomNo${10 - (total % 10)}"
        val toAdd = AccountDataClass(
            randomNumber,
            codeAndRandomNumber,
            _mFactor,
            mappedNumber,
            _total,
            modulo,
            chkDgt,
            acctNo
        )
        accountList.add(toAdd)
        total = 0
    }
}
