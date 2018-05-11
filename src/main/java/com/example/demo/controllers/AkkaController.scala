package com.example.demo.controllers

import java.util
import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import com.example.demo.MyMsg
import com.example.demo.actors.PublishActor
import com.example.demo.entity.Page
import org.springframework.web.bind.annotation._

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Await
import scala.language.postfixOps

@CrossOrigin(origins = Array("http://localhost:4200", "http://localhost:8080", "https://hypers-server.herokuapp.com"))
@RestController
@RequestMapping(path = Array("/api/akka"))
class AkkaController {
  val system = ActorSystem("hyperscluster")

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
    responseList.toArray
  }


  @GetMapping(path = Array("/response/test"))
  def getActorResponse2: String = {
    val router = system.actorSelection("akka.tcp://hyperscluster@127.0.0.1:2554/user/routeractor")

    (1 to 50).foreach(f = (i) => {
      router ! MyMsg(i)
      Thread.sleep(500)
    })

    Thread.sleep(5000)
    "work"
  }

  @GetMapping(path = Array("/get/book"))
  @ResponseBody def getActorResponse3: java.util.ArrayList[Page] = {
    implicit val timeout = Timeout(8L, TimeUnit.SECONDS)
    val pubber = system.actorOf(PublishActor.props())
    //pubber ! "start"
    val future = pubber ? "start"
    val result: Array[String] = Await.result(future, timeout.duration).asInstanceOf[Array[String]]
    var count = 0
    val pages = new util.ArrayList[Page]()
    result.foreach(page => {
      count += 1;
      pages.add(new Page(page, null, count))
    })
    pages
  }

}

