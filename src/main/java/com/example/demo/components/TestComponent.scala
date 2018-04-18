package com.example.demo.components

import akka.actor.{Actor, ActorSystem, Props}
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TestComponent extends CommandLineRunner{


  override def run(strings: String*): Unit = {
    //    val system = ActorSystem("testSystem")
    //val a = system.actorOf(Props[ActorRunner])
    println("ddd ")

  }

  class ActorRunner extends Actor{


   def this (st:String){
      this
        //val actor = context.actorOf(IotSupervisor.props())
    }
    override def receive: Receive = {
      case "s" ⇒
        sender() ! println("d")
    }
  }
  object ActorRunner {
    def props(): Props = Props(new ActorRunner("s"))
  }


}
