import edu.gdut.*

fun main() {
    val p = Person("Jack",10)    //实例化类
//    p.name = "Jack"
//    p.age = 10
    p.eat()

    val s = Student("Jack",20)
    doStudy(s)

    var cp1 = Cellphone("Samsung",1299.9)
    var cp2 = Cellphone("Samsung",1299.9)
    println(cp1)
    println(cp1==cp2)   //相等

    //调用单例类的方式类似静态方法调用,但程序自动创建了该单例类的实例
    Singleton.singletonTest()

}

fun doStudy(study:Study){
    study.readBooks()
    study.doHomework()
}