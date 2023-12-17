package good.vacation.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import good.vacation.dtos.TripDto;
import good.vacation.enums.SystemAlerts;
import good.vacation.models.Client;
import good.vacation.models.Trip;
import good.vacation.repositories.ClientRepository;
import good.vacation.repositories.DestinyRepository;
import good.vacation.repositories.TripRepository;
import good.vacation.services.TripService;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private TripRepository tripRepo;
	
	@Autowired
	private DestinyRepository destinyRepo;
	
	@Autowired
	private ClientRepository clientRepo;

	@Override
	public Object saveObject(Object object) {
		Trip savedTrip = mp.map(object, Trip.class);

		savedTrip.setDestiny(this.destinyRepo.findById(((TripDto) object).getIdDestiny()).orElseThrow(() -> 
			SystemAlerts.printRuntimeEx(SystemAlerts.DEPENDENCY_ID_NOT_FOUND)
		));	
		
		this.tripRepo.save(savedTrip);
		SystemAlerts.printSuccess(SystemAlerts.SAVED_SUCCESSFULLY);
	
		return savedTrip;
	}
	
	@Override
	public Object getObjectById(Long id) {
		return this.tripRepo.findById(id).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
	}
	
	@Override
	public List<Object> getAllObjects() {
		return new ArrayList<>(this.tripRepo.findAll());
	}
	
	@Override
	public Object updateObject(Long id, Object updatedObject) {
		Trip existingTrip = this.tripRepo.findById(id).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
		TripDto updatedTripDto = (TripDto) updatedObject;
		
		existingTrip.setDepartureDate(updatedTripDto.getDepartureDate());
		existingTrip.setArrivalDate(updatedTripDto.getArrivalDate());
		existingTrip.setTravelPrice(updatedTripDto.getTravelPrice());
		existingTrip.setPromotion(updatedTripDto.isPromotion());
		existingTrip.setTravelStatus(updatedTripDto.getTravelStatus());
		
		existingTrip.setDestiny(this.destinyRepo.findById(updatedTripDto.getIdDestiny()).orElseThrow(() -> 
				SystemAlerts.printRuntimeEx(SystemAlerts.DEPENDENCY_ID_NOT_FOUND)
		));
		
		return this.tripRepo.save(existingTrip);
	}
	
	@Override
	public void deleteObjectById(Long id) {
		this.tripRepo.findById(id).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
		this.tripRepo.deleteById(id);
	}

	@Override
	public void createPackage(Long idUserClient, Long idTrip) {
		Client client = this.clientRepo.findById(idUserClient).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
		Trip trip = this.tripRepo.findById(idTrip).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
		
		client.getTrips().add(trip);
		trip.getClients().add(client);
		
		this.tripRepo.save(trip);
		this.clientRepo.save(client);
	}
}