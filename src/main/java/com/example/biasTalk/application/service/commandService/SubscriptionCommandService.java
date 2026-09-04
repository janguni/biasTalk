package com.example.biasTalk.application.service.commandService;

import com.example.biasTalk.application.service.commandDto.SubscriptionCommand;
import com.example.biasTalk.application.service.commandDto.UnSubscriptionCommand;
import com.example.biasTalk.domain.exception.DomainException;
import com.example.biasTalk.domain.exception.ErrorCode;
import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.fan.repository.FanRepository;
import com.example.biasTalk.domain.subscription.model.Subscription;
import com.example.biasTalk.domain.subscription.repository.SubscriptionRepository;
import com.example.biasTalk.domain.celebrity.repository.CelebrityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class SubscriptionCommandService {

    private final SubscriptionRepository subscriptionRepository;
    private final FanRepository fanRepository;
    private final CelebrityRepository celebrityRepository;

    /**
     * 구독
     * @param command 구독 command
     */
    @Transactional
    public void subscribe(SubscriptionCommand command) {
        Fan fan = command.fan();
        Celebrity celebrity = command.celebrity();

        // 구독
        subscriptionRepository.findByFanAndCelebrity(fan, celebrity).ifPresentOrElse(
			Subscription::subscribe,
            () -> subscriptionRepository.save(Subscription.subscribe(fan, celebrity))
        );
    }

    /**
     * 구독 해제
     * @param command 구독 해제 command
     */
    @Transactional
    public void unsubscribe(UnSubscriptionCommand command) {
        Subscription subscription = subscriptionRepository.findByFanAndCelebrity(command.fan(), command.celebrity()).orElseThrow(
            () -> new DomainException(ErrorCode.NOT_FOUND_SUBSCRIBED));

        subscription.unsubscribe();
    }
}
