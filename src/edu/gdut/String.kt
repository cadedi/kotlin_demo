package edu.gdut


//定义一个统计字符串字母数量的**扩展函数**添加到String类中
//扩展函数拥有this
fun String.lettersCount():Int{
    var count = 0
    for(char in this) {
        if(char.isLetter()){
            count++
        }
    }
    return count
}

//添加重载运算符*的扩展函数
/*operator fun String.times(n:Int):String {
    val builder = StringBuilder()
    repeat(n) {
        builder.append(this)
    }
    return builder.toString()
}*/

//调用String自带的repeat方法,更精简
operator fun String.times(n: Int) = repeat(n)