package com.example.demo.repositories

import com.example.demo.entity.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait BookRepository extends CrudRepository[Book, Long] {

}
