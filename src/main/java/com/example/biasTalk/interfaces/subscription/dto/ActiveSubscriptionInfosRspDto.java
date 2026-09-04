package com.example.biasTalk.interfaces.subscription.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 구독 중인 구독 정보 응답 DTO
 */
@Getter
@AllArgsConstructor
@ToString
public class ActiveSubscriptionInfosRspDto {
    
    private List<SubscriptionInfo> activeSubscriptionInfos; // 구독 중인 구독 정보 목록

    @Getter
    @AllArgsConstructor
    @ToString
    public static class SubscriptionInfo {
        private long subscriptionId; // 구독 ID
        private LocalDateTime subscribedAt; // 구독 시작일시
        private long celebrityId; // 연예인 ID
        private String celebrityName; // 연예인 이름
    }
}
