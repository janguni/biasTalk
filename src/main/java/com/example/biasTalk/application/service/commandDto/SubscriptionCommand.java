package com.example.biasTalk.application.service.commandDto;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;

public record SubscriptionCommand(Fan fan, Celebrity celebrity) {

}
