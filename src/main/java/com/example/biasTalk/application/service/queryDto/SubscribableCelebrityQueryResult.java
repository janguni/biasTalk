package com.example.biasTalk.application.service.queryDto;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import java.util.List;

public record SubscribableCelebrityQueryResult(
    List<CelebrityInfo> subscribableCelebrities // 구독 가능한 연예인 정보 목록
) {
    public static SubscribableCelebrityQueryResult from(List<Celebrity> subscribableCelebrity) {
        return new SubscribableCelebrityQueryResult(
            subscribableCelebrity.stream()
                .map(CelebrityInfo::from)
                .toList()
        );
    }

    public record CelebrityInfo(
        long celebrityId, // 연예인 ID
        String celebrityName // 연예인 이름
    ) {
        public static CelebrityInfo from(Celebrity celebrity) {
            return new CelebrityInfo(
                celebrity.getId(),
                celebrity.getName()
            );
        }
    }
}
