package com.haeseong.sirenorder.controller;

import com.haeseong.sirenorder.controller.assembler.LoginAssembler;
import com.haeseong.sirenorder.controller.dto.LoginRequest;
import com.haeseong.sirenorder.controller.dto.LoginResponse;
import com.haeseong.sirenorder.model.entity.Member;
import com.haeseong.sirenorder.model.exception.LoginFailureException;
import com.haeseong.sirenorder.model.service.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;
    private final LoginAssembler loginAssembler;

    /**
     * 아이디와 비밀번호로 로그인합니다
     *
     * @param loginRequest 아이디, 비밀번호
     * @return 로그인 한 회원의 정보
     * @throws LoginFailureException 로그인 정보가 일치하지 않는 경우
     */
    public LoginResponse login(final LoginRequest loginRequest) {
        final Member member = memberService.login(loginRequest.getId(), loginRequest.getPassword());
        return loginAssembler.assemble(member);
    }
}
