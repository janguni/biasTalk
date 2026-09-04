package com.example.biasTalk.application.service.queryService;

import com.example.biasTalk.application.service.queryDto.ActivateSubscriptionQueryResult;
import com.example.biasTalk.application.service.queryDto.SubscribableCelebrityQueryResult;
import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.subscription.model.Subscription;
import com.example.biasTalk.domain.subscription.repository.SubscriptionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class SubscriptionQueryService {

    private final SubscriptionRepository subscriptionRepository;

	/**
	 * 구독 중인 구독정보 조회
	 * @return 구독 중인 구독정보 목록
	 */
    public ActivateSubscriptionQueryResult getActiveSubscriptions(Fan fan) {
        // 구독 중인 구독 정보 목록
        List<Subscription> activateSubscriptions = subscriptionRepository.findActivate(fan);

		return ActivateSubscriptionQueryResult.from(activateSubscriptions);
    }

	/**
	 * 구독 가능한 연예인 목록 조회
	 * @param fan 팬
	 * @return 구독 가능한 연예인 목록 조회
	 */
	public SubscribableCelebrityQueryResult getSubscribableCelebrities(Fan fan) {
		// 구독 중인 연예인 목록 조회
		List<Celebrity> subscribableCelebrities = subscriptionRepository.findSubscribable(fan);

		return SubscribableCelebrityQueryResult.from(subscribableCelebrities);
	}
}
