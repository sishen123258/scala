package tong.traits

import scala.collection.mutable.ArrayBuffer


//没有特质的情况下

case class Point(x: Int, y: Int)

class Rectangle(topLeft: Point, bottomRight: Point) {

    def width = bottomRight.x - topLeft.x

    def height = topLeft.y - bottomRight.y

    def area = this.height * this.width


}

//二维图的工具类 此时代码 width和height和上面的重复
abstract class Component(topLeft: Point, bottomRight: Point) {

    def width = bottomRight.x - topLeft.x

    def height = topLeft.y - bottomRight.y

}

//使用trait减少这种重复
trait Rectangular {

    val topLeft: Point

    def bottomRight: Point

    def width = bottomRight.x - topLeft.x

    def height = topLeft.y - bottomRight.y

}

//特质版
class Rectangle2(val topLeft: Point, val bottomRight: Point) extends Rectangular {


}


//ordered trait 实现compare方法，则自动帮我们实现 >= <=
class Line(x: Point, y: Point) extends Ordered[Line] {

    def lineLength: Int = Math.sqrt(Math.pow(x.x - y.x, 2) + Math.pow(y.y - x.y, 2)).toInt //double to int

    override def compare(that: Line): Int = this.lineLength - that.lineLength


}

/*
* 为类提供可堆叠的改变
*
* 1，队列的内容double
* 2，队列的内容 increment
* 3，队列的内容 filter掉负数
*
*/


abstract class IntQueue {

    def put(x: Int)

    def get(): Int
}

class BaseIntQueue extends IntQueue {

    private val buf = new ArrayBuffer[Int]

    override def put(x: Int): Unit = buf.append(x)

    override def get(): Int = buf.remove(0)

}


//究竟是用特质还是抽象类，要看实现的行为，如果行为会被多个不想关的类重用，那么，就使用trait

//对于特质来说，方法调用是由类和被混入类中的特质的线性化顺序决定的
trait Doubling extends IntQueue {
    abstract override def put(x: Int): Unit = {
        super.put(2 * x)
    }
}

trait Increment extends IntQueue{
    abstract override def put(x: Int): Unit = {
        super.put(x+1)
    }
}

trait Filter extends IntQueue{
    abstract override def put(x: Int): Unit = {
        if(x>0){
            super.put(x)
        }
    }
}



//scala 里的静态变量
class TestStatic{

    import TestStatic.url

    def getUrl():String={
        return url
    }

}

object TestStatic{

    val url="www.tong.com"

}




object script2 extends App {
    val p1 = Point(1, 2)
    val p2 = Point(2, 1)
    val r = new Rectangle2(p1, p2)
    println(r.height)

    val line1 = new Line(p1, p2)
    val line2 = new Line(p2, p1)

    println(line1 == line2)
    println(line1 <= line2)
    println(line1 >= line2)

    val intQueue = new BaseIntQueue
    intQueue.put(1)
    println(intQueue.get())

    val intQueue2=new BaseIntQueue with Increment with Doubling  //从右往左调用put

    intQueue2.put(2)
    println(intQueue2.get()) //5

    val testStatic=new TestStatic
    println(testStatic.getUrl())

}
