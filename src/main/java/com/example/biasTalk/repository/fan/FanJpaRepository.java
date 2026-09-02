package com.example.biasTalk.repository.fan;

import com.example.biasTalk.domain.fan.model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FanJpaRepository extends JpaRepository<Fan, Long> {
}
