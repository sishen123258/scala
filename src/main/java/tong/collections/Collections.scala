package tong.collections

import tong.fundmental.add

/**
  * Created by Tong on 2015/12/30.
  */
object Collections {

  val list = List(1, 2, 3, 4, 5, 6)
  val set = Set(1, 1, 2, 3, 4, 5)
  val tuple = (1, 2)
  val tuplet = 1->2
  //与样本类不同，元组不能通过名称获取字段，而是使用位置下标来读取对象；而且这个下标基于1，而不是基于0。
  val tuple2 = Tuple2(1, 2)
  val tuple3 = Tuple3

  //映射的值可以是映射甚或是函数。
  val map=Map(1->2)
  val map2=Map(1->add(1,2))

  /**
    * 选项 Option
      Option 是一个表示有可能包含值的容器。
      Option本身是泛型的，并且有两个子类： Some[T] 或 None
      Option基本的接口是这样的：

      trait Option[T] {
        def isDefined: Boolean
        def get: T
        def getOrElse(t: T): T
      }
    *
    */

  def main(args: Array[String]) {
    println(list)
    println(set)
    println(tuple)
    println(tuple._1)
    println(tuple2)
    println(tuple3)
    println(tuplet)
    println(map)
    println(map2)

    //由于map中并不存在，因此返回的是一个Option
    println(map.get(2))
    println(map.get(2).isDefined)
    println(map.get(2).isEmpty)

    val result = map.get(2) match {
      case Some(n) => n * 2
      case None => 0
    }

    println(result)
  }

  /*
  元组可以很好得与模式匹配相结合
  hostPort match {
    case ("localhost", port) => ...
    case (host, port) => ...
  }
  * */
}
