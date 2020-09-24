package br.com.florafoz.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "tbimageFlora")
public class FloraImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String imageName;

	private String imageType;

	private String floraCol;

//	@JsonIgnoreProperties("floraImage")
//	@ManyToOne
//    @JoinColumn(name = "floraId", nullable = false)
//    private Flora flora;

	// oneimageonefloraimage
//	@OneToOne(fetch = FetchType.EAGER, optional = false)
//	@JoinColumn(name = "imageId", nullable = true)
//	private Image image;
	private long imageId;

}
