/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.PositionWorkArea.PositionWorkAreaJPanel;
import userinterface.Government.GovernmentAuthorizationJPanel;
/**
 *
 * @author Sneha
 */
public class MilitaryJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserDetailIO udio=new UserDetailIO();
    /**
     * Creates new form MilitaryJPanel
     */
    public MilitaryJPanel(JPanel userProcessContainer, Enterprise enterprise, String country) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        conuntryValue.setText(country);
        this.udio=udio;
    }

    MilitaryJPanel(JPanel userProcessContainer, Enterprise enterprise, String country, UserDetailIO udio) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        conuntryValue.setText(country);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        conuntryValue = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        armyJButton = new javax.swing.JButton();
        navyJButton = new javax.swing.JButton();
        airForceJButton = new javax.swing.JButton();
        govtSignInJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Select your Division");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to the ");

        conuntryValue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        conuntryValue.setText("<value>");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Military");

        jButton1.setBackground(new java.awt.Color(204, 204, 0));
        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        armyJButton.setBackground(new java.awt.Color(204, 204, 0));
        armyJButton.setText("Army");
        armyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armyJButtonActionPerformed(evt);
            }
        });

        navyJButton.setBackground(new java.awt.Color(204, 204, 0));
        navyJButton.setText("Navy");
        navyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navyJButtonActionPerformed(evt);
            }
        });

        airForceJButton.setBackground(new java.awt.Color(204, 204, 0));
        airForceJButton.setText("Air Force");
        airForceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airForceJButtonActionPerformed(evt);
            }
        });

        govtSignInJButton.setBackground(new java.awt.Color(204, 204, 0));
        govtSignInJButton.setText("Goverment--Sign in");
        govtSignInJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                govtSignInJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(185, 185, 185)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(conuntryValue)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(289, 289, 289)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(navyJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(armyJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(airForceJButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(govtSignInJButton)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(conuntryValue)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(38, 38, 38)
                .addComponent(armyJButton)
                .addGap(33, 33, 33)
                .addComponent(navyJButton)
                .addGap(28, 28, 28)
                .addComponent(airForceJButton)
                .addGap(38, 38, 38)
                .addComponent(govtSignInJButton)
                .addContainerGap(216, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void govtSignInJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_govtSignInJButtonActionPerformed
        // TODO add your handling code here:
        GovernmentAuthorizationJPanel pos = new GovernmentAuthorizationJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("GovernmentAuthorizationJPanel",pos);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_govtSignInJButtonActionPerformed

    private void armyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armyJButtonActionPerformed
        // TODO add your handling code here:
        udio.setOrganization("army");
        PositionWorkAreaJPanel pos = new PositionWorkAreaJPanel(userProcessContainer, enterprise,udio);
        userProcessContainer.add("PositionWorkAreaJPanel",pos);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_armyJButtonActionPerformed

    private void navyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navyJButtonActionPerformed
        // TODO add your handling code here:
        PositionWorkAreaJPanel pos = new PositionWorkAreaJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("PositionWorkAreaJPanel",pos);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_navyJButtonActionPerformed

    private void airForceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airForceJButtonActionPerformed
        // TODO add your handling code here:
        PositionWorkAreaJPanel pos = new PositionWorkAreaJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("PositionWorkAreaJPanel",pos);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_airForceJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton airForceJButton;
    private javax.swing.JButton armyJButton;
    private javax.swing.JLabel conuntryValue;
    private javax.swing.JButton govtSignInJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton navyJButton;
    // End of variables declaration//GEN-END:variables
}
