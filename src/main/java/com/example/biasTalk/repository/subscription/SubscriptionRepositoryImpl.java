package com.example.biasTalk.repository.subscription;

import static com.example.biasTalk.domain.celebrity.model.QCelebrity.celebrity;
import static com.example.biasTalk.domain.subscription.model.QSubscription.subscription;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.subscription.model.Subscription;
import com.example.biasTalk.enums.SubscriptionStatus;
import com.example.biasTalk.domain.subscription.repository.SubscriptionRepository;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    private final JPAQueryFactory queryFactory;
    private final SubscriptionJpaRepository subscriptionJpaRepository;

    @Override
    public Optional<Subscription> findByFanAndCelebrity(Fan fan, Celebrity celebrity) {
        return Optional.ofNullable(
            queryFactory
                .selectFrom(subscription)
                .where(
                    subscription.fan.id.eq(fan.getId()),
                    subscription.celebrity.id.eq(celebrity.getId())
                )
                .fetchOne()
        );
    }

    @Override
    public void save(Subscription subscription) {
        subscriptionJpaRepository.save(subscription);
    }

    /**
     * 구독 중인 구독 정보 목록
     * @param fanId 팬 id
     * @return 구독 중인 구독 정보 목록
     */
    @Override
    public List<Subscription> findActivate(long fanId) {
        return queryFactory
            .selectFrom(subscription)
            .join(subscription.celebrity, celebrity).fetchJoin() // celebrity 정보 모두 가져옴
            .where(
                subscription.fan.id.eq(fanId),
                subscription.status.eq(SubscriptionStatus.SUBSCRIBED)
            )
            .fetch();
    }

    @Override
    public List<Celebrity> findSubscribable(long fanId) {
        return queryFactory
            .selectFrom(celebrity)
            .where(celebrity.id.notIn( // 구독 중인 셀럽 ID를 제외
                JPAExpressions
                    .select(subscription.celebrity.id)
                    .from(subscription)
                    .where(
                        subscription.fan.id.eq(fanId),
                        subscription.status.eq(SubscriptionStatus.SUBSCRIBED)
                    )
            ))
            .fetch();
    }

}
