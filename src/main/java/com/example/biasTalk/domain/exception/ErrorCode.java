package com.example.biasTalk.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Member (Fan, Celebrity)
    FAN_NOT_FOUND(HttpStatus.NOT_FOUND, "M001", "팬을 찾을 수 없습니다."),

    // Auth
    GOOGLE_USER_INFO_REQUEST_FAILED(HttpStatus.BAD_GATEWAY, "A001", "accessToken으로 구글 사용자 정보를 가져오는데 실패했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
