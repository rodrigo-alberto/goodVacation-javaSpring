package good.vacation.enums;

public enum SystemAlerts {
	ID_NOT_FOUND("ID não encontrado!"),
	DEPENDENCY_ID_NOT_FOUND("ID do objeto relacionado não encontrado!"),
	SAVED_SUCCESSFULLY("Objeto salvo com sucesso!");
	
	private final String message;
	
    private SystemAlerts(String message) {
		this.message = message;
	}
    
    public static RuntimeException printRuntimeEx(SystemAlerts alert) {
    	return new RuntimeException("## Alerta: "+ alert.message + " ##\n");
    }
    
    public static void printSuccess(SystemAlerts alert) {
    	System.out.println("\n\n # "+ alert.message + " #\n");
    }
}