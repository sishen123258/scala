package extend


/**
  * Created by Tong on 2016/5/22.
  */
object Main {
  def main(args: Array[String]): Unit = {

    val arrayElement=Element.element((Array("123","***")))
    println(arrayElement.height)
    println(arrayElement.width)

    val lineElement=Element.element("s")
    println(lineElement.height)
    println(lineElement.width)



  }
}
