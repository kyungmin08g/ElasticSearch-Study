package com.kyungmin.elasticsearch.repository

import com.kyungmin.elasticsearch.documents.UserDocument
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface UserDocumentRepository : ElasticsearchRepository<UserDocument, String> {
}