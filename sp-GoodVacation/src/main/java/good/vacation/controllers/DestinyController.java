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
import good.vacation.dtos.DestinyDto;
import good.vacation.models.Destiny;
import good.vacation.services.DestinyService;

@RestController
@RequestMapping("/destinys")
public class DestinyController {
	
	@Autowired
	private DestinyService destinyService;
	
	@PostMapping("/save")
	public ResponseEntity<Destiny> saveDestiny(@RequestBody DestinyDto destinyDto) {
		return new ResponseEntity<>((Destiny) this.destinyService.saveObject(destinyDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{idDestiny}")
	public ResponseEntity<Destiny> getDestinyById(@PathVariable Long idDestiny) {
		Destiny destiny = ((Destiny) this.destinyService.getObjectById(idDestiny));
		
		return ResponseEntity.ok(destiny);
	}
	
	@GetMapping("/getAll")
	public List<Destiny> getAllDestinys() {
		List<Object> arrObjc = this.destinyService.getAllObjects();
		List<Destiny> arrDestinys = new ArrayList<>();
		
		for (int i = 0; i < arrObjc.size(); i++) {
			arrDestinys.add((Destiny) arrObjc.get(i));
		}
				
		return arrDestinys;
	}
	
	@PutMapping("/update/{idDestiny}")
	public ResponseEntity<Destiny> updateDestinyById(@PathVariable Long idDestiny, @RequestBody DestinyDto destinyDto) {		
		this.destinyService.updateObject(idDestiny, destinyDto);
		
		return ResponseEntity.ok((Destiny) this.destinyService.getObjectById(idDestiny));
	}
	
	@DeleteMapping("/delete/{idDestiny}")
	public ResponseEntity<String> deleteDestinyById(@PathVariable Long idDestiny) {	
		this.destinyService.deleteObjectById(idDestiny);
		
		return new ResponseEntity<>("Object successfully deleted!", HttpStatus.ACCEPTED);
	}
}