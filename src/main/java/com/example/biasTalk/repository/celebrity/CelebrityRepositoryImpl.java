package com.example.biasTalk.repository.celebrity;


import static com.example.biasTalk.domain.celebrity.model.QCelebrity.celebrity;
import static com.example.biasTalk.domain.subscription.model.QSubscription.subscription;

import com.example.biasTalk.domain.celebrity.model.Celebrity;
import com.example.biasTalk.domain.celebrity.model.QCelebrity;
import com.example.biasTalk.domain.celebrity.repository.CelebrityRepository;
import com.example.biasTalk.domain.subscription.model.QSubscription;
import com.example.biasTalk.domain.subscription.model.Subscription;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CelebrityRepositoryImpl implements CelebrityRepository {

    private final JPAQueryFactory queryFactory;
    private final CelebrityJpaRepository celebrityJpaRepository;

    @Override
    public Optional<Celebrity> findById(Long id) {
        return Optional.ofNullable(
            queryFactory
                .selectFrom(celebrity)
                .where(
                    celebrity.id.eq(id)
                )
                .fetchOne()
        );
    }

    @Override
    public Optional<Celebrity> findByLoginId(String loginId) {
        return Optional.ofNullable(
            queryFactory
                .selectFrom(celebrity)
                .where(
                    celebrity.loginId.eq(loginId)
                )
                .fetchOne()
        );
    }

    @Override
    public Celebrity save(String name, String loginId, String password) {
        Celebrity celebrity = new Celebrity(name, loginId, password);

		return celebrityJpaRepository.save(celebrity);
    }

}
