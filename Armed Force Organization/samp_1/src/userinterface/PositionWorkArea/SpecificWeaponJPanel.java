/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PositionWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pujitha sriramaneni
 */
public class SpecificWeaponJPanel extends javax.swing.JPanel {

    private JPanel Containerflow;
    private EcoSystem system;
    Enterprise enterprise;
    private JPanel container;

    public String user;

    /**
     * Creates new form SpecificWeaponJPanel
     */
    public SpecificWeaponJPanel() {
        initComponents();
    }

    public SpecificWeaponJPanel(JPanel userProcessContainer, Enterprise enterprise, String user) {//from other pages
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        this.user = user;

    }

    SpecificWeaponJPanel(String user, JPanel containerflow) {//direct login
        initComponents();
        addlistners();
        this.user = user;
        this.Containerflow=containerflow;
        System.out.println(user);
        LoadWeaponRequest();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WeaponNamejComboBox = new javax.swing.JComboBox<>();
        SubmitRequestjButton = new javax.swing.JButton();
        WeaponCountjTextField = new javax.swing.JTextField();
        PredictJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        backjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        WeaponNamejComboBox.setBackground(new java.awt.Color(204, 204, 0));
        WeaponNamejComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rifles", "Carbines", "ShortGuns", "Grenades", "ShortGuns", "SubMachine Guns", "Mines", "Swords" }));

        SubmitRequestjButton.setBackground(new java.awt.Color(204, 204, 0));
        SubmitRequestjButton.setText("Submit");
        SubmitRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitRequestjButtonActionPerformed(evt);
            }
        });

        WeaponCountjTextField.setBackground(new java.awt.Color(204, 204, 0));
        WeaponCountjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeaponCountjTextFieldActionPerformed(evt);
            }
        });

        PredictJButton.setBackground(new java.awt.Color(204, 204, 0));
        PredictJButton.setText("Predict");
        PredictJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PredictJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Result");

        jTable1.setBackground(new java.awt.Color(204, 204, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Status", "Item", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        backjButton.setBackground(new java.awt.Color(204, 204, 0));
        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Please enter number of items required");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("                          SECURED");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(backjButton)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(WeaponCountjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(WeaponNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PredictJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SubmitRequestjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(backjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WeaponCountjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WeaponNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubmitRequestjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PredictJButton)
                    .addComponent(jLabel1))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(402, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitRequestjButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubmitRequestjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        SoldierDisplayJPanel hp = new SoldierDisplayJPanel(user,Containerflow);
                        Containerflow.removeAll();
                        //JPanel blankJP = new JPanel();
                        Containerflow.add("SoldierDisplayJPanel", hp);
                        CardLayout crdLyt = (CardLayout) Containerflow.getLayout();
                        crdLyt.next(Containerflow); // TODO add your handling code here:
        //Containerflow.remove(this);
        //CardLayout layout = (CardLayout) Containerflow.getLayout();
        //layout.previous(Containerflow);
        
    }//GEN-LAST:event_backjButtonActionPerformed

    private void PredictJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PredictJButtonActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_PredictJButtonActionPerformed

    private void WeaponCountjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeaponCountjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WeaponCountjTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PredictJButton;
    private javax.swing.JButton SubmitRequestjButton;
    private javax.swing.JTextField WeaponCountjTextField;
    private javax.swing.JComboBox<String> WeaponNamejComboBox;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void addlistners() {
        String userName = user;
        PredictJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PredictJButtonActionPerformed(evt);
            }

            private void PredictJButtonActionPerformed(ActionEvent evt) {
                System.out.println("Predict clicked");
                String strItem = WeaponNamejComboBox.getSelectedItem().toString();
                
                String query = "select * from Request_Maintenance where Status='Accepted' and Name='" + strItem + "'";//"select * from Request_Maintenance where Status=/"+"Accepted"+/" and Name=/"+strItem+/"/";
                System.out.println("Predict clicked"+query);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    String quantity = "";
                    while (rs.next()) {
                        quantity = rs.getString("quantity");
                        if (null != quantity && !quantity.equalsIgnoreCase("")) {
                            WeaponCountjTextField.setText(quantity);
                            break;
                        }

                    }

                    rs.close();
                    conn.close();
                } catch (Exception e) {
                    System.out.println("Error");
                } //To change body of generated methods, choose Tools | Templates.

                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        SubmitRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }

            private void submitJButtonActionPerformed(ActionEvent evt) {
                int perm_id = (int) (Math.random() * 1000);
                //permidlabel.setText("Your Permission ID is " + perm_id);
                String quantity = WeaponCountjTextField.getText();
                String Name = WeaponNamejComboBox.getSelectedItem().toString();
                String role = "Soldier";
                String status = "Active";
                String user = "potato";
                String Organization_name = "Army";
                String Country = "USA";
                String Continent = "NorthAmerica";//userName;//remove user
                String query = "insert into Request_Maintenance values(\"" + perm_id + "\",\"" + status + "\",\"" + user + "\",\"" + quantity + "\",\"" + Name + "\",\"" + role + "\",\"" + Organization_name + "\",\"" + Country + "\",\"" + Continent + "\")";
                System.out.println(query);
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
                    Statement st = conn.createStatement();
                    st.executeUpdate(query);
                    jLabel1.setText("Sucessfully Added");
                    conn.close();
                    LoadWeaponRequest();
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }

            private void LoadWeaponRequest() {

                String query = "select * from Request_Maintenance";
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        Object[] row = new Object[4];
                        row[0] = rs.getInt("req_id");
                        row[1] = rs.getString("Status");
                        row[2] = rs.getString("Name");
                        row[3] = rs.getString("quantity");
                        //row[4] = rs.getString("user");
                        model.addRow(row);
                    }
                    rs.close();
                    conn.close();
                } catch (Exception e) {
                    System.out.println("Error");
                } //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    private void LoadWeaponRequest() {
        String query = "select * from Request_Maintenance";
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getInt("req_id");
                row[1] = rs.getString("Status");
                row[2] = rs.getString("Name");
                row[3] = rs.getString("quantity");
                row[4] = rs.getString("user");
                model.addRow(row);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
        } //To change body of generated methods, choose Tools | Templates.

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
