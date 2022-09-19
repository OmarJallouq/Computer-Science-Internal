import java.sql.*;

class DBMethods {
    public static int getInventoryMaxID(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT max(id) FROM inventory");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getCarMaxID(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT max(id) FROM car");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static ResultSet getAllCar(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM car");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int addCarRecord(int id, String brand, int year, String color){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO car VALUES(?,?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2,brand);
            stmt.setInt(3,year);
            stmt.setString(4,color);
            int n = stmt.executeUpdate();
            return n;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int addInventoryRecord(int id, int CarID, String LicensePlate, int RentalRate, String note){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO inventory VALUES(?,?,?,?,?)");
            stmt.setInt(1,id);
            stmt.setInt(2, CarID);
            stmt.setString(3, LicensePlate);
            stmt.setInt(4, RentalRate);
            stmt.setString(5, note);
            int n = stmt.executeUpdate();
            return n;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static ResultSet getAllInventory(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT inventory.id, car.Brand, car.Year, car.Color, inventory.LicensePlate_Number, inventory.RentalRate, inventory.Notes FROM inventory INNER JOIN car ON inventory.Car_ID = car.id");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getInventoryRecord(int id){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT inventory.id, car.Brand, car.Year, car.Color, inventory.LicensePlate_Number, inventory.RentalRate, inventory.Notes  FROM inventory  INNER JOIN car ON inventory.Car_ID = car.id WHERE inventory.id = '" + id + "'");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static int updateInventoryRecord(int id, int rentalrate, String notes){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE inventory set RentalRate=?, Notes=? WHERE id=?");
            stmt.setInt(1,rentalrate);
            stmt.setString(2, notes);
            stmt.setInt(3,id);

            int n = stmt.executeUpdate();
            return n;
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static int deleteInventoryRecord(int id){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM inventory WHERE id='"+id+"'");
            int n = stmt.executeUpdate();
            return n;
        }
        catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static int getEmployeeMaxID(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT max(id) FROM employee");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static ResultSet getAllAddress(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM address");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int getAddressMaxID(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT max(id) FROM address");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int addAddressRecord(int id, String city, String area, String address){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO address VALUES(?,?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2,city);
            stmt.setString(3,area);
            stmt.setString(4,address);
            int n = stmt.executeUpdate();
            return n;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int addEmployeeRecord(int id, int addressID, String FirstName, String LastName, String Email, int PhoneNumber, String Username, String Password, String Role){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,id);
            stmt.setInt(2,addressID);
            stmt.setString(3, FirstName);
            stmt.setString(4, LastName);
            stmt.setString(5, Email);
            stmt.setInt(6, PhoneNumber);
            stmt.setString(7, Username);
            stmt.setString(8, Password);
            stmt.setString(9, Role);
            int n = stmt.executeUpdate();
            return n;
        }
        catch(SQLException e){
            
            e.printStackTrace();
        }
        return 0;
    }

    public static ResultSet getAllEmployee(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * from employee");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getEmployeeRecord(int id){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT *  FROM employee WHERE employee.id = '" + id + "'");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int updateEmployeeRecord(int id, int addressID, String FirstName, String LastName, String Email, int PhoneNumber, String Username, String Password, String Role){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE employee set Address_ID=?, First_Name=?, Last_Name=?, Email=?, Phone_Number=?, LogIn_Username=?, LogIn_Password=?, role=? WHERE id=?");
            stmt.setInt(1,addressID);
            stmt.setString(2, FirstName);
            stmt.setString(3, LastName);
            stmt.setString(4, Email);
            stmt.setInt(5, PhoneNumber);
            stmt.setString(6, Username);
            stmt.setString(7, Password);
            stmt.setString(8, Role);
            stmt.setInt(9,id);

            int n = stmt.executeUpdate();
            return n;
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static int deleteEmployeeRecord(int id){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM employee WHERE id='"+id+"'");
            int n = stmt.executeUpdate();
            return n;
        }
        catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static ResultSet getAllCustomer(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int addCustomerRecord(int id, String FirstName, String LastName, String Email, int PhoneNumber){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2,FirstName);
            stmt.setString(3,LastName);
            stmt.setString(4,Email);
            stmt.setInt(5,PhoneNumber);
            int n = stmt.executeUpdate();
            return n;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int getCustomerMaxID(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT max(id) FROM customer");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getRentalMaxID(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT max(id) FROM rental");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int addRentalRecord(int id, int CustomerID, String RentalType, Date RentalDate, Date ReturnDate, String Note){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO rental VALUES(?,?,?,?,?,?,0)");
            stmt.setInt(1, id);
            stmt.setInt(2,CustomerID);
            stmt.setString(3,RentalType);
            stmt.setDate(4,RentalDate);
            stmt.setDate(5,ReturnDate);
            stmt.setString(6,Note);
            int n = stmt.executeUpdate();
            return n;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static ResultSet getAllRental(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT rental.id, customer.First_Name , customer.Last_Name, rental.RentalType FROM rental JOIN customer WHERE rental.Customer_ID=customer.id");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getCustomerRecord(int id){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT *  FROM customer WHERE id = '" + id + "'");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static int updateRentalRecord(int id, String RentalType, String Note, Boolean completed){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE rental set id=?, RentalType=?, Notes=?, Completed=? WHERE id=?");
            stmt.setInt(1,id);
            stmt.setString(2,RentalType);
            stmt.setString(3,Note);
            stmt.setBoolean(4, completed);
            stmt.setInt(5,id);
            int n = stmt.executeUpdate();
            return n;
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static ResultSet getAllCurrentRental(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT rental.id, customer.First_Name , customer.Last_Name, rental.RentalType FROM rental JOIN customer WHERE rental.Customer_ID=customer.id AND rental.Completed=0");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getOldRentals(){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT rental.id, customer.First_Name, customer.Last_Name, rental.RentalType, rental.Notes FROM rental JOIN customer WHERE customer.id = rental.Customer_ID AND rental.Completed=TRUE");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getEmployeesInvolved(int RentalID){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT employee.First_Name, employee.Last_Name FROM employeerental JOIN employee WHERE employeerental.employeeID = employee.id AND employeerental.rentalID = ?");
            stmt.setInt(1,RentalID);
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getEmployeeSpecificRentals(int EmployeeID){
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT rental.id, customer.First_Name, customer.Last_Name, rental.RentalType, rental.Notes, employeerental.employeeID FROM rental JOIN customer, employeerental WHERE customer.id = rental.Customer_ID AND employeerental.employeeID ="+EmployeeID+"");
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
