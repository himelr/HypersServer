package com.example.demo

import akka.actor.{ActorSystem, Props}
import akka.cluster.routing.{ClusterRouterPool, ClusterRouterPoolSettings}
import akka.routing.RoundRobinPool
import com.example.demo.actors.NodeActor
import com.typesafe.config.ConfigFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

case class MyMsg(n: Int)

@SpringBootApplication
class Application

object Application extends App {
  SpringApplication.run(classOf[Application])
  val config = ConfigFactory.load()
  val system = ActorSystem("hyperscluster")

  if (config.getString("akka.remote.netty.tcp.port") == "2551") {
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
  }
}