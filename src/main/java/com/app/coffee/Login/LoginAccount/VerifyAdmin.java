/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.Login.LoginAccount;
import com.app.coffee.Login.CustomDialog;
import com.app.coffee.Login.LoginAccount.Reset;
import com.app.coffee.virtualKeyBoard.LetterVirtualKeyBoard;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
/**
 *
 * @author Admin
 */
public class VerifyAdmin extends javax.swing.JPanel {
    private int randomCode;
    private String email;
    private JLabel secondsLabel;
    private VerifyAdmin verifyCodeAmdmin;
    private boolean isCodeValid;
    private SendAdmin sendAdminPanel;
    private LetterVirtualKeyBoard virtualKeyboard;
    private JDialog keyboardDialog;
    private int remainingTime;
    
    private Timer timer;
    private int countdownTime;
    
    /**
     * Creates new form VerifyAdmin
     */
    public VerifyAdmin(int randomCode, String email) {
        initComponents();
        this.randomCode = randomCode;
        this.email = email;
        this.isCodeValid = true;
        this.sendAdminPanel = sendAdminPanel;
        
        virtualKeyboard = new LetterVirtualKeyBoard();
        keyboardDialog = new JDialog((java.awt.Frame) SwingUtilities.getWindowAncestor(this), "Virtual Keyboard", true);
        keyboardDialog.add(virtualKeyboard);
        keyboardDialog.pack();
        keyboardDialog.setLocationRelativeTo(null);
        
        txtVer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                showVirtualKeyboard(txtVer);
            }
        });
    }
    
    public int getCode() {
        return randomCode;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtVer = new javax.swing.JTextField();
        VerifyCode = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        Seconds = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(243, 114, 44)));
        jPanel4.setForeground(new java.awt.Color(51, 255, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(73, 80, 87));
        jLabel4.setText("Code:");

        txtVer.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        VerifyCode.setBackground(new java.awt.Color(243, 114, 44));
        VerifyCode.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VerifyCode.setForeground(new java.awt.Color(255, 255, 255));
        VerifyCode.setText("Verify");
        VerifyCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyCode(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(73, 80, 87));
        jLabel3.setText("Verify Code");

        Back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(243, 114, 44));
        Back.setText("Back");
        Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 114, 44), 2));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back(evt);
            }
        });

        Refresh.setBackground(new java.awt.Color(243, 114, 44));
        Refresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Resend");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh(evt);
            }
        });

        Seconds.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Seconds.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Seconds, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtVer, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(VerifyCode, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43)
                        .addComponent(Refresh)))
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(Seconds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVer, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerifyCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        add(jPanel4, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void VerifyCode(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyCode
        // TODO add your handling code here:
        try {
        int userCode = Integer.parseInt(txtVer.getText().trim());

        if (userCode == randomCode && isCodeValid) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (frame != null) {
                RegisterAdmin resetPanel = new RegisterAdmin(email);               
                frame.setContentPane(resetPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.revalidate();
                frame.repaint();
                isCodeValid = false; 
                
            }
        } else {
            new CustomDialog(null, "Error", "Invalid code or code expired.");
        }
    } catch (NumberFormatException e) {
        new CustomDialog(null, "Error", "Invalid code format.");
    }
    }//GEN-LAST:event_VerifyCode

    private void Back(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            SendAdmin sendCodePanel = new SendAdmin();
            frame.getContentPane().removeAll();
            frame.setContentPane(sendCodePanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } else {
            new CustomDialog(null, "Error", "Don't esixt SendAdmin panel.");
        }
    }//GEN-LAST:event_Back

    private void Refresh(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh
    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       if (frame != null) {
           if (remainingTime > 0) {
                setSecondsLabelText(remainingTime + "(s)");
                new CustomDialog(null, "Error", " seconds before requesting a new code. " +  remainingTime);
                return;
            }
           frame.getContentPane().removeAll();
           VerifyAdmin newVerifyCodePanel = new VerifyAdmin(generateRandomCode(), email);
           if (newVerifyCodePanel.sendAdminPanel == null) {
               newVerifyCodePanel.sendAdminPanel = new SendAdmin();
           }
           newVerifyCodePanel.sendAdminPanel.sendMail(email, newVerifyCodePanel.randomCode);
           newVerifyCodePanel.countdownTime = 60;
           newVerifyCodePanel.setSecondsLabelText(newVerifyCodePanel.countdownTime + "(s)");
           frame.setContentPane(newVerifyCodePanel);
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
           newVerifyCodePanel.startTimer();
           
           if (newVerifyCodePanel.countdownTime == 0) {
                newVerifyCodePanel.isCodeValid = false;
            }
           remainingTime = newVerifyCodePanel.countdownTime;
       } else {
           new CustomDialog(null, "Error", "VerifyCode panel doesn't exist.");
       }  
    }//GEN-LAST:event_Refresh
    
    private int generateRandomCode() {
        return (int) (Math.random() * 900000) + 100000; 
    }
    
    public void updateSeconds(int seconds, String email) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null && frame.getContentPane() instanceof VerifyAdmin) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Seconds.setText(seconds + "(s)");
                }
            });
            if (seconds == 0) {
                isCodeValid = false;
                randomCode = -1;
            }
        }
    }
      
    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            int timeRemaining = countdownTime;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                    setSecondsLabelText(timeRemaining + "(s)");
                    remainingTime = timeRemaining;
                } else {
                    timer.stop();
                    isCodeValid = false;
                }
            }
        });
        timer.start();
    }
    
    public void setSecondsLabelText(String text) {
    Seconds.setText(text);
}
    
    private void showVirtualKeyboard(JTextField textField) {
        virtualKeyboard.setText(textField.getText());
        virtualKeyboard.setTitle("Virtual Keyboard");
        keyboardDialog.setVisible(true);
        textField.setText(virtualKeyboard.getSavedText());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Refresh;
    private javax.swing.JLabel Seconds;
    private javax.swing.JButton VerifyCode;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtVer;
    // End of variables declaration//GEN-END:variables
}
