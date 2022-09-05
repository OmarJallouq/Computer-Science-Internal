import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class AddEmployee extends  javax.swing.JFrame {
    
    public AddEmployee() {
        initComponents();
        try{
            int itemid = DBMethods.getEmployeeMaxID() + 1;
            ItemNumberTF.setText(String.valueOf(itemid));
            ResultSet rs = DBMethods.getAllAddress();
            
            while(rs.next()){
                AddressPresetTF.addItem(rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4));
            }
            RoleTF.addItem("Admin");
            RoleTF.addItem("Employee");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void initComponents() {

        ItemNumberLabel = new JLabel();
        FirstNameLabel = new JLabel();
        LastNameLabel = new JLabel();
        TitleLabel = new JLabel();
        AddressPresetLabel = new JLabel();
        EmailLabel = new JLabel();
        PhoneNumberLabel = new JLabel();
        UsernameLabel = new JLabel();
        PasswordLabel = new JLabel();
        ConfirmPasswordLabel = new JLabel();
        RoleLabel = new JLabel();
        ItemNumberTF = new JTextField();
        FirstNameTF = new JTextField();
        LastNameTF = new JTextField();
        EmailTF = new JTextField();
        PhoneNumberTF = new JTextField();
        UsernameTF = new JTextField();
        PasswordTF = new JTextField();
        ConfirmPasswordTF = new JTextField();
        AddressPresetTF = new JComboBox<>();
        RoleTF = new JComboBox<>();
        CreateNewPresetBtn = new JButton();
        AddEmployeeBtn = new JButton();
        CancelBtn = new JButton();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Add New Employee");

        ItemNumberLabel.setText("Employee Number:  ");

        ItemNumberTF.setEditable(false);

        AddressPresetLabel.setText("Address:  ");

        FirstNameLabel.setText("First Name:  ");
        
        LastNameLabel.setText("Last Name:  ");
        
        EmailLabel.setText("Email:  ");

        PhoneNumberLabel.setText("Phone Number:  ");

        UsernameLabel.setText("Username:  ");

        PasswordLabel.setText("Password:  ");

        ConfirmPasswordLabel.setText("Confirm Password:  ");

        RoleLabel.setText("Role: ");

        CreateNewPresetBtn.setText("Add New Address");
        CreateNewPresetBtn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewPresetPerformed(evt);
            }
        });
        
        AddEmployeeBtn.setText("Add Employee");
        AddEmployeeBtn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmployeeActionPerformed(evt);
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
                            .addComponent(ItemNumberLabel)
                            .addComponent(ItemNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(AddressPresetLabel)
                            .addComponent(AddressPresetTF)
                            .addComponent(CreateNewPresetBtn)
                            .addGap(250,250,250))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(FirstNameLabel)
                            .addComponent(FirstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastNameLabel)
                            .addComponent(LastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(PhoneNumberLabel)
                            .addComponent(PhoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLabel)
                            .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(UsernameLabel)
                            .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordLabel)
                            .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(RoleLabel)
                            .addComponent(RoleTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConfirmPasswordLabel)
                            .addComponent(ConfirmPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(AddEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18,18,18)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(ItemNumberLabel)
                            .addComponent(ItemNumberTF))
                        .addGap(18,18,18)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(AddressPresetLabel)
                            .addComponent(AddressPresetTF)
                            .addComponent(CreateNewPresetBtn))
                        .addGap(18,18,18))
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()  
                                .addComponent(FirstNameLabel)
                                .addComponent(FirstNameTF)
                                .addComponent(LastNameLabel)
                                .addComponent(LastNameTF))
                            .addGap(18,18,18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(PhoneNumberLabel)
                                .addComponent(PhoneNumberTF)
                                .addComponent(EmailLabel)
                                .addComponent(EmailTF))
                            .addGap(18,18,18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(UsernameLabel)
                                .addComponent(UsernameTF)
                                .addComponent(PasswordLabel)
                                .addComponent(PasswordTF))
                            .addGap(18,18,18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(RoleLabel)
                                .addComponent(RoleTF)
                                .addComponent(ConfirmPasswordLabel)
                                .addComponent(ConfirmPasswordTF)))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(AddEmployeeBtn)
                        .addComponent(CancelBtn))));  
        
        pack();
        setLocationRelativeTo(null);
    }

    private void CreateNewPresetPerformed(ActionEvent evt) {
        new AddAddress("add employee", -1).setVisible(true);
        this.dispose();
    }

    private void AddEmployeeActionPerformed(java.awt.event.ActionEvent evt){
        if(FirstNameTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'First Name' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(LastNameTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'Last Name' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(UsernameTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'Username' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(PasswordTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'Password' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(ConfirmPasswordTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please confirm your password.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!(PasswordTF.getText().equals(ConfirmPasswordTF.getText()))){
            JOptionPane.showMessageDialog(this, "Password Confirmation Error, please check that the password confirmation matches.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                int id = Integer.parseInt(ItemNumberTF.getText());
                String preset = this.AddressPresetTF.getItemAt(this.AddressPresetTF.getSelectedIndex());
                String city = "";
                String area = "";
                String address = "";

                int iend = preset.indexOf('-');
                    city = preset.substring(0,iend);
                    preset = preset.substring(iend+1);
                
                iend = preset.indexOf('-');
                    area = preset.substring(0,iend);
                    preset = preset.substring(iend+1);
                
                address = preset;

                String FirstName = String.valueOf(FirstNameTF.getText());
                String LastName = String.valueOf(LastNameTF.getText());
                int PhoneNumber = Integer.parseInt(PhoneNumberTF.getText());
                String Email = String.valueOf(EmailTF.getText());
                String Username = String.valueOf(UsernameTF.getText());
                String Password = String.valueOf(PasswordTF.getText());
                String role = this.RoleTF.getItemAt(this.RoleTF.getSelectedIndex());

                Connection con = MyConnection.getMyConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT id FROM address WHERE City='"+city+"' AND Area='"+area+"' AND Address1='"+address+"'");
                ResultSet rs = stmt.executeQuery();
                rs.next();
                int addressID = rs.getInt(1);

                int num = DBMethods.addEmployeeRecord(id, addressID, FirstName, LastName, Email, PhoneNumber, Username, Password, role);
                if(num > 0){
                    JOptionPane.showMessageDialog(this, "Employee Added Successfully!");
                    this.dispose();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            catch(NumberFormatException ex){
                if(String.valueOf(PhoneNumberTF.getText()).equals("")){
                    JOptionPane.showMessageDialog(this, "'Phone Number' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "'Phone Number' has to be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void CancelActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }

    private JLabel ItemNumberLabel;
    private JLabel FirstNameLabel;
    private JLabel LastNameLabel;
    private JLabel TitleLabel;
    private JLabel AddressPresetLabel;
    private JLabel EmailLabel;
    private JLabel PhoneNumberLabel;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JLabel ConfirmPasswordLabel;
    private JLabel RoleLabel;
    private JTextField ItemNumberTF;
    private JTextField FirstNameTF;
    private JTextField LastNameTF;
    private JComboBox<String> AddressPresetTF;
    private JComboBox<String> RoleTF;
    private JTextField EmailTF;
    private JTextField PhoneNumberTF;
    private JTextField UsernameTF;
    private JTextField PasswordTF;
    private JTextField ConfirmPasswordTF;
    private JButton CreateNewPresetBtn;
    private JButton AddEmployeeBtn;
    private JButton CancelBtn;

}
