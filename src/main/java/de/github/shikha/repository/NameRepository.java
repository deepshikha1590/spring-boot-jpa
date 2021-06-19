package de.github.shikha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.github.shikha.model.NameEntity;
 
@Repository
public interface NameRepository extends JpaRepository<NameEntity, Long> {
}
