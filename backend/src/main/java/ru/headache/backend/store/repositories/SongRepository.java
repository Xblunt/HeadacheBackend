package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.headache.backend.store.entities.Song;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song,String> {
    List<Song> findAll();
    Optional<Song> findByUuid(String uuid);
    List<Song> findAllByUuidIn(List<String> uuids);
}
