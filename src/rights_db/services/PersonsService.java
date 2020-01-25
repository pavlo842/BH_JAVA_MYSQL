package rights_db.services;

import rights_db.dbManager.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonsService {

    private static final String INSERT_NEW_PERSONS_QUERY =
            "insert into persons value (null, ?, default, ?, ?);";

    private DbManager dbManager;

    public PersonsService() throws SQLException {
        this.dbManager = new DbManager();
    }

    public void addNewPersons(String surname, String name, String patronimic) throws SQLException {
        Connection connection = dbManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_NEW_PERSONS_QUERY);
        statement.setString(1, surname);
        statement.setString(2, name);
        statement.setString(3, patronimic);

        statement.execute();
    }
}
