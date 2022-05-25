import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

class MyThread : Thread() {
    override fun run() {
        //具体逻辑
    }
}

class MyThread2 : Runnable {
    override fun run() {
        //具体逻辑
    }
}

fun main() {
    //开启线程方式1
    MyThread().start()
    //开启线程方式2
    val myThread2 = MyThread2()
    Thread(myThread2).start()
    //开启线程方式3
    Thread {
        //具体逻辑
    }.start()
    //开启线程方式4(Kotlin顶层函数thread)
    thread {
        //具体逻辑
    }

}
