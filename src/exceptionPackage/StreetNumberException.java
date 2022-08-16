package exceptionPackage;

public class StreetNumberException extends Exception {
    public String getMessage() {
        return "Numéro de la rue incorrecte (négatif)";}
}
