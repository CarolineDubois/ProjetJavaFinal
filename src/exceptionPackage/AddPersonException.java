package exceptionPackage;

public class AddTypeException extends Exception {

    public String getMessage() {
        return "Ajout d'un nouveau type impossible";
    }
}
