package com.example.biasTalk.domain.auth.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthProvider {
    GOOGLE("google"),
    KAKAO("kakao");

    private final String registrationId;

    public static AuthProvider fromString(String registrationId) {
        for (AuthProvider provider : AuthProvider.values()) {
            if (provider.registrationId.equalsIgnoreCase(registrationId)) {
                return provider;
            }
        }
        throw new IllegalArgumentException("Unknown registrationId: " + registrationId);
    }
}
