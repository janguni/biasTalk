package com.example.biasTalk.domain.celebrity.repository;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import java.util.Optional;

public interface CelebrityRepository {

    /**
     * 연예인 ID로 연예인 조회
     * @param id 연예인 ID
     * @return Optional 연예인
     */
    Optional<Celebrity> findById(Long id);
    Optional<Celebrity> findByLoginId(String loginId);
    Celebrity save(String name, String loginId, String password);
}
