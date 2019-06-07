package com.haeseong.sirenorder.controller.assembler;

import com.haeseong.sirenorder.controller.dto.MemberResponse;
import com.haeseong.sirenorder.model.entity.Member;

public class MemberAssembler {
    public MemberResponse assemble(Member member) {
        if (member == null) {
            return null;
        }
        final MemberResponse memberResponse = new MemberResponse();
        memberResponse.setId(member.getId());
        memberResponse.setName(member.getName());
        memberResponse.setPhoneNumber(member.getPhoneNumber());
        return memberResponse;
    }
}
