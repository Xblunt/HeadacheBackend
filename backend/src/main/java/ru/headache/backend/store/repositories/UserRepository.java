package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.headache.backend.store.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    List<User> findAll();
    Optional<User> findByUuid(String uuid);
}
