package com.example.biasTalk.application.service.queryService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.biasTalk.application.service.queryDto.ActivateSubscriptionQueryResult;
import com.example.biasTalk.application.service.queryDto.SubscribableCelebrityQueryResult;
import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.subscription.model.Subscription;
import com.example.biasTalk.domain.subscription.repository.SubscriptionRepository;
import com.example.biasTalk.enums.SubscriptionStatus;
import com.example.testData.CelebrityTestData;
import com.example.testData.FanTestData;
import com.example.testData.SubscriptionTestData;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class SubscriptionQueryServiceTest {

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @InjectMocks
    private SubscriptionQueryService subscriptionQueryService;

    @Test
    @DisplayName("구독 중인 구독 정보 목록을 조회한다 - 성공")
    void getActiveSubscriptions_success() {
        Fan fan = FanTestData.getFan(1L);
        Celebrity celebrity = CelebrityTestData.getCelebrity(1L);
        Subscription subscription = SubscriptionTestData.getActiveSubscription(fan, celebrity, 1L);

        when(subscriptionRepository.findActivate(fan)).thenReturn(List.of(subscription));

        ActivateSubscriptionQueryResult result = subscriptionQueryService.getActiveSubscriptions(fan);

        assertThat(result.activeSubscriptionInfos()).hasSize(1);
        assertThat(result.activeSubscriptionInfos().get(0).celebrityId()).isEqualTo(1L);
        assertThat(result.activeSubscriptionInfos().get(0).celebrityName()).isEqualTo(CelebrityTestData.celebrityName);
        verify(subscriptionRepository).findActivate(fan);
    }

    @Test
    @DisplayName("구독 가능한 연예인 목록을 조회한다 - 성공")
    void getSubscribableCelebrities_success() {
        Fan fan = FanTestData.getFan(1L);
        Celebrity celebrity = CelebrityTestData.getCelebrity(1L);

        when(subscriptionRepository.findSubscribable(fan)).thenReturn(List.of(celebrity));

        SubscribableCelebrityQueryResult result = subscriptionQueryService.getSubscribableCelebrities(fan);

        assertThat(result.subscribableCelebrities()).hasSize(1);
        assertThat(result.subscribableCelebrities().get(0).celebrityId()).isEqualTo(1L);
        assertThat(result.subscribableCelebrities().get(0).celebrityName()).isEqualTo(CelebrityTestData.celebrityName);
        verify(subscriptionRepository).findSubscribable(fan);
    }
}
