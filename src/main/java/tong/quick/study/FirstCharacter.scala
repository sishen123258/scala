package tong.quick.study

import scala.BigInt
import scala.math._
import scala.runtime.RichInt

object FirstCharacter extends App {

    val res = 3
    val calcRes = pow(3, 2)

    println(res)
    println(sqrt(calcRes) - res)

    val str = "123456789"
    println(str * 3)

    println(10 max 2) //在Predef 中转为 RichInt

    println(pow(2, 1024))

    val bigInt = BigInt(2)
    private val powRes: BigInt = bigInt.pow(10)
    println(powRes)

    //获取string的首尾字符
    println(str(0))
    println(str(str.length - 1))
    println(str.take(2))
    println(str.drop(1))
    println(str.takeRight(1))
    println(str.takeWhile(_ > 3))

    println(character2.signnum(12))


}

object character2 {


    def signnum(x: Any): Int = {
        implicit def toInt(x: Any): Int = x.asInstanceOf[Number].intValue() //类型转化
        x match {
            case x if x > 0 => 1
            case x if x < 0 => -1
            case x if x == 0 => 0
        }

    }
}

