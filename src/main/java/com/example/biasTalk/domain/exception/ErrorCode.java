package com.example.biasTalk.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력값입니다."),

    // Member (Fan, Celebrity)
    FAN_NOT_FOUND(HttpStatus.NOT_FOUND, "M001", "팬을 찾을 수 없습니다."),
    CELEBRITY_NOT_FOUND(HttpStatus.NOT_FOUND, "M002", "셀럽을 찾을 수 없습니다."),

    // Subscription
    ALREADY_SUBSCRIBED(HttpStatus.BAD_REQUEST, "S001", "이미 구독 중입니다."),
    NOT_FOUND_SUBSCRIBED(HttpStatus.BAD_REQUEST, "S002", "구독 정보가 없습니다."),

    // Event
    EVENT_NOT_FOUND(HttpStatus.NOT_FOUND, "E001", "이벤트를 찾을 수 없습니다."),
    EVENT_ALREADY_EXISTS(HttpStatus.CONFLICT, "E002", "이미 등록된 이벤트 일정과 겹칩니다. (겹치는 이벤트: %s)"),

    // Auth
    GOOGLE_USER_INFO_REQUEST_FAILED(HttpStatus.BAD_GATEWAY, "A001", "accessToken으로 구글 사용자 정보를 가져오는데 실패했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
