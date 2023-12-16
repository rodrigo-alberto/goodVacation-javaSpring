package good.vacation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import good.vacation.models.Destiny;

@Repository
public interface DestinyRepository extends JpaRepository<Destiny, Long>{

}