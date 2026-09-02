package com.example.biasTalk.interfaces.googleAuth;

import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "google", url = "${spring.security.oauth2.client.provider.google.user-info-uri}")
public interface GoogleAuthRepository {
	@GetMapping("")
	Map<String, Object> getUserGoogleProfile(@RequestHeader("Authorization") String accessTokenWithBearer);
}
