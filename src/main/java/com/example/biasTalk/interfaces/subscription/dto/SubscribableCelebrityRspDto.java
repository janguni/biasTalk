package com.example.biasTalk.interfaces.subscription.dto;

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
public class SubscribableCelebrityRspDto {
    
    private List<CelebrityInfo> subscribableCelebrityInfos; // 구독 가능한 연예인 정보 목록

    @Getter
    @AllArgsConstructor
    @ToString
    public static class CelebrityInfo {
        private long celebrityId; // 연예인 ID
        private String celebrityName; // 연예인 이름
    }
}
