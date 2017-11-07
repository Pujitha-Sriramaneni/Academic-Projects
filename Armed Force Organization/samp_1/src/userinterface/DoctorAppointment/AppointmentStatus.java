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
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.PositionWorkArea.SoldierDisplayJPanel;

/**
 *
 * @author srchaudhuri
 */
public class AppointmentStatus extends javax.swing.JPanel {
    JPanel userProcessContainer;
    private JPanel container;
    private Enterprise enterprise;
    String pos;
    public String user;
     private JPanel Containerflow;
    /**
     * Creates new form AppointmentStatus
     */
    public AppointmentStatus(JPanel container, Enterprise enterprise, String pos) {
        initComponents();
        this.container = container;
        this. enterprise = enterprise;
        this.pos = pos;
        appointmentStatus();
    }
AppointmentStatus(String user, JPanel containerflow) {//direct login
        initComponents();
       
        this.user = user;
        this.Containerflow=containerflow;
        System.out.println(user);
        appointmentStatus();
    }
    public AppointmentStatus(String pos) {
        initComponents();
        this.pos =pos;
        
       appointmentStatus(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AppointmentStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentStatusjTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        AppointmentStatus.setBackground(new java.awt.Color(153, 153, 153));
        AppointmentStatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AppointmentStatus.setText("Appointment Status");

        appointmentStatusjTable.setBackground(new java.awt.Color(204, 204, 0));
        appointmentStatusjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(appointmentStatusjTable);

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
                        .addGap(208, 208, 208)
                        .addComponent(AppointmentStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(AppointmentStatus)
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
/*private void appointmentStatus() {
        String query = "select * from doc_app where pos = \""+pos+"\"";
        DefaultTableModel model = (DefaultTableModel) appointmentStatusjTable.getModel();
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
        }//To change body of generated methods, choose Tools | Templates.
    }*///Commented after testing





    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       /*container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
        */
        
                    SoldierDisplayJPanel hp = new SoldierDisplayJPanel(user,Containerflow);
                        Containerflow.removeAll();
                        Containerflow.add("SoldierDisplayJPanel", hp);
                        CardLayout crdLyt = (CardLayout) Containerflow.getLayout();
                        crdLyt.next(Containerflow);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppointmentStatus;
    private javax.swing.JTable appointmentStatusjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void appointmentStatus() {
        String query = "select * from doc_app";
        DefaultTableModel model = (DefaultTableModel) appointmentStatusjTable.getModel();
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

    
}