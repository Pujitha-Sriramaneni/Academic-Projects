/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Government;

import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Sneha
 */
public class GovermentPermissionJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    /**
     * Creates new form GovermentWeaponJPanel
     */
    public GovermentPermissionJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        loadGovPerm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        govtWarPermJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        AcceptJButton = new javax.swing.JButton();
        declineJButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        govtWarPermJTable.setBackground(new java.awt.Color(204, 204, 0));
        govtWarPermJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Request ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(govtWarPermJTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Permission for War ");

        jButton1.setBackground(new java.awt.Color(204, 204, 0));
        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        AcceptJButton.setBackground(new java.awt.Color(204, 204, 0));
        AcceptJButton.setText("Accept");
        AcceptJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptJButtonActionPerformed(evt);
            }
        });

        declineJButton1.setBackground(new java.awt.Color(204, 204, 0));
        declineJButton1.setText("Decline");
        declineJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton1)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AcceptJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(declineJButton1)))))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AcceptJButton)
                    .addComponent(declineJButton1))
                .addContainerGap(268, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AcceptJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptJButtonActionPerformed
        int count=govtWarPermJTable.getSelectedRowCount();
        if(count==0){
            JOptionPane.showMessageDialog(null, "InvalidRow Selection");
            return;
        }
        String req_id = govtWarPermJTable.getValueAt(govtWarPermJTable.getSelectedRow(), 0).toString();
        System.out.println(req_id);
        String u_query = "update Request_Maintenance set Status = \"Accepted\" where req_id = "+req_id+"";
        DefaultTableModel model = (DefaultTableModel) govtWarPermJTable.getModel();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(u_query);
            
            conn.close();
            loadGovPerm();
        }
        catch(Exception e){
            System.out.println("Error");
        }// TODO add your handling code here:
    }//GEN-LAST:event_AcceptJButtonActionPerformed

    private void declineJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineJButton1ActionPerformed
        // TODO add your handling code here:
        int count=govtWarPermJTable.getSelectedRowCount();
        if(count==0){
            JOptionPane.showMessageDialog(null, "InvalidRow Selection");
            return;
        }
        String req_id = govtWarPermJTable.getValueAt(govtWarPermJTable.getSelectedRow(), 0).toString();
        System.out.println(req_id);
        String u_query = "update perm_id set Status = \"Declined\" where req_id = "+req_id+"";

        DefaultTableModel model = (DefaultTableModel) govtWarPermJTable.getModel();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(u_query);
            //st.executeUpdate(u1_query);
            conn.close();
            loadGovPerm();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }//GEN-LAST:event_declineJButton1ActionPerformed

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptJButton;
    private javax.swing.JButton declineJButton1;
    private javax.swing.JTable govtWarPermJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void loadGovPerm() {
       String query = "select * from Request_Maintenance";
        DefaultTableModel model = (DefaultTableModel) govtWarPermJTable.getModel();
        model.setRowCount(0);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Object[] row = new Object[2];
                row[0] = rs.getInt("req_id");
                row[1] = rs.getString("Status");
                model.addRow(row);
            }
            rs.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        } //To change body of generated methods, choose Tools | Templates.
    }
}
