package br.com.florafoz.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
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
@Table(name = "tbdenuncia")
public class Report {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String justify; //justificativa
	
	@JsonIgnoreProperties("report")
	@ManyToOne
	@JoinColumn(name = "commentId", nullable = false)
	private Comment comment;
	
	//Created
	private LocalDateTime createdAt;

	@JsonIgnoreProperties("report")
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User createdBy;
	
	@PrePersist
	private void prePersist() {
		this.createdAt = LocalDateTime.now();
		//
	}

}

