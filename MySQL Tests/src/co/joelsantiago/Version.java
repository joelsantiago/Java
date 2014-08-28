package co.joelsantiago;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Version {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        // Database connection information
        String url = "jdbc:mysql://localhost:8889/testdb"; // Host, Port, DB name
        String user = "testuser";
        String password = "test123";

        try {

            // Establish a connection to the database
            con = DriverManager.getConnection(url, user, password);

            // Statement object creation for sending SQL queries
            st = con.createStatement();

            // Execute given query and place returned data into table
            rs = st.executeQuery("SELECT VERSION()");

            // Move cursor from before first row to first row, returns false if returned result is empty
            if (rs.next()) {
                // Retrieve and print value of specified column (First column = index 1)
                System.out.println(rs.getString(1));
            }

        // Catch exception and log to console
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            // Close database connection and resources
            try {
                // Check for non null objects to prevent null pointer exception
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            // Catch exception and log to console if resources couldn't be closed
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

    }
}
