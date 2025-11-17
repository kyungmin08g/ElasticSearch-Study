package com.kyungmin.elasticsearch.controller.response

data class UserDocumentResponse(
  val id: String,
  val name: String,
  val age: Int,
  val isActive: Boolean
)