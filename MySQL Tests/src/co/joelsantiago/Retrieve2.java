package co.joelsantiago;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 8/25/14
 * Time: 6:11 PM
 */
public class Retrieve2 {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        // Properties object to store database connection information
        Properties props = new Properties();
        // File input object
        FileInputStream in = null;

        try {
            // Read in database.properties file and load returned values into properties object
            in = new FileInputStream("database.properties");
            props.load(in);

        // Catch error if the file needed isn't located
        } catch (FileNotFoundException ex) {
            Logger lgr = Logger.getLogger(Retrieve2.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        // Catch error if an IO operation occurs
        } catch (IOException ex) {
            Logger lgr = Logger.getLogger(Retrieve2.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            // Close file input stream object
            try {
                if (in != null) {
                    in.close();
                }
            // Catch error if an IO operation occurs
            } catch (IOException ex) {
                Logger lgr = Logger.getLogger(Retrieve2.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        // Assign DB connection info into local variables from properties object
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String passwd = props.getProperty("db.passwd");

        try {

            // Database connection
            con = DriverManager.getConnection(url, user, passwd);

            // Prepared Query
            pst = con.prepareStatement("SELECT title AS BookTitle, name AS Author FROM Books LEFT JOIN Authors ON Books.author_id = Authors.id ORDER BY Author ASC");

            // Execute Query
            rs = pst.executeQuery();

            // Result output
            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(" by ");
                System.out.println(rs.getString(2));
            }

        // Catch SQL error
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Retrieve2.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            // Close all open connections
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Retrieve2.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}
