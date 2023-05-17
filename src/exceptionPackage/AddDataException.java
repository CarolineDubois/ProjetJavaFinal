package exceptionPackage;

public class AddDataException extends Exception{

    private String message;
    private String data;

    public AddDataException(String message, String data) {
        this.message = message;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return "Erreur lors de l'ajout " + data + " dans la base de données : \n" + message;
    }
}
