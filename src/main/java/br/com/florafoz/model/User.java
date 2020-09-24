package br.com.florafoz.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbusuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String email;

	private String password;

	private String phone;

	private Boolean isModerator;

	private Boolean isActive;

	//@JsonIgnoreProperties("user")
	//@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private Set<Comment> comments;

	// @JsonIgnoreProperties("user")
//	@JsonManagedReference
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Flora> floras;

	@JsonIgnoreProperties("user")
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ReceipTips> receipTips;

	@JsonIgnoreProperties("user")
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Report> reports;

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
