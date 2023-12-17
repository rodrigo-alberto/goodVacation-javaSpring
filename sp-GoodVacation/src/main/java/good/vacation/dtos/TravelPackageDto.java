package good.vacation.dtos;

public class TravelPackageDto {
	
	private Long idUserClient;
	private Long idTrip;
	
	public Long getIdUserClient() {
		return idUserClient;
	}
	
	public void setIdUserClient(Long idUserClient) {
		this.idUserClient = idUserClient;
	}
	
	public Long getIdTrip() {
		return idTrip;
	}
	
	public void setIdTrip(Long idTrip) {
		this.idTrip = idTrip;
	}
}