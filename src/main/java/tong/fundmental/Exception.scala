package tong.fundmental

/**
  * Created by Tong on 2015/12/30.
  */
object Exception {
  def main(args: Array[String]) {

    try {
      1 / 0
    } catch {
      case e:ArithmeticException => println(e)
    } finally {
      1
    }

    //try也是面向表达式的
    val result: Int = try {
      1 / 0
    } catch {
      case e:ArithmeticException => 0
    } finally {
      1
    }
    println(result)
  }
}
