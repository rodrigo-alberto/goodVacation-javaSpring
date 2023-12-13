package good.vacation.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destiny {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDestiny;
	
	@Column(nullable = false, length = 85)
	private String name;
	
	@Column(nullable = false, name = "images_url")
	private String imagesUrl;
	
	@Column(nullable = false, length = 85)
	private String city;

	public Destiny() {
	}

	public Destiny(int idDestiny, String name, String imagesUrl, String city) {
		this.idDestiny = idDestiny;
		this.name = name;
		this.imagesUrl = imagesUrl;
		this.city = city;
	}

	public int getIdDestiny() {
		return idDestiny;
	}

	public void setIdDestiny(int idDestiny) {
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