package com.example.demo.controllers

import java.util.concurrent.TimeUnit

import akka.actor.Actor
import akka.util.Timeout
import org.springframework.web.bind.annotation._

import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps

@CrossOrigin(origins = Array("http://localhost:4200", "http://localhost:8080", "https://hypers-server.herokuapp.com"))
@RestController
@RequestMapping(path = Array("/api"))
class AkkaController {

  //val system = ActorSystem("mySystem")

  @GetMapping(path = Array("/response/{amount}"))
  @ResponseBody def getActorResponse(@PathVariable amount: Int): Array[String] = {

    implicit val timeout = Timeout(5L, TimeUnit.SECONDS)
    val listA = ArrayBuffer.empty[Actor]
    val responseList = ArrayBuffer.empty[String]
    /*
        for (x <- 1 to amount) {
          val myActor = system.actorOf(Props[MyActor], "myactor" + x)
          val future = myActor ? MyActor.Greeting(x.toString)
          val result = Await.result(future, timeout.duration).asInstanceOf[String]
          myActor ! PoisonPill
          responseList += result
        }*/


    return responseList.toArray
  }
}

