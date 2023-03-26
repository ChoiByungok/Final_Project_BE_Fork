package com.fc.final7.domain.member.controller;

import com.fc.final7.domain.member.dto.SignUpRequestDto;
import com.fc.final7.domain.member.dto.SignupResponseDto;
import com.fc.final7.domain.member.service.MemberService;
import com.fc.final7.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public BaseResponse<SignupResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestDto) throws Exception {
        SignupResponseDto signupResponseDto = memberService.signUp(requestDto);
        return BaseResponse.of(1, "회원가입이 완료되었습니다.", signupResponseDto);
    }
}
