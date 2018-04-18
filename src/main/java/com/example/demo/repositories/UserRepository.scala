package com.example.demo.repositories

import org.springframework.stereotype.Repository
import org.springframework.data.repository.CrudRepository
import java.lang.Long

import com.example.demo.entity.User

@Repository
trait UserRepository extends CrudRepository[User, Long] {

  def findUserByUsername(username: String): User

}

