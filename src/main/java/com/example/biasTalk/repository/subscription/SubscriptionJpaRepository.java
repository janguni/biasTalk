package com.example.biasTalk.repository.subscription;

import com.example.biasTalk.domain.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionJpaRepository extends JpaRepository<Subscription, Long> {
}
