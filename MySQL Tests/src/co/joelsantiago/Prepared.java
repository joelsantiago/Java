package co.joelsantiago;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 8/25/14
 * Time: 3:09 PM
 */
public class Prepared {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;

        // Database connection information
        String url = "jdbc:mysql://localhost:8889/testdb";
        String user = "testuser";
        String password = "test123";

        try {

            // New author string to be entered into Authors table
            String author = "Trygve Gulbranssen";

            // Establish a connection to the database
            con = DriverManager.getConnection(url, user, password);

            // Create a prepared statement with the base query with necessary placeholders (?)
            // Useful against SQL injection
            pst = con.prepareStatement("INSERT INTO Authors(name) VALUES(?)");

            // Bind a value - author variable - to the placeholder
            pst.setString(1, author);

            // Execute the prepared statement with the inserted placeholder variable
            // Useful when not expecting any data to be returned
            pst.executeUpdate();

        // Catch exception and log to console
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Prepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            // Close database connection and resources
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            // Catch exception and log to console if resources couldn't be closed
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Prepared.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}
