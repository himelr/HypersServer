package com.example.demo.actors

import akka.actor.{Actor, Props}
import akka.cluster.pubsub.DistributedPubSub
import akka.cluster.pubsub.DistributedPubSubMediator.Publish

object PublishActor {
  def props(): Props = Props(new PublishActor)
}

class PublishActor extends Actor {
  val mediator = DistributedPubSub(context.system).mediator

  def receive = {
    case in: String ⇒ println(in)

  }

  mediator ! Publish("content", "owo")
}
