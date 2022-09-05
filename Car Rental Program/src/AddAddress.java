import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class AddAddress extends  javax.swing.JFrame {
    
    public AddAddress(String ogframe, Integer ireturnid) {
        initComponents();
        int itemid = DBMethods.getAddressMaxID() + 1;
        ItemNumberTF.setText(String.valueOf(itemid));
        origframe = ogframe;
        returnid = ireturnid;
    }

    private void initComponents() {

        ItemNumberLabel = new JLabel();
        CityLabel = new JLabel();
        AreaLabel = new JLabel();
        AddressLabel = new JLabel();
        TitleLabel = new JLabel();
        ItemNumberTF = new JTextField();
        CityTF = new JTextField();
        AreaTF = new JTextField();
        AddressTF = new JTextField();
        AddItemBtn = new JButton();
        CancelBtn = new JButton();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Add New Address Preset");

        ItemNumberLabel.setText("Item Number:  ");

        ItemNumberTF.setEditable(false);

        CityLabel.setText("City:  ");

        AreaLabel.setText("Area:  ");

        AddressLabel.setText("Address:  ");

        AddItemBtn.setText("Add Address");
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
                            .addComponent(CityLabel)
                            .addComponent(CityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AreaLabel)
                            .addComponent(AreaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressLabel)
                            .addComponent(AddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(CityLabel)
                        .addComponent(CityTF)
                        .addComponent(AreaLabel)
                        .addComponent(AreaTF)
                        .addComponent(AddressLabel)
                        .addComponent(AddressTF))
                    .addGap(9,9,9)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(AddItemBtn)
                        .addComponent(CancelBtn))));  
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void AddItemActionPerformed(java.awt.event.ActionEvent evt){
        if(CityTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'City' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(AreaTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'Area' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(AddressTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'Address' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int id = Integer.parseInt(ItemNumberTF.getText());
            String city = CityTF.getText();
            String area = AreaTF.getText();
            String address = AddressTF.getText();

            int num = DBMethods.addAddressRecord(id, city, area, address);
            if(num>0){
                JOptionPane.showMessageDialog(this, "Address Added Successfully");
                
                if(origframe == "add employee"){
                    new AddEmployee().setVisible(true);
                }
                else if(origframe == "edit employee"){
                    new EditSpecificEmployee(returnid).setVisible(true);
                }

                this.dispose();
            }
        }   
    }

    private void CancelActionPerformed(java.awt.event.ActionEvent evt){
        new AddEmployee().setVisible(true);
        this.dispose();
    }

    private JLabel ItemNumberLabel;
    private JLabel CityLabel;
    private JLabel AreaLabel;
    private JLabel AddressLabel;
    private JLabel TitleLabel;
    private JTextField ItemNumberTF;
    private JTextField CityTF;
    private JTextField AreaTF;
    private JTextField AddressTF;
    private JButton AddItemBtn;
    private JButton CancelBtn;
    String origframe;
    Integer returnid;

}
