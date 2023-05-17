package exceptionPackage;

public class DeleteDataException extends Exception{
    private String message;
    private String data;

    public DeleteDataException(String message, String data) {
        this.message = message;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return "Erreur lors de la suppression de " + data + " dans la base de données : \n" + message;
    }
}
