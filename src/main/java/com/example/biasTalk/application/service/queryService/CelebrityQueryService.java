package com.example.biasTalk.application.service.queryService;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.celebrity.repository.CelebrityRepository;
import com.example.biasTalk.domain.exception.DomainException;
import com.example.biasTalk.domain.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CelebrityQueryService {

	private final CelebrityRepository celebrityRepository;

	/**
	 * 연예인 entity 조회
	 * @param celebrityId 연예인 ID
	 * @return 연예인 entity
	 * @throws DomainException 연예인 조회 실패
	 */
	public Celebrity getCelebrity(Long celebrityId) {
		return celebrityRepository.findById(celebrityId)
			.orElseThrow(() -> new DomainException(ErrorCode.CELEBRITY_NOT_FOUND));
	}
}
