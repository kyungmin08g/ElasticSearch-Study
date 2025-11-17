package com.kyungmin.elasticsearch.controller.request

data class UpdateUserRequest(
  val name: String,
  val age: Int,
  val isActive: Boolean
)