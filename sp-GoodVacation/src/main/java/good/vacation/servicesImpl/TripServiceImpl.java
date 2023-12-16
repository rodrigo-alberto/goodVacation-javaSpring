package good.vacation.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import good.vacation.models.Trip;
import good.vacation.repositories.TripRepository;
import good.vacation.services.TripService;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepo;
	
	@Override
	public Trip saveTrip(Trip trip) {
		return this.tripRepo.save(trip);
	}

	@Override
	public List<Trip> getAllTrips() {
		return this.tripRepo.findAll();
	}

	@Override
	public Trip getTripById(Long idTrip) {
		return this.tripRepo.getReferenceById(idTrip);
	}

	@Override
	public Trip UpdateTrip(Long idTrip, Trip updatedTrip) {
		Trip existingTrip = this.tripRepo.findById(idTrip).orElse(null)
		
		if( != null) {
			
		}
		
		
		return this.tripRepo.saveAndFlush(updatedTrip);
	}

	@Override
	public void deleteTripById(Long idTrip) {
		// TODO Auto-generated method stub
		
	}
}