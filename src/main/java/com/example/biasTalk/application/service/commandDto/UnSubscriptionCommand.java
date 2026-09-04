package com.example.biasTalk.application.service.commandDto;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.fan.model.Fan;

public record UnSubscriptionCommand(Fan fan, Celebrity celebrity) {
}
