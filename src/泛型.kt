class MyClass<T>{
    fun method(param:T):T{
        return param
    }
    //泛型方法
    fun <V> gpMethod(param:V):V{
        return param
    }
    //泛型上界
    fun <N:Number> gpMethod2(param: N):N{
        return param
    }
    //泛型的上界默认是Any?,可为空,手动设置为Any则不可为空
    fun <V:Any> gpMethod3(param: V):V{
        return param
    }


}
val myClass = MyClass<Int>()
val result = myClass.method(123)
val gpFunResult = myClass.gpMethod<String>("hello")
//泛型方法可以自动推导
val gpFunResult1 = myClass.gpMethod("hello")
val gpFunResult2 = myClass.gpMethod2(123)
//保证类型不可为空
//val gpFunResult3 = myClass.gpMethod3(null)

//build函数定义成泛型函数,使得任何类可用
fun <T> T.build(block:T.() -> Unit):T{
    block()
    return this
}

//泛型实化(解决泛型 类型擦除的问题)
inline fun <reified T> getGenericType() = T::class.java





fun main() {
    val result1 = getGenericType<String>()
    val result2  = getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")
}