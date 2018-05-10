package com.example.demo.controllers

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorSystem, Props}
import akka.cluster.routing.{ClusterRouterPool, ClusterRouterPoolSettings}
import akka.routing.RoundRobinPool
import akka.util.Timeout
import com.example.demo.MyMsg
import com.example.demo.actors.{NodeActor, PublishActor}
import org.springframework.web.bind.annotation._

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Await
import scala.language.postfixOps

@CrossOrigin(origins = Array("http://localhost:4200", "http://localhost:8080", "https://hypers-server.herokuapp.com"))
@RestController
@RequestMapping(path = Array("/api"))
class AkkaController {
  val system = ActorSystem("hyperscluster")
  println(s"now creating a router towards node actors")
  val router = system.actorOf(ClusterRouterPool(
    local = RoundRobinPool(8),
    settings = ClusterRouterPoolSettings(
      totalInstances = 15,
      maxInstancesPerNode = 4,
      allowLocalRoutees = false
    )
  ).props(Props[NodeActor]),
    name = "routeractor")
  println(s"router: ${router.path}")

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

  @GetMapping(path = Array("/response/test2"))
  def getActorResponse3: String = {
    implicit val timeout = Timeout(5L, TimeUnit.SECONDS)
    val pubber = system.actorOf(PublishActor.props())
    val future = pubber ? "start"
    val result = Await.result(future, timeout.duration).asInstanceOf[String]
    ""
  }

}

