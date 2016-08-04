package extend

//这个引用了工厂对象的element方法
import Element.element

//定义工厂对象
abstract class Element {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

//  def above(that: Element): Element = new ArrayElement(this.contents ++ that.contents)
  def above(that: Element): Element = element(this.contents ++ that.contents)

  def beside(that: Element) = element(
    for ((line1, line2) <- that.contents zip this.contents) yield line1 + line2
  )

  override def toString = contents mkString "\n"

}

//定义工厂方法
object Element {

  def element(contents: Array[String]): Element = new ArrayElement(contents)

  def element(str:String):Element=new LineElement(str)

}