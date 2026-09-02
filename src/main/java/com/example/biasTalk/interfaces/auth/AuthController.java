package com.example.biasTalk.interfaces.auth;

import com.example.biasTalk.domain.auth.model.GoogleUserInfo;
import com.example.biasTalk.domain.auth.service.GoogleAuthService;
import com.example.biasTalk.domain.exception.DomainException;
import com.example.biasTalk.domain.exception.ErrorCode;
import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.fan.repository.FanRepository;
import com.example.biasTalk.enums.Role;
import com.example.biasTalk.global.auth.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final FanRepository fanRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final GoogleAuthService googleAuthService;

    @GetMapping("/google")
    public ResponseEntity<String> oauthLogin(HttpServletRequest request) {
        String accessToken = jwtTokenProvider.resolveToken(request);

        // 구글에게 사용자 정보 요청하기
        GoogleUserInfo googleUserInfo = googleAuthService.getGoogleUserInfo(accessToken);

        // 팬 조회
        Fan fan = fanRepository.findByUniqueId(googleUserInfo.getId())
            .orElseThrow(() -> new DomainException(ErrorCode.FAN_NOT_FOUND));

        // jwt 만들기
        String jwt = jwtTokenProvider.createToken(fan.getId().toString(), Role.FAN.getCode());

        // jwt 응답하기
        return ResponseEntity.ok().body(jwt);
    }
}
