package good.vacation.models;

import jakarta.persistence.Entity;

@Entity
public class CommonUser extends User { //Usuário não-cliente com nível de acesso instanciável;

	public CommonUser() {
	}
}
