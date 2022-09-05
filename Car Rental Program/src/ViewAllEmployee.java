import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

public class ViewAllEmployee extends javax.swing.JFrame {
    public ViewAllEmployee(){
        initComponents();
        jScrollPane.setVisible(true);
        try{
            ResultSet rs = DBMethods.getAllEmployee();
            Object column[]={"ID","Role","First Name","Last Name","Email","Phone Number","Username","Password", "Address ID"};
            DefaultTableModel model = new DefaultTableModel();
            model=(DefaultTableModel)jTable1.getModel();
            model.setColumnCount(8);
            model.setColumnIdentifiers(column);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(9),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(2)
                });
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void initComponents(){

        TitleLabel = new JLabel();
        jScrollPane = new JScrollPane();
        jTable1 = new JTable();
        CloseBtn = new JButton();
        ViewAllAddressBtn = new JButton();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("View All Employee");
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel());
        jTable1.setDefaultEditor(Object.class, null);
        jScrollPane.setViewportView(jTable1);

        CloseBtn.setText("Close");
        CloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                CloseActionPerformed(evt);
            }
        });

        ViewAllAddressBtn.setText("View Addresses");
        ViewAllAddressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ViewAllAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100,100,100)
                        .addComponent(TitleLabel))
                    .addComponent(jScrollPane,800,800,800)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CloseBtn,135,135,135)
                        .addComponent(ViewAllAddressBtn,135,135,135))))
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
                    .addComponent(CloseBtn)
                    .addComponent(ViewAllAddressBtn))
                .addGap(23,23,23)
                ));

        pack();
        setLocationRelativeTo(null);
    }

    private void ViewAllAddressActionPerformed(java.awt.event.ActionEvent evt){
        new ViewAllAddress().setVisible(true);
    }

    private void CloseActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }

    private JLabel TitleLabel;
    private JScrollPane jScrollPane;
    private JButton CloseBtn;
    private JButton ViewAllAddressBtn;
    private JTable jTable1;
}