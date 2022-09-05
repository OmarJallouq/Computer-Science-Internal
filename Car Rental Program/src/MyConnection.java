
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static Connection con = null;

    public static Connection getMyConnection() {
        if (con == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                String url = "jdbc:mysql://127.0.0.1:3306/car_rental_db";
                con = DriverManager.getConnection(url, "omarj", "ririgreen12");
            } catch (SQLException e) { 
            }
        }
        System.out.println("Connection Successful");
        return con;
    }
}
