package edu.gdut

//非抽象类默认都是不可以被继承,使用open关键字允许被继承
/*open class Person {
    var name = ""
    var age = 0

    fun eat() {
        println(name + " is eating.He is " + age + " years old")
    }
}*/

//主构造函数中被var或val修饰的参数自动成为类中字段
open class Person(val name:String,val age:Int) {

    fun eat() {
        println(name + " is eating.He is " + age + " years old")
    }
}

