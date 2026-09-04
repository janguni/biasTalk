package com.example.biasTalk.global.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.ERROR // 타겟에 매핑되지 않는 필드가 있으면 오류
)
public interface MapStructConfig {

}
