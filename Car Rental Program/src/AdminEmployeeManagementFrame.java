import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class AdminEmployeeManagementFrame extends javax.swing.JFrame {
    public AdminEmployeeManagementFrame() {
        initComponents();
    }

    private void initComponents() {
        AddEmployee = new JButton();
        ModifyEmployee = new JButton();
        DeleteEmployee = new JButton();
        ViewAllEmployees = new JButton();
        GoBack = new JButton();
        TitleLabel = new JLabel();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Employee Management Page");

        AddEmployee.setText("Add Employee");
        AddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmployeeActionPerformed(evt);
            }
        });

        ModifyEmployee.setText("Modify Employee");
        ModifyEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyEmployeeActionPerformed(evt);
            }
        });

        DeleteEmployee.setText("Delete Employee");
        DeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployeeActionPerformed(evt);
            }
        });

        ViewAllEmployees.setText("View All Employees");
        ViewAllEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAllEmployeesActionPerformed(evt);
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
                                                .addComponent(AddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ModifyEmployee, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(DeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ViewAllEmployees, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(AddEmployee)
                                        .addComponent(ModifyEmployee, Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(DeleteEmployee)
                                        .addComponent(ViewAllEmployees))
                                .addGap(18, 18, 18)
                                .addComponent(GoBack)));

        pack();
        setLocationRelativeTo(null);
    }

    private void AddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {
        new AddEmployee().setVisible(true);
    }

    private void ModifyEmployeeActionPerformed(java.awt.event.ActionEvent evt) {
        new ModifyEmployee().setVisible(true);
    }

    private void DeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {
        new DeleteEmployee().setVisible(true);
    }

    private void ViewAllEmployeesActionPerformed(java.awt.event.ActionEvent evt) {
        new ViewAllEmployee().setVisible(true);
    }

    private void GoBackActionPerformed(java.awt.event.ActionEvent evt) {
        new AdminFrame().setVisible(true);
        this.dispose();
    }

    private JButton AddEmployee;
    private JButton ModifyEmployee;
    private JButton DeleteEmployee;
    private JButton ViewAllEmployees;
    private JButton GoBack;
    private JLabel TitleLabel;
}