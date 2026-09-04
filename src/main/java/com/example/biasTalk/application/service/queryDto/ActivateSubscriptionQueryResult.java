package com.example.biasTalk.application.service.queryDto;

import com.example.biasTalk.domain.subscription.model.Subscription;
import java.time.LocalDateTime;
import java.util.List;

public record ActivateSubscriptionQueryResult(
    List<SubscriptionInfo> activeSubscriptionInfos // 구독 중인 구독 정보 목록
) {
    public static ActivateSubscriptionQueryResult from(List<Subscription> subscriptions) {
        return new ActivateSubscriptionQueryResult(
            subscriptions.stream()
                .map(SubscriptionInfo::from)
                .toList()
        );
    }

    public record SubscriptionInfo(
        long subscriptionId, // 구독 ID
        LocalDateTime subscribedAt, // 구독 시작일시
        long celebrityId, // 연예인 ID
        String celebrityName // 연예인 이름
    ) {
        public static SubscriptionInfo from(Subscription subscription) {
            return new SubscriptionInfo(
                subscription.getId(),
                subscription.getSubscribedAt(),
                subscription.getCelebrity().getId(),
                subscription.getCelebrity().getName()
            );
        }
    }
}
