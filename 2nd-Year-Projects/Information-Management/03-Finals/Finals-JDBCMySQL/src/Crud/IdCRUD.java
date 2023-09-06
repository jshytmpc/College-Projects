package Crud;

import Connector.DatabaseConnector;
import Constructors.Id;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdCRUD {
    DatabaseConnector db = new DatabaseConnector();
    Connection connection = db.createConnection();

    public void creatId(Id id, int userid) {
        try {
            String query = "insert into id(portraitpic,gov_idno,gov_idpic,gov_idtype,userid) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setBlob(1,id.getPortraitPic());
            preparedStatement.setString(2,id.getGovIdNo());
            preparedStatement.setBlob(3,id.getGovIdPic());
            preparedStatement.setString(4,id.getGovIdType());
            preparedStatement.setInt(5,userid);

            int regUpdate = preparedStatement.executeUpdate();
            if(regUpdate > 0) {
                System.out.println();
                System.out.println("Successfully created ID");
                System.out.println();
            } else {
                System.out.println("Creation was Unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkGovId(String govId) {
        String q = "\"";
        String quoted = q+govId+q;
        try {
            String query = "Select gov_idno FROM id WHERE gov_idno =" + quoted;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

}
