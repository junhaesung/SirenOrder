package com.haeseong.sirenorder.controller.assembler;

import com.haeseong.sirenorder.controller.dto.LoginResponse;
import com.haeseong.sirenorder.controller.dto.MemberResponse;
import com.haeseong.sirenorder.model.entity.Member;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginAssembler {
    private final MemberAssembler memberAssembler;

    public LoginResponse assemble(Member member) {
        final MemberResponse memberResponse = memberAssembler.assemble(member);
        return new LoginResponse(memberResponse);
    }
}
