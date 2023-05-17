package exceptionPackage;

public class ConnectionException extends Exception {

    private String message;

    public ConnectionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "La connexion à la base de données a échouée : " + message;
    }
}
