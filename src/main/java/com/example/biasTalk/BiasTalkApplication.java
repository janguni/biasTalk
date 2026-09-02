package com.example.biasTalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableFeignClients // FeignClient 인터페이스 스캔 활성화
@EnableJpaAuditing
@SpringBootApplication
public class BiasTalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiasTalkApplication.class, args);
	}
}

