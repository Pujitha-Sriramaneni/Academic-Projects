/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PositionWorkArea;

import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.AdministrativeRole.UserDetailIO;

/**
 *
 * @author Sneha
 */
public class SoldierSelectJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserDetailIO udio;
    /**
     * Creates new form SoldierSelectJPanel
     */
    public SoldierSelectJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
    }

    SoldierSelectJPanel(JPanel userProcessContainer, Enterprise enterprise, UserDetailIO udio) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.udio= udio;
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
        soldierSignUpJButton = new javax.swing.JButton();
        soldierSignInJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Choose Your Action");

        soldierSignUpJButton.setBackground(new java.awt.Color(204, 204, 0));
        soldierSignUpJButton.setText("Sign Up");
        soldierSignUpJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldierSignUpJButtonActionPerformed(evt);
            }
        });

        soldierSignInJButton.setBackground(new java.awt.Color(204, 204, 0));
        soldierSignInJButton.setText("Sign In");
        soldierSignInJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldierSignInJButtonActionPerformed(evt);
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
                        .addGap(290, 290, 290)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(soldierSignInJButton)
                                    .addComponent(soldierSignUpJButton)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton1)))
                .addContainerGap(450, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(soldierSignUpJButton)
                .addGap(64, 64, 64)
                .addComponent(soldierSignInJButton)
                .addContainerGap(365, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void soldierSignUpJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldierSignUpJButtonActionPerformed
        // TODO add your handling code here:
        SoldierDetailsEntryJPanel sol = new SoldierDetailsEntryJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("SoldierDetailsEntryJPanel", sol);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_soldierSignUpJButtonActionPerformed

    private void soldierSignInJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldierSignInJButtonActionPerformed
        // TODO add your handling code here:
        SoldierSignInJPanel sol = new SoldierSignInJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("SoldierSignInJPanel", sol);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_soldierSignInJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton soldierSignInJButton;
    private javax.swing.JButton soldierSignUpJButton;
    // End of variables declaration//GEN-END:variables
}
