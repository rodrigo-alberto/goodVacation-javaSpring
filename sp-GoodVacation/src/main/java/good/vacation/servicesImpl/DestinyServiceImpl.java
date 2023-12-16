package good.vacation.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import good.vacation.models.Destiny;
import good.vacation.repositories.DestinyRepository;
import good.vacation.services.DestinyService;

@Service
public class DestinyServiceImpl implements DestinyService {

	@Autowired
	private DestinyRepository destinyRepo;
	
	@Override
	public Object saveObject(Object object) {
		this.destinyRepo.save((Destiny) object);
		return object;
	}

	@Override
	public List<Object> getAllObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObjectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateObject(Long id, Object updatedObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteObjectById(Long id) {
		// TODO Auto-generated method stub
		
	}
}