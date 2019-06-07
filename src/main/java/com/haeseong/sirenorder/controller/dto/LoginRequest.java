package com.haeseong.sirenorder.controller.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class LoginRequest {
    private final String id;
    private final String password;
}
