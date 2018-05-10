package com.example.demo.entity


import java.io.Serializable
import java.util

import javax.persistence._

import scala.beans.BeanProperty

@Entity
class Book() extends Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @Column(name = "name")
  var name: String = _

  @BeanProperty
  @OneToMany(fetch = FetchType.EAGER, cascade = Array(CascadeType.ALL), mappedBy = "book")
  var pages: java.util.List[Page] = _

  def this(name: String) {
    this
    this.name = name
    this.pages = new util.ArrayList[Page]()
  }

}
