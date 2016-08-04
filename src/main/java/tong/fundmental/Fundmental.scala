package tong.fundmental

/**
  * apply 语法糖
  * 当类或对象有一个主要用途的时候，apply方法为你提供了一个很好的语法糖。
  */
class Foundation {
  def apply()=0
}


class Bar{

}

object BarMaker{
  def apply()=new Bar
}

object oo{
  def main(args: Array[String]): Unit = {
    val f=new Foundation
    println(f)
    println(f())

    val b=BarMaker
    println(b)
  }
}