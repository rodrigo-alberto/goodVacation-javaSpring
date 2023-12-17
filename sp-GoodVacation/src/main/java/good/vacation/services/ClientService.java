package good.vacation.services;

import java.util.List;

import good.vacation.dtos.ClientDto;
import good.vacation.enums.AccessLevel;
import good.vacation.models.Client;

public interface ClientService {
	
	Client saveClient(ClientDto clientDto);
	
	List<Client> getAllClients();
	
	Client updateAccessLevel(Long idUser, AccessLevel accessLevel);
	
	Client blockClient(Long idUser);

}
