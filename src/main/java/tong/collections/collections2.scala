package tong.collections

import scala.collection.mutable.Queue
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object script4 extends App {

    //构造列表
    val list = 1 :: 2 :: 3 :: 4 :: Nil
    println(list)
    println(list.head)
    println(list.headOption)
    println(list.tail)
    println(list.tails)
    println(list.init)
    println(list.inits)
    println(list.last)
    println(list.isEmpty)
    println(list.reverse)

    val list2 = 5 :: 6 :: 7 :: 8 :: Nil
    println(list ::: list2)
    //:::链接两个列表

    //list vs listbuffer
    //list 类提供了对列表头的快速访问，因此当需要向列表尾部添加元素的时候，需要在列表头添加然后翻转
    //另外也可以使用list buffer
    val listBuffer = new ListBuffer[Int]
    for (i <- 0 to 100) {
        i % 2 match {
            case 0 => listBuffer += i
            case 1 => listBuffer.insert(0, i)
        }
    }
    println(listBuffer.toList)

    //数组缓存
    val array = Array(1, 2, 3, 4, 5)
    println(array.length)

    val arrayBuffer = new ArrayBuffer[Int]()
    for (i <- 0 to 100) {
        i % 2 match {
            case 0 => arrayBuffer += i
            case 1 => arrayBuffer.insert(0, i)
        }
    }
    println(arrayBuffer)

    //queue 可变和不可变queue

    val queue = Queue(1, 2, 3, 4, 5)
    println(queue)



}

class Queue[T]{



}