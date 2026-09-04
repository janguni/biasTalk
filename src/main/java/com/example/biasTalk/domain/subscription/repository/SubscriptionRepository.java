package com.example.biasTalk.domain.subscription.repository;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.subscription.model.Subscription;
import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository {

    /**
     * 구독 조회
     * @param fan 팬
     * @param celebrity 연예인
     * @return Optional 구독
     */
    Optional<Subscription> find(Fan fan, Celebrity celebrity);

    /**
     * 구독 저장
     * @param subscription 구독
     */
    void save(Subscription subscription);

    /**
     * 구독 중인 구독 정보 목록
     * @param fan 팬
     * @return 구독 중인 구독 정보 목록
     */
    List<Subscription> findActivate(Fan fan);

    /**
     * 구독 가능한 연예인 목록 조회
     * @param fan 팬
     * @return
     */
    List<Celebrity> findSubscribable(Fan fan);
}
