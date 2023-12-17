package good.vacation.dtos;

import java.time.LocalDate;
import good.vacation.enums.AccessLevel;
import good.vacation.enums.Sex;

public class ClientDto {
	
	//Dados gerais da classe 'User';
	private String name;
	private String email;
	private String password;
//	private byte[] profilePicture;
	private AccessLevel accessLevel;
	
	//Dados específicos da classe 'Client';
	private LocalDate dateBirth;
	private String cpf;
	private Sex sex;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
//	public byte[] getProfilePicture() {
//		return profilePicture;
//	}
//	
//	public void setProfilePicture(byte[] profilePicture) {
//		this.profilePicture = profilePicture;
//	}
	
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public LocalDate getDateBirth() {
		return dateBirth;
	}
	
	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Sex getSex() {
		return sex;
	}
	
	public void setSex(Sex sex) {
		this.sex = sex;
	}
}