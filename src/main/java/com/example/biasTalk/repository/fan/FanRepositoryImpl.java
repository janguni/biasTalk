package com.example.biasTalk.repository.fan;


import static com.example.biasTalk.domain.fan.model.QFan.fan;

import com.example.biasTalk.domain.fan.model.Fan;
import com.example.biasTalk.domain.fan.repository.FanRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FanRepositoryImpl implements FanRepository {

    private final JPAQueryFactory queryFactory;
    private final FanJpaRepository celebrityJpaRepository;

    @Override
    public Optional<Fan> findByEmail(String email) {
        return Optional.ofNullable(queryFactory.selectFrom(fan)
			.where(fan.email.eq(email))
			.fetchOne());
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.findByEmail(email).isPresent();
    }

    @Override
    public Fan save(Fan fan) {
        return celebrityJpaRepository.save(fan);
    }

    @Override
    public Optional<Fan> findById(Long id) {
        return celebrityJpaRepository.findById(id);
    }

    @Override
    public Optional<Fan> findByUniqueId(String uniqueId) {
        return Optional.ofNullable(queryFactory.selectFrom(fan)
            .where(fan.uniqueId.eq(uniqueId))
            .fetchOne());
    }
}
