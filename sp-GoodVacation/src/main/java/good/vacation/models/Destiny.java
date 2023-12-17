package good.vacation.models;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Destiny {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestiny;
	
	@Column(nullable = false, length = 85)
	private String name;
	
	@Column(nullable = false, name = "images_url")
	private String imagesUrl;
	
	@Column(nullable = false, length = 85)
	private String city;

	@Transient
	@OneToMany(mappedBy = "destiny")
	@JsonIgnore
	private Set<Trip> trips = new HashSet<>();
	
	public Destiny() {
	}

	public Destiny(String name, String imagesUrl, String city) {
		this.name = name;
		this.imagesUrl = imagesUrl;
		this.city = city;
	}

	public Long getIdDestiny() {
		return idDestiny;
	}

	public void setIdDestiny(Long idDestiny) {
		this.idDestiny = idDestiny;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}