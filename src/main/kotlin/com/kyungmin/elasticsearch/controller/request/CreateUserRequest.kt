package com.kyungmin.elasticsearch.controller.request

@JvmRecord
data class CreateUserRequest(
  val name: String,
  val age: Int,
  val isActive: Boolean
)