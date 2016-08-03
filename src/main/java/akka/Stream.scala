package akka

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}

import scala.collection.immutable
import scala.util.Random


object Stream extends App {

    implicit val actorSystem = ActorSystem()

    //没有这一句会报错
    import actorSystem.dispatcher

    implicit val actorMaterializer = ActorMaterializer()

    val input = Source(1 to 100)

    val flow = Flow[Int].map(_ * 2)

    val sink = Sink.foreach(println)

    input.via(flow).runWith(sink).andThen {

        case _ => {

            actorSystem.shutdown()
            actorSystem.awaitTermination()

        }
    }
}
