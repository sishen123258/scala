package akka.actor.path

import akka.actor.{ActorSystem, Props}


object Application extends App{

    val actorSystem=ActorSystem("myActorSystem")

    val counter = actorSystem.actorOf(Props[Counter], "counter")
    val watcher = actorSystem.actorOf(Props[Watcher], "watcher")

    counter ! Counter.Inc(10)
    counter ! Counter.Inc(10)
    Thread.sleep(1000)

    actorSystem.awaitTermination()


}
