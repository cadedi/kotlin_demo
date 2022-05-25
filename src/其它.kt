import edu.gdut.Student
import kotlin.text.StringBuilder

fun main(){
    val brand = "Sansung"
    val price = 1299.99
    val s = Student("Jack",30)
    Student.goToSchool()
    //字符串内嵌表达式$
    println("Cellphone(brand=$brand,price=$price)")
    println("My name is ${s.name}")
    println("${"$"}")   //输出$符本身

    printParams(122)
    //键值对传参
    printParams2(str = "world")

    // 常用标准函数
    // let(判空)
    // with apply run (可相互替换)
    // repeat

    //with函数,指定对象成为lambda表达式的上下文,最后一行作为返回值
    val list = listOf("Apple","Banana","Orange")
    val result = with(StringBuilder()){
        append("Start eating fruits.\n")
        for(fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
    println(result)

    //run函数,类似with,,最后一行作为返回值,但由对象主动调用
    val runResult = StringBuilder().run {
        append("Start eating fruits.\n")
        for(fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
    println(runResult)

    //apply函数类似run,但返回调用对象本身
    val applyResult = StringBuilder().apply {
        append("Start eating fruits.\n")
        for(fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(applyResult.toString())


    //语法糖:infix函数
    if ("Hello Kotlin" beginsWith "Hello") {
        println("调用infix函数beginsWith")
    }
    val list2 = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    if (list has "Banana") {
        println("调用infix函数has")
    }
}
/*
* infix函数是不能定义成顶层函数的，它必须是某个类的成员函数，可以使用扩展函数的方式将它定义到某个类当中；
* 其次，infix函数必须接收且只能接收一个参数
* */
infix fun String.beginsWith(prefix: String) = startsWith(prefix)

infix fun <T> Collection<T>.has(element: T) = contains(element)

//函数的默认值(也可用在类的主构造函数精简次构造函数)
fun printParams(num:Int,str:String = "hello"){
    println("num is $num,str is $str")
}
fun printParams2(num:Int=100,str:String){
    println("num is $num,str is $str")
}

