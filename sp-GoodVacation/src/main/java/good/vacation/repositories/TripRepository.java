package good.vacation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import good.vacation.models.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{
	
}