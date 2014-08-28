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
 * Date: 8/26/14
 * Time: 1:03 AM
 */
public class Multiple {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        // Database connection info with new allowMultiQueries argument
        String url = "jdbc:mysql://localhost:8889/testdb?allowMultiQueries=true";
        String user = "testuser";
        String passwd = "test123";

        try {

            con = DriverManager.getConnection(url, user, passwd);

            // Multi SQL statement string
            String query = "SELECT id, name FROM Authors WHERE id = 1;"
                    + "SELECT id, name FROM Authors WHERE id = 2;"
                    + "SELECT id, name FROM Authors WHERE id = 3";

            // PreparedStatement object created with multi-statement query
            pst = con.prepareStatement(query);

            // Execute when true
            boolean isResult = pst.execute();

            do {

                // Get first results
                rs = pst.getResultSet();

                // Print query output
                while (rs.next()) {
                    System.out.print(rs.getInt(1));
                    System.out.print(": ");
                    System.out.println(rs.getString(2));
                }

                // getMoreResults returns true if next result is a ResultSet object
                isResult = pst.getMoreResults();

            // Continues as long as a new ResultSet is available from the query results
            } while (isResult);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Multiple.class.getName());
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
                Logger lgr = Logger.getLogger(Multiple.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
