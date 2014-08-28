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
 * Time: 1:56 PM
 */
public class Transaction {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        String url = "jdbc:mysql://localhost:8889/testdb";
        String user = "testuser";
        String password = "test123";

        try {

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // Turn autocommit off, default is true, prevents queries from executing immediately
            con.setAutoCommit(false);

            st.executeUpdate("UPDATE Authors SET name = 'Leo Tolstoy' "
                    + "WHERE Id = 1");
            st.executeUpdate("UPDATE Books SET title = 'War and Peace' "
                    + "WHERE Id = 1");
            st.executeUpdate("UPDATE Books SET title = 'Anna Karenina' "
                    + "WHERE Id = 2");

            // Commit queries all together
            con.commit();

        // If there is an SQL exception
        } catch (SQLException ex) {

            if (con != null) {
                try {
                    // Rollback the transactions and commit no changes to DB
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger lgr = Logger.getLogger(Transaction.class.getName());
                    lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
            }

            Logger lgr = Logger.getLogger(Transaction.class.getName());
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
                Logger lgr = Logger.getLogger(Transaction.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
