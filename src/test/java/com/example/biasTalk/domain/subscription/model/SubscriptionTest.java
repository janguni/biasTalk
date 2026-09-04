package com.example.biasTalk.domain.subscription.model;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.enums.SubscriptionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubscriptionTest {

	@Test
	@DisplayName("구독 생성에 성공한다.")
	void subscribe() {
		// given
		Fan fan = new Fan("uni", "12345");
		Celebrity celebrity = new Celebrity("JK");

		// when
		Subscription subscription = Subscription.subscribe(fan, celebrity);

		// then
		Assertions.assertThat(subscription.getStatus()).isEqualTo(SubscriptionStatus.SUBSCRIBED);
	}

	@Test
	void unsubscribe() {
		// given
		Fan fan = new Fan("uni", "12345");
		Celebrity celebrity = new Celebrity("JK");
		Subscription subscription = Subscription.subscribe(fan, celebrity);

		// when
		subscription.unsubscribe();

		// then
		Assertions.assertThat(subscription.getStatus()).isEqualTo(SubscriptionStatus.CANCELED);
		Assertions.assertThat(subscription.getUnsubscribedAt()).isNotNull();

	}
}