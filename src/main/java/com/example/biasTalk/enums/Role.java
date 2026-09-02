package com.example.biasTalk.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    FAN("F"),
    CELEBRITY("C");

    private final String code;
}
