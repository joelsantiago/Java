package co.joelsantiago;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 8/25/14
 * Time: 3:48 PM
 */
public class NotPrepared {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        // Database connection information
        String url = "jdbc:mysql://localhost:8889/testdb";
        String user = "testuser";
        String password = "test123";

        try {

            // Establish a connection to the database
            con = DriverManager.getConnection(url, user, password);

            // Statement object creation for sending SQL queries
            st = con.createStatement();

            // Loop through values and insert into table
            for (int i = 1; i <= 1000; i++) {

                // Create query with calculated values
                String query = "INSERT INTO Testing(id) VALUES (" + 2 * i + ")";

                // Execute query
                st.executeUpdate(query);
            }
        // Catch exception and log to console
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(NotPrepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(NotPrepared.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}
