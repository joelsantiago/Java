package co.joelsantiago;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 8/25/14
 * Time: 4:52 PM
 */
public class Retrieve {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:8889/testdb";
        String user = "testuser";
        String password = "test123";

        try {

            // Database connection information
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("SELECT * FROM Books");
            rs = pst.executeQuery();

            // Loop through result set and format output
            while (rs.next()) {
                // Print id number
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                // Print out Book title
                System.out.println(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Retrieve.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

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
                Logger lgr = Logger.getLogger(Retrieve.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}
