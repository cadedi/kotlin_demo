import kotlin.reflect.KProperty

//委托模式示例
/*
class MySet<T>(val helperSet: HashSet<T>) : Set<T> {
    override val size: Int
        get() = helperSet.size
    override fun contains(element: T) = helperSet.contains(element)
    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)
    override fun isEmpty() = helperSet.isEmpty()
    override fun iterator() = helperSet.iterator()
}*/


//类委托,kotlin提供简化写法
class MySet<T>(val helperSet:HashSet<T>):Set<T> by helperSet{

    //可单独重写某些方法,其它方法由委托类直接提供
    override fun isEmpty(): Boolean {
        println("嗨呀")
        return helperSet.isEmpty()
    }
    //自定义方法
    fun helloWorld() = println("Hello World")
}

//委托属性
class MyClass4delegate {
    /*
    * 当调用p属性的时候会自动调用Delegate类的getValue()方法，
    * 当给p属性赋值的时候会自动调用Delegate类的setValue()方法。
    * */
    var p by Delegate()
}
class Delegate {
    var propValue:Any? = null
    //固定写法,必须使用operator关键字声明
    operator fun getValue(myClass: MyClass4delegate,prop:KProperty<*>):Any?{
        return propValue
    }
    //如果委托属性p使用val声明则该方法可以不实现
    operator fun setValue(myClass: MyClass4delegate,prop: KProperty<*>,value:Any?){
        propValue = value
    }
}

//Koltin的内置函数lazy的使用就是通过委托实现的
val p by lazy {

}