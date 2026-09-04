package com.example.biasTalk.application.service.queryService;

import com.example.biasTalk.domain.exception.DomainException;
import com.example.biasTalk.domain.exception.ErrorCode;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.fan.repository.FanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthFanQueryService {

	private final FanRepository fanRepository;

	/**
	 * principal을 통해 팬 엔티티를 조회한다.
	 * @param principal
	 * @return fan entity
	 * @throws DomainException principal null
	 * @throws DomainException 팬 조회 실패
	 */
	public Fan getFan(User principal) {
		if (principal == null) {
			throw new DomainException(ErrorCode.INVALID_INPUT_VALUE);
		}
		return fanRepository.findById(Long.parseLong(principal.getUsername()))
			.orElseThrow(() -> new DomainException(ErrorCode.FAN_NOT_FOUND));
	}
}
