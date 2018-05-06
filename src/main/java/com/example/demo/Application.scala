package com.example.demo

import akka.actor.ActorSystem
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

  if (config.getString("akka.remote.netty.tcp.port") == "2555") {

    // your ip address here (sorry)
    // note you need to change ip address in application.conf, too
    //val router = system.actorSelection("akka.tcp://hyperscluster@127.0.0.1:2551/user/routeractor")

  }
}