import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class AddCustomer extends  javax.swing.JFrame {
    
    public AddCustomer() {
        initComponents();
        int itemid = DBMethods.getCustomerMaxID() + 1;
        ItemNumberTF.setText(String.valueOf(itemid));
    }

    private void initComponents() {

        ItemNumberLabel = new JLabel();
        FNameLabel = new JLabel();
        LNameLabel = new JLabel();
        EmailLabel = new JLabel();
        TitleLabel = new JLabel();
        PhoneNumberLabel = new JLabel();
        ItemNumberTF = new JTextField();
        FNameTF = new JTextField();
        LNameTF = new JTextField();
        EmailTF = new JTextField();
        PhoneNumberTF = new JTextField();
        AddItemBtn = new JButton();
        CancelBtn = new JButton();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Add New Customer");

        ItemNumberLabel.setText("Item Number:  ");

        ItemNumberTF.setEditable(false);

        FNameLabel.setText("First Name:  ");

        LNameLabel.setText("Last Name:  ");

        EmailLabel.setText("Email:  ");

        PhoneNumberLabel.setText("Phone Number:   ");

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
                            .addGap(60,60,60)
                            .addComponent(TitleLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30,30,30)
                            .addComponent(ItemNumberLabel)
                            .addComponent(ItemNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(FNameLabel)
                            .addComponent(FNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LNameLabel)
                            .addComponent(LNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(EmailLabel)
                            .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhoneNumberLabel)
                            .addComponent(PhoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(AddItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addComponent(TitleLabel)
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(ItemNumberLabel)
                        .addComponent(ItemNumberTF))
                    .addGap(9,9,9)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(FNameLabel)
                        .addComponent(FNameTF)
                        .addComponent(LNameLabel)
                        .addComponent(LNameTF))
                    .addGap(9,9,9)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(EmailLabel)
                        .addComponent(EmailTF)
                        .addComponent(PhoneNumberLabel)
                        .addComponent(PhoneNumberTF))
                    .addGap(9,9,9)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(AddItemBtn)
                        .addComponent(CancelBtn))));  
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void AddItemActionPerformed(java.awt.event.ActionEvent evt){
        if(FNameTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'First Name' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(LNameTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'Last Name' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(EmailTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'Email' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                int id = Integer.parseInt(ItemNumberTF.getText());
                String FirstName = FNameTF.getText();
                String LastName = LNameTF.getText();
                String Email = EmailTF.getText();
                int PhoneNumber = Integer.parseInt(PhoneNumberTF.getText());
                
                int num = DBMethods.addCustomerRecord(id, FirstName, LastName, Email, PhoneNumber);
                if(num>0){
                    JOptionPane.showMessageDialog(this, "Customer Added Successfully");
                    new AddRental().setVisible(true);
                    this.dispose();
                }
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
        new AddRental().setVisible(true);
        this.dispose();
    }

    private JLabel ItemNumberLabel;
    private JLabel FNameLabel;
    private JLabel LNameLabel;
    private JLabel EmailLabel;
    private JLabel TitleLabel;
    private JLabel PhoneNumberLabel;
    private JTextField ItemNumberTF;
    private JTextField FNameTF;
    private JTextField LNameTF;
    private JTextField EmailTF;
    private JTextField PhoneNumberTF;
    private JButton AddItemBtn;
    private JButton CancelBtn;

}
