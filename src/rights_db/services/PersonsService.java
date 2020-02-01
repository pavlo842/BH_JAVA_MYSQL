package rights_db.services;

import rights_db.dbManager.DbManager;
import rights_db.persons.Persons;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonsService {

    private static final String INSERT_NEW_PERSONS_QUERY =
            "insert into persons value (null, ?, default, ?, ?);";

    private static final String GET_ALL_PERSONS =
            "select * from persons;";

//    private static final String DELETE_PERSONS =
//            "DELETE FROM persons p WHERE p.persons_id = ?;";

    public void addNewPersons(String surname, String name, String patronimic) throws SQLException {
        Connection connection = DbManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_NEW_PERSONS_QUERY);
        statement.setString(1, surname);
        statement.setString(2, name);
        statement.setString(3, patronimic);

        statement.execute();
    }

    public List<Persons> getAllPersonsData() throws SQLException {

        Connection connection = DbManager.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(GET_ALL_PERSONS);
        List<Persons> resultList = new ArrayList<>();

        while (resultSet.next()) {
            int persons_id = resultSet.getInt(1);
            String surname = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String name = resultSet.getString(4);
            String patronimic = resultSet.getString(5);

            Persons persons = new Persons(persons_id, surname, age, name, patronimic);

            resultList.add(persons);
        }
        return resultList;
    }

    public void printAllPersonsData() throws SQLException {
        getAllPersonsData().forEach(System.out::println);
    }

//    public void deletPersons(int persons_id) throws SQLException {
//        Connection connection = DbManager.getConnection();
//        PreparedStatement statement = connection.prepareStatement(DELETE_PERSONS);
//    }

}
