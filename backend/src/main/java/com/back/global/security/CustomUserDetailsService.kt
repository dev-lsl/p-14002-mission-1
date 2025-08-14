package com.back.global.security

import com.back.domain.member.member.service.MemberService
import lombok.RequiredArgsConstructor
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CustomUserDetailsService(
    private val memberService: MemberService
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val member = memberService.findByUsername(username)
            .orElseThrow<UsernameNotFoundException?>( { UsernameNotFoundException("사용자를 찾을 수 없습니다.") })

        return SecurityUser(
            member.id,
            member.username,
            "",
            member.nickname,
            member.authorities
        )
    }
}