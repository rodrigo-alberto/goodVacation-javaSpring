package good.vacation.enums;

public enum SystemAlerts {
	NOT_NULL_PROPERTY("Referência nula associada a uma propriedade não nula!"),
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
  
//    public static Exception printException(SystemAlerts alert, Exception ex) {
//    	return new Exception("\n\n # Alerta: "+ alert.message + " #\n\n"+ex);
//    }
    
    public static void printSuccess(SystemAlerts alert) {
    	System.out.println("\n\n # "+ alert.message + " #\n");
    }
}