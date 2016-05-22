package extend

//ArrayElement(Array(s)) 调用了超类的构造方法
private class LineElement(s:String) extends Element{

  val arr=Array(s)
  //若子类成员重写了父类的成员，则必须带上override
  override def height: Int = 1

  override def width: Int = s.length

  override def contents: Array[String] = arr
}
