package com.kyungmin.elasticsearch.documents

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "users")
data class UserDocument(

  @Id
  val id: String,

  @Field(type = FieldType.Keyword)
  var name: String,

  @Field(type = FieldType.Integer)
  var age: Int,

  @Field(type = FieldType.Boolean)
  var isActive: Boolean
)