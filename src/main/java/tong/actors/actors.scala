package tong.actors

import scala.actors.Actor
import scala.actors.Actor._


object actors extends App {

    //开始 actor
    //    SillyActors.start()
    //    SillyActors2.start()


    EchoActor.start()
    EchoActor ! "Hi!"
    EchoActor ! 5

    EchoActor2.start()

    NameResolver.start()
    NameResolver ! "123456"
    NameResolver ! 123456

    NameResolver2.start()
    NameResolver2 ! "123456"
    NameResolver2 ! 123456

}


object SillyActors extends Actor {
    override def act(): Unit = {
        for (i <- 1 to 5) {
            println("I am sleeping!")
            Thread.sleep(10)
        }
    }
}

object SillyActors2 extends Actor {
    override def act(): Unit = {
        for (i <- 1 to 5) {
            println("To be or not to be!")
            Thread.sleep(10)
        }
    }
}

object EchoActor extends Actor {
    override def act(): Unit = {
        while (true) {
            //永远等下去 receive阻塞
            receive {
                case msg: Int => println("Double is: " + msg * 2)
                case msg => println("Receiving msg:" + msg)
            }
        }
    }
}

object EchoActor2 extends Actor {
    override def act(): Unit = {
        //设置了超时时间
        receiveWithin(1000) {
            case msg: Int => println("Double is: " + msg * 2)
            case msg => println("Receiving msg:" + msg)
        }
        println("over")
    }
}

//当使用react时 可以重用线程，性能优化
object NameResolver extends Actor {
    override def act(): Unit = {

        react {
            case msg: Int =>
                println("Double is: " + msg * 2)
                act()
            case msg =>
                println("Receiving msg:" + msg)
                act()
        }

    }
}

//上面的升级版
object NameResolver2 extends Actor {
    override def act(): Unit = {
        loop {
            react {
                case msg: Int =>
                    println("NameResolver2 Double is: " + msg * 2)
                case msg =>
                    println("NameResolver2 Receiving msg:" + msg)
            }
        }
    }
}


