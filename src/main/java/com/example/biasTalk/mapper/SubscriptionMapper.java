package com.example.biasTalk.mapper;

import com.example.biasTalk.application.service.queryDto.ActivateSubscriptionQueryResult;
import com.example.biasTalk.application.service.queryDto.SubscribableCelebrityQueryResult;
import com.example.biasTalk.global.config.MapStructConfig;
import com.example.biasTalk.interfaces.subscription.dto.ActiveSubscriptionInfosRspDto;
import com.example.biasTalk.interfaces.subscription.dto.SubscribableCelebrityRspDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public abstract class SubscriptionMapper {

    @Mapping(target = "activeSubscriptionInfos", source = "activeSubscriptionInfos")
    public abstract ActiveSubscriptionInfosRspDto toRspDto(ActivateSubscriptionQueryResult queryResult);

    public abstract ActiveSubscriptionInfosRspDto.SubscriptionInfo mapItem(ActivateSubscriptionQueryResult.SubscriptionInfo value);

    @Mapping(target = "subscribableCelebrityInfos", source = "subscribableCelebrities")
    public abstract SubscribableCelebrityRspDto toRspDto(SubscribableCelebrityQueryResult queryResult);

    public abstract SubscribableCelebrityRspDto.CelebrityInfo mapItem(SubscribableCelebrityQueryResult.CelebrityInfo value);
}
