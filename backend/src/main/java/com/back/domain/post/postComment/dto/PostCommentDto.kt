package com.back.domain.post.postComment.dto

import com.back.domain.post.postComment.entity.PostComment
import java.time.LocalDateTime

class PostCommentDto(
    val id: Int,
    val createDate: LocalDateTime,
    val modifyDate: LocalDateTime,
    val authorId: Int,
    val authorName: String,
    val postId: Int,
    val content: String?
) {
    constructor(postComment: PostComment) : this(
        id = postComment.id,
        createDate = postComment.createDate,
        modifyDate = postComment.modifyDate,
        authorId = postComment.author.id,
        authorName = postComment.author.name,
        postId = postComment.post.id,
        content = postComment.content
    )
}

// val postCommentDto = PostCommentDto(id = 1, createDate = LocalDateTime.now(), modifyDate = LocalDateTime.now(), authorId = 1, authorName = "Author", postId = 1, content = "This is a comment.")
// val postCommentDto2 = PostCommentDto(postComment)

// 코틀린에서는 Lombok으로 만든 getter/setter를 접근할수 없다.