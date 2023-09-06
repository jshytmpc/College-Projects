package Crud;

import Connector.DatabaseConnector;
import Constructors.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationCRUD {
    DatabaseConnector db = new DatabaseConnector();
    Connection connection = db.createConnection();
    public void createPhoneNo(Registration registration, int userid) {
        try {
            String query = "INSERT INTO registration(phoneno,ownership,userid,network) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,registration.getPhoneNumber());
            preparedStatement.setString(2,registration.getOwnership());
            preparedStatement.setInt(3,userid);
            preparedStatement.setString(4,registration.getNetwork());
            System.out.println("Successfully Registered Phone number");
            System.out.println();
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error: Registration was unsuccessful");
        }
    }

    public boolean checkPhoneNumber(long phoneno) {
        try {
            String query = "Select phoneno FROM registration WHERE phoneno =" + phoneno;
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

    public void updateOwner(String owner, int userid) {
        try {
            String query = "update registration set ownership = ? WHERE userid = ?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query);
            preparedStatement2.setString(1,owner);
            preparedStatement2.setInt(2,userid);
            int regUpdate = preparedStatement2.executeUpdate();
            if(regUpdate > 0) {
                System.out.println();
                System.out.println("Successfully Updated User");
                System.out.println();
            } else {
                System.out.println("Update was Unsuccessful");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
