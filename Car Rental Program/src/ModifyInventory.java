import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class ModifyInventory extends javax.swing.JFrame {
    public ModifyInventory(){
        initComponents();
        jScrollPane.setVisible(true);
        try{
            ResultSet rs = DBMethods.getAllInventory();
            ItemList.removeAll();
            DefaultListModel<String> model = new DefaultListModel<>();
            ItemList.setModel(model);

            while(rs.next()){
                model.addElement(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4) + " " + rs.getString(5));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void initComponents(){

        TitleLabel = new JLabel();
        ItemList = new JList<>();
        jScrollPane = new JScrollPane();
        EditItemBtn = new JButton();
        CloseBtn = new JButton();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Modify Existing Inventory");
        
        jScrollPane.setViewportView(ItemList);

        EditItemBtn.setText("Edit Item");
        EditItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                EditItemActionPerformed(evt);
            }
        });

        CloseBtn.setText("Cancel");
        CloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18,18,18)
                        .addComponent(TitleLabel))
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EditItemBtn, 135,135,135)
                        .addComponent(CloseBtn,135,135,135))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23,23,23)
                .addComponent(TitleLabel)
                .addGap(18,18,18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18,18,18)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(EditItemBtn)
                    .addComponent(CloseBtn))
                .addGap(23,23,23)
                ));

        pack();
        setLocationRelativeTo(null);
    }
    
    private void EditItemActionPerformed(ActionEvent evt) {
        int id;
        String brand;
        String year;
        String color;
        String licenseplate;

        String selected = ItemList.getModel().getElementAt(ItemList.getSelectedIndex());
        
        int iend = selected.indexOf(' ');
            id = Integer.parseInt(selected.substring(0,iend));
            selected = selected.substring(iend+1);
        
        iend = selected.indexOf(' ');
            brand = selected.substring(0,iend);
            selected = selected.substring(iend+1);
        
        iend = selected.indexOf(' ');
            year = selected.substring(0,iend);
            selected = selected.substring(iend+1);
        
        iend = selected.indexOf(' ');
            color = selected.substring(0,iend);
            selected = selected.substring(iend+1);
        
        licenseplate = selected;

        EditSpecificInventory E = new EditSpecificInventory(id, brand, year, color, licenseplate);
        E.setVisible(true);
    }

    private void CloseActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }

    private JLabel TitleLabel;
    private JList<String> ItemList;
    private JScrollPane jScrollPane;
    private JButton EditItemBtn;
    private JButton CloseBtn;
}