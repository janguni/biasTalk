package com.example.biasTalk.domain.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {
    private final ErrorCode errorCode;

    public DomainException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public DomainException(ErrorCode errorCode, String message) {
        super(String.format(errorCode.getMessage(), message));
        this.errorCode = errorCode;
    }
}
