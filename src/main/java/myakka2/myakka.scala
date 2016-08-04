package myakka2

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive

object myakka extends App {

    //给actor构造参数传递值
    val actorSystem = ActorSystem("myakka")

    val props = Props(classOf[ConstructorAkka], 5)
    val constructorAkka = actorSystem.actorOf(props)

    val res = constructorAkka ! 5
    val res2 = constructorAkka ! "should have a return value"

    println(res) //print () 并没有返回？？？？？
    println(res2)  //也没有返回值

    //TODO Exception no matching constructor found on class myakka2.ValueActor for arguments [class myakka2.MyValueClass]
//    val prop1=Props(classOf[ValueActor],MyValueClass(5))
//    val valueActor=actorSystem.actorOf(prop1)
//    val res3: Unit = valueActor ! 5
//    println(res3)

    //使用 ActorSystem 创建的是 top level actor
    val firstActor =actorSystem.actorOf(Props[FirstActor])

    actorSystem.terminate()


}


class ConstructorAkka(v: Int) extends Actor {
    override def receive: Receive = {

        case x: Int => println(x + v)
        case y: String => sender() ! "If you want to get return value, please have a view to me,your message is " + y
        case _ =>

    }
}



case class MyValueClass(v : Int) extends AnyVal

class ValueActor(myValueClass: MyValueClass) extends Actor{
    override def receive: Receive = {
        case y :Long => sender() !  (myValueClass.v * y)
    }
}

class FirstActor extends Actor{

    val child=context.actorOf(Props(classOf[MyValueClass],123)) //使用context建立的是子actor

    override def receive: Receive = {

        case _ =>


    }
}