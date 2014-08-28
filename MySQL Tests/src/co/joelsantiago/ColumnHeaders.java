package co.joelsantiago;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 8/26/14
 * Time: 12:27 PM
 */
public class ColumnHeaders {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:8889/testdb";
        String user = "testuser";
        String passwd = "test123";

        try {

            con = DriverManager.getConnection(url, user, passwd);
            String query = "SELECT name, title FROM Authors, " +
                    "Books WHERE Authors.id=Books.author_id";
            pst = con.prepareStatement(query);

            rs = pst.executeQuery();

            // Get column names from results
            ResultSetMetaData meta = rs.getMetaData();

            // Assign column names to local variables
            String colname1 = meta.getColumnName(1);
            String colname2 = meta.getColumnName(2);

            // Object to format output into 2 columns
            Formatter fmtl = new Formatter();
            fmtl.format("%-21s%s", colname1, colname2);
            System.out.println(fmtl);

            // Print formatted output
            while (rs.next()) {
                Formatter fmt2 = new Formatter();
                fmt2.format("%-21s", rs.getString(1));
                System.out.print(fmt2);
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(ColumnHeaders.class.getName());
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
                Logger lgr = Logger.getLogger(ColumnHeaders.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}
