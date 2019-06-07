package com.haeseong.sirenorder.model.service;

import com.haeseong.sirenorder.model.entity.Member;

import java.util.Optional;

public interface MemberService {
    Member login(String memberId, String password);

    Optional<Member> getMemberById(String memberId);

    Member createMember(String memberId, String password, String name, String phoneNumber);
}
