package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PersonDBAccess implements PersonDataAccess {
    private Connection connection;

    public PersonDBAccess() throws ConnectionException {
        connection = SingletonConnection.getConnection();
    }

    @Override
    public void addPerson(Person person) throws AddPersonException {
        String sqlInstruction = "insert into person (identifier, firstName, lastName, middleName, street, streetNumber, birthDate, phoneNumber, isDisabled) values (?,?,?,?,?,?,?,?,?,?)";
        GregorianCalendar calendar = person.getBirthDate();
        java.sql.Date sqlDate = new Date(calendar.getTimeInMillis());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, person.getIdentifier());
            preparedStatement.setString(2, person.getFistName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getMiddleName());
            preparedStatement.setString(5, person.getStreet());
            preparedStatement.setInt(6, person.getStreetNumber());
            preparedStatement.setDate(7, sqlDate);
            preparedStatement.setInt(8, person.getPhoneNumber());
            preparedStatement.setBoolean(9, person.getIsDisable());
            preparedStatement.setInt(10, person.getIdentifierLocality());

            preparedStatement.executeUpdate();



        }
        catch(SQLException exception) {
            throw new AddPersonException();
        }
    }

    @Override
    public ArrayList<Person> getAllPerson() throws AllPersonException {
        String sqlInstruction = "select * from person";
        ArrayList<Person> allPerson = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();
            Person person;
            GregorianCalendar calendar;

            while (data.next()) {
                calendar = new GregorianCalendar();
                calendar.setTime(data.getDate("birthday"));
                person = new Person(
                        data.getInt("identifier"),
                        data.getString("firstName"),
                        data.getString("lastName"),
                        data.getString("middleName"),
                        data.getString("street"),
                        data.getInt("streetNumber"),
                        calendar,
                        data.getInt("phoneNumber"),
                        data.getBoolean("isDisable"),
                        data.getInt("identifierLocality")

            );

                allPerson.add(person);
            }


            return null;
        } catch (SQLException exception) {
            throw new AllPersonException();
        }
    }

    @Override
    public void updatePerson(Person person) throws UpdateException {
        GregorianCalendar calendar = person.getBirthDate();
        java.sql.Date sqlDate = new Date(calendar.getTimeInMillis());
        String sqlInstruction = "update person set " +
                "identifier = ?," +
                "firstName = ?, " +
                "lastName = ?, " +
                "middleName = ?, " +
                "street = ?, " +
                "streetNumber = ? " +
                "birthday = ?," +
                "phoneNumber = ? " +
                "isDisable = ?," +
                "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, person.getIdentifier());
            preparedStatement.setString(2, person.getFistName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getMiddleName());
            preparedStatement.setString(5, person.getStreet());
            preparedStatement.setInt(6, person.getStreetNumber());
            preparedStatement.setDate(7, sqlDate);
            preparedStatement.setInt(8, person.getPhoneNumber());
            preparedStatement.setBoolean(9, person.getIsDisable());
            preparedStatement.setInt(10, person.getIdentifierLocality());

            preparedStatement.executeUpdate();


        }
        catch(SQLException exception) {
            throw new UpdateException();
        }
    }

    @Override
    public void deletePerson(Person person) throws DeleteException {
        String sqlInstruction = "delete from person where identifier = ?";
        String findArticles = "delete from uniquePerson where person = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findArticles);
            preparedStatement.setInt(1, person.getIdentifier());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlInstruction);
            preparedStatement2.setInt(1, person.getIdentifier());
            preparedStatement2.executeUpdate();

        }
        catch(SQLException exception) {
            throw new DeleteException();
        }
    }
}
