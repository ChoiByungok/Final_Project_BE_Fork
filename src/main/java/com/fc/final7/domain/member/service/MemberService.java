package com.fc.final7.domain.member.service;

import com.fc.final7.domain.member.dto.SignUpRequestDto;
import com.fc.final7.domain.member.dto.SignupResponseDto;
import com.fc.final7.domain.member.entity.Member;
import com.fc.final7.domain.member.repository.MemberRepository;
import com.fc.final7.global.exception.DuplicateEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    public SignupResponseDto signUp(SignUpRequestDto memberDto) throws Exception {
        memberRepository.findByEmail(memberDto.getEmail()).ifPresent(member -> {
            throw new DuplicateEmailException();
        });
        Member member = Member.createMember(memberDto, encoder);
        Member savedMember = memberRepository.save(member);

        return from(savedMember);
    }

    public SignupResponseDto from(Member member) {
        return SignupResponseDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .gender(member.getGender())
                .age(member.getAge())
                .build();
    }
}
