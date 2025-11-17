package com.kyungmin.elasticsearch.service

import com.kyungmin.elasticsearch.controller.request.CreateUserRequest
import com.kyungmin.elasticsearch.controller.request.UpdateUserRequest
import com.kyungmin.elasticsearch.controller.response.UserDocumentResponse
import com.kyungmin.elasticsearch.documents.UserDocument
import com.kyungmin.elasticsearch.repository.UserDocumentRepository
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
@RequiredArgsConstructor
class UserService(
  private val repo: UserDocumentRepository
) {

  fun createUser(request: CreateUserRequest) {
    val uuid = UUID.randomUUID().toString()
    val document = UserDocument(
      id = uuid,
      name = request.name,
      age = request.age,
      isActive = request.isActive
    )

    repo.save(document)
  }

  fun getUser(id: String): UserDocumentResponse {
    val document: UserDocument = repo.findById(id).orElseThrow {
        Exception("Document with id $id not found")
      }

    return UserDocumentResponse(
      id = document.id,
      name = document.name,
      age = document.age,
      isActive = document.isActive
    )
  }

  fun getUserList(): List<UserDocumentResponse> {
    val pageable: Pageable = PageRequest.of(0, 10)
    val document: Page<UserDocument> = repo.findAll(pageable)

    val userList = ArrayList<UserDocumentResponse>()
    document.forEach {
      userList.add(
        UserDocumentResponse(
          id = it.id,
          name = it.name,
          age = it.age,
          isActive = it.isActive
        )
      )
    }

    return userList
  }

  fun updateUser(id: String, request: UpdateUserRequest) {
    val document: UserDocument = repo.findById(id).orElseThrow {
      Exception("Document with id $id not found")
    }

    document.name = request.name
    document.age = request.age
    document.isActive = request.isActive

    repo.save(document)
  }

  fun deleteUser(id: String) {
    repo.deleteById(id)
  }
}