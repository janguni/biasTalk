package com.example.testData;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.subscription.model.Subscription;
import org.springframework.test.util.ReflectionTestUtils;

public class SubscriptionTestData {

	/**
	 * 구독 중인 구독 엔티티
	 * @param fan 팬
	 * @param celebrity 연예인
	 * @param subscriptionID 구독 ID
	 * @return 구독 중인 구독 엔티티
	 */
	public static Subscription getActiveSubscription(Fan fan, Celebrity celebrity, long subscriptionID) {
		Subscription subscription = Subscription.subscribe(fan, celebrity);
		ReflectionTestUtils.setField(subscription, "id", subscriptionID);
		return subscription;
	}

}
