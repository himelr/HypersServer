package com.example.demo.entity

import javax.persistence._

import scala.beans.BeanProperty

@Entity
class User(){

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @Column(name = "username")
  var username: String = _

  @BeanProperty
  @Column(name = "password")
  var password: String = _

  def this (userName:String, password:String){
    this
    this.username = userName
    this.password = password
  }


}
