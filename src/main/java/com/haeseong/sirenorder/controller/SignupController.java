package com.haeseong.sirenorder.controller;

import com.haeseong.sirenorder.controller.assembler.MemberAssembler;
import com.haeseong.sirenorder.controller.dto.CheckIdRequest;
import com.haeseong.sirenorder.controller.dto.MemberResponse;
import com.haeseong.sirenorder.controller.dto.SignupRequest;
import com.haeseong.sirenorder.model.entity.Member;
import com.haeseong.sirenorder.model.exception.SignupFailureException;
import com.haeseong.sirenorder.model.service.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SignupController {
    private final MemberService memberService;
    private final MemberAssembler memberAssembler;

    /**
     * 사용할 수 있는 아이디인지 확인합니다.
     *
     * @param checkIdRequest 사용하고 싶은 아이디
     * @return 사용할 수 있으면 true
     */
    public Boolean checkIdIsAvailable(final CheckIdRequest checkIdRequest) {
        final String memberId = checkIdRequest.getId();
        return !memberService.getMemberById(memberId).isPresent();
    }

    /**
     * 입력된 정보로 회원 가입합니다
     *
     * @param signupRequest 회원 가입 정보
     * @return 새로 가입된 회원
     * @throws SignupFailureException 이미 사용중인 아이디인 경우
     */
    public MemberResponse signup(final SignupRequest signupRequest) {
        final Member member = memberService.createMember(
                signupRequest.getId(),
                signupRequest.getPassword(),
                signupRequest.getName(),
                signupRequest.getPhoneNumber()
        );
        return memberAssembler.assemble(member);
    }
}
