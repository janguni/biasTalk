package com.example.biasTalk.domain.celebrity.repository;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import java.util.Optional;

public interface CelebrityRepository {

    Optional<Celebrity> findById(Long id);
    Optional<Celebrity> findByLoginId(String loginId);
    Celebrity save(String name, String loginId, String password);
}
