package br.com.florafoz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbgrupoCientifico")
public class CientificGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cientificName;

	private Boolean isActive;

	// OneCienfiticManyFloras
	//@JsonIgnoreProperties("cientificGroup")
//	@JsonManagedReference
//	@OneToMany(mappedBy = "cientificGroup", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private Set<Flora> floras;
}
