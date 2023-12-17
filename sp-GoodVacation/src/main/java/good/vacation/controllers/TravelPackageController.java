package good.vacation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import good.vacation.dtos.TravelPackageDto;
import good.vacation.services.TripService;

@RestController
@RequestMapping("/travelPackages")
public class TravelPackageController {
	
	@Autowired
	private TripService tripService;
	
	@PostMapping("/createPackage")
	public ResponseEntity<String> createPackage(@RequestBody TravelPackageDto tPackageDto){
		this.tripService.createPackage(tPackageDto.getIdUserClient(), tPackageDto.getIdTrip());
				
		return new ResponseEntity<>("Travel package successfully created!", HttpStatus.CREATED);	
	}
}