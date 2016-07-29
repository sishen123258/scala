package tong.traits


//没有特质的情况下

case class Point(x: Int, y: Int)

class Rectangle(topLeft: Point, bottomRight: Point) {

    def width = bottomRight.x - topLeft.x

    def height = topLeft.y - bottomRight.y

    def area = this.height * this.width



}

//二维图的工具类 此时代码 width和height和上面的重复
abstract class Component(topLeft: Point, bottomRight: Point){

    def width = bottomRight.x - topLeft.x

    def height = topLeft.y - bottomRight.y

}

//使用trait减少这种重复
trait Rectangular{

    val topLeft:Point
    def bottomRight:Point

    def width = bottomRight.x - topLeft.x

    def height = topLeft.y - bottomRight.y

}

//特质版
class Rectangle2(val topLeft: Point,val bottomRight: Point) extends Rectangular{


}

object script2 extends App{
    val p1=Point(1,2)
    val p2=Point(2,1)
    val r=new Rectangle2(p1,p2)
    println(r.height)

}


