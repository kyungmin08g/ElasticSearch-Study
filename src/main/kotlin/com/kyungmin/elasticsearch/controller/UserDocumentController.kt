package com.kyungmin.elasticsearch.controller

import com.kyungmin.elasticsearch.controller.request.CreateUserRequest
import com.kyungmin.elasticsearch.controller.request.UpdateUserRequest
import com.kyungmin.elasticsearch.controller.response.UserDocumentResponse
import com.kyungmin.elasticsearch.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/document/user")
class UserDocumentController(
  private val userService: UserService
) {

  @PostMapping("/create")
  fun createUser(
    @RequestBody request: CreateUserRequest
  ): ResponseEntity<Unit> {
    userService.createUser(request)

    return ResponseEntity.status(HttpStatus.CREATED).build()
  }

  @GetMapping("/{id}")
  fun getUser(
    @PathVariable("id") id: String
  ): ResponseEntity<UserDocumentResponse> {
    return ResponseEntity.ok().body(userService.getUser(id))
  }

  @GetMapping("/list")
  fun getUserList(): ResponseEntity<List<UserDocumentResponse>> {
    return ResponseEntity.ok(userService.getUserList())
  }

  @PutMapping("/update/{id}")
  fun updateUser(
    @PathVariable("id") id: String,
    @RequestBody request: UpdateUserRequest
  ): ResponseEntity<Unit> {
    userService.updateUser(id, request)

    return ResponseEntity.ok().build()
  }

  @DeleteMapping("/delete/{id}")
  fun deleteUser(
    @PathVariable("id") id: String
  ): ResponseEntity<Unit> {
    userService.deleteUser(id)

    return ResponseEntity.ok().build()
  }
}