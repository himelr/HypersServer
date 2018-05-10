package com.example.demo.actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import akka.cluster.pubsub.DistributedPubSub
import akka.cluster.pubsub.DistributedPubSubMediator.Subscribe

object SubscribeActor {
  def props(): Props = Props(new SubscribeActor)
}

class SubscribeActor extends Actor with ActorLogging {
  val mediator: ActorRef = DistributedPubSub(context.system).mediator

  mediator ! Subscribe("content", self)

  def receive = {
    case s: String ⇒
      log.info("Got {}", s)
    //sender() ! "BWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"

  }

}
