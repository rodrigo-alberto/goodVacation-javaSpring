package good.vacation.enums;

public enum AccessLevel {
	ADMIN_ACESS(1, "admin"),
	COMMON_ACCESS(2, "common"),
	BLOCKED_ACCESS(3, "blocked");

	private final int cod;
	private final String name;

	private AccessLevel(int cod, String name) {
		this.cod = cod;
		this.name = name;
	}

	public int getCod() {
		return cod;
	}
	
	public String getName() {
		return name;
	}
}