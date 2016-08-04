package tong.fundmental

/**
  * 值和函数不能在类或单例对象之外定义。单例对象是组织静态函数(static function)的有效工具。
  */
object Function {
  def main(args: Array[String]) {
    println(addone(1))
    println(add(1,2))
  }
}

/**
  * Function特质集合下标从0开始一直到22。为什么是22？
  * 这是一个主观的魔幻数字(magic number)。我从来没有使用过多于22个参数的函数，所以这个数字似乎是合理的。
  */
object addone extends Function1[Int,Int]{
  override def apply(v1: Int): Int = v1+1
}

object addtwo extends (Int => Int){
  override def apply(v1: Int): Int = v1+2
}


object add extends Function2[Int,Int,Int]{
  override def apply(v1: Int, v2: Int): Int = v1+v2
}

