package com.example.demo.actors

import akka.actor.{Actor, ActorRef, Props}
import akka.cluster.pubsub.DistributedPubSub
import akka.cluster.pubsub.DistributedPubSubMediator.Publish

object PublishActor {
  def props(): Props = Props(new PublishActor)

  case class GetBook()

}

class PublishActor extends Actor {
  val mediator: ActorRef = DistributedPubSub(context.system).mediator
  var controller: ActorRef = _

  def receive = {
    case result: Array[String] => controller ! result
    case in: String ⇒ controller = sender(); println("Starting query"); mediator ! Publish("content", Tuple2(6, 6L))
  }

}
