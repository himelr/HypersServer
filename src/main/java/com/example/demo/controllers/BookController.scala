package com.example.demo.controllers

import java.lang.Iterable

import com.example.demo.entity.{Book, Page}
import com.example.demo.repositories.BookRepository
import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, ResponseBody, RestController}

@RestController
@RequestMapping(path = Array("/api/book"))
class BookController(@Autowired private val bookRepository: BookRepository) {

  @Transactional
  @GetMapping(path = Array("/create"))
  def createBook(): String = {

    val book = new Book("Hype book")
    book.pages.add(new Page("hello", book, 1))
    book.pages.add(new Page("bajs", book, 2))
    book.pages.add(new Page("fsdfsdfsdfsfsdfsdfsfsdfds", book, 3))
    book.numberOfPages = book.pages.size()

    val book2 = new Book("Pog book")
    book2.pages.add(new Page("monkey", book2, 1))
    book2.pages.add(new Page("Chicken", book2, 2))
    book2.pages.add(new Page("asddadasd", book2, 3))
    book2.pages.add(new Page("jhgfjghjhgjghj", book2, 4))
    book2.pages.add(new Page("123124", book2, 5))
    book2.pages.add(new Page("dsds", book2, 6))
    book2.numberOfPages = book2.pages.size()

    bookRepository.save(book)
    bookRepository.save(book2)

    "saved"
  }

  @GetMapping(path = Array("/all"))
  @ResponseBody def getAll: Iterable[Book] = {

    bookRepository.findAll()

  }
}
