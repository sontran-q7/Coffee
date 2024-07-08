/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app.coffee.Login.LoginAccount;


import com.app.coffee.Backend.Model.UsersModel;
//import com.app.coffee.Database.AdminAccountManager;
//import static com.app.coffee.Database.AdminAccountManager.hashPassword;
import com.app.coffee.Database.PasswordUtils;
import java.awt.Color;
import com.app.coffee.Login.CustomDialog;
import java.security.NoSuchAlgorithmException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.app.coffee.dashboard.*;
import com.app.coffee.hashpassword.PasswordHash;
import java.awt.Component;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class LoginForm extends javax.swing.JFrame {
    private final UserController userController;
    private UsersModel user;
    private  Dashboard dashboard;
    
//    private final VirtualKeyboard virtualKeyboard;

    /**
     * Creates new form LoginForm
     */
    
    public LoginForm() {
        
        initComponents();
        userController = new UserController();
        setLocationRelativeTo(null);
        setResizable(true);
}
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(243, 114, 44)));
        jPanel2.setForeground(new java.awt.Color(51, 255, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(73, 80, 87));
        jLabel1.setText("Login Account");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(73, 80, 87));
        jLabel2.setText("Email :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(73, 80, 87));
        jLabel3.setText("Password :");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jButton1.setBackground(new java.awt.Color(243, 114, 44));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("forgot Password?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClickForgot(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverForgot(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UnHoverForgot(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   java.lang.String enteredEmail = jTextField1.getText();
    String enteredPassword = new String(jPasswordField1.getPassword());
    user = userController.getUserByEmail(enteredEmail);
    
        if (user != null && PasswordHash.checkPassword(enteredPassword, user.getPassword())) {

           System.out.println("Success");
            UserSession session = UserSession.getInstance();
        session.setUserName(user.getUserName());
        session.setAccountId(user.getAccount_id());
        showDashboard(user.getUserName());

        dispose();

//            System.out.println("Success");
          //  new Dashboard().setVisible(true);

        } else {
            JLabel message = new JLabel("Email and password don't exist");
            message.setForeground(Color.RED);
            new CustomDialog(this, "Error", "Email and password don't exist!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ClickForgot(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClickForgot
     Component source = (Component) evt.getSource();
    Window ancestor = SwingUtilities.getWindowAncestor(source);
    
    if (ancestor != null) {
        JFrame forgotPasswordFrame = new JFrame("Send Code");
        SendCode sendCodePanel = new SendCode();
        forgotPasswordFrame.setContentPane(sendCodePanel);
        forgotPasswordFrame.pack(); 
        forgotPasswordFrame.setLocationRelativeTo(ancestor); 
        forgotPasswordFrame.setVisible(true);
        
        // Dispose the current window if needed
        ancestor.dispose();
    } else {
        System.err.println("Ancestor window is null. Cannot proceed.");
    }
        
    }//GEN-LAST:event_ClickForgot

    private void HoverForgot(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoverForgot
        // TODO add your handling code here:
         jLabel4.setForeground(Color.BLACK);
    }//GEN-LAST:event_HoverForgot

    private void UnHoverForgot(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnHoverForgot
        // TODO add your handling code here:
        jLabel4.setForeground(Color.BLUE);
    }//GEN-LAST:event_UnHoverForgot

    public static void main(String args[]) {
     /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new LoginForm().setVisible(true);
                
            }
        });
    }
    private void showDashboard(String userName) {
        if (dashboard == null) {
            dashboard = new Dashboard();
        }
         dashboard.setUserName(userName);
        dashboard.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
