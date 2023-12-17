package good.vacation.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import good.vacation.dtos.ClientDto;
import good.vacation.enums.AccessLevel;
import good.vacation.enums.SystemAlerts;
import good.vacation.models.Client;
import good.vacation.repositories.ClientRepository;
import good.vacation.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public Client saveClient(ClientDto clientDto) {
		Client savedClient = mp.map(clientDto, Client.class);
		
		this.clientRepo.save(savedClient);
		SystemAlerts.printSuccess(SystemAlerts.SAVED_SUCCESSFULLY);
	
		return savedClient;
	}

	@Override
	public List<Client> getAllClients() {
		return new ArrayList<>(this.clientRepo.findAll());
	}

	@Override
	public Client updateAccessLevel(Long idUser, AccessLevel accessLevel) {
		Client existingClient = this.clientRepo.findById(idUser).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
		
		existingClient.setAccessLevel(accessLevel);
		
		return this.clientRepo.save(existingClient);
	}

	@Override
	public Client blockClient(Long idUser) {
		Client existingClient = this.clientRepo.findById(idUser).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
		
		existingClient.setAccessLevel(AccessLevel.BLOCKED_ACCESS);
		
		return this.clientRepo.save(existingClient);
	}
}