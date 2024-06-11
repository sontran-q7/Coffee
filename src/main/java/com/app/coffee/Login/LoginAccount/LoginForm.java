/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app.coffee.Login.LoginAccount;


import static com.app.coffee.Database.AdminAccountManager.hashPassword;
import java.awt.Color;
import com.app.coffee.Login.CustomDialog;
import java.security.NoSuchAlgorithmException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Admin
 */
public class LoginForm extends javax.swing.JFrame {
    private final UserController userController;
    private UsersModel user;
//    private final VirtualKeyboard virtualKeyboard;

    /**
     * Creates new form LoginForm
     */
    
    public LoginForm() {
        
        initComponents();
        userController = new UserController();
        setLocationRelativeTo(null);
        setResizable(true);
        
//        virtualKeyboard = new VirtualKeyboard();
//        JPanel virtualKeyboardPanel = new JPanel();
//        virtualKeyboardPanel.add(virtualKeyboard);
//        virtualKeyboardPanel.setSize(1000, 1000);
//        
//       
//        
//        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                virtualKeyboard.setCurrentTextField(jTextField1);
//                displayVirtualKeyboard();
//            }
//        });
//
//        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                virtualKeyboard.setCurrentPasswordField(jPasswordField1);
//                displayVirtualKeyboard();
//            }
//        });
   

//    JPanel1Layout.applyLayout(jPanel1, virtualKeyboardPanel);
        
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//        @Override
//        public void actionPerformed(java.awt.event.ActionEvent evt) {
//            jButton1ActionPerformed(evt);
//        }
//    });
        
//       virtualKeyboard.addActionListener(new ActionListener() {
//        public void actionPerformed(ActionEvent e) {
//            if (currentTextField != null) {
//                currentTextField.replaceSelection(e.getActionCommand());
//            }
//        }
//    });        
    }
    
//   private void displayVirtualKeyboard() {
//     
//    if (keyboardFrame == null) {
//        keyboardFrame = new JFrame();
//        keyboardFrame.getContentPane().add(virtualKeyboard);
//        keyboardFrame.pack();
//    }
//    
//    int x = this.getX();
//    int y = this.getY() + this.getHeight();
//
//    // Đặt vị trí của bàn phím ảo ngay dưới LoginForm
//    keyboardFrame.setLocation(x, y);
//    
//    if (currentTextField != null) {
//        // Lưu vị trí con trỏ chuột hiện tại trong trường nhập liệu
//        int caretPosition = currentTextField.getCaretPosition();
//        
//        // Hiển thị bàn phím ảo
//        keyboardFrame.setVisible(true);
//        
//        // Đặt lại vị trí con trỏ chuột vào sau khi hiển thị bàn phím ảo
//        currentTextField.setCaretPosition(caretPosition);
//    }
//    
//    
//}


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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField1))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addGap(0, 69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
  
    
    
    
    
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    java.lang.String enteredEmail = jTextField1.getText();
    String enteredPassword = new String(jPasswordField1.getPassword());
    user = userController.getUserByEmail(enteredEmail);
    
        if (user != null && checkPassword(enteredPassword, user.getPassWord())) {
            System.out.println("success");
        } else {
            JLabel message = new JLabel("Email and password don't exist");
            message.setForeground(Color.RED);
            new CustomDialog(this, " Error", "Email and password don't exist! ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
 
    private boolean checkPassword(String enteredPassword, String hashedPasswordFromDB) {
    try {
        String hashedEnteredPassword = hashPassword(enteredPassword);
        return hashedEnteredPassword.equals(hashedPasswordFromDB);
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return false;
    }
}   
   
           
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
