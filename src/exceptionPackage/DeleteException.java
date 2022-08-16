package exceptionPackage;

public class DeleteException extends Exception{
    public String getMessage() {
        return "Suppression de la personne impossible";
    }
}
