/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PositionWorkArea;

import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import userinterface.AdministrativeRole.UserDetailIO;

/**
 *
 * @author Sneha
 */
public class SoldierDetailsEntryJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Enterprise enterprise;

    /**
     * Creates new form SoldierJPanel
     */
    UserDetailIO udio;
    public SoldierDetailsEntryJPanel(JPanel container, Enterprise enterprise) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        dobTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        trainerNameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        UsernameJTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        JPasswordField = new javax.swing.JPasswordField();
        createJButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        dateOfJoiningTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        phoneNumberJTextField = new javax.swing.JTextField();
        genderJComboBox = new javax.swing.JComboBox<>();
        educationJCheckBox = new javax.swing.JCheckBox();
        housingJCheckBox = new javax.swing.JCheckBox();
        foodCouponsJCheckBox = new javax.swing.JCheckBox();
        giftCardsJCheckBox = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to the soldier entry page - Please enter your details below");

        jLabel2.setText("Name");

        jLabel3.setText("Date of birth");

        jLabel4.setText("Gender");

        jLabel5.setText("Address");

        jLabel6.setText("ID");

        addressTextArea.setBackground(new java.awt.Color(204, 204, 0));
        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);
        jScrollPane1.setViewportView(addressTextArea);

        dobTextField.setBackground(new java.awt.Color(204, 204, 0));

        idTextField.setBackground(new java.awt.Color(204, 204, 0));

        nameTextField.setBackground(new java.awt.Color(204, 204, 0));
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("Name of the trainer");

        trainerNameTextField.setBackground(new java.awt.Color(204, 204, 0));

        jLabel10.setText("Benefits");

        backJButton.setBackground(new java.awt.Color(204, 204, 0));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("User name");

        UsernameJTextField.setBackground(new java.awt.Color(204, 204, 0));
        UsernameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameJTextFieldActionPerformed(evt);
            }
        });

        jLabel11.setText("Password");

        JPasswordField.setBackground(new java.awt.Color(204, 204, 0));

        createJButton.setBackground(new java.awt.Color(204, 204, 0));
        createJButton.setText("Create");
        createJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createJButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Date of Joining");

        dateOfJoiningTextField.setBackground(new java.awt.Color(204, 204, 0));

        jLabel7.setText("Phone Number");

        phoneNumberJTextField.setBackground(new java.awt.Color(204, 204, 0));

        genderJComboBox.setBackground(new java.awt.Color(204, 204, 0));
        genderJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        educationJCheckBox.setBackground(new java.awt.Color(204, 204, 0));
        educationJCheckBox.setText("Education");

        housingJCheckBox.setBackground(new java.awt.Color(204, 204, 0));
        housingJCheckBox.setText("Housing");

        foodCouponsJCheckBox.setBackground(new java.awt.Color(204, 204, 0));
        foodCouponsJCheckBox.setText("Food Coupons");

        giftCardsJCheckBox.setBackground(new java.awt.Color(204, 204, 0));
        giftCardsJCheckBox.setText("Gift Cards");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(backJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(housingJCheckBox)
                            .addComponent(giftCardsJCheckBox))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(educationJCheckBox)
                            .addComponent(foodCouponsJCheckBox))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createJButton)
                            .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trainerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dobTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(idTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(phoneNumberJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(dateOfJoiningTextField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(JPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 163, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(backJButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dateOfJoiningTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(phoneNumberJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trainerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(housingJCheckBox)
                            .addComponent(educationJCheckBox))
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foodCouponsJCheckBox)
                    .addComponent(giftCardsJCheckBox))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPasswordField)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(createJButton)
                .addGap(96, 96, 96))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void createJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createJButtonActionPerformed
        // TODO add your handling code here:
        String dob = dobTextField.getText();
        String x = dobTextField.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = "";
        try {
            formattedDate = sdf.format(sdf.parse(x));
        } catch (ParseException ex) {
            Logger.getLogger(SoldierDetailsEntryJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (formattedDate.equals(x)) {
            String doj = dateOfJoiningTextField.getText();
            String y = dateOfJoiningTextField.getText();
            try {
                formattedDate = sdf.format(sdf.parse(y));
            } catch (ParseException ex) {
                Logger.getLogger(SoldierDetailsEntryJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (formattedDate.equals(y)) {
                String name = nameTextField.getText();
                String ID = idTextField.getText();
                if (ID.matches("[A-Z]{5}[0-9]{2}")) {
                    String ph = phoneNumberJTextField.getText();
                    if (ph.matches("[0-9]{10}")) {
                        String gender = (String) genderJComboBox.getSelectedItem();
                        String address = addressTextArea.getText();
                        String trainer = trainerNameTextField.getText();
                        String ben1 = "", ben2 = "", ben3 = "", ben4 = "";
                        if (educationJCheckBox.isSelected()) {
                            ben1 = educationJCheckBox.getText();
                        }
                        if (foodCouponsJCheckBox.isSelected()) {
                            ben2 = foodCouponsJCheckBox.getText();
                        }
                        if (giftCardsJCheckBox.isSelected()) {
                            ben3 = giftCardsJCheckBox.getText();
                        }
                        if (housingJCheckBox.isSelected()) {
                            ben4 = housingJCheckBox.getText();
                        }
                        String benefits = ben1 + " " + ben2 + " " + ben3 + " " + ben4;
                        String username = UsernameJTextField.getText();
                        String pass = new String(JPasswordField.getPassword());

                        String query = "insert into soldier_details values(\"" + name + "\",\"" + ID + "\",\'" + dob + "\',\'" + doj + "\'," + ph + ",\"" + gender + "\",\"" + address + "\",\"" + trainer + "\",\"" + benefits + "\",\"" + username + "\",\"" + pass + "\")";

                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
                            Statement st = conn.createStatement();
                            st.executeUpdate(query);
                            conn.close();
                            JOptionPane.showMessageDialog(null, "Account Created");
                        } catch (Exception e) {
                            System.out.println("Error" + e);
                        }
    }//GEN-LAST:event_createJButtonActionPerformed
else {
                        JOptionPane.showMessageDialog(null, "please enter a valid Phone Number");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "please enter a valid ID");
                }
            } else {
                JOptionPane.showMessageDialog(null, "please enter a valid date for doj");
            }
        } else {
            JOptionPane.showMessageDialog(null, "please enter a valid date for dob");
        }
    }


    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void UsernameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameJTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JPasswordField;
    private javax.swing.JTextField UsernameJTextField;
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton createJButton;
    private javax.swing.JTextField dateOfJoiningTextField;
    private javax.swing.JTextField dobTextField;
    private javax.swing.JCheckBox educationJCheckBox;
    private javax.swing.JCheckBox foodCouponsJCheckBox;
    private javax.swing.JComboBox<String> genderJComboBox;
    private javax.swing.JCheckBox giftCardsJCheckBox;
    private javax.swing.JCheckBox housingJCheckBox;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneNumberJTextField;
    private javax.swing.JTextField trainerNameTextField;
    // End of variables declaration//GEN-END:variables
}
