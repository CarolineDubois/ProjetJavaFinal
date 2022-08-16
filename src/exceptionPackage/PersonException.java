package exceptionPackage;

public class PersonException extends Exception {
    public String getMessage() {
        return "Récupération de la personne impossible";
    }
}
