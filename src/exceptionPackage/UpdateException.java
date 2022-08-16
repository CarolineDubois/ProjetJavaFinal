package exceptionPackage;

public class UpdateException extends Exception {
    public String getMessage() {
        return "Erreur lors de la mise à jour de la personne";
    }
}
