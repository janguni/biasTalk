package com.example.biasTalk.interfaces.subscription;

import com.example.biasTalk.application.service.queryDto.ActivateSubscriptionQueryResult;
import com.example.biasTalk.application.service.queryDto.SubscribableCelebrityQueryResult;
import com.example.biasTalk.application.service.queryService.OAuthFanQueryService;
import com.example.biasTalk.application.service.queryService.SubscriptionQueryService;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.interfaces.subscription.dto.ActiveSubscriptionInfosRspDto;
import com.example.biasTalk.interfaces.subscription.dto.SubscribableCelebrityRspDto;
import com.example.biasTalk.mapper.SubscriptionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionQueryController {

    private final SubscriptionQueryService subscriptionQueryService;
    private final SubscriptionMapper subscriptionMapper;
    private final OAuthFanQueryService OAuthFanQueryService;

    /**
     * 구독 중인 구독 정보 조회
     */
    @GetMapping("/actives")
    public ResponseEntity<ActiveSubscriptionInfosRspDto> getActiveSubscriptions(@AuthenticationPrincipal User principal) {
        Fan fan = OAuthFanQueryService.getFan(principal);

        ActivateSubscriptionQueryResult queryResult = subscriptionQueryService.getActiveSubscriptions(fan);

        ActiveSubscriptionInfosRspDto rspDto = subscriptionMapper.toRspDto(queryResult);
        return new ResponseEntity<>(rspDto, HttpStatus.OK);
    }

    /**
     * 구독 가능한 연예인 정보 조회
     */
    @GetMapping("/subscribables")
    public ResponseEntity<SubscribableCelebrityRspDto> getAvailableCelebrities(@AuthenticationPrincipal User principal) {
        Fan fan = OAuthFanQueryService.getFan(principal);

        SubscribableCelebrityQueryResult queryResult = subscriptionQueryService.getSubscribableCelebrities(fan);
        return new ResponseEntity<>(subscriptionMapper.toRspDto(queryResult), HttpStatus.OK);
    }
}
