package com.example.biasTalk.domain.subscription.repository;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.subscription.model.Subscription;
import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository {
    Optional<Subscription> findByFanAndCelebrity(Fan fan, Celebrity celebrity);
    void save(Subscription subscription);
    List<Subscription> findActivate(long fanId);
    List<Celebrity> findSubscribable(long fanId);
}
