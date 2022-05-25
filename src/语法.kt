import java.lang.Integer.max

//Kotlin的4种修饰符，分别是public、private、protected和internal

fun main() {
//    println("Hello Kotlin")
    val a = 10 //常量
    println("a=" + a)
    var b: Int = 10  //变量,以及显式声明类型
    b = b * 10
    println("b=" + b)

    println("larger number is " + largerNum(a, b))


    println(getScore("Lily"))
    println(getScore2("CJ"))

    checkNum(13.5)
    checkNum(16L)

    testForIn()
}

fun largerNum(num1: Int, num2: Int): Int {
    return max(num1, num2)
}

fun largerNum2(num1: Int, num2: Int): Int = max(num1, num2) //省略花括号
fun largerNum3(num1: Int, num2: Int) = max(num1, num2)  //省略返回值,自动推导

//if语句的返回值(Java写法仍被允许)
fun largerNum4(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}

//更精简
fun largerNum5(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

//switch的替代:when
//精确匹配
fun getScore(name: String) = when (name) {
    "Tom" -> 86 //只有一句执行逻辑时无需花括号
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}

//类型匹配
fun checkNum(num: Number) {
    when (num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}

//不传参
fun getScore2(name: String) = when {
    name == "Tom" -> 86     //字符串相等无需equals()直接==
    name.startsWith(("C")) -> 75    //无参时可执行此类逻辑
    name == "Jim" -> 77
    else -> 0
}

//while语句与Java相同
fun testWhile(){
    var times = 5
    while (times!=0){
        times--
        println("while一次")
    }
}

//替代for循环的for-in循环
fun testForIn(){
    for (i in 0..10){ //创建两端闭合的区间
        println(i)
    }
    for (i in 0 until 10 step 2){   //创建左闭右开的区间并指定步长
        println(i)
    }
    for (i in 10 downTo 1 step 2){ //创建两端闭合降序的区间并指定步长
        println(i)
    }
}