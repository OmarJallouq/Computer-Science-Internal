import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

/*
 * JFrame responsible for adding new rentals to the DB
 */

public class EditSpecificRental extends  javax.swing.JFrame {
    DefaultListModel<String> modelList = new DefaultListModel<String>();
    int ItemID = -1;

    //Initializes the ID field to the pre-set auto-incremented number
    //Initializes the employeeList and the CustomerPreset with the values in the employee + customer DB
    public EditSpecificRental(int RentalID) {
        initComponents();
        try{
            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT Customer_ID, RentalType, Notes FROM rental WHERE id="+RentalID+"");
            PreparedStatement stmt2 = con.prepareStatement("SELECT employeeID FROM employeerental WHERE rentalID ="+RentalID+"");
            ResultSet RentalRecord = stmt.executeQuery();
            ResultSet EmployeesInvolved = stmt2.executeQuery();
            RentalRecord.next();

            int customerID = RentalRecord.getInt(1);
            String RentalType = RentalRecord.getString(2);
            String Notes = RentalRecord.getString(3);
            ResultSet rs = DBMethods.getCustomerRecord(customerID);
            ItemID = RentalID;
            
            while(EmployeesInvolved.next()){
                ResultSet EmployeeRecord = DBMethods.getEmployeeRecord(EmployeesInvolved.getInt(1));
                EmployeeRecord.next();
                String EmployeeFirstName = EmployeeRecord.getString(3);
                String EmployeeLastName = EmployeeRecord.getString(4);
                modelList.addElement(EmployeeFirstName+" "+EmployeeLastName);
            }
            while(rs.next()){
                CustomerPresetTF.addItem(rs.getString(2)+" "+rs.getString(3));
            }

            RentalTypeTF.addItem("Normal Rental");
            RentalTypeTF.addItem("Airport");
            RentalTypeTF.addItem("Driver");
            RentalTypeTF.addItem("Other");

            RentalTypeTF.setSelectedItem(RentalType);

            NotesTF.setText(Notes);

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
        CompletedLabel = new JLabel();
        RentalTypeTF = new JComboBox<>();
        NotesTF = new JTextArea();
        CustomerPresetTF = new JComboBox<>();
        CompletedTF = new JCheckBox();
        EditItemBtn = new JButton();
        CancelBtn = new JButton();
        jScrollPane = new JScrollPane();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Edit Rental");

        CustomerPresetLabel.setText("Customer Preset:  ");

        RentalTypeLabel.setText("Rental Type:  ");
        
        EmployeeLabel.setText("Employee(s) Involved:   ");

        EmployeeList.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        JScrollPane EmployeeTF = new JScrollPane(EmployeeList);
        EmployeeList.setVisibleRowCount(9);

        NotesLabel.setText("Notes:  ");

        NotesTF.setColumns(20);
        NotesTF.setRows(5);
        jScrollPane.setViewportView(NotesTF);
        
        CompletedLabel.setText("Completed?   ");
        
        EditItemBtn.setText("Edit Item");
        EditItemBtn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditItemActionPerformed(evt);
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
                            .addComponent(CustomerPresetTF))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(RentalTypeLabel)
                                .addComponent(RentalTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NotesLabel)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(EmployeeLabel)    
                                .addComponent(EmployeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(EditItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(CustomerPresetTF))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(RentalTypeLabel)
                        .addComponent(EmployeeLabel))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(RentalTypeTF)
                            .addGap(18,18,18)
                            .addComponent(NotesLabel)
                            .addComponent(jScrollPane))
                        .addComponent(EmployeeTF))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(EditItemBtn)
                        .addComponent(CancelBtn))));  
        
        pack();
        setLocationRelativeTo(null);
    }

    //Add item button action
    private void EditItemActionPerformed(java.awt.event.ActionEvent evt){
            //Gets the values in the fields and adds them to the rental DB                        
            String RentalType = this.RentalTypeTF.getItemAt(this.RentalTypeTF.getSelectedIndex());
            String note = String.valueOf(NotesTF.getText());

            int num = DBMethods.updateRentalRecord(ItemID, RentalType, note);
            
            if(num>0){
                JOptionPane.showMessageDialog(this, "Rental Edited Successfully!");
                this.dispose();
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
    private JLabel CompletedLabel;
    private JComboBox<String> RentalTypeTF;
    private JTextArea NotesTF;
    private JComboBox<String> CustomerPresetTF;
    private JCheckBox CompletedTF;
    private JButton EditItemBtn;
    private JButton CancelBtn;
    private JScrollPane jScrollPane;
    

}
