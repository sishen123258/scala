package akka.actor.path

import akka.actor.Actor
import akka.actor.Actor.Receive

class Counter extends Actor {

    import Counter._

    var counter = 0

    println(getClass.getName)


    override def receive: Receive = {

        case Inc(x) => counter += x
        case Dec(x) => counter -= x
    }

}

object Counter {

    case class Inc(x: Int)

    case class Dec(x: Int)

}
