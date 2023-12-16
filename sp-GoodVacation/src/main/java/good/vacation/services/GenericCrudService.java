package good.vacation.services;

import java.util.List;

public interface GenericCrudService {
	Object saveObject(Object object);
	
	List<Object> getAllObjects();
	
	Object getObjectById(Long id);
	
	Object updateObject(Long id, Object updatedObject);
	
	void deleteObjectById(Long id);
}