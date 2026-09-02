package com.example.biasTalk.domain.auth.service;

import static com.example.biasTalk.domain.exception.ErrorCode.GOOGLE_USER_INFO_REQUEST_FAILED;

import com.example.biasTalk.domain.auth.model.GoogleUserInfo;
import com.example.biasTalk.domain.exception.DomainException;
import com.example.biasTalk.interfaces.googleAuth.GoogleAuthRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GoogleAuthService {

	private final GoogleAuthRepository googleAuthRepository;

	public GoogleUserInfo getGoogleUserInfo(String accessToken) {
		try {
			String request = plusBearer(accessToken);
			log.info("request: {}", request);
			Map<String, Object> result = googleAuthRepository.getUserGoogleProfile(request);
			return new GoogleUserInfo(result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DomainException(GOOGLE_USER_INFO_REQUEST_FAILED);
		}
	}

	private String plusBearer(String accessToken) {
		return "Bearer " + accessToken;
	}
}
