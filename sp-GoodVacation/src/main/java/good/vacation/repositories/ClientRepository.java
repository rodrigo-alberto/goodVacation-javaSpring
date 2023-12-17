package good.vacation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import good.vacation.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}