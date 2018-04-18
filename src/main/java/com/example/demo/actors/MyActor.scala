package com.example.demo.actors

import akka.actor.{Actor, ActorLogging}


object MyActor {
  case class Greeting(from: String)
  case object Goodbye
}
class MyActor extends Actor with ActorLogging {
  import MyActor._
  def receive = {
    case Greeting(greeter) ⇒ sender() ! "Greetings " + greeter
    case Goodbye           ⇒ sender() ! "Goodbye"
  }
}