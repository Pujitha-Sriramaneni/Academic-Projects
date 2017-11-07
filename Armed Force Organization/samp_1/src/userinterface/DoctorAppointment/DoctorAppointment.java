/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorAppointment;

import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author srchaudhuri
 */
public class DoctorAppointment extends javax.swing.JPanel {
    
    private JPanel container;
    private Enterprise enterprise;
    /**
     * Creates new form DoctorAppointment
     */
    public DoctorAppointment(JPanel container, Enterprise enterprise) {
        initComponents();
        this.container = container;
        this. enterprise = enterprise;
        doctorAppointment();
    }

    public DoctorAppointment(String userName) {
        initComponents(); 
doctorAppointment();//To change body of generated methods, choose Tools | Templates.
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
        doctable = new javax.swing.JTable();
        confirmAllbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        confirmbtn1 = new javax.swing.JButton();
        DeclinejButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Please Respond to the requests");

        doctable.setBackground(new java.awt.Color(204, 204, 0));
        doctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Req_ID", "Status", "Position"
            }
        ));
        jScrollPane1.setViewportView(doctable);

        confirmAllbtn.setBackground(new java.awt.Color(204, 204, 0));
        confirmAllbtn.setText("ConfirmAll");
        confirmAllbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAllbtnActionPerformed(evt);
            }
        });

        backbtn.setBackground(new java.awt.Color(204, 204, 0));
        backbtn.setText("<< Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        confirmbtn1.setBackground(new java.awt.Color(204, 204, 0));
        confirmbtn1.setText("Confirm");
        confirmbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbtn1ActionPerformed(evt);
            }
        });

        DeclinejButton.setBackground(new java.awt.Color(204, 204, 0));
        DeclinejButton.setText("Decline");
        DeclinejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeclinejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmAllbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(confirmbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeclinejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)))
                .addGap(0, 102, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmAllbtn)
                    .addComponent(confirmbtn1))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeclinejButton)
                    .addComponent(backbtn))
                .addContainerGap(173, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backbtnActionPerformed
 private void doctorAppointment() {
        String query = "select * from doc_app";
        DefaultTableModel model = (DefaultTableModel) doctable.getModel();
        model.setRowCount(0);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Object[] row = new Object[3];
                row[0] = rs.getInt("req_id");
                row[1] = rs.getString("Status");
                row[2] = rs.getString("Position");
                model.addRow(row);
            }
            rs.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        } //To change body of generated methods, choose Tools | Templates.
    }
    private void confirmAllbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAllbtnActionPerformed
        // TODO add your handling code here:
        String u_query = "update doc_app set Status = \"Confirmed\" where Status = \"Pending\"";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(u_query);
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }//GEN-LAST:event_confirmAllbtnActionPerformed

    private void confirmbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtn1ActionPerformed
              int count=doctable.getSelectedRowCount();
        if(count==0){
            JOptionPane.showMessageDialog(null, "InvalidRow Selection");
            return;
        }
        String req_id = doctable.getValueAt(doctable.getSelectedRow(), 0).toString();
        System.out.println(req_id);
        String u_query = "update doc_app set Status = \"Accepted\" where req_id = "+req_id+"";
        
//String u1_query = "update Request_Maintenance set Status = \"Accepted\" where Status = \"Active\"";//Maintain all data in one table
DefaultTableModel model = (DefaultTableModel) doctable.getModel();
try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root", "");
    Statement st = conn.createStatement();
    st.executeUpdate(u_query);
    //st.executeUpdate(u1_query);
    conn.close();
    LoadDoctorAppointment();
}
catch(Exception e){
    System.out.println("Error"+e);
}  // TODO add your handling code here:
    }//GEN-LAST:event_confirmbtn1ActionPerformed

    private void DeclinejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeclinejButtonActionPerformed
       int count=doctable.getSelectedRowCount();
        if(count==0){
            JOptionPane.showMessageDialog(null, "InvalidRow Selection");
            return;
        }
        String req_id = doctable.getValueAt(doctable.getSelectedRow(), 0).toString();
        System.out.println(req_id);
        String u_query = "update doc_app set Status = \"Declined\" where req_id = "+req_id+"";
        
//String u1_query = "update Request_Maintenance set Status = \"Accepted\" where Status = \"Active\"";//Maintain all data in one table
DefaultTableModel model = (DefaultTableModel) doctable.getModel();
try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root", "");
    Statement st = conn.createStatement();
    st.executeUpdate(u_query);
    //st.executeUpdate(u1_query);
    conn.close();
    LoadDoctorAppointment();
}
catch(Exception e){
    System.out.println("Error"+e);
}   // TODO add your handling code here:
    }//GEN-LAST:event_DeclinejButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeclinejButton;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton confirmAllbtn;
    private javax.swing.JButton confirmbtn1;
    private javax.swing.JTable doctable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void LoadDoctorAppointment() {
         String query = "select * from doc_app";
        DefaultTableModel model = (DefaultTableModel) doctable.getModel();
        model.setRowCount(0);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Object[] row = new Object[5];
                row[0] = rs.getInt("req_id");
                row[1] = rs.getString("Status");
                row[2] = rs.getString("Position");
                model.addRow(row);
            }
            rs.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error"+e);
        } //To change body of generated methods, choose Tools | Templates.
    } //To change body of generated methods, choose Tools | Templates.
    }

   