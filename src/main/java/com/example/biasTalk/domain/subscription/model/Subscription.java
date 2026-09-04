package com.example.biasTalk.domain.subscription.model;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.enums.SubscriptionStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 구독
 */
@Entity
@Table(name = "subscribe")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fan_id", nullable = false)
    private Fan fan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "celebrity_id", nullable = false)
    private Celebrity celebrity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SubscriptionStatus status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @Column(nullable = false)
    private LocalDateTime subscribedAt;

    private LocalDateTime unsubscribedAt;

    private Subscription(Fan fan, Celebrity celebrity, SubscriptionStatus subscriptionStatus) {
        this.fan = fan;
        this.celebrity = celebrity;
        this.status = subscriptionStatus;
        this.subscribedAt = LocalDateTime.now();
    }

    /**
     * 생성
     * @param fan 팬
     * @param celebrity 연예인
     * @return 구독 상태인 구독 entity
     */
    public static Subscription subscribe(Fan fan, Celebrity celebrity) {
        return new Subscription(fan, celebrity, SubscriptionStatus.SUBSCRIBED);
    }

    /**
     * 구독
     */
    public void subscribe() {
        this.status = SubscriptionStatus.SUBSCRIBED;
        this.subscribedAt = LocalDateTime.now();
    }

    /**
     * 구독 취소
     */
    public void unsubscribe() {
        this.status = SubscriptionStatus.CANCELED;
        this.unsubscribedAt = LocalDateTime.now();
    }

    /**
     * 구독 여부 확인
     * @return 구독 중이면 true
     */
    public boolean isSubscribe() {
        return SubscriptionStatus.SUBSCRIBED.equals(this.status);
    }
}
