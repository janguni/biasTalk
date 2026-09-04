package com.example.biasTalk.repository.celebrity;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CelebrityJpaRepository extends JpaRepository<Celebrity, Long> {
}
