package exceptionPackage;

public class UpdateDataException extends Exception{
    private String message;
    private String data;

    public UpdateDataException(String message, String data) {
        this.message = message;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return "Erreur lors de la modification de " + data + " dans la base de données : \n" + message;
    }
}
