package dataAccessPackage;

import exceptionPackage.ConnectionException;

public interface ConnectionInterface {
    void closeConnection () throws ConnectionException;
}
