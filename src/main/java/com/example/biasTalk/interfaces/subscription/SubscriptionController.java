package com.example.biasTalk.interfaces.subscription;

import com.example.biasTalk.application.service.commandDto.UnSubscriptionCommand;
import com.example.biasTalk.application.service.commandService.SubscriptionCommandService;
import com.example.biasTalk.application.service.commandDto.SubscriptionCommand;
import com.example.biasTalk.application.service.queryService.CelebrityQueryService;
import com.example.biasTalk.application.service.queryService.OAuthFanQueryService;
import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionController {

	private final SubscriptionCommandService subscriptionCommandService;
	private final OAuthFanQueryService OAuthFanQueryService;
	private final CelebrityQueryService celebrityQueryService;

	/**
	 * 구독
	 * @param principal
	 * @param celebrityId 연예인 ID
	 */
	@PostMapping("subscribe/{celebrityId}")
	public void subscribe(
		@AuthenticationPrincipal User principal,
		@PathVariable Long celebrityId) {
		// 팬 조회
		Fan fan = OAuthFanQueryService.getFan(principal);

		// 연예인 조회
		Celebrity celebrity = celebrityQueryService.getCelebrity(celebrityId);

		// 구독
		subscriptionCommandService.subscribe(new SubscriptionCommand(fan, celebrity));
	}

	/**
	 * 구독 해제
	 * @param principal
	 * @param celebrityId 연예인 ID
	 */
	@PutMapping("unsubscribe/{celebrityId}")
	public void unsubscribe(
		@AuthenticationPrincipal User principal,
		@PathVariable Long celebrityId) {
		// 팬 조회
		Fan fan = OAuthFanQueryService.getFan(principal);

		// 연예인 조회
		Celebrity celebrity = celebrityQueryService.getCelebrity(celebrityId);
		
		// 구독 해제
		subscriptionCommandService.unsubscribe(new UnSubscriptionCommand(fan, celebrity));
	}
}
