import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

/*
 * JFrame responsible for adding new rentals to the DB
 */

public class AddRental extends  javax.swing.JFrame {
    DefaultListModel<String> modelList = new DefaultListModel<String>();
    int ItemID = -1;

    //Initializes the ID field to the pre-set auto-incremented number
    //Initializes the employeeList and the CustomerPreset with the values in the employee + customer DB
    public AddRental() {
        initComponents();
        try{
            ResultSet rs = DBMethods.getAllCustomer();
            ResultSet rs2 = DBMethods.getAllEmployee();
            ItemID = DBMethods.getRentalMaxID()+1;

            modelList.addElement("No Driver");             
            modelList.addElement("Choose for Me!");
            while(rs2.next()){
                modelList.addElement(rs2.getString(3)+" "+rs2.getString(4));
            }
            while(rs.next()){
                CustomerPresetTF.addItem(rs.getString(2)+" "+rs.getString(3));
            }

            RentalTypeTF.addItem("Normal Rental");
            RentalTypeTF.addItem("Airport");
            RentalTypeTF.addItem("Driver");
            RentalTypeTF.addItem("Other");

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    JList<String> EmployeeList = new JList<String>(modelList);
    

    private void initComponents() {

        //Initalizes the components of the JFrame
        RentalTypeLabel = new JLabel();
        NotesLabel = new JLabel();
        TitleLabel = new JLabel();
        CustomerPresetLabel = new JLabel();
        EmployeeLabel = new JLabel();
        RentalDateLabel = new JLabel();
        ReturnDateLabel = new JLabel();
        RentalTypeTF = new JComboBox<>();
        NotesTF = new JTextArea();
        CustomerPresetTF = new JComboBox<>();
        RentalDateTF = new JTextField();
        ReturnDateTF = new JTextField();
        CreateNewPresetBtn = new JButton();
        AddItemBtn = new JButton();
        CancelBtn = new JButton();
        jScrollPane = new JScrollPane();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Add New Rental");

        CustomerPresetLabel.setText("Customer Preset:  ");

        RentalTypeLabel.setText("Rental Type:  ");
        
        EmployeeLabel.setText("Employee(s) Involved:   ");

        EmployeeList.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        RentalDateLabel.setText("Rental Date (dd/mm/yyyy):  ");

        ReturnDateLabel.setText("Return Date (dd/mm/yyyy):  ");

        JScrollPane EmployeeTF = new JScrollPane(EmployeeList);
        EmployeeList.setVisibleRowCount(9);

        NotesLabel.setText("Notes:  ");

        NotesTF.setColumns(20);
        NotesTF.setRows(5);
        jScrollPane.setViewportView(NotesTF);


        CreateNewPresetBtn.setText("Add New Customer");
        CreateNewPresetBtn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewPresetPerformed(evt);
            }
        });
        
