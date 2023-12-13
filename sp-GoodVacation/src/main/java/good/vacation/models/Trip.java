package good.vacation.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTrip;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = false, name = "departure_date")
	private LocalDateTime departureDate;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = false)		//Adicionar "name";
	private LocalDateTime arrivalDate;
	
	@Column(nullable = false, name = "travel_price")
	private Double travelPrice;
	
	@Column(nullable = false)
	private boolean isPromotion;
	
	@ManyToMany(mappedBy = "trips", cascade = {CascadeType.ALL})
	private Set<Client> clients = new HashSet<>();

	public Trip() {
	}

	public Trip(Long idTrip, LocalDateTime departureDate, LocalDateTime arrivalDate, Double travelPrice, boolean isPromotion) {
		this.idTrip = idTrip;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.travelPrice = travelPrice;
		this.isPromotion = isPromotion;
	}

	public Long getIdTrip() {
		return idTrip;
	}

	public void setIdTrip(Long idTrip) {
		this.idTrip = idTrip;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Double getTravelPrice() {
		return travelPrice;
	}

	public void setTravelPrice(Double travelPrice) {
		this.travelPrice = travelPrice;
	}

	public boolean isPromotion() {
		return isPromotion;
	}

	public void setPromotion(boolean isPromotion) {
		this.isPromotion = isPromotion;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}