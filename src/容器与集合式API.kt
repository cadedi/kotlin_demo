import kotlin.concurrent.thread

fun main() {
    //创建一个不可变的List
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    for (fruit in list) {
        println(fruit)
    }
    //创建一个可变的List
    val list2 = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
    list2.add("Watermelon")
    for (fruit in list2) {
        println(fruit)
    }
    //Set
    val set = setOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val set2 = mutableSetOf("Apple", "Banana", "Orange", "Pear", "Grape")

    //创建map
    val map = HashMap<String, Int>()
    map.put("Apple", 1)//Java式,不推荐
    map["Pear"] = 4 //推荐
    val num = map["Apple"]
    println("Apple is " + num)
    //键值对组合初始化map,infix函数to关联键值对
    val map2 = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    for ((fruit, num) in map2) {
        println("fruit is " + fruit + ",num is " + num)
    }

    //使用集合的函数式API

    //找到集合中最长的字符串
    println("max length fruit is " + list.maxBy { it.length })

    //list.maxBy { it.length }的写法简化过程
    //原始写法
    val lambda = { fruit: String -> fruit.length }
    var maxLengthFruit = list.maxBy(lambda)
    //当Lambda参数是函数的最后一个参数时，可以将Lambda表达式移到函数括号的外面
    maxLengthFruit = list.maxBy() { fruit: String -> fruit.length }
    //Lambda参数是函数的唯一一个参数的话，可以将函数的括号省略
    maxLengthFruit = list.maxBy { fruit: String -> fruit.length }
    //自动推导,简化声明
    maxLengthFruit = list.maxBy { fruit -> fruit.length }
    //当Lambda表达式的参数列表中只有一个参数时，也不必声明参数名，而是可以使用it关键字来代替
    maxLengthFruit = list.maxBy { it.length }

    //函数式API: map函数
    val list3 = list.map {it.toUpperCase()}
    for(fruit in list3){
        println(fruit)
    }

    //函数式API: filter函数
    val list4 = list.filter { it.length <=5 }.map { it.toUpperCase() }
    for(fruit in list4){
        println(fruit)
    }

    //函数式API: any和all函数
    val anyRes = list.any { it.length <= 5 }
    val allRes = list.all { it.length <= 5 }
    println("anyResult is " + anyRes + ", allResult is " + allRes)

    //Kotlin调用Java API时,匿名类使用object声明(Java使用new关键字创建匿名类实例)
    Thread(object:Runnable{
        override fun run() {
            println("Thread is running")
        }
    }).start()
    //Thread类接收一个Java单抽象方法接口参数,因此可使用函数式API精简语法
    Thread(Runnable { println("Thread is running") }).start()
    Thread({ println("Thread is running")}).start()
    thread { println("Thread is running") }.start()
}

