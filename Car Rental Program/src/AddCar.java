import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

/*
 * JFrame responsible to add GENERAL cars into the DB.
 */

public class AddCar extends  javax.swing.JFrame {
    
    //Initializes the ID field to the pre-set auto-incremented number from DB
    public AddCar() {
        initComponents();
        int itemid = DBMethods.getCarMaxID() + 1;
        ItemNumberTF.setText(String.valueOf(itemid));
    }

    private void initComponents() {
        
        //Initializes the components on the JFrame
        ItemNumberLabel = new JLabel();
        BrandLabel = new JLabel();
        YearLabel = new JLabel();
        ColorLabel = new JLabel();
        TitleLabel = new JLabel();
        ItemNumberTF = new JTextField();
        BrandTF = new JTextField();
        YearTF = new JTextField();
        ColorTF = new JComboBox<>();
        AddItemBtn = new JButton();
        CancelBtn = new JButton();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Add New Car Preset");

        ItemNumberLabel.setText("Item Number:  ");

        ItemNumberTF.setEditable(false);

        BrandLabel.setText("Brand:  ");

        YearLabel.setText("Year:  ");

        ColorLabel.setText("Color:  ");

        ColorTF.addItem("White");
        ColorTF.addItem("Black");
        ColorTF.addItem("Gray");
        ColorTF.addItem("Silver");
        ColorTF.addItem("Red");
        ColorTF.addItem("Blue");
        ColorTF.addItem("Other");

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
                            .addComponent(BrandLabel)
                            .addComponent(BrandTF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YearLabel)
                            .addComponent(YearTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ColorLabel)
                            .addComponent(ColorTF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(BrandLabel)
                        .addComponent(BrandTF)
                        .addComponent(YearLabel)
                        .addComponent(YearTF)
                        .addComponent(ColorLabel)
                        .addComponent(ColorTF))
                    .addGap(9,9,9)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(AddItemBtn)
                        .addComponent(CancelBtn))));  
        
        pack();
        setLocationRelativeTo(null);
    }
    
    //Add Item button pressed action
    private void AddItemActionPerformed(java.awt.event.ActionEvent evt){
        //Checks if any of the required fields are empty
        if(BrandTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'Brand' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                //Gets the field values from the Text Fields and inputs them into the Car Table in the DB.
                int id = Integer.parseInt(ItemNumberTF.getText());
                String brand = BrandTF.getText();
                int year = Integer.parseInt(YearTF.getText());
                String color = this.ColorTF.getItemAt(this.ColorTF.getSelectedIndex());

                int num = DBMethods.addCarRecord(id, brand, year, color);
                if(num>0){
                    JOptionPane.showMessageDialog(this, "Car Added Successfully");
                    new AddCarToInventory().setVisible(true);
                    this.dispose();
                }
            }
            //Exception: CHecks if the "Year" TF is empty or is not a number
            catch(NumberFormatException e){ 
                if(String.valueOf(YearTF.getText()).equals("")){
                    JOptionPane.showMessageDialog(this, "'Year' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(this, "'Year' has to be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }

    //Cancel button action, returns to previous JFrame
    private void CancelActionPerformed(java.awt.event.ActionEvent evt){
        new AddCarToInventory().setVisible(true);
        this.dispose();
    }

    private JLabel ItemNumberLabel;
    private JLabel BrandLabel;
    private JLabel YearLabel;
    private JLabel ColorLabel;
    private JLabel TitleLabel;
    private JTextField ItemNumberTF;
    private JTextField BrandTF;
    private JTextField YearTF;
    private JComboBox<String> ColorTF;
    private JButton AddItemBtn;
    private JButton CancelBtn;

}
