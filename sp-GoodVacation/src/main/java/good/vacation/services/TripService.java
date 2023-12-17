package good.vacation.services;

public interface TripService extends GenericCrudService { //Inserir update do status da viagem p/ restrição;
	
	void createPackage(Long idUserClient, Long idTrip);
	
//	List<Object> getAllPackages();
	
}
