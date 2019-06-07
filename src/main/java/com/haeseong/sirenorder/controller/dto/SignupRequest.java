package com.haeseong.sirenorder.controller.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class SignupRequest {
    private final String id;
    private final String password;
    private final String name;
    private final String phoneNumber;
}
