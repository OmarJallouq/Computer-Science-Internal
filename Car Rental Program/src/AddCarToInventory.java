import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

/*
 * JFrame responsible in adding a specific car into the Rental Company's Inventory
 */

public class AddCarToInventory extends  javax.swing.JFrame {
    
    //Initializes the ID field to the pre-set auto-incremented number from DB
    //Initializes Car Preset drop down to values present in Car Table in DB
    public AddCarToInventory() {
        initComponents();
        try{
            int itemid = DBMethods.getInventoryMaxID() + 1;
            ItemNumberTF.setText(String.valueOf(itemid));
            ResultSet rs = DBMethods.getAllCar();
            
            while(rs.next()){
                CarPresetTF.addItem(rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void initComponents() {

        //Initializes the components on the JFrame
        ItemNumberLabel = new JLabel();
        LicensePlateLabel = new JLabel();
        RentalRateLabel = new JLabel();
        NotesLabel = new JLabel();
        TitleLabel = new JLabel();
        CarPresetLabel = new JLabel();
        ItemNumberTF = new JTextField();
        LicensePlateTF = new JTextField();
        RentalRateTF = new JTextField();
        NotesTF = new JTextArea();
        CarPresetTF = new JComboBox<>();
        CreateNewPresetBtn = new JButton();
        AddItemBtn = new JButton();
        CancelBtn = new JButton();
        jScrollPane = new JScrollPane();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Add New Car to Inventory");

        ItemNumberLabel.setText("Item Number:  ");

        ItemNumberTF.setEditable(false);

        CarPresetLabel.setText("Car Preset:  ");

        LicensePlateLabel.setText("License Plate No.:  ");
        
        RentalRateLabel.setText("Rental Rate /Day:  ");
        
        NotesLabel.setText("Notes:  ");

        NotesTF.setColumns(20);
        NotesTF.setRows(5);
        jScrollPane.setViewportView(NotesTF);

        CreateNewPresetBtn.setText("Create New Preset");
        CreateNewPresetBtn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewPresetPerformed(evt);
            }
        });
        
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
                            .addGap(55,55,55)
                            .addComponent(TitleLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ItemNumberLabel)
                            .addComponent(ItemNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CarPresetLabel)
                            .addComponent(CarPresetTF)
                            .addComponent(CreateNewPresetBtn)
                        )
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LicensePlateLabel)
                            .addComponent(LicensePlateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RentalRateLabel)
                            .addComponent(RentalRateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(NotesLabel)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(AddItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(ItemNumberLabel)
                        .addComponent(ItemNumberTF))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(CarPresetLabel)
                        .addComponent(CarPresetTF)
                        .addComponent(CreateNewPresetBtn))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(LicensePlateLabel)
                        .addComponent(LicensePlateTF)
                        .addComponent(RentalRateLabel)
                        .addComponent(RentalRateTF))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(NotesLabel)
                        .addComponent(jScrollPane))
                    .addGap(18,18,18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(AddItemBtn)
                        .addComponent(CancelBtn))));  
        
        pack();
        setLocationRelativeTo(null);
    }

    //Create new preset button action: Opens the Add Car JFrame
    private void CreateNewPresetPerformed(ActionEvent evt) {
        new AddCar().setVisible(true);
        this.dispose();
    }

    //Add item button action: Adds the specific car into the Inventory Table in DB
    private void AddItemActionPerformed(java.awt.event.ActionEvent evt){
        //Checks to see if required fields are empty
        if(LicensePlateTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "'License Plate Number' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                //Gets the field values from the Text Fields and inputs them into the Inventory Table in the DB.
                int id = Integer.parseInt(ItemNumberTF.getText());
                String preset = this.CarPresetTF.getItemAt(this.CarPresetTF.getSelectedIndex());
                String brand = "";
                String year = "";
                String color = "";
                
                int iend = preset.indexOf('-');
                    brand = preset.substring(0, iend);
                    preset = preset.substring(iend+1);

                iend = preset.indexOf('-');
                    year = preset.substring(0, iend);
                    preset = preset.substring(iend+1);
                
                    color = preset;

                String licenseplate = String.valueOf(LicensePlateTF.getText());
                int rentalrate = Integer.parseInt(RentalRateTF.getText());
                String note = String.valueOf(NotesTF.getText());
            
                //Gets the ID from the Car Table in DB
                Connection con = MyConnection.getMyConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT id FROM car WHERE Brand='"+brand+"' AND Year='"+year+"' AND Color='"+color+"'");
                ResultSet rs = stmt.executeQuery();
                rs.next();
                int CarID = rs.getInt(1);

                int num = DBMethods.addInventoryRecord(id, CarID, licenseplate, rentalrate, note);
                if(num>0){
                    JOptionPane.showMessageDialog(this, "Item Added Successfully!");
                    this.dispose();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            //Exception: CHecks if the "Rental Rate" TF is empty or is not a number
            catch(NumberFormatException ex){
                if(String.valueOf(RentalRateTF.getText()).equals("")){
                    JOptionPane.showMessageDialog(this, "'Rental Rate' cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "'Rental Rate' has to be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    //Cancel button action, closes this JFrame
    private void CancelActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }
    
    //Function that checks if a certain string solely composed of an integer
    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    private JLabel ItemNumberLabel;
    private JLabel LicensePlateLabel;
    private JLabel RentalRateLabel;
    private JLabel NotesLabel; 
    private JLabel TitleLabel;
    private JLabel CarPresetLabel;
    private JTextField ItemNumberTF;
    private JTextField LicensePlateTF;
    private JTextField RentalRateTF;
    private JTextArea NotesTF;
    private JComboBox<String> CarPresetTF;
    private JButton CreateNewPresetBtn;
    private JButton AddItemBtn;
    private JButton CancelBtn;
    private JScrollPane jScrollPane;

}
