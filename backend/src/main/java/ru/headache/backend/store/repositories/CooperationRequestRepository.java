package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.headache.backend.store.entities.СooperationRequest;

import java.util.List;
import java.util.Optional;

@Repository
public interface CooperationRequestRepository extends JpaRepository<СooperationRequest,String> {
    List<СooperationRequest> findAll();
    Optional<СooperationRequest> findByUuid(String uuid);
}
