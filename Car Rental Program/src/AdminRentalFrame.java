import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

/*
 * JFrame responsible for managing rentals
 */

public class AdminRentalFrame extends javax.swing.JFrame {
    public AdminRentalFrame() {
        initComponents();
    }

    private void initComponents() {
        //Initializes the components on the JFrame
        AddRental = new JButton();
        ModifyRental = new JButton();
        DeleteRental = new JButton();
        ViewAllRentals = new JButton();
        Payments = new JButton();
        GoBack = new JButton();
        TitleLabel = new JLabel();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Rentals Page");

        AddRental.setText("Add Rental");
        AddRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRentalActionPerformed(evt);
            }
        });

        ModifyRental.setText("Modify Rental");
        ModifyRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyRentalActionPerformed(evt);
            }
        });

        DeleteRental.setText("Delete Rental");
        DeleteRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRentalActionPerformed(evt);
            }
        });

        ViewAllRentals.setText("View All Rentals");
        ViewAllRentals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAllRentalsActionPerformed(evt);
            }
        });

        Payments.setText("Payments");
        Payments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentsActionPerformed(evt);
            }
        });

        GoBack.setText("Go Back");
        GoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(GoBack)
                                .addGap(0, 280, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(TitleLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(AddRental, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ModifyRental, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(DeleteRental, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ViewAllRentals, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 78)
                                                .addComponent(Payments, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
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
                                        .addComponent(AddRental)
                                        .addComponent(ModifyRental, Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(DeleteRental)
                                        .addComponent(ViewAllRentals))
                                .addGap(18, 18, 18)
                                .addComponent(Payments)
                                .addGap(18, 18, 18)
                                .addComponent(GoBack)));

        pack();
        setLocationRelativeTo(null);
    }

    //Buttons that redirects the user to the respective JFrames

    private void AddRentalActionPerformed(java.awt.event.ActionEvent evt) {
        new AddRental().setVisible(true);
    }

    private void ModifyRentalActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Modify Rental Clicked");
    }

    private void DeleteRentalActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Delete Rental Clicked");
    }

    private void ViewAllRentalsActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("View All Rentals Clicked");
    }

    private void PaymentsActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Payments Clicked");
    }

    private void GoBackActionPerformed(java.awt.event.ActionEvent evt) {
        new AdminFrame().setVisible(true);
        this.dispose();
    }

    private JButton AddRental;
    private JButton ModifyRental;
    private JButton DeleteRental;
    private JButton ViewAllRentals;
    private JButton Payments;
    private JButton GoBack;
    private JLabel TitleLabel;
}