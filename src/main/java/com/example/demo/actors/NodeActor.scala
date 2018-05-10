package com.example.demo.actors

import akka.actor.{Actor, Props}
import com.example.demo.MyMsg

object NodeActor {
  def props(): Props = Props(new NodeActor)
}

class NodeActor extends Actor {
  override def receive: Receive = {
    case MyMsg(i) => {
      println(s"$self: $i")
      Thread.sleep(700)
    }

    case _ => println("unknown")
  }
}