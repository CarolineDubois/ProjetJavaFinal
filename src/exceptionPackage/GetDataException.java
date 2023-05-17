package exceptionPackage;

public class GetDataException extends Exception{
    private String message;
    private String data;

    public GetDataException(String message, String data) {
        this.message = message;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return "Erreur lors de la lecture de " + data + " dans la base de données : \n" + message;
    }
}

