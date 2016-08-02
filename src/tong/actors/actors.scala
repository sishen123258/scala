package tong.actors

import scala.actors.Actor
import scala.actors.Actor._


object actors extends App {

    //开始 actor
//    SillyActors.start()
//    SillyActors2.start()



    EchoActor.start()
    EchoActor ! "Hi!"


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
            receive {
                case msg => println("Receiving msg:" + msg)
            }
        }
    }
}