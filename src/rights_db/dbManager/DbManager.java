package rights_db.dbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    private static final String DATABASE_URL =
            "jdbc:mysql://localhost:3306/bh_java_mysql?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "papa0807";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
