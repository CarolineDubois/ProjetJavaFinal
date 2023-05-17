package dataAccessPackage;

import exceptionPackage.ConnectionException;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDBAccess implements ConnectionInterface {
    @Override
    public void closeConnection() throws ConnectionException {
        Connection uniqueConnection =  SingletonConnection.getConnection();
        if (uniqueConnection != null) {
            try {
                uniqueConnection.close();
            } catch (SQLException exception) {
                throw new ConnectionException(exception.getMessage());
            }
        }
    }
}
