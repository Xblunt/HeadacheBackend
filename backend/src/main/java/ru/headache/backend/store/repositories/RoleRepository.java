package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.headache.backend.store.entities.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    List<Role> findAll();
    Optional<Role> findByUuid(String uuid);
    List<Role> findAllByRoleIn(List<String> roleNames);
}
