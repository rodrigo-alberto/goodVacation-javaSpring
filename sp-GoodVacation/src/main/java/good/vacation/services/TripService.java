package good.vacation.services;

import java.util.List;

import good.vacation.models.Trip;

public interface TripService { //Extender o service genérico;
	
	Trip saveTrip(Trip trip);
	
	List<Trip> getAllTrips();
	
	Trip getTripById(Long idTrip);
	
	Trip UpdateTrip(Long id, Trip updatedTrip);
	
	void deleteTripById(Long idTrip);
}
