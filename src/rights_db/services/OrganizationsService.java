package rights_db.services;

import rights_db.dbManager.DbManager;
import rights_db.organizations.Organizations;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrganizationsService {
    private static final String INSERT_NEW_ORGANIZATIONS_QUERY =
            "insert into organizations value (null, ?, ?, ?);";

    private static final String GET_ALL_ORGANIZATIONS =
            "select * from organizations;";

    public void addNewOrganizations(String name_org, int utn, String start_date) throws SQLException {
        Connection connection = DbManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_NEW_ORGANIZATIONS_QUERY);
        statement.setString(1, name_org);
        statement.setInt(2, utn);
        statement.setString(3, String.valueOf(start_date));

        statement.execute();
    }

    public List<Organizations> getAllOrganizationsData() throws SQLException {

        Connection connection = DbManager.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(GET_ALL_ORGANIZATIONS);
        List<Organizations> resultList = new ArrayList<>();

        while (resultSet.next()) {
            int org_id = resultSet.getInt(1);
            String name_org = resultSet.getString(2);
            int utn = resultSet.getInt(3);
            java.util.Date start_date = resultSet.getDate(4);

            Organizations organizations = new Organizations(org_id, name_org, utn, start_date);

            resultList.add(organizations);
        }
        return resultList;
    }

    public void printAllOrganizationsData() throws SQLException {
        getAllOrganizationsData().forEach(System.out::println);
    }
}
