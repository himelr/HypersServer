package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

case class MyMsg(n: Int)

@SpringBootApplication
class Application

object Application extends App {
  SpringApplication.run(classOf[Application])

}