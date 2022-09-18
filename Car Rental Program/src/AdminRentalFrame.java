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
        ViewModifyRental = new JButton();
        DeleteRental = new JButton();
        PaymentsRentals = new JButton();
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

        ViewModifyRental.setText("ViewModify Rental");
        ViewModifyRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewModifyRentalActionPerformed(evt);
            }
        });

        DeleteRental.setText("Delete Rental");
        DeleteRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRentalActionPerformed(evt);
            }
        });

        PaymentsRentals.setText("Payments");
        PaymentsRentals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentsRentalsActionPerformed(evt);
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
                                                .addComponent(ViewModifyRental, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(DeleteRental, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(PaymentsRentals, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 78)))
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
                                        .addComponent(ViewModifyRental, Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(DeleteRental)
                                        .addComponent(PaymentsRentals))
                                .addGap(18, 18, 18)
                                .addComponent(GoBack)));

        pack();
        setLocationRelativeTo(null);
    }

    //Buttons that redirects the user to the respective JFrames

    private void AddRentalActionPerformed(java.awt.event.ActionEvent evt) {
        new AddRental().setVisible(true);
    }

    private void ViewModifyRentalActionPerformed(java.awt.event.ActionEvent evt) {
        new ModifyRentals().setVisible(true);
    }

    private void DeleteRentalActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Delete Rental Clicked");
    }

    private void PaymentsRentalsActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Payments Rentals Clicked");
    }

    private void GoBackActionPerformed(java.awt.event.ActionEvent evt) {
        new AdminFrame().setVisible(true);
        this.dispose();
    }

    private JButton AddRental;
    private JButton ViewModifyRental;
    private JButton DeleteRental;
    private JButton PaymentsRentals;
    private JButton GoBack;
    private JLabel TitleLabel;
}