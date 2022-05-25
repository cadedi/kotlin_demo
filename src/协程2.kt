import kotlinx.coroutines.*


//suspend关键字将任意函数声明成挂起函数(挂起函数之间可以互相调用),但不提供协程作用域
//coroutineScope函数提供协程作用域(可调用launch函数等),也是一个挂起函数
//coroutineScope会继承外部的协程的作用域并创建一个子协程
//coroutineScope函数和runBlocking函数类似，它可以保证其作用域内的所有代码和子协程在全部执行完之前，外部的**协程**会一直被挂起
//runBlocking阻塞线程(包括主线程),而coroutineScope阻塞当前协程，既不影响其他协程，也不影响任何线程,故没有性能问题

suspend fun printDot() = coroutineScope{
    launch {
        println(".")
        delay(1000)
    }
}

fun main() {
    runBlocking {
        coroutineScope {
            launch {
                for(i in 1..10){
                    println(i)
                    delay(1000)
                }
            }
        }
        //coroutineScope之后的这行打印语句被挂起,等待子协程执行完毕才会运行
        println("coroutineScope finished")
    }
    println("runBlocking finished")


    //GlobalScope.launch函数和launch函数都会返回Job对象
    val job = GlobalScope.launch {
        println("Hello")    //不会打印,协程被取消
    }
    job.cancel()    //取消协程
}