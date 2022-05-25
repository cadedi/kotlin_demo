import edu.gdut.Student
import edu.gdut.Study

var content:String? = "hello"

fun main() {
    val s = Student("Jack", 30)

    //?操作符保证当对象不为空时正常调用相应的方法，当对象为空时则什么都不做。
    s?.doHomework()


/*    if(content != null){
        content.toUpperCase()
    }*/
    content?.toUpperCase()  //if不能对全局变量判空因为全局变量的值随时都有可能被其他线程所修改，即使做了判空处理，仍然无法保证if语句中的study变量没有空指针风险,必须借助辅助工具
}

//Kotlin方法参数默认不可为空,在编译器就会判断,若要允许参数为空,需在类型后加?
//但Kotlin仍会在编译期检查是否有空指针异常,所以需显式加上空指针判断执行不同的逻辑才可通过编译
fun doStudy(study: Study?) {
/*    if (study != null) {
        study.readBooks()
        study.doHomework()
    }*/
    //借助判空辅助工具 ?
    study?.readBooks()
    study?.doHomework()

    //借助let函数简化写法,let函数将其原始调用对象作为参数传递到Lambda表达式中
    study?.let { stu ->
        stu.readBooks()
        stu.doHomework()
    }
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}

//判空辅助工具 ?: 操作符的左右两边都接收一个表达式，如果左边表达式的结果不为空就返回左边表达式的结果，否则就返回右边表达式的结果
//text为空时text?.length返回null
fun getTextLength(text: String?) = text?.length ?: 0



//判空逻辑在调用函数之前执行,但Kotlin检测到函数中没有判空逻辑就编译不通过
//因此使用非空断言工具 !!
fun printUpperCase(){
    val upperCase = content!!.toUpperCase()
    print(upperCase)
}