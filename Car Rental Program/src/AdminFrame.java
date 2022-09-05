import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class AdminFrame extends javax.swing.JFrame {
    public AdminFrame() {
        initComponents();
    }

    private void initComponents() {

        Inventory = new JButton();
        Rentals = new JButton();
        Employees = new JButton();
        LogOut = new JButton();
        TitleLabel = new JLabel();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Admin Page");

        Inventory.setText("Inventory");
        Inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryActionPerformed(evt);
            }
        });

        Rentals.setText("Rentals");
        Rentals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentalsActionPerformed(evt);
            }
        });

        Employees.setText("Employees");
        Employees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeesActionPerformed(evt);
            }
        });

        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(LogOut)
                                .addGap(0, 335, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(190, 190, 190)
                                                .addComponent(TitleLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Rentals, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Employees, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(Inventory)
                                        .addComponent(Rentals)
                                        .addComponent(Employees))
                                .addGap(18, 18, 18)
                                .addComponent(LogOut)));

        pack();
        setLocationRelativeTo(null);
    }

    private void InventoryActionPerformed(java.awt.event.ActionEvent evt) {
        new AdminInventoryFrame().setVisible(true);
        this.dispose();
    }

    private void RentalsActionPerformed(java.awt.event.ActionEvent evt) {
        new AdminRentalFrame().setVisible(true);
        this.dispose();
    }

    private void EmployeesActionPerformed(java.awt.event.ActionEvent evt) {
        new AdminEmployeeManagementFrame().setVisible(true);
        this.dispose();
    }

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {
        new LogInFrame().setVisible(true);
        this.dispose();
    }

    private JButton Inventory;
    private JButton Rentals;
    private JButton Employees;
    private JButton LogOut;
    private JLabel TitleLabel;

}