//内联函数中用到函数类型参数的地方会执行代码替换
/*
* 内联的函数类型参数与一般的函数类型参数的区别
* 1.内联的函数类型参数不是真正的函数类型,不能自由传递给其他任何函数,只允许传递给另外一个内联函数
* 2.内联函数所引用的Lambda表达式中是可以使用return关键字来进行函数返回的(同时终止外部函数)，而非内联函数只能进行局部返回(必须使用return@关键字,且只终止该lambda的执行)
* */
inline fun num1AndNum2_inline(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

inline fun printString_inline(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

//noinline关键字可以选择让内联函数只内联部分函数参数
inline fun inlineTest(block1: () -> Unit, noinline block2: () -> Unit) {
}


//不能直接使用内联函数的情况
/*inline fun runRunnable(block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}*/
/*
* 在高阶函数中创建了另外的Lambda或者匿名类的实现，并且在这些实现中调用函数类型参数，
* 此时再将高阶函数声明成内联函数，就一定会提示错误
* 因为内联函数所引用的Lambda表达式允许使用return关键字进行外层调用函数返回,而在高阶函数内部创建的匿名类是不允许的
* */
//crossinline可修正这一错误,crossinline关键字保证在内联函数的Lambda表达式中一定不会使用return关键字
//但是可以使用return@的写法进行局部返回(例如return@runRunnable)
inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}

fun main() {

    println("测试内联函数的返回")
    println("main start")
    val str = ""
    printString_inline(str) { s ->
        println("lambda start")
        if (s.isEmpty()) return
        println(s)
        println("lambda end")
    }
    println("main end")


/*    println("测试非内联函数的返回")
    println("main start")
    val str = ""
    printString(str) { s ->
        println("lambda start")
        if (s.isEmpty()) return@printString
        println(s)
        println("lambda end")
    }
    println("main end")*/

/*    val result =  num1AndNum2_inline(100,80){ n1, n2 ->
        n1 - n2
    }
    println("result is $result")*/
}