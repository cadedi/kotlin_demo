import kotlinx.coroutines.*

//创建方便管理的协程
fun main() {
    val job = Job()
    //CoroutineScope函数返回CoroutineScope实例
    val scope = CoroutineScope(job)
    scope.launch {
        println("test") //不会执行,协程被取消
    }
    //所有调用CoroutineScope的launch函数所创建的协程，都会被关联在Job对象的作用域下面。
    // 这样只需要调用一次cancel()方法，就可以将同一作用域内的所有协程全部取消
    job.cancel()


    runBlocking {
        //async函数必须在协程作用域当中才能调用，它会创建一个新的子协程并返回一个Deferred对象
        //调用Deferred对象的await()可获取代码块的执行结果
        val result = async {
            5 + 5
        }.await()   //调用await()方法时，如果代码块中的代码还没执行完，那么await()方法会将当前协程阻塞住
        println(result)
    }

    runBlocking {
        val start = System.currentTimeMillis()
        val deferred1 = async {
            delay(1000)
            5 + 5
        }//.await()
        //立即await这两个代码块是串行执行
        val deferred2 = async {
            delay(1000)
            4 + 6
        }//.await()
        //需要结果时才await,两个async函数同时执行,比串行方式节约了一倍时间
        println("result is ${deferred1.await() + deferred2.await()} .")
        val end = System.currentTimeMillis()
        println("cost ${end - start} milliseconds. ")
    }

    //withContext()是一个挂起函数
    //调用withContext()函数之后，会立即执行代码块中的代码，同时将外部协程挂起
    //最后一行的执行结果作为 withContext()函数的返回值返回
    //强制要求我们指定一个线程参数表示线程策略
    //除了coroutineScope函数之外，其他所有的函数(协程作用域构建器)都可以指定线程参数
    runBlocking {
        val result = withContext(Dispatchers.Default) {
            3 + 3
        }
        println(result)
    }

}