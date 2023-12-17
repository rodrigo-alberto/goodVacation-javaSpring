package good.vacation.dtos;

import java.time.LocalDateTime;
import good.vacation.enums.TravelStatus;

public class TripDto {
	
	private LocalDateTime departureDate;
	private LocalDateTime arrivalDate;
	private Double travelPrice;
	private boolean isPromotion;
	private TravelStatus travelStatus;
	private Long idDestiny;
	
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

	public Long getIdDestiny() {
		return idDestiny;
	}

	public void setIdDestiny(Long idDestiny) {
		this.idDestiny = idDestiny;
	}
}