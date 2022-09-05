import java.sql.*;
import javax.swing.*;

public class DBTest {
    public String checkLoginCredentials(String uName, String uPass) {
        try {
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con
                    .prepareStatement("SELECT * FROM employee WHERE LogIn_Username = ? AND LogIn_Password = ?");
            stmt.setString(1, uName);
            stmt.setString(2, uPass);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "successful login");
                return rs.getString(9);
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public Integer getEmployeeID(String uName) {
        try {
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT id FROM employee WHERE LogIn_Username = ?");
            stmt.setString(1, uName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
}