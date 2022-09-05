import java.awt.Component;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class EditSpecificInventory extends javax.swing.JFrame {

    public EditSpecificInventory(Integer id, String brand, String year, String color, String licenseplate) {
        initComponents();
        try {
            ResultSet rs = DBMethods.getInventoryRecord(id);
            rs.next();
            ItemNumberTF.setText(rs.getString(1));

            ResultSet carPresets = DBMethods.getAllCar();
            while (carPresets.next()) {
                CarPresetTF.addItem(
                        carPresets.getString(2) + "-" + carPresets.getString(3) + "-" + carPresets.getString(4));
            }
            CarPresetTF.setSelectedItem(brand + "-" + year + "-" + color);

            LicensePlateTF.setText(rs.getString(5));
            RentalRateTF.setText(rs.getString(6));
            NotesTF.setText(rs.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {

        ItemNumberLabel = new JLabel();
        LicensePlateLabel = new JLabel();
        RentalRateLabel = new JLabel();
        NotesLabel = new JLabel();
        TitleLabel = new JLabel();
        CarPresetLabel = new JLabel();
        CarPresetTF = new JComboBox<>();
        ItemNumberTF = new JTextField();
        LicensePlateTF = new JTextField();
        RentalRateTF = new JTextField();
        NotesTF = new JTextArea();
        CarPresetTF = new JComboBox<>();
        EditItemBtn = new JButton();
        CancelBtn = new JButton();
        jScrollPane = new JScrollPane();

        TitleLabel.setFont(new java.awt.Font("Ariel", 1, 14));
        TitleLabel.setText("Edit Inventory Item");

        ItemNumberLabel.setText("Item Number:  ");

        ItemNumberTF.setEditable(false);

        CarPresetLabel.setText("Car Preset:  ");
        setJComboBoxReadOnly(CarPresetTF);

        LicensePlateLabel.setText("License Plate No.:  ");
        LicensePlateTF.setEditable(false);

        RentalRateLabel.setText("Rental Rate /Day:  ");

        NotesLabel.setText("Notes:  ");

        NotesTF.setColumns(20);
        NotesTF.setRows(5);
        jScrollPane.setViewportView(NotesTF);

        EditItemBtn.setText("Edit Item");
        EditItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditItemActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(TitleLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ItemNumberLabel)
                                                .addComponent(ItemNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(CarPresetLabel)
                                                .addComponent(CarPresetTF))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(LicensePlateLabel)
                                                .addComponent(LicensePlateTF, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(RentalRateLabel)
                                                .addComponent(RentalRateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(NotesLabel)
                                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(EditItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
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
                                        .addComponent(ItemNumberLabel)
                                        .addComponent(ItemNumberTF))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(CarPresetLabel)
                                        .addComponent(CarPresetTF))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(LicensePlateLabel)
                                        .addComponent(LicensePlateTF)
                                        .addComponent(RentalRateLabel)
                                        .addComponent(RentalRateTF))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(NotesLabel)
                                        .addComponent(jScrollPane))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(EditItemBtn)
                                        .addComponent(CancelBtn))));

        pack();
        setLocationRelativeTo(null);
    }

    private void EditItemActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = Integer.parseInt(ItemNumberTF.getText());            
            int rentalrate = Integer.parseInt(RentalRateTF.getText());
            String note = String.valueOf(NotesTF.getText());

            int num = DBMethods.updateInventoryRecord(id, rentalrate, note);
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Inventory Updated Successfully!");
                this.dispose();
            }
        } catch (NumberFormatException ex) {
            if (String.valueOf(RentalRateTF.getText()).equals("")) {
                JOptionPane.showMessageDialog(this, "'Rental Rate' cannot be empty.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "'Rental Rate' has to be a number.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    private void setJComboBoxReadOnly(JComboBox<String> jcb) {
        JTextField jtf = (JTextField) jcb.getEditor().getEditorComponent();
        jtf.setEditable(false);

        MouseListener[] mls = jcb.getMouseListeners();
        for (MouseListener listener : mls)
            jcb.removeMouseListener(listener);

        Component[] comps = jcb.getComponents();
        for (Component c : comps) {
            if (c instanceof AbstractButton) {
                AbstractButton ab = (AbstractButton) c;
                ab.setEnabled(false);

                MouseListener[] mls2 = ab.getMouseListeners();
                for (MouseListener listener : mls2)
                    ab.removeMouseListener(listener);
            }
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
    private JButton EditItemBtn;
    private JButton CancelBtn;
    private JScrollPane jScrollPane;

}
