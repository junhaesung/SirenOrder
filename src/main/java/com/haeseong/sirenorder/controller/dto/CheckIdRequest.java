package com.haeseong.sirenorder.controller.dto;

import lombok.Value;

@Value(staticConstructor = "from")
public class CheckIdRequest {
    private final String id;
}
