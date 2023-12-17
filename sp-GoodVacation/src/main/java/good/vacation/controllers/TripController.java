package good.vacation.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import good.vacation.dtos.TripDto;
import good.vacation.models.Trip;
import good.vacation.services.TripService;

@RestController
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private TripService tripService;
	
	@PostMapping("/save")
	public ResponseEntity<Trip> saveTrip(@RequestBody TripDto tripDto) {
		return new ResponseEntity<>((Trip) this.tripService.saveObject(tripDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{idTrip}")
	public ResponseEntity<Trip> getTripById(@PathVariable Long idTrip) {
		Trip trip = ((Trip) this.tripService.getObjectById(idTrip));
		
		return ResponseEntity.ok(trip);
	}
	
//	@GetMapping("/getAll")
//	public List<Object> getAllTrips() {
//		return this.tripService.getAllObjects();
//	}
	
	@GetMapping("/getAll")
	public List<Trip> getAllTrips() {
		List<Object> arrObjc = this.tripService.getAllObjects();
		List<Trip> arrTrips = new ArrayList<>();
		
		for (int i = 0; i < arrObjc.size(); i++) {
			arrTrips.add((Trip) arrObjc.get(i));
		}
				
		return arrTrips;
	}
	
	@PutMapping("/update/{idTrip}")
	public ResponseEntity<Trip> updateTripById(@PathVariable Long idTrip, @RequestBody TripDto tripDto) {
		this.tripService.updateObject(idTrip, tripDto);
		
		return ResponseEntity.ok((Trip) this.tripService.getObjectById(idTrip));
	}
	
	@DeleteMapping("/delete/{idTrip}")
	public ResponseEntity<String> deleteTripById(@PathVariable Long idTrip) {
		this.tripService.deleteObjectById(idTrip);
		
		return new ResponseEntity<>("Object successfully deleted!", HttpStatus.ACCEPTED);
	}
}