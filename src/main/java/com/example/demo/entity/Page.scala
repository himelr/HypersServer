package com.example.demo.entity

import java.io.Serializable

import javax.persistence._

import scala.beans.BeanProperty

@Entity
class Page() extends Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @Column(name = "content", length = 1024)
  var content: String = _

  @BeanProperty
  @Column(name = "number")
  var number: Int = _
  
  @ManyToOne
  @JoinColumn(name = "book_id")
  var book: Book = _

  def this(content: String, book: Book, number: Int) {
    this()
    this.content = content
    this.book = book
    this.number = number
  }
}
