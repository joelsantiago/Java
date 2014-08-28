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
 * Time: 2:18 PM
 */
public class BatchUpdate {

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

            // Start batch statement using addBatch to add a new command
            st.addBatch("DELETE FROM Authors");
            st.addBatch("INSERT INTO Authors(id, name) VALUES(1, 'Jack London')");
            st.addBatch("INSERT INTO Authors(id, name) VALUES(2, 'Honore de Balzac')");
            st.addBatch("INSERT INTO Authors(id, name) VALUES(3, 'Lion Feuchtwanger')");
            st.addBatch("INSERT INTO Authors(id, name) VALUES(4, 'Emile Zola')");
            st.addBatch("INSERT INTO Authors(id, name) VALUES(5, 'Truman Capote')");
            st.addBatch("INSERT INTO Authors(id, name) VALUES(6, 'Umberto Eco')");

            // Execute batch statement returning an array of changes
            int counts[] = st.executeBatch();

            // Commit updates
            con.commit();

            // Display change count
            System.out.println("Committed " + counts.length + " updates");

        } catch (SQLException ex) {

            if (con != null) {
                // Rollback if an exception is thrown
                try {
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger lgr = Logger.getLogger(BatchUpdate.class.getName());
                    lgr.log(Level.WARNING, ex1.getMessage(), ex1);
                }
            }

            Logger lgr = Logger.getLogger(BatchUpdate.class.getName());
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
                Logger lgr = Logger.getLogger(BatchUpdate.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
