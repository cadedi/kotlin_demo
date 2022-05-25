import edu.gdut.Money
import edu.gdut.lettersCount

fun main() {
    //使用自定义在String类上的的扩展函数(建议定义在与指定类同名的顶层文件中)
    val count = "ABC123xyz!@#".lettersCount()
    println(count)

    //测试运算符重载(重载运算符实际调用的是相应的函数,添加扩展函数时也可以添加重载运算符的函数)
    val m1 = Money(5)
    val m2 = Money(10)
    val m3 = m1 + m2
    val m4 = m3 + 20
    print(m4.value)
}
