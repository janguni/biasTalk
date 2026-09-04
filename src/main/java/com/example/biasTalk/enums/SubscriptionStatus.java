package com.example.biasTalk.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SubscriptionStatus {

    // TODO: status를 줄여야함. db에 너무 길게 들어갈 이유가 하등 없음
    SUBSCRIBED("구독"),
    CANCELED("구독 취소"),
    STOPPED("중단");

    private final String description;
}
