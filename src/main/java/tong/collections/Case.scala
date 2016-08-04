package tong.collections

/**
  * Created by Tong on 2015/12/31.
  */
object Case {
  //组合函数
  def f(s: String) = "f(" + s + ")"

  def g(s: String) = "g(" + s + ")"

  //compose 组合其他函数形成一个新的函数 f(g(x))
  val fComposeG = f _ compose g _

  def main(args: Array[String]) {
    println(fComposeG("yay"))
  }

}
