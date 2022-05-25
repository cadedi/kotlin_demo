package edu.gdut

interface Study {
    fun readBooks()
    //接口的默认实现
    fun doHomework() {
        println("do homework default implementation")
    }

}