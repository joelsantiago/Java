package co.joelsantiago;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 8/26/14
 * Time: 1:20 PM
 */
public class WriteImage {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;
        FileInputStream fin = null;

        String url = "jdbc:mysql://localhost:8889/testdb";
        String user = "testuser";
        String password = "test123";

        try {

            // Read image file into file object and read it with FileInputStream
            File img = new File("intellij.png");
            fin = new FileInputStream(img);

            con = DriverManager.getConnection(url, user, password);

            // Image insertion query
            pst = con.prepareStatement("INSERT INTO Images(data) VALUES(?)");
            // Convert the image into DB compatible binary data
            pst.setBinaryStream(1, fin, (int) img.length());
            // Execute query
            pst.executeUpdate();

        } catch (FileNotFoundException ex) {
            Logger lgr = Logger.getLogger(WriteImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(WriteImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
                if (fin != null) {
                    fin.close();
                }

            } catch (IOException ex) {
                Logger lgr = Logger.getLogger(WriteImage.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(WriteImage.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
