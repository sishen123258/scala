package tong.clazz

/**
  * Created by Tong on 2016/7/29.
  */
object script extends App{

    def isEqual(x:Int ,y:Int)=x==y

    println(isEqual(1,1))

    //scala 判断引用相等
    val x=new String("abc")
    val y=new String("abc")

    println( x eq y )

    //scala 里面== 和 equals是相同的

    //NUll 是null的引用 Nothing 是任何其他类型的子类型 标明了不正常的终止
    def error(message:String) : Nothing = throw new RuntimeException

    def divide(x:Int,y:Int):Int=
        if (y!=0) x/y
        else error("y can not be 0")

    //当y为0时，返回nothing nothing也是Int的子类型 类型统一



}
