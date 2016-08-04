package tong.fundmental

/**
  * Created by Tong on 2015/12/28.
  */
class First(name: String) {
  def add_func(m: Int): Int = m + 1

  //  如果函数没有参数，调用的时候可以不写括号
  def three() = 1 + 2

  //  匿名函数
  val res = (x: Int) => x + 1

  //部分应用,使用下划线“_”部分应用一个函数，
  // 结果将得到另一个函数.Scala使用下划线表示不同上下文中的不同事物，
  // 你通常可以把它看作是一个没有命名的神奇通配符。在{ _ + 2 }的上下文中，它代表一个匿名参数
  def adder(m: Int, n: Int): Int =
    return m + n

  //只要是3和某个数相加，就可以使用add2（XXX）
  val add2 = adder(3, _: Int)

  //柯里化函数,允许别人一会在你的函数上应用一些参数，然后又应用另外的一些参数。
  def multiply(m: Int)(n: Int): Int = m * n

  //可变长度参数
  def capitalizeAll(s: String*) = {
    s.map(x => x.capitalize)
  }


  //类
  //成员变量
  //可以写在类名旁边
  //  var name:String

  //构造函数,在创建类的时候做一些初始化的操作
  val sex: String = {
    if (name.equals("TONG")) {
      "MALE"
    } else {
      "FEMALE"
    }
  }

}

//继承
class Son(s: String) extends First(s) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

//覆盖方法
class SonSon(s: String) extends Son(s) {
  override def log(m: Double, base: Double) = math.log(base) / math.log(m)
}

//抽象类
abstract class Shape {
  def getArea(): Double
}

class Circle(r: Double) extends Shape {
  override def getArea(): Double = {
    scala.math.Pi * r * r
  }
}



object main2 {
  def main(args: Array[String]) {
    val f = new First("YUE")
    println(f.three())
    println(f.three)
    println(f.add_func(1))

    println(f.res(1))

    println(f.add2)
    //<function1>
    println(f.add2(3))

    println(f.multiply(2)(3))

    val x: (Int) => Int = f.multiply(2) _
    println(x)
    //<function1>
    println(x(3))

    println(f.capitalizeAll("tong", "yue"))
    //ArrayBuffer(Tong, Yue)

    val f2 = new First("TONG")
    println(f2.sex)

    val son = new Son("XIAO")
    println(son.log(22, 5))

    val ss = new SonSon("DANG")
    println(ss.log(22, 5))

    val c=new Circle(3)
    println(c.getArea())

    println(addone(3))
  }
}




