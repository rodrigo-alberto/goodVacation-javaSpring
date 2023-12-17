package good.vacation.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import good.vacation.enums.Sex;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client_user")
public class Client extends User {

	@Column(name = "date_birth", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateBirth;
	
	@Column(nullable = false, length = 14, unique = true)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Sex sex;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "travel_package",
	joinColumns = @JoinColumn(name = "fk_clientUser_idUser"),
	inverseJoinColumns = @JoinColumn(name = "fk_trip_idTrip"))
	private Set<Trip> trips = new HashSet<>();
	
	public Client() {
	}	

	public Client(LocalDate dateBirth, String cpf, Sex sex, Set<Trip> trips) {
		this.dateBirth = dateBirth;
		this.cpf = cpf;
		this.sex = sex;
		this.trips = trips;
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

	public Set<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
}