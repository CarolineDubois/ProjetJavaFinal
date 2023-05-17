package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;

public class PersonDBAccess implements PersonInterface {

    public PersonDBAccess(){
    }

    @Override
    public void addPerson(Person person) throws AddDataException, ConnectionException {
        String sqlInstruction = "insert into person (firstName, lastName, middleName, street, streetNumber, birthDate, phoneNumber, isDisabled, identifierLocality) values (?,?,?,?,?,?,?,?,?)";
        java.sql.Date sqlDate = java.sql.Date.valueOf(person.getBirthDate());

        try {
            PreparedStatement preparedStatement = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            preparedStatement.setString(1, person.getFistName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getMiddleName());
            preparedStatement.setString(4, person.getStreet());
            preparedStatement.setInt(5, person.getStreetNumber());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setString(7, person.getPhoneNumber());
            preparedStatement.setBoolean(8, person.getIsDisable());
            preparedStatement.setInt(9, person.getIdentifierLocality());


            preparedStatement.executeUpdate();

        }
        catch(SQLException exception) {
            throw new AddDataException(exception.getMessage(), "personne");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }

    @Override
    public ArrayList<Person> getAllPerson() throws GetDataException, ConnectionException {
        String sqlInstruction = "select * from person";
        ArrayList<Person> allPerson = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();
            Person person;

            while (data.next()) {
                person = new Person(
                        data.getInt("identifier"),
                        data.getString("firstName"),
                        data.getString("lastName"),
                        null,
                        data.getString("street"),
                        data.getInt("streetNumber"),
                        null,
                        null,
                        data.getBoolean("isDisabled"),
                        data.getInt("identifierLocality")

            );
                Date birthDate = data.getDate("birthDate");
                if(!data.wasNull()){
                    person.setBirthDate(birthDate.toLocalDate());
                }
                String middleName = data.getString("middleName");
                if(!data.wasNull()){
                    person.setMiddleName(middleName);
                }
                String phoneNumber = data.getString("phoneNumber");
                if(!data.wasNull()){
                    person.setPhoneNumber(phoneNumber);
                }
                
                allPerson.add(person);
            }


            return allPerson;
        } catch(SQLException exception) {
            throw new GetDataException(exception.getMessage(), "personne");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }

    @Override
    public void updatePerson(Person person) throws UpdateDataException, ConnectionException {
        java.sql.Date sqlDate = java.sql.Date.valueOf(person.getBirthDate());
        String sqlInstruction = "UPDATE person " +
                "SET firstName = ?, " +
                "    lastName = ?, " +
                "    middleName = ?, " +
                "    street = ?, " +
                "    streetNumber = ?, " +
                "    birthDate = ?, " +
                "    phoneNumber = ?, " +
                "    isDisabled = ?, " +
                "    identifierLocality = ? " +
                "WHERE identifier = ?;";



        try {
            PreparedStatement preparedStatement = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            preparedStatement.setString(1, person.getFistName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getMiddleName());
            preparedStatement.setString(4, person.getStreet());
            preparedStatement.setInt(5, person.getStreetNumber());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setString(7, person.getPhoneNumber());
            preparedStatement.setBoolean(8, person.getIsDisable());
            preparedStatement.setInt(9, person.getIdentifierLocality());
            preparedStatement.setInt(10, person.getIdentifier());



            preparedStatement.executeUpdate();


        }
        catch(SQLException exception) {
            throw new UpdateDataException(exception.getMessage(), "personne");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }

    @Override
    public void deletePerson(Person person) throws DeleteDataException, ConnectionException {
        String sqlInstruction = "delete from person where identifier = ?";

        try {

            PreparedStatement preparedStatement2 = SingletonConnection.getConnection().prepareStatement(sqlInstruction);
            preparedStatement2.setInt(1, person.getIdentifier());
            preparedStatement2.executeUpdate();

        }
        catch(SQLException exception) {
            throw new DeleteDataException(exception.getMessage(), "personne");
        } catch (ConnectionException exception){
            throw new ConnectionException(exception.getMessage());
        }
    }
}
