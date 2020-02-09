package rights_db.services;

import rights_db.dbManager.DbManager;
import rights_db.rights.Rights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RightsService {
    private static final String INSERT_NEW_RIGHTS_QUERY =
            "insert into rights value (null, ?, ?, ?)";

    private static final String GET_ALL_RIGHTS =
            "select * from rights;";

    private static final String DELETE_RIGHTS =
            "DELETE FROM rights r WHERE r.right_id = ?;";

    public void addNewRights(String right_type, String start_date, String end_date) throws SQLException {
        Connection connection = DbManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_NEW_RIGHTS_QUERY);
        statement.setString(1, right_type);
        statement.setString(2, String.valueOf(start_date));
        statement.setString(3, String.valueOf(end_date));

        statement.execute();
    }

    public List<Rights> getAllRightsData() throws SQLException {

        Connection connection = DbManager.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(GET_ALL_RIGHTS);
        List<Rights> resultList = new ArrayList<>();

        while (resultSet.next()) {
            int right_id = resultSet.getInt(1);
            String right_type = resultSet.getString(2);
            java.util.Date start_date = resultSet.getDate(3);
            java.util.Date end_date = resultSet.getDate(4);

            Rights rights = new Rights(right_id, right_type, start_date, end_date);

            resultList.add(rights);
        }
        return resultList;
    }

    public void printAllRightsData() throws SQLException {
        getAllRightsData().forEach(System.out::println);
    }

    public void deleteRights(int right_id) throws SQLException {
        Connection connection = DbManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_RIGHTS);
        statement.setInt(1, right_id);

        statement.execute();
    }
}
