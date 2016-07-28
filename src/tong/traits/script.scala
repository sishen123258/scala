package tong.traits


/**
  * Created by Tong on 2016/7/29.
  */
trait Philosophical{

    def philosophize(): Unit ={
        println("I am here!")
    }
}


//定义trait后，可以使用extends 或者 with关键字
class Tong extends Philosophical{
    override def philosophize(): Unit = {
        super.philosophize()
        println("Tong is here!")
    }
}

object script extends App{

    val t=new Tong
    t.philosophize()

}