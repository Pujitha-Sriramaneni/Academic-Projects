/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Government;

import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Sneha
 */
public class GovermentWeaponsJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    /**
     * Creates new form GovermentWeaponsJPanel
     */
    public GovermentWeaponsJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        LoadGovWeapons();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        govtWeaponsPermJTable = new javax.swing.JTable();
        acceptJButton = new javax.swing.JButton();
        declineJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Permission for Weapons ");

        govtWeaponsPermJTable.setBackground(new java.awt.Color(204, 204, 0));
        govtWeaponsPermJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(govtWeaponsPermJTable);

        acceptJButton.setBackground(new java.awt.Color(204, 204, 0));
        acceptJButton.setText("Accept");
        acceptJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptJButtonActionPerformed(evt);
            }
        });

        declineJButton.setBackground(new java.awt.Color(204, 204, 0));
        declineJButton.setText("Decline");
        declineJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineJButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 0));
        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(acceptJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(declineJButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptJButton)
                    .addComponent(declineJButton))
                .addContainerGap(259, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void acceptJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptJButtonActionPerformed
        // TODO add your handling code here:
      /*int count=govtWeaponsPermJTable.getSelectedRowCount();
        if(count==0){
            JOptionPane.showMessageDialog(null, "InvalidRow Selection");
            return;
        }
        String req_id = govtWeaponsPermJTable.getValueAt(govtWeaponsPermJTable.getSelectedRow(), 0).toString();
        System.out.println(req_id);
        String u_query = "update govw_perm_id set Status = \"Accepted\" where req_id = "+req_id+"";
         String u1_query = "update solw_perm_id set Status = \"Accepted\" where req_id = "+req_id+"";
        DefaultTableModel model = (DefaultTableModel) govtWeaponsPermJTable.getModel();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(u_query);
            LoadGovWeapons();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
        */
        int count=govtWeaponsPermJTable.getSelectedRowCount();
        if(count==0){
            JOptionPane.showMessageDialog(null, "InvalidRow Selection");
            return;
        }
        String req_id = govtWeaponsPermJTable.getValueAt(govtWeaponsPermJTable.getSelectedRow(), 0).toString();
        System.out.println(req_id);
        String u_query = "update Request_Maintenance set Status = \"Accepted\" where req_id = "+req_id+"";
        DefaultTableModel model = (DefaultTableModel) govtWeaponsPermJTable.getModel();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(u_query);
            LoadGovWeapons();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }//GEN-LAST:event_acceptJButtonActionPerformed

    private void declineJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineJButtonActionPerformed
        // TODO add your handling code here:
        /*String u_query = "update govw_perm_id set Status = \"Declined\" where Status = \"Active\"";
        String u1_query = "update solw_perm_id set Status = \"Declined\" where Status = \"Active\"";

        DefaultTableModel model = (DefaultTableModel) govtWeaponsPermJTable.getModel();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(u_query);
            st.executeUpdate(u1_query);            
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }*/
        int count=govtWeaponsPermJTable.getSelectedRowCount();
        if(count==0){
            JOptionPane.showMessageDialog(null, "InvalidRow Selection");
            return;
        }
        String req_id = govtWeaponsPermJTable.getValueAt(govtWeaponsPermJTable.getSelectedRow(), 0).toString();
        System.out.println(req_id);
        String u_query = "update Request_Maintenance set Status = \"Declined\" where req_id = "+req_id+"";
        DefaultTableModel model = (DefaultTableModel) govtWeaponsPermJTable.getModel();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(u_query);
            LoadGovWeapons();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }//GEN-LAST:event_declineJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptJButton;
    private javax.swing.JButton declineJButton;
    private javax.swing.JTable govtWeaponsPermJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void LoadGovWeapons() {
       String query = "select * from Request_Maintenance";
        DefaultTableModel model = (DefaultTableModel) govtWeaponsPermJTable.getModel();
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
