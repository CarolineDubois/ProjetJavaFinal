package exceptionPackage;

public class AllPersonException extends Exception {

    public String getMessage() {
        return "Récupération de la liste des personnes impossible";
    }
}
