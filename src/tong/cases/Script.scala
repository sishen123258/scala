package tong.cases



abstract class Expr

case class Var(name:String) extends Expr


object script3 extends App{

    val v=new Var("123")

    println(v)

}




