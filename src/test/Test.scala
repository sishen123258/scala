package test

/**
  * Created by Tong on 2015/12/29.
  */
object Test {

  def main(args: Array[String]): Unit = {
    val start=System.currentTimeMillis()
    var s=0
    var i=1000000
    while (i>=0) {
//      s=1 + (2 + (3 + (4 + (5 + (6 + (7 + 8))))))
      s=((((((1+2)+3)+4)+5)+6)+7)+8
      i-=1
    }

    val end=System.currentTimeMillis()
    println(end-start)

  }

}
