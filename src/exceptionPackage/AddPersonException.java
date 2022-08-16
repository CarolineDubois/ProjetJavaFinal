package exceptionPackage;

public class AddPersonException extends Exception {

    public String getMessage() {
        return "Ajout d'une nouvelle personne impossible";
    }
}
