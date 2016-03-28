package Model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;

/**
 * Created by Milena on 27.03.2016.
 * connetion base tool
 */
public class DBworker {
    private final String url = "jdbc:mysql://localhost:3306/insurance";
    private final String username = "root";
    private final String password = "root";
    private Connection connection;
    private Statement statement;


    public DBworker(){
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnetion(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return set of insurances by condition
     * @param condition required condition
     * @return set of insurances
     */
    public ResultSet selectEntries(String condition){
        String query = "SELECT * FROM insurances " + condition+";";
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BigDecimal aggrValue(String value){
        String query = "SELECT "+value+" FROM insurances;";
        try {
            ResultSet res = statement.executeQuery(query);
            res.next();
            return res.getBigDecimal(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Insert value to deriativ
     */

    public void insertValue(String subject, int risk, BigDecimal payout){
        String query = "INSERT INTO insurances(subject, risk, payout) VALUES( ?, ?, ?);";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, subject);
            preparedStmt.setInt (2, risk);
            preparedStmt.setBigDecimal (3, payout);
            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete value from deriativ
     */

    public void deleteValue(int id){
        String query = "DELETE FROM insurances WHERE id =?;";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, id);
            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
