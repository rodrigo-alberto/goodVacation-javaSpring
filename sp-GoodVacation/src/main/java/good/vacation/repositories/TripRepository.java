package good.vacation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import good.vacation.models.Trip;
import jakarta.transaction.Transactional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{
	
	@Transactional
	@Modifying
	@Query(nativeQuery= true, value= "INSERT INTO `travel_package` (`fk_client_user_id_user`, `fk_trip_id_trip`) VALUES (:idUserClient, :idTrip)")
	void createPackage(@Param("idUserClient") Long idUserClient, @Param("idTrip") Long idTrip);
	
}