package com.hardik.scapula.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.hardik.scapula.utility.CodeUtility;

import lombok.Data;

@Data
@Entity
@Table(name = "url_mappings")
public class UrlMapping implements Serializable {

	private static final long serialVersionUID = -5165112696362414830L;

	@Id
	@Column(name = "id", nullable = false, unique = true, length = 8, updatable = false)
	private String id;

	@Column(name = "original_value")
	private String originalValue;

	@Column(name = "visitor_count", nullable = false)
	private int visitors;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@PrePersist
	void onCreate() {
		this.id = CodeUtility.generate(this.originalValue);
		this.visitors = 0;
		this.createdAt = LocalDateTime.now();
	}

}
