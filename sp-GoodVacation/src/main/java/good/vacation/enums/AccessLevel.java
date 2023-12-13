package good.vacation.enums;

public enum AccessLevel {
	ADMIN_ACESS(1, "adm"),
	COMMON_ACCESS(2, "com"),
	BLOCKED_ACCESS(3, "blo");

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