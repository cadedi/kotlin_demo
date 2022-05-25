package edu.gdut

//:表示继承,后缀主构造函数调用的父类构造函数
/*class Student():Person(){
    var sno = ""
    var grade = 0
}*/

//主构造函数无函数体,写在类名后
//传给父类构造函数的参数不加var或val
class Student(val sno: String, val grade: Int, name: String, age: Int) :
    Person(name, age), Study {  //实现接口
    //主构造函数的逻辑
    init {
        println("sno is " + sno)
        println("grade is " + grade)
    }


    //次构造函数可以有多个,但必须直接或间接调用主构造函数或父类构造函数(无主构造函数时)
    constructor(name: String, age: Int) : this("", 0, name, age) {

    }

    constructor() : this("", 0) {

    }

    override fun readBooks() {
        println(name + " is reading.")
    }

/*    override fun doHomework() {
        println(name + "is doing homework.")
    }*/

    //伴生类,可在其中定义静态成员
    companion object {
        //该注解可使得编译成真正的静态成员供Java调用
        //@JvmStatic
        fun goToSchool(){
            println("类似静态方法,上学咯")
        }
    }
}


//无主构造函数(因此亦无需调用父类构造函数)
/*
class Student : person {
    //调用父类构造函数
    constructor(name: String, age: Int) : super(name, age) {

    }
}*/
