import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

public class EmployeeViewAllRentals extends javax.swing.JFrame {
    Boolean hasRentals = true;

    public EmployeeViewAllRentals(Integer employeeID){
        initComponents();
        jScrollPane.setVisible(true);
        try{
            ResultSet rs = DBMethods.getEmployeeSpecificRentals(employeeID);
            

            if(!rs.next()){
                JOptionPane.showMessageDialog(this, "You have no rentals assigned!");
                hasRentals = false;
            }
            else {
                rs.next();
                ResultSet employeesInvolvedRS = DBMethods.getEmployeesInvolved(rs.getInt(1));
                String employeesInvolvedString;

                employeesInvolvedString = "";
                
                while(employeesInvolvedRS.next()){
                    employeesInvolvedString += employeesInvolvedRS.getString(1)+" "+employeesInvolvedRS.getString(2);
                    employeesInvolvedString += " - ";
                }

                Object column[]={"ID","Customer Name", "Rental Type", "Drivers Involved", "Notes"};
                DefaultTableModel model = new DefaultTableModel();
                model=(DefaultTableModel)jTable1.getModel();
                model.setColumnCount(4);
                model.setColumnIdentifiers(column);
                do {
                    model.addRow(new Object[]{
                        rs.getInt(1),
                        rs.getString(2)+" "+rs.getString(3),
                        rs.getString(4),
                        employeesInvolvedString,
                        rs.getString(5)
                    });
                    rs.next();
                }
                while(rs.next());
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void initComponents(){
        
        TitleLabel = new JLabel();
        jScrollPane = new JScrollPane();
        jTable1 = new JTable();
        CloseBtn = new JButton();
        ViewAllCustomerBtn = new JButton();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("View Personal Rentals");
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel());
        jTable1.setDefaultEditor(Object.class, null);
        jScrollPane.setViewportView(jTable1);

        CloseBtn.setText("Close");
        CloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                CloseActionPerformed(evt);
            }
        });

        ViewAllCustomerBtn.setText("View Customers");
        ViewAllCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ViewAllCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100,100,100)
                        .addComponent(TitleLabel))
                    .addComponent(jScrollPane,800,800,800)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CloseBtn,135,135,135)
                        .addComponent(ViewAllCustomerBtn,135,135,135))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23,23,23)
                .addComponent(TitleLabel)
                .addGap(18,18,18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18,18,18)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(CloseBtn)
                    .addComponent(ViewAllCustomerBtn))
                .addGap(23,23,23)
                ));

        pack();
        setLocationRelativeTo(null);
    }
    
    private void ViewAllCustomerActionPerformed(java.awt.event.ActionEvent evt){
        new ViewAllCustomer().setVisible(true);
    }

    private void CloseActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }
    
    private JLabel TitleLabel;
    private JScrollPane jScrollPane;
    private JButton CloseBtn;
    private JButton ViewAllCustomerBtn;
    private JTable jTable1;
}