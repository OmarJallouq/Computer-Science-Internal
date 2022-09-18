import javax.swing.*;

/*
 * Main JFrame, log in page
 */

public class LogInFrame extends javax.swing.JFrame {
    public LogInFrame() {
        initComponents();
    }

    //Initializes the components on the JFrame
    private void initComponents() {
        UsernameTF = new JTextField();
        PasswordTF = new JPasswordField();
        UsernameLabel = new JLabel();
        PasswordLabel = new JLabel();
        TitleLabel = new JLabel();
        LoginBtn = new JButton();
        ExitBtn = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        TitleLabel.setText("Car Rental Program Log In Here");
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 18));

        UsernameLabel.setText("Username:");
        PasswordLabel.setText("Password:");

        UsernameTF.setToolTipText("Enter Username");

        PasswordTF.setToolTipText("Enter Password");

        LoginBtn.setText("Log In");
        LoginBtn.setFont(new java.awt.Font("Ariel", 0, 12));
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LAYOUT = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(LAYOUT);

        LAYOUT.setHorizontalGroup(
                LAYOUT.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LAYOUT.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(LAYOUT.createSequentialGroup()
                                .addContainerGap(61, Short.MAX_VALUE)
                                .addGroup(LAYOUT.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(UsernameLabel)
                                        .addComponent(PasswordLabel))
                                .addGap(33, 33, 33)
                                .addGroup(LAYOUT.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(LAYOUT.createSequentialGroup()
                                                .addComponent(LoginBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ExitBtn))
                                        .addGroup(LAYOUT.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 194,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 194,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(60, Short.MAX_VALUE)));
        LAYOUT.setVerticalGroup(
                LAYOUT.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LAYOUT.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(LAYOUT.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UsernameLabel))
                                .addGap(65, 65, 65)
                                .addGroup(LAYOUT.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PasswordLabel))
                                .addGap(39, 39, 39)
                                .addGroup(LAYOUT.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LoginBtn)
                                        .addComponent(ExitBtn))
                                .addContainerGap(42, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }

    //Log In Button Action
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {
        String uName = UsernameTF.getText();
        String uPass = String.valueOf(PasswordTF.getPassword());
        DBTest t = new DBTest();
        Integer userID = t.getEmployeeID(uName);
        String check = t.checkLoginCredentials(uName, uPass);

        if (check != null) {
            System.out.println("User Type: " + check);
            System.out.println("ID: " + userID);
            if (check.equals("Admin")) {
                this.setVisible(false);
                AdminFrame f = new AdminFrame();
                f.setVisible(true);
            } else if (check.equals("Employee")) {
                this.setVisible(false);
                EmployeeFrame f = new EmployeeFrame(userID);
                f.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid Username and Password");
        }
    }

    //Exit button, quits app
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInFrame().setVisible(true);
            }
        });
    }

    private JTextField UsernameTF;
    private JPasswordField PasswordTF;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JLabel TitleLabel;
    private JButton LoginBtn;
    private JButton ExitBtn;
}
