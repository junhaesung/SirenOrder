package com.haeseong.sirenorder.model.entity;

import com.haeseong.sirenorder.model.Entity;
import com.haeseong.sirenorder.model.vo.MemberAuthority;
import lombok.Data;

@Data
public class Member implements Entity<String> {
    /**
     * 아이디
     */
    private String id;
    /**
     * 비밀번호
     */
    private String password;
    /**
     * 이름
     */
    private String name;
    /**
     * 연락처
     */
    private String phoneNumber;
    /**
     * 권한
     */
    private MemberAuthority authority;
    /**
     * 장바구니
     */
    private Cart cart;
}
