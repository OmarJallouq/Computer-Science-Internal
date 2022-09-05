import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class EmployeeFrame extends javax.swing.JFrame {
    public EmployeeFrame(Integer userID){
        initComponents();
    }

    private void initComponents(){
        
        ViewAllInventory = new JButton();
        ClockInOut = new JButton();
        Rentals = new JButton(); 
        LogOut = new JButton();
        TitleLabel = new JLabel();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Employee Page - ");

        ViewAllInventory.setText("View All Inventory");
        ViewAllInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ViewAllInventoryActionPerformed(evt);
            }
        });

        ClockInOut.setText("Clock In/Out");
        ClockInOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ClockInOutActionPerformed(evt);
            }
        });

         Rentals.setText("Rentals");
         Rentals.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt){ 
                 RentalsActionPerformed(evt);
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
                                                .addComponent(ViewAllInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ClockInOut, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Rentals, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
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
                                        .addComponent(ViewAllInventory)
                                        .addComponent(ClockInOut)
                                        .addComponent(Rentals))
                                .addGap(18, 18, 18)
                                .addComponent(LogOut)));

        pack();
        setLocationRelativeTo(null);
    }

    private void ViewAllInventoryActionPerformed(java.awt.event.ActionEvent evt) {
        new ViewAllInventory().setVisible(true);
    }

    private void ClockInOutActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Clock In / Out Button Clicked");
    }

     private void RentalsActionPerformed(java.awt.event.ActionEvent evt){
         System.out.println("Rentals Clicked");
     }

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {
        new LogInFrame().setVisible(true);
        this.dispose();
    }
    private JButton ViewAllInventory;
    private JButton ClockInOut;
    private JButton Rentals; 
    private JButton LogOut;
    private JLabel TitleLabel;
}