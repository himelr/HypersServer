package com.example.demo.controllers

import java.lang.Iterable

import com.example.demo.entity.User
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation._
import org.springframework.http.HttpStatus
import org.springframework.http.HttpHeaders

@RestController
@RequestMapping(path = Array("/api"))
//@Autowired private val userService: UserService,
class UserController(@Autowired private val userRepository: UserRepository) {

  @GetMapping(path = Array("/users"))
  @ResponseBody def getAllUsers: Iterable[User] = {
    userRepository.findAll()
  }
  
  @GetMapping(path = Array("/users/{id}"))
  def getUser(@PathVariable id: Long): User = {
/*    val user = userRepository.findById(id)
    user.get()*/

    userRepository.findById(id).get()

    }


  @GetMapping(path = Array("/error"))
  def index2(): String = {
    "error"
  }

  @PostMapping(path = Array("/users"))
  def createUser(@RequestBody users: User): ResponseEntity[User] = {
    val id = userRepository.save(users)
    new ResponseEntity(id, new HttpHeaders, HttpStatus.CREATED)
  }

}