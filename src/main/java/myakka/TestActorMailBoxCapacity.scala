package myakka

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive
import akka.event.Logging


object TestActorMailBoxCapacity extends App {

    val actorSystem = ActorSystem("myActorSystem")

    val myActor = actorSystem.actorOf(Props[MyActor], "MyActor")

    for (x <- 1 to 1000000000) {
        x % 2 match {
            case 0 => myActor ! "test"
            case 1 => myActor ! 123
        }

    }

    actorSystem.terminate()


}


class MyActor extends Actor {

    val log = Logging(context.system, this)

    override def receive: Receive = {
        case x: String => log.info("Received " + x)
//        case _ => log.info("It is not string")
    }
}