        AddItemBtn.setText("Add Item");
        AddItemBtn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                CancelActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23,23,23)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(55,55,55)
                            .addComponent(TitleLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CustomerPresetLabel)
                            .addComponent(CustomerPresetTF)
                            .addComponent(CreateNewPresetBtn))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()                                
                                    .addComponent(RentalTypeLabel)
                                    .addComponent(RentalTypeTF))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(RentalDateLabel)
                                    .addComponent(RentalDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ReturnDateLabel)
                                    .addComponent(ReturnDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(NotesLabel)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(4,4,4)
                                    .addComponent(EmployeeLabel))
                                .addComponent(EmployeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(AddItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(23, Short.MAX_VALUE)));
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(CustomerPresetLabel)
                        .addComponent(CustomerPresetTF)
                        .addComponent(CreateNewPresetBtn))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(RentalTypeLabel)
                        .addComponent(RentalTypeTF)
                        .addComponent(EmployeeLabel))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18,18,18)
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(RentalDateLabel)
                                .addComponent(RentalDateTF))
                            .addGap(9,9,9)
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(ReturnDateLabel)
                                .addComponent(ReturnDateTF))
                            .addComponent(NotesLabel)
                            .addComponent(jScrollPane))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(EmployeeTF)))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(AddItemBtn)
                        .addComponent(CancelBtn))));  
        
        pack();
        setLocationRelativeTo(null);
    }

    //Create new customer button action: opens add customer JFrame
    private void CreateNewPresetPerformed(ActionEvent evt) {
        new AddCustomer().setVisible(true);
        this.dispose();
    }

    //Add item button action
    private void AddItemActionPerformed(java.awt.event.ActionEvent evt){
        try{
            //Gets the values in the fields and adds them to the rental DB
            Connection con = MyConnection.getMyConnection();

            String CustomerPreset = this.CustomerPresetTF.getItemAt(this.CustomerPresetTF.getSelectedIndex());
            String FirstName = "";
            String LastName = "";

            int iend = CustomerPreset.indexOf(' ');
                FirstName = CustomerPreset.substring(0, iend);
                CustomerPreset = CustomerPreset.substring(iend+1);
                LastName = CustomerPreset;
                        
            String RentalType = this.RentalTypeTF.getItemAt(this.RentalTypeTF.getSelectedIndex());
            String note = String.valueOf(NotesTF.getText());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate RentalDate = LocalDate.parse(RentalDateTF.getText(), formatter);
            LocalDate ReturnDate = LocalDate.parse(ReturnDateTF.getText(), formatter);
            Date RentalDateSQL = Date.valueOf(RentalDate);
            Date ReturnDateSQL = Date.valueOf(ReturnDate);

            List<String> SelectedEmployees = EmployeeList.getSelectedValuesList();

            Boolean EmployeeAutomation = false;
            Boolean NoDriver = false;
            for(int i = 0 ; i < SelectedEmployees.size() ; i++){
                if(SelectedEmployees.get(i) == "Choose for Me!"){
                    EmployeeAutomation = true;
                    break;
                }
                else if(SelectedEmployees.get(i) == "No Driver"){
                    NoDriver = true;
                    break;
                }
            }

            if(EmployeeAutomation){
                //Do employee Automation

                PreparedStatement stmtGetAllEmployees = con.prepareStatement("SELECT * from employee WHERE role = 'Employee'");
                ResultSet allEmployees = stmtGetAllEmployees.executeQuery();
                List<Integer> availableDrivers=new ArrayList<Integer>();
                int leastTasks = 2147483647;
                int chosenEmployee = -1;

                //Returns a list of all of the employees that are free during that time frame
                while(allEmployees.next()){
                    int EmployeeID = allEmployees.getInt(1);
                    PreparedStatement stmtGetDatesForEmployee = con.prepareStatement("SELECT Rental_Date, Return_Date FROM car_rental_db.employeerental JOIN rental WHERE rental.id = employeerental.rentalID AND employeerental.employeeID = ?");
                    stmtGetDatesForEmployee.setInt(1, EmployeeID);
                    ResultSet IntervalsRS = stmtGetDatesForEmployee.executeQuery();

                    Date[][] Intervals = new Date[3][2];
                    Intervals[1][0] = RentalDateSQL;
                    Intervals[1][1] = ReturnDateSQL;

                    boolean DoThis = true;
                        Intervals[0][0] = new Date(Long.MIN_VALUE);
                        Intervals[0][1] = new Date(Long.MIN_VALUE);
                        Intervals[2][0] = new Date(Long.MAX_VALUE);
                        Intervals[2][1] = new Date(Long.MAX_VALUE);


                    if(DoThis){
                        while(IntervalsRS.next()){
                            if((IntervalsRS.getDate(1)).compareTo(RentalDateSQL) < 0){
                                Intervals[0][0] = IntervalsRS.getDate(1);
                                Intervals[0][1] = IntervalsRS.getDate(2);
                            }
                            else{
                                Intervals[2][0] = IntervalsRS.getDate(1);
                                Intervals[2][1] = IntervalsRS.getDate(2);
                                break;
                            }
                        };

                    }

                    //If employee available during time slot, count how many tasks and set minimum appropriately
                    if(!((Intervals[1][1].compareTo(Intervals[0][0]) >= 0) && (Intervals[0][1].compareTo(Intervals[1][0]) >= 0))){
                        if(!((Intervals[2][1].compareTo(Intervals[1][0]) >= 0) && (Intervals[1][1].compareTo(Intervals[2][0]) >= 0))){
                            availableDrivers.add(EmployeeID);
                            PreparedStatement stmtGetEmployeeRentals = con.prepareStatement("SELECT * FROM employeerental WHERE employeeID = ?");
                            stmtGetEmployeeRentals.setInt(1, EmployeeID);
                            ResultSet EmployeeTasksRS = stmtGetEmployeeRentals.executeQuery();

                            int count = 0;
                            //count the tasks
                            while(EmployeeTasksRS.next()){
                                count++;
                            }

                            //decide if they has the least tasks
                            if (count <= leastTasks){
                                chosenEmployee = EmployeeID;
                            }
                        }
                    }
                }

                //add that employee to the employeerental join table

                PreparedStatement stmt = con.prepareStatement("INSERT INTO employeerental VALUES(?,?)");
                stmt.setInt(1, chosenEmployee);
                stmt.setInt(2, ItemID);
                stmt.executeUpdate();
            }
            else if(NoDriver){
                //nothing just skips
            }
            else{
                //gets the ID of all employees selected, and adds them all into the employeerental JOIN table in DB
                for(int i = 0 ; i < SelectedEmployees.size() ; i++){
                    String FullName = SelectedEmployees.get(i);


                    int iend2 = FullName.indexOf(' ');
                        String EmpFirstName = FullName.substring(0,iend2);
                        FullName = FullName.substring(iend2+1);
                        String EmpLastName = FullName;

                    PreparedStatement stmt = con.prepareStatement("SELECT id FROM employee WHERE First_Name='"+EmpFirstName+"' AND Last_Name='"+EmpLastName+"'");
                    ResultSet rs = stmt.executeQuery();
                    rs.next();
                    int EmployeeID = rs.getInt(1);
                    stmt = con.prepareStatement("INSERT INTO employeerental VALUES(?,?)");
                    stmt.setInt(1, EmployeeID);
                    stmt.setInt(2, ItemID);
                    stmt.executeUpdate();
                }
            }

            PreparedStatement stmt = con.prepareStatement("SELECT id FROM customer WHERE First_Name='"+FirstName+"' AND Last_Name='"+LastName+"'");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int CustomerID = rs.getInt(1);

            int num = DBMethods.addRentalRecord(ItemID, CustomerID, RentalType, RentalDateSQL, ReturnDateSQL, note);
            
            if(num>0){
                JOptionPane.showMessageDialog(this, "Rental Added Successfully!");
                this.dispose();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Cancel button pressed, return to previous JFrame
    private void CancelActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }
    
    //Function that checks if a certain string solely composed of an integer
    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    private JLabel RentalTypeLabel;
    private JLabel NotesLabel; 
    private JLabel TitleLabel;
    private JLabel CustomerPresetLabel;
    private JLabel EmployeeLabel;
    private JLabel RentalDateLabel;
    private JLabel ReturnDateLabel;
    private JComboBox<String> RentalTypeTF;
    private JTextArea NotesTF;
    private JComboBox<String> CustomerPresetTF;
    private JTextField RentalDateTF;
    private JTextField ReturnDateTF;
    private JButton CreateNewPresetBtn;
    private JButton AddItemBtn;
    private JButton CancelBtn;
    private JScrollPane jScrollPane;
    
    

}
