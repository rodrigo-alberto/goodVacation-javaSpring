package good.vacation.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import good.vacation.enums.TravelStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTrip;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = false, name = "departure_date")
	private LocalDateTime departureDate;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(nullable = false, name = "arrival_date")
	private LocalDateTime arrivalDate;
	
	@Column(nullable = false, name = "travel_price")
	private Double travelPrice;
	
	@Column(nullable = false)
	private boolean isPromotion;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "travel_status")
	private TravelStatus travelStatus;
	
	@ManyToMany(mappedBy = "trips", cascade = {CascadeType.ALL})
	@JsonIgnore
	private Set<Client> clients = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "fk_destiny_idDestiny")
	private Destiny destiny;

	public Trip() {
	}

	public Trip(LocalDateTime departureDate, LocalDateTime arrivalDate, Double travelPrice, boolean isPromotion, TravelStatus travelStatus) {
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.travelPrice = travelPrice;
		this.isPromotion = isPromotion;
		this.travelStatus = travelStatus;
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

	public TravelStatus getTravelStatus() {
		return travelStatus;
	}

	public void setTravelStatus(TravelStatus travelStatus) {
		this.travelStatus = travelStatus;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Destiny getDestiny() {
		return destiny;
	}
	
	public void setDestiny(Destiny destiny) {
		this.destiny = destiny;
	}
}