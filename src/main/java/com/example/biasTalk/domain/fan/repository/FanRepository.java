package com.example.biasTalk.domain.fan.repository;

import com.example.biasTalk.domain.fan.model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FanRepository {
    Optional<Fan> findByEmail(String email);
    boolean existsByEmail(String email);
    Fan save(Fan fan);
    Optional<Fan> findById(Long id);
    Optional<Fan> findByUniqueId(String uniqueId);
}
