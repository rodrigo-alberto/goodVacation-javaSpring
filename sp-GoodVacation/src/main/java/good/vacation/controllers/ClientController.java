package good.vacation.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import good.vacation.dtos.ClientDto;
import good.vacation.enums.AccessLevel;
import good.vacation.models.Client;
import good.vacation.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/save")
	public ResponseEntity<Client> saveClient(@RequestBody ClientDto clientDto) {
		return new ResponseEntity<>((Client) this.clientService.saveClient(clientDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public List<Client> getAllClients() {			
		return this.clientService.getAllClients();
	}
	
	@PutMapping("/updateAccessLevel/{idUser}")
	public ResponseEntity<Client> updateAccessLevel(@PathVariable Long idUser, @RequestBody AccessLevel accessLevel) {		
		return ResponseEntity.ok(this.clientService.updateAccessLevel(idUser, accessLevel));
	}
	
	@PutMapping("/blockClient/{idUser}")
	public ResponseEntity<String> blockClient(@PathVariable Long idUser) {	
		this.clientService.blockClient(idUser);
		
		return new ResponseEntity<>("User successfully blocked!", HttpStatus.ACCEPTED);
	}
}
