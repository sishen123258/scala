package tong.collections


/**
  * Created by Tong on 2015/12/30.
  */
object HighLevelFunction {
  private val list = List(1, 2, 3, 4, 5, 6)
  private val z_list = List("a", "b", "c", "d", "e", "f", "g")
  private val map = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)

  def main(args: Array[String]) {
    println(list.map(x => x + 1))
    //也可以传一个部分应用函数
    println(list.map(addone _))
    println()
    //foreach很像map，但没有返回值。foreach仅用于有副作用[side-effects]的函数。
    list.foreach(x => print(x * 2 + ","))
    println()
    //foreach并未改变list的值
    println(list)

    val new_list = list.filter(x => x % 2 == 0)
    println(new_list)

    println(list.zip(z_list))

    //partition将使用给定的谓词函数分割列表。
    println(list.partition(x => x % 2 == 0))

    //find返回集合中第一个匹配谓词函数的元素。
    println(list.find(x => x % 2 == 0))

    //drop 将删除前i个元素
    println(list.drop(2))
    //dropWhile 将删除元素直到找到第一个匹配谓词函数的元素。
    println(list.dropWhile(x => x % 2 == 1))
    //reduce 求和
    println(list.reduce((m, n) => m + n))
    //初始值为1，求list的和
    println(list.foldLeft(1)((m: Int, n: Int) => m + n))
    //和foldLeft一样，只是运行过程相反。
    println(list.foldRight(1)((m: Int, n: Int) => m + n))

    println(list.++(z_list))

    //flatten将嵌套结构扁平化为一个层次的集合。
    println(List(list, new_list).flatten)
    println(List(list, new_list))

    //先映射后扁平化
    println(List(list, new_list).flatMap(m => m.map(n => n * n)))

    println(list.fold(0)((m, n) => m + n))

    println(map)
    //遍历collection使用 <-
    for ((k, v) <- map) {
      println(k+":"+v)
    }


  }

  def addone(i: Int) = {
    i + 1
  }
}
