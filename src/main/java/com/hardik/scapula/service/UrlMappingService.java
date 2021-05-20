package com.hardik.scapula.service;

import java.util.Optional;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hardik.scapula.model.UrlMapping;
import com.hardik.scapula.repository.UrlMappingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UrlMappingService {

	private final UrlMappingRepository urlMappingRepository;

	private final UrlValidator urlValidator;

	public boolean isValidUrl(final String originalUrlValue) {
		return urlValidator.isValid(originalUrlValue);
	}

	public boolean exists(final String originalUrlValue) {
		return urlMappingRepository.existsByoriginalValue(originalUrlValue);
	}

	public UrlMapping retreiveShortUrl(final String originalUrlValue) {
		return urlMappingRepository.findByOriginalValue(originalUrlValue).get();
	}

	public UrlMapping createShortUrl(final String originalUrlValue) {
		final var urlMapping = new UrlMapping();
		urlMapping.setOriginalValue(originalUrlValue);
		return urlMappingRepository.save(urlMapping);
	}

	public Optional<String> getOriginalUrl(final String urlId) {
		final var urlMapping = urlMappingRepository.findById(urlId);
		if (urlMapping.isPresent())
			return Optional.of(urlMapping.get().getOriginalValue());
		return Optional.empty();
	}

	@Async
	public void increaseVisitor(final String urlId) {
		final var urlMapping = urlMappingRepository.findById(urlId).get();
		urlMapping.setVisitors(urlMapping.getVisitors() + 1);
		urlMappingRepository.save(urlMapping);
	}

}
