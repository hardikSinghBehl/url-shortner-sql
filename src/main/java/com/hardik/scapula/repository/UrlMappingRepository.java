package com.hardik.scapula.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.scapula.model.UrlMapping;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, String> {

	Boolean existsByoriginalValue(String originalValue);

	Optional<UrlMapping> findByOriginalValue(String originalValue);

}
