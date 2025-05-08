package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.headache.backend.store.entities.File;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File,String> {
    List<File> findAll();
    Optional<File> findByUuid(String uuid);
}
