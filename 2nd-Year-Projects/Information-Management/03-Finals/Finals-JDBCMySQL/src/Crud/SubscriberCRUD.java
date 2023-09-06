package Crud;

import Connector.DatabaseConnector;
import Constructors.Subscriber;

import java.sql.*;

public class SubscriberCRUD {

    DatabaseConnector db = new DatabaseConnector();
    Connection connection = db.createConnection();


    public void createSubscriberInfo(Subscriber subscriber) {
        java.util.Date javaDate = new java.util.Date(subscriber.getBirthday());
        java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());
        try {
            String query = "insert into subscriber(firstname,lastname,middlename,suffix,birthday,sex,nationality,province,city,unit,street,barangay,zipcode) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,subscriber.getFirstname());
            preparedStatement.setString(2,subscriber.getLastname());
            preparedStatement.setString(3,subscriber.getMiddlename());
            preparedStatement.setString(4,subscriber.getSuffix());
            preparedStatement.setDate(5,mySQLDate);
            preparedStatement.setString(6,subscriber.getSex());
            preparedStatement.setString(7,subscriber.getNationality());
            preparedStatement.setString(8,subscriber.getProvince());
            preparedStatement.setString(9,subscriber.getCity());
            preparedStatement.setInt(10,subscriber.getUnit());
            preparedStatement.setString(11,subscriber.getStreet());
            preparedStatement.setString(12,subscriber.getBarangay());
            preparedStatement.setInt(13,subscriber.getZipcode());
            int regUpdate = preparedStatement.executeUpdate();
            if(regUpdate > 0) {
                System.out.println();
                System.out.println("Successfully Created User");
                System.out.println();
            } else {
                System.out.println("Creation was Unsuccessful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean checkUserId(int userid) {
        try {
            String query = "Select userid FROM subscriber WHERE userid =" + userid;
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


    public int get() {
        DatabaseConnector db = new DatabaseConnector();
        Connection connection = db.createConnection();
        try {
            String query = "SELECT * FROM subscriber ORDER BY userid DESC LIMIT 1";
            PreparedStatement prepStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("Could not retrieve data");
        }
        return -1;
    }

    public void read() {
        DatabaseConnector db = new DatabaseConnector();
        Connection connection = db.createConnection();

        try {
            String line= "-";
            String query = "SELECT registration.dates, registration.userid, registration.phoneno, registration.ownership, firstname, lastname, middlename, suffix, birthday, sex, nationality, province, city, unit, street, barangay, zipcode FROM subscriber INNER JOIN registration ON registration.userid = subscriber.userid";
            PreparedStatement prepStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepStatement.executeQuery();


            System.out.println();
            System.out.println("+" + line.repeat(298)+"+");
            System.out.printf("| %3s %-25s %-10s %-15s %-15s %-15s %-15s %-15s %-12s %-15s %-10s %-20s %-20s %-20s %-15s %-20s %-20s %-15s| \n",
                    "","Date | Timestamp","Userid","PhoneNumber","Ownership","Firstname","Lastname","Middlename","Suffix","Birthday","Sex","Nationality","Province","City","Unit","Street","Barangay","Zipcode");
            System.out.println("+" + line.repeat(298)+"+");

            while(resultSet.next()) {
                System.out.printf("| %3s %-25s %-10s %-15s %-15s %-15s %-15s %-15s %-12s %-15s %-10s %-20s %-20s %-20s %-15s %-20s %-20s %-15s| \n", "",resultSet.getString(1) , resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),
                        resultSet.getString(13),resultSet.getString(14),resultSet.getString(15),resultSet.getString(16),resultSet.getString(17));
            }
            System.out.println("+" + line.repeat(298)+"+");
            System.out.println();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Can't Read Data");
        }
    }

    public void update(Subscriber subscriber, int usernid) {
        java.util.Date javaDate = new java.util.Date(subscriber.getBirthday());
        java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());
        try {
            String query = "update subscriber set firstname = ?, lastname = ?, middlename = ?, suffix = ?, birthday = ?, sex = ?, nationality = ?, province = ?, city = ?, unit = ?, street = ?, barangay = ?, zipcode = ? WHERE userid = ?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query);
            preparedStatement2.setString(1,subscriber.getFirstname());
            preparedStatement2.setString(2,subscriber.getLastname());
            preparedStatement2.setString(3,subscriber.getMiddlename());
            preparedStatement2.setString(4,subscriber.getSuffix());
            preparedStatement2.setDate(5,mySQLDate);
            preparedStatement2.setString(6,subscriber.getSex());
            preparedStatement2.setString(7,subscriber.getNationality());
            preparedStatement2.setString(8,subscriber.getProvince());
            preparedStatement2.setString(9,subscriber.getCity());
            preparedStatement2.setInt(10,subscriber.getUnit());
            preparedStatement2.setString(11,subscriber.getStreet());
            preparedStatement2.setString(12,subscriber.getBarangay());
            preparedStatement2.setInt(13,subscriber.getZipcode());
            preparedStatement2.setInt(14,usernid);
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


    public void delete(int usernid) {
        try {
            String query = "delete from subscriber WHERE userid = ?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query);
            preparedStatement2.setInt(1,usernid);
            int regUpdate = preparedStatement2.executeUpdate();
            if(regUpdate > 0) {
                System.out.println();
                System.out.println("Successfully Deleted User");
                System.out.println();
            } else {
                System.out.println("Deletion was Unsuccessful");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }





}
