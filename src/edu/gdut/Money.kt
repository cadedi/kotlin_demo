package edu.gdut

class Money(val value:Int) {


    //运算符重载 +
    operator fun plus(money: Money):Money{
        val sum = value+money.value
        return Money(sum)
    }

    operator fun plus(newValue:Int):Money{
        val sum = value + newValue
        return Money(sum)
    }
}