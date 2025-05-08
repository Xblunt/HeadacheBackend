package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.headache.backend.store.entities.PromotionRequest;

import java.util.List;
import java.util.Optional;

@Repository
public interface PromotionRequestRepository extends JpaRepository<PromotionRequest,String> {
    List<PromotionRequest> findAll();
    Optional<PromotionRequest> findByUuid(String uuid);
}
