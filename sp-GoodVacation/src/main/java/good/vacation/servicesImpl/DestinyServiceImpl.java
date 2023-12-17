package good.vacation.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import good.vacation.dtos.DestinyDto;
import good.vacation.enums.SystemAlerts;
import good.vacation.models.Destiny;
import good.vacation.repositories.DestinyRepository;
import good.vacation.services.DestinyService;

@Service
public class DestinyServiceImpl implements DestinyService {

	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private DestinyRepository destinyRepo;
	
	@Override
	public Object saveObject(Object object)  {
		Destiny savedDestiny = mp.map(object, Destiny.class);
		
		this.destinyRepo.save(savedDestiny);
		SystemAlerts.printSuccess(SystemAlerts.SAVED_SUCCESSFULLY);
	
		return savedDestiny;
	}

	@Override
	public Object getObjectById(Long id) {
		return this.destinyRepo.findById(id).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
	}

	@Override
	public List<Object> getAllObjects() {
		return new ArrayList<>(this.destinyRepo.findAll());
	}

	@Override
	public Object updateObject(Long id, Object updatedObject) {
		Destiny existingDestiny = this.destinyRepo.findById(id).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
		DestinyDto updatedDestinationDto = (DestinyDto) updatedObject;
	
		existingDestiny.setName(updatedDestinationDto.getName());
		existingDestiny.setImagesUrl(updatedDestinationDto.getImagesUrl());
		existingDestiny.setCity(updatedDestinationDto.getCity());	
	
		return this.destinyRepo.save(existingDestiny);
	}

	@Override
	public void deleteObjectById(Long id) {
		this.destinyRepo.findById(id).orElseThrow(() -> SystemAlerts.printRuntimeEx(SystemAlerts.ID_NOT_FOUND));
		this.destinyRepo.deleteById(id);
	}
}