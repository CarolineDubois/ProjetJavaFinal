package exceptionPackage;

public class ConnectionException extends Exception {

    public String getMessage() {
        return "La connexion à la base de données a échouée";
    }
}
