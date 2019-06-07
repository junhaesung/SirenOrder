package com.haeseong.sirenorder.model.service;

import com.haeseong.sirenorder.model.entity.Cart;
import com.haeseong.sirenorder.model.entity.Member;
import com.haeseong.sirenorder.model.exception.LoginFailureException;
import com.haeseong.sirenorder.model.exception.SignupFailureException;
import com.haeseong.sirenorder.model.repository.MemberRepository;
import com.haeseong.sirenorder.model.vo.MemberAuthority;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Member login(final String memberId, final String password) {
        Objects.requireNonNull(memberId, "'memberId' must not be null");
        Objects.requireNonNull(password, "'password' must not be null");

        final Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new LoginFailureException("아이디 또는 패스워드가 맞지 않습니다."));
        if (!member.getPassword().equals(password)) {
            throw new LoginFailureException("아이디 또는 패스워드가 맞지 않습니다.");
        }
        return member;
    }

    @Override
    public Optional<Member> getMemberById(final String memberId) {
        Objects.requireNonNull(memberId, "'memberId' must not be null");

        return memberRepository.findById(memberId);
    }

    @Override
    public Member createMember(final String memberId, final String password, final String name, final String phoneNumber) {
        Objects.requireNonNull(memberId, "'memberId' must not be null");
        Objects.requireNonNull(password, "'password' must not be null");
        Objects.requireNonNull(name, "'name' must not be null");
        Objects.requireNonNull(phoneNumber, "'phoneNumber' must not be null");

        if (memberRepository.findById(memberId).isPresent()) {
            throw new SignupFailureException("이미 사용중인 아이디입니다");
        }

        final Member member = new Member();
        member.setId(memberId);
        member.setPassword(password);
        member.setName(name);
        member.setPhoneNumber(phoneNumber);
        member.setAuthority(MemberAuthority.MEMBER);
        member.setCart(Cart.from(member));
        return memberRepository.save(member);
    }
}
