package co.joelsantiago;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 8/26/14
 * Time: 1:39 PM
 */
public class ReadImage {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pst = null;
        FileOutputStream fos = null;

        String url = "jdbc:mysql://localhost:8889/testdb";
        String user = "testuser";
        String password = "test123";

        try {

            con = DriverManager.getConnection(url, user, password);

            String query = "SELECT Data FROM Images LIMIT 1";
            pst = con.prepareStatement(query);

            ResultSet result = pst.executeQuery();
            result.next();

            // Create output stream object for image to be written to with new name
            fos = new FileOutputStream("intellij-alt.png");

            // Get the image data from the data column
            Blob blob = result.getBlob("data");

            // Find length (number of bytes)
            int len = (int) blob.length();

            // Retrieves bytes in form of array
            byte[] buf = blob.getBytes(1, len);

            // Bytes are written to the output stream and image is created
            fos.write(buf, 0, len);

        } catch (IOException ex) {
            Logger lgr = Logger.getLogger(ReadImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(ReadImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger lgr = Logger.getLogger(ReadImage.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ReadImage.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
