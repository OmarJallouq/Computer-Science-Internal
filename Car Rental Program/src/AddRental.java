import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class AddRental extends  javax.swing.JFrame {
    DefaultListModel<String> modelList = new DefaultListModel<String>();
    int ItemID = -1;
    public AddRental() {
        initComponents();
        try{
            ResultSet rs = DBMethods.getAllCustomer();
            ResultSet rs2 = DBMethods.getAllEmployee();
            ItemID = DBMethods.getRentalMaxID()+1;
            
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

        RentalTypeLabel = new JLabel();
        NotesLabel = new JLabel();
        TitleLabel = new JLabel();
        CustomerPresetLabel = new JLabel();
        RentalDateLabel = new JLabel();
        RentalReturnLabel = new JLabel();
        EmployeeLabel = new JLabel();
        RentalTypeTF = new JComboBox<>();
        NotesTF = new JTextArea();
        CustomerPresetTF = new JComboBox<>();
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
        
        JScrollPane EmployeeTF = new JScrollPane(EmployeeList);
        EmployeeList.setVisibleRowCount(4);

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
                            .addComponent(CreateNewPresetBtn)
                        )
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(RentalTypeLabel)
                            .addComponent(RentalTypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmployeeLabel)
                            .addComponent(EmployeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(NotesLabel)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(AddItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))));
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
                    .addGroup(layout.createParallelGroup()
                        .addComponent(RentalTypeLabel)
                        .addComponent(RentalTypeTF)
                        .addComponent(EmployeeLabel)
                        .addComponent(EmployeeTF))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(NotesLabel)
                        .addComponent(jScrollPane))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(AddItemBtn)
                        .addComponent(CancelBtn))));  
        
        pack();
        setLocationRelativeTo(null);
    }

    private void CreateNewPresetPerformed(ActionEvent evt) {
        new AddCustomer().setVisible(true);
        this.dispose();
    }

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt){
        try{
            String CustomerPreset = this.CustomerPresetTF.getItemAt(this.CustomerPresetTF.getSelectedIndex());
            String FirstName = "";
            String LastName = "";
            java.util.Date RentalDate = new java.util.Date();
            java.util.Date ReturnDate = new java.util.Date();

            int iend = CustomerPreset.indexOf(' ');
                FirstName = CustomerPreset.substring(0, iend);
                CustomerPreset = CustomerPreset.substring(iend+1);
                LastName = CustomerPreset;
            
            String RentalType = this.RentalTypeTF.getItemAt(this.RentalTypeTF.getSelectedIndex());
            String note = String.valueOf(NotesTF.getText());

            Connection con = MyConnection.getMyConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT id FROM customer WHERE First_Name='"+FirstName+"' AND Last_Name='"+LastName+"'");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int CustomerID = rs.getInt(1);
            
            java.sql.Date RentalDateSQL = new java.sql.Date(RentalDate.getTime());
            java.sql.Date ReturnDateSQL = new java.sql.Date(ReturnDate.getTime());

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

    private void CancelActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }
    
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
    private JLabel RentalReturnLabel;
    private JComboBox<String> RentalTypeTF;
    private JTextArea NotesTF;
    private JComboBox<String> CustomerPresetTF;
    private JButton CreateNewPresetBtn;
    private JButton AddItemBtn;
    private JButton CancelBtn;
    private JScrollPane jScrollPane;

}
