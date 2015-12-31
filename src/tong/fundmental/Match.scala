package tong.fundmental

/**
  * 模式匹配
  * 这是Scala中最有用的部分之一
  */
object Match {
  def main(args: Array[String]) {
    val time = 5
    //匹配值
    time match {
      case 1 => println(time)
      case 2 => println(time)
      //使用守卫进行匹配
      case _ => println("some other number")
    }

    println(bigger(5.5))
    println(bigger(-5.5))
    println(bigger(5))
    println(bigger(-5))
    println(bigger(-1))

    //样本类
    val hp20b = Calculator("hp", "20b")
    val hp20B = Calculator("hp", "20B")

    print(hp20B==hp20b)
    print(calcType(hp20B))
  }

  //匹配类型
  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => -i
      //case i: Int if i < -2 => i+1   -5时并不会到达这里
      case i: Int => i + 1
      case d: Double if d<0.0=> -d
      case d:Double => d + 1
      case _ => o
    }
  }

  /*
  样本类 Case Classes
  使用样本类可以方便得存储和匹配类的内容。你不用new关键字就可以创建它们。

  样本类基于构造函数的参数，自动地实现了相等性和易读的toString方法。
  * */
  case class Calculator(brand: String, model: String)
  //使用样本类进行模式匹配

  def calcType(calc: Calculator) = calc match {
    case Calculator("hp", "20B") => "financial"
    case Calculator("hp", "48G") => "scientific"
    case Calculator("hp", "30B") => "business"
    case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
    //case Calculator(_, _) => "Calculator of unknown type"
    //case _ => "Calculator of unknown type"
  }
}





