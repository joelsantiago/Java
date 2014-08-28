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
 * Date: 8/26/14
 * Time: 2:13 PM
 */
public class Update {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        String url = "jdbc:mysql://localhost:8889/testdb";
        String user = "testuser";
        String password = "test123";

        try {

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            st.executeUpdate("UPDATE Authors SET Name = 'Leo Tolstoy' "
                    + "WHERE Id = 1");
            st.executeUpdate("UPDATE Books SET Title = 'War and Peace' "
                    + "WHERE Id = 1");
            st.executeUpdate("UPDATE Books SET Title = 'Anna Karenina' "
                    + "WHERE Id = 2");

            con.close();

            // Same as before except no transaction rollback in case of error
            // Queries are allowed to go to database despite error being thrown

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Update.class.getName());
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

                Logger lgr = Logger.getLogger(Update.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
