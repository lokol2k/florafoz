package br.com.florafoz.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "tbcomentario")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String description;

	private Boolean isActive;

	// ManyReportOneComment
	@JsonIgnoreProperties("comment")
	@OneToMany(mappedBy = "comment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Report> reports;
	
	// OneUserManyComments
	//@JsonIgnoreProperties("comment")
	//@ManyToOne
	//@JoinColumn(name = "userId", nullable = false)
	private Long userId;
	
	// OnePostManyComments
	//@JsonIgnoreProperties("comment")
	//@ManyToOne
	//@JoinColumn(name = "postId", nullable = false)
	private Long postId;
	
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
