/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PositionWorkArea;

import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.JOptionPane;
import userinterface.DoctorAppointment.AppointmentStatus;
import Business.EcoSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JPanel;

/**
 *
 * @author Sneha
 */
public class TrainerDisplayJPanel extends javax.swing.JPanel {
    
    private JPanel container;
    private Enterprise enterprise;
    String user;
    
    
    private JPanel containerflow = null;
   
    JPanel userProcessContainer;
    EcoSystem system;
    
    /**
     * Creates new form trainerJPanel
     */
    public TrainerDisplayJPanel(JPanel container, Enterprise enterprise, String user) {
        initComponents();       
        this.container = container;
        this. enterprise = enterprise;
        this.user = user;
        loadTrainerDetails();
    }

   /* public TrainerDisplayJPanel(String userName) {        
        initComponents();      
        this.container = container;
        this. enterprise = enterprise;
        this.user = userName;
        loadTrainerDetails();
    }*/
    
    public TrainerDisplayJPanel(String userName) {
        initComponents();
        this.user = userName;
        this.container = container;
        loadTrainerDetails();
        System.out.print(userName);
    }

    public TrainerDisplayJPanel(String userName, JPanel container) {
        initComponents();
        this.user = userName;
        this.container = container;
        loadTrainerDetails();
        System.out.print(userName); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        docapplabel = new javax.swing.JLabel();
        dobTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        soldierTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dateOfJoiningJTextField = new javax.swing.JTextField();
        benefittextfield = new javax.swing.JTextField();
        gendertextfield = new javax.swing.JTextField();
        docAppointmentJButton = new javax.swing.JButton();
        statusbtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("Name");

        nameTextField.setEditable(false);
        nameTextField.setBackground(new java.awt.Color(204, 204, 0));

        idTextField.setEditable(false);
        idTextField.setBackground(new java.awt.Color(204, 204, 0));

        jLabel6.setText("ID");

        docapplabel.setText("<Appointment Number>");

        dobTextField.setEditable(false);
        dobTextField.setBackground(new java.awt.Color(204, 204, 0));

        addressTextArea.setEditable(false);
        addressTextArea.setBackground(new java.awt.Color(204, 204, 0));
        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);
        jScrollPane1.setViewportView(addressTextArea);

        jLabel4.setText("Gender");

        jLabel5.setText("Address");

        phoneTextField.setEditable(false);
        phoneTextField.setBackground(new java.awt.Color(204, 204, 0));

        jLabel7.setText("Phone Number");

        jLabel8.setText("No. of the soliers");

        soldierTextField.setEditable(false);
        soldierTextField.setBackground(new java.awt.Color(204, 204, 0));

        jLabel10.setText("Benefits");

        backJButton.setBackground(new java.awt.Color(204, 204, 0));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trainer Account");

        jLabel9.setText("Date of Joining");

        dateOfJoiningJTextField.setEditable(false);
        dateOfJoiningJTextField.setBackground(new java.awt.Color(204, 204, 0));

        benefittextfield.setEditable(false);
        benefittextfield.setBackground(new java.awt.Color(204, 204, 0));

        gendertextfield.setEditable(false);
        gendertextfield.setBackground(new java.awt.Color(204, 204, 0));

        docAppointmentJButton.setBackground(new java.awt.Color(204, 204, 0));
        docAppointmentJButton.setText("Schedule Doctor's Appointment");
        docAppointmentJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docAppointmentJButtonActionPerformed(evt);
            }
        });

        statusbtn.setBackground(new java.awt.Color(204, 204, 0));
        statusbtn.setText("Check Appointment Status");
        statusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusbtnActionPerformed(evt);
            }
        });

        jLabel11.setText("Date of birth");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docapplabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(docAppointmentJButton)
                        .addGap(59, 59, 59)
                        .addComponent(statusbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(benefittextfield, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addComponent(soldierTextField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(gendertextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateOfJoiningJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(362, 362, 362))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(backJButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfJoiningJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gendertextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soldierTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(benefittextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docAppointmentJButton)
                    .addComponent(statusbtn))
                .addGap(36, 36, 36)
                .addComponent(docapplabel)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);

    }//GEN-LAST:event_backJButtonActionPerformed
    private void loadTrainerDetails() {
 String query = "select * from trainer_details where username = \""+user+"\"";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("Name");
                nameTextField.setText(name);
                
                String ID = rs.getString("ID");
                idTextField.setText(ID);
                
                String dob = rs.getDate("DOB").toString();
                dobTextField.setText(dob);
                
                String doj = rs.getDate("DOJ").toString();
                dateOfJoiningJTextField.setText(doj);
                
                String gender = rs.getString("Gender");
                gendertextfield.setText(gender);
                
                String address = rs.getString("Address");
                addressTextArea.setText(address);
                
                int phone = rs.getInt("Phone");
                phoneTextField.setText(Integer.toString(phone));
                
                int sol = rs.getInt("Soldier_no");
                soldierTextField.setText(Integer.toString(sol));
                
                String ben = rs.getString("Benefits");
                benefittextfield.setText(ben);
            }
            rs.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    private void docAppointmentJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docAppointmentJButtonActionPerformed
        // TODO add your handling code here:
        int app_id = (int)(Math.random()*100);
        docapplabel.setText("Your Appointment ID is "+app_id);

        String query = "insert into doc_app(req_id,Status,Position) values("+app_id+",\"Pending\",\"Trainer\")";
System.out.println(query);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys","root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            jLabel1.setText("Sucessfully Added");
            conn.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
        
        
        /*int app_id = (int) (Math.random() * 100);
        appointmentlabel.setText("Your Appointment ID is " + app_id);

        String query = "insert into doc_app(req_id,Status,Position) values(" + app_id + ",\"Pending\",\"name\")";
 System.out.println(query);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "");
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            jLabel1.setText("Sucessfully Added");
            conn.close();
             loadSoldierDetails();
        } catch (Exception e) {
            System.out.println("Error"+e);
        }*/
        
        
        
    }//GEN-LAST:event_docAppointmentJButtonActionPerformed

    private void statusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusbtnActionPerformed
        // TODO add your handling code here:
       String poc = docapplabel.getText();
        if (null != poc && !poc.equalsIgnoreCase("")) { AppointmentStatus ap = new AppointmentStatus(user);
        container.removeAll();
        container.add("AppointmentStatus", ap);

        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        
        } else {
            JOptionPane.showMessageDialog(null, "Appointment ID is null");
        }
        
        
        /*String poc = appointmentlabel.getText();
        if (null != poc && !poc.equalsIgnoreCase("")) {

            AppointmentStatus ap = new AppointmentStatus(user);

            containerflow.removeAll();
            containerflow.add("AppointmentStatus", ap);
            CardLayout crdLyt = (CardLayout) containerflow.getLayout();
            crdLyt.next(containerflow);
        } else {
            JOptionPane.showMessageDialog(null, "Appointment ID is null");
        }*/
        
    }//GEN-LAST:event_statusbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField benefittextfield;
    private javax.swing.JTextField dateOfJoiningJTextField;
    private javax.swing.JTextField dobTextField;
    private javax.swing.JButton docAppointmentJButton;
    private javax.swing.JLabel docapplabel;
    private javax.swing.JTextField gendertextfield;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JTextField soldierTextField;
    private javax.swing.JButton statusbtn;
    // End of variables declaration//GEN-END:variables
}
