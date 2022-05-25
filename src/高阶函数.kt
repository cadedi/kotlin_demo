//(Int, Int) -> Int 表示函数类型
//在字节码实现上,该类型被每次调用都会创建一个匿名类实例,使用内联函数可以减少该类开销
fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}


fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

//使用已有声明的可调用引用获取函数类型的实例
val plusFunVar: (Int, Int) -> Int = ::plus
//lambda获取函数类型的实例
val minusFunVar: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 - num2 }
//匿名函数获取函数类型的实例
val minusFunVar2: (Int, Int) -> Int = fun(num1: Int, num2: Int): Int {
    return num1 - num2
}

//Unit表示该函数类型无返回值
//StringBuilder.() -> Unit在函数类型的前面加上ClassName表示定义在指定类中,该函数类型将自动拥有该类的上下文(apply的原理)
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}


val sum: Int.(Int) -> Int = { other -> plus(other) }

fun main() {


/*    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())*/


/*    val num1 = 100
    val num2 = 80
    //传入函数类型固定写法::
    val result1 = num1AndNum2(num1, num2, ::plus)
    val result2 = num1AndNum2(num1, num2, ::minus)
    //函数类型参数接受lambda表达式
    val result3 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
    val result4 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 - n2
    }
    //直接传入函数引用类型变量
    val result5 = num1AndNum2(num1, num2, plusFunVar)
    val result6 = num1AndNum2(num1, num2, minusFunVar)
    println("result1 is $result1")
    println("result2 is $result2")
    println("result3 is $result3")
    println("result4 is $result4")
    println("result5 is $result5")
    println("result6 is $result6")*/


}