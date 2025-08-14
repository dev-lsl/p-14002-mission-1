package com.back.domain.member.member.dto

import com.back.domain.member.member.entity.Member
import java.time.LocalDateTime


open class MemberDto(
    private val id: Int,
    private val createDate: LocalDateTime,
    private val modifyDate: LocalDateTime,
    private val name: String,
    private val isAdmin: Boolean,
    private val profileImageUrl: String
) {
    constructor(member: Member) : this(
        id = member.id,
        createDate = member.createDate,
        modifyDate = member.modifyDate,
        name = member.name,
        isAdmin = member.isAdmin,
        profileImageUrl = member.profileImgUrlOrDefault
    )
} // spring Doc  -> Swagger -> OpenAPI

