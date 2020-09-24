package br.com.florafoz.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbflora")
public class Flora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String popularName;

	private String information;

	private Boolean isActive;

	private Boolean isPoison;

	private Boolean isEatable;

	// OneCienfiticManyFloras
	// @JsonIgnoreProperties("flora")
	// @JsonBackReference
	// relation
	// @ManyToOne
	// @JoinColumn(name = "cientificGroupId", nullable = false)
//	private CientificGroup cientificGroup;
	private long cientificGroupId;

	// OneFloraManyFloraImage
	// @JsonIgnoreProperties("flora")
	// relation
	// @JsonBackReference
	// @OneToMany(mappedBy = "flora", fetch = FetchType.EAGER, cascade =
	// CascadeType.ALL)
	// private Set<FloraImage> floraImages;
	private long floraImageId;

	// @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =
	// "flora")
	// private FloraAddress floraAddress;
	private long floraAddressId;

	// @JsonIgnoreProperties("flora")
	// @JsonBackReference // funciona, mas nao retorna o ID
	// @JsonIdentityInfo(generator =
	// ObjectIdGenerators.PropertyGenerator.class.property = "id") //teste
	// relation
	// @ManyToOne
	// @JoinColumn(name = "userId", nullable = false)
	// private User user;

	private long userId;

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
