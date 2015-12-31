package tong.fundmental

/**
  * Created by Tong on 2015/12/29.
  */
object Singleton {

  def main(args: Array[String]) {
    val t=Timer
    println(t.currentCount())

    println(Timer.currentCount())

    val b=Bar2
    println(b.apply("t"))

  }

}


//单例对象
object Timer{
  private var count=0
  def currentCount(): Int ={
    count+=1
    return count
  }
}


class Bar2(s:String){
  var name=s
  def getName(): String ={
    return name
  }


  override def toString = s"Bar2($name)"
}

//单例对象可以和类具有相同的名称，此时该对象也被称为“伴生对象”。
// 我们通常将伴生对象作为工厂使用。
//可以不需要使用’new’来创建一个实例了。
object Bar2{

  def apply(s:String)=new Bar2(s)


  override def toString = s"Bar2()"
}