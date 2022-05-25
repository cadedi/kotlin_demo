import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //lobalScope.launch函数创建一个协程的作用域
    GlobalScope.launch {
        println("codes run in coroutine scope")
        //delay(1500) 延迟1.5秒(大于主线程阻塞时间),则该作用域代码仍然不能完全执行
        println("codes run in coroutine scope finished")
    }
    //阻塞主线程指定时间,防止主线程在协程运行完毕之前结束
    Thread.sleep(1000)

    //runBlocking函数同样会创建一个协程的作用域
    //但它可以保证在协程作用域内的所有代码和子协程没有全部执行完之前一直阻塞当前**线程**(缺点是性能变差,一般只在测试环境使用)
    runBlocking {
        println("codes run in coroutine scope ")
        delay(1500)
        println("codes run in coroutine scope finished")
    }


    //runBlocking使用launch创建多个协程
    //launch必须在 协程的作用域中才能调用，其次它会在当前协程的作用域下创建子协程(而GlobalScope.launch函数创建的永远是顶层协程)
    //子协程的特点是如果 外层作用域的协程结束了，该作用域下的所有子协程也会一同结束
    runBlocking {
        launch {
            println("launch1")
            delay(1000)
            println("launch1 finished")
        }
        launch {
            println("launch2")
            delay(1000)
            println("launch2 finished")
        }
    }
    /**
     * 打印结果
     * launch1
     * launch2
     * launch1 finished
     * launch2 finished
     */

    val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000){
            launch { println(".") }
        }
    }
    val end = System.currentTimeMillis()
    println("创建100000个协程运行时间")
    println(end - start)      //1秒内可运行完毕
}