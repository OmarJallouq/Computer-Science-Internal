import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

/*
 * JFrame responsible in managing inventory
 */

public class AdminInventoryFrame extends javax.swing.JFrame {
    public AdminInventoryFrame() {
        initComponents();
    }

    //Initializes the components on the JFrame
    private void initComponents() {
        AddCar = new JButton();
        ModifyCar = new JButton();
        DeleteCar = new JButton();
        ViewAllCars = new JButton();
        GoBack = new JButton();
        TitleLabel = new JLabel();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Inventory Management Page");

        AddCar.setText("Add Car");
        AddCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCarActionPerformed(evt);
            }
        });

        ModifyCar.setText("Modify Car");
        ModifyCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyCarActionPerformed(evt);
            }
        });

        DeleteCar.setText("Delete Car");
        DeleteCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCarActionPerformed(evt);
            }
        });

        ViewAllCars.setText("View All Cars");
        ViewAllCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAllCarsActionPerformed(evt);
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
                                                .addComponent(AddCar, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ModifyCar, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(DeleteCar, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ViewAllCars, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
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
                                        .addComponent(AddCar)
                                        .addComponent(ModifyCar, Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(DeleteCar)
                                        .addComponent(ViewAllCars))
                                .addGap(18, 18, 18)
                                .addComponent(GoBack)));

        pack();
        setLocationRelativeTo(null);
    }

    //Buttons that redirects the user to the respective JFrames

    private void AddCarActionPerformed(java.awt.event.ActionEvent evt) {
        new AddCarToInventory().setVisible(true);
    }

    private void ModifyCarActionPerformed(java.awt.event.ActionEvent evt) {
        new ModifyInventory().setVisible(true);
    }

    private void DeleteCarActionPerformed(java.awt.event.ActionEvent evt) {
        new DeleteInventory().setVisible(true);
    }

    private void ViewAllCarsActionPerformed(java.awt.event.ActionEvent evt) {
        new ViewAllInventory().setVisible(true);
    }

    private void GoBackActionPerformed(java.awt.event.ActionEvent evt) {
        new AdminFrame().setVisible(true);
        this.dispose();
    }

    private JButton AddCar;
    private JButton ModifyCar;
    private JButton DeleteCar;
    private JButton ViewAllCars;
    private JButton GoBack;
    private JLabel TitleLabel;
}