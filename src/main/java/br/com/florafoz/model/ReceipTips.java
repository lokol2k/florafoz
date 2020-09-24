package br.com.florafoz.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbdicasReceitas")
public class ReceipTips {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String tittle;

	private String description;

	private Boolean isActive;

	//@JsonIgnoreProperties("receipTips")
	//@ManyToOne
	//@JoinColumn(name = "postId", nullable = false)
	private long postId;

	@JsonIgnoreProperties("receipTips")
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User createdBy;

	// Created
	private LocalDateTime createdAt;

	private LocalDateTime lastUpdateDate;

	@PrePersist
	private void prePersist() {
		this.createdAt = LocalDateTime.now();
		this.lastUpdateDate = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate() {
		this.lastUpdateDate = LocalDateTime.now();
	}

}
