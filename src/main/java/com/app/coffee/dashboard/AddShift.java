/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/OkCancelDialog.java to edit this template
 */
package com.app.coffee.dashboard;


import com.app.coffee.Backend.Connect.ConnectionCoffee;
import com.app.coffee.Backend.DAO.ControlDAO;
import com.app.coffee.Backend.DAO.UserDAO;
import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.Login.LoginAccount.UserSession;
import com.app.coffee.employee.EmployeeManager;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.PlainDocument;

/**
 *
 * @author anhso
 */
public class AddShift extends javax.swing.JDialog {

    private String userName;
    public static final int RET_CANCEL = 0;
    
    public static final int RET_OK = 1;
    
    private HashMap<String, Integer> shiftMap;
    private HashMap<String, Integer> managerMap;
       private void loadBoxShift() {
        String sql = "SELECT * FROM working_time"; 
        try (Connection conn = ConnectionCoffee.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            BoxShift.removeAllItems();
            while (rs.next()) {
                String shiftName = rs.getString("name");// name này là tên của working_time
                BoxShift.addItem(shiftName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Creates new form ListStaff
     */
    public AddShift(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initShiftMap();
        updateCheckInTimeLabel();
        loadBoxShift();
        GetList();
        // Đặt các renderers
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        ListUserTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // Cột ID
        ListUserTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); // Cột User name
        ListUserTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); // Cột Role
        //ListUserTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer); // Cột Phone
        

        // Đặt ImageRenderer cho cột chứa ảnh
        ListUserTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());

        
       
        
        
        
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }
    
    
    public class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER); // Căn giữa ảnh và văn bản
            String photoName = value != null ? value.toString() : "no-image.png";
            File imageFile = new File("src/image/" + photoName);
            if (!imageFile.exists()) {
                imageFile = new File("src/image/no-image.png");
            }
            ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(imageFile.getAbsolutePath()).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));          
            return new JLabel(imageIcon);
    }
}
    
      public void setUserName(String userName) {
        this.userName = userName;
        // Cập nhật giao diện nếu cần, ví dụ:
         nametest.setText(userName);
       
    }


    public int getReturnStatus() {
        return returnStatus;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListUserTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        shiftpanel = new javax.swing.JLabel();
        selectStaff = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        BoxShift = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        CheckInTime = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        InPayField = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        nameFiled = new javax.swing.JLabel();
        nametest = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setBackground(new java.awt.Color(255, 153, 0));
        okButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setText("OK");
        okButton.setPreferredSize(new java.awt.Dimension(72, 40));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(102, 102, 102));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        ListUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Image", "Name", "Position"
            }
        ));
        ListUserTable.setRowHeight(50);
        jScrollPane2.setViewportView(ListUserTable);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(jPanel1);

        jPanel10.setBackground(new java.awt.Color(255, 102, 0));
        jPanel10.setPreferredSize(new java.awt.Dimension(463, 60));

        shiftpanel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        shiftpanel.setForeground(new java.awt.Color(255, 255, 255));
        shiftpanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shiftpanel.setText("Staff Manager");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(shiftpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shiftpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        selectStaff.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selectStaff.setForeground(new java.awt.Color(51, 51, 51));
        selectStaff.setText("Select staff :");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setText("Choose a work shift:");

        BoxShift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 51, 51));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Check-in time:");

        CheckInTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CheckInTime.setText("time");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("Starting cash:");

        InPayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InPayFieldActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("Manager Shitf:");

        nametest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nametest.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BoxShift, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InPayField, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(selectStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckInTime, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nametest, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckInTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameFiled, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InPayField)
                            .addComponent(jLabel47)
                            .addComponent(nametest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void initShiftMap() {
        shiftMap = new HashMap<>();
        try (Connection conn = ConnectionCoffee.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT working_time_id, name FROM working_time")) {
            while (rs.next()) {
                shiftMap.put(rs.getString("name"), rs.getInt("working_time_id"));
            }
            BoxShift.setModel(new javax.swing.DefaultComboBoxModel<>(shiftMap.keySet().toArray(new String[0])));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    String selectedShift = (String) BoxShift.getSelectedItem();
    Integer workingTimeId = shiftMap.get(selectedShift);
    if (workingTimeId == null) {
        JOptionPane.showMessageDialog(this, "Ca làm việc không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String checkIn = now.format(formatter);
    String checkOut = now.format(formatter); 

    float checkInPay;
    try {
        checkInPay = Float.parseFloat(InPayField.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho Check In Pay.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        return;
    }

    float checkOutPay = 0; // Giá trị check out pay, nếu cần lấy từ giao diện

    Integer accountId = UserSession.getInstance().getAccountId();
    if (accountId == null) {
        JOptionPane.showMessageDialog(this, "Không thể lấy được Account ID của người dùng hiện tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Thêm ca làm việc và lưu controlId vào SessionData
    int controlId = ControlDAO.addControl(workingTimeId, checkIn, checkOut, checkInPay, checkOutPay, accountId);
    if (controlId != -1) {
         UserSession.getInstance().setControlId(controlId);
         
        JOptionPane.showMessageDialog(this, "Tạo ca thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Tạo ca thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed
    
    // Phương thức updateCheckInTimeLabel
    private void updateCheckInTimeLabel() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);
        CheckInTime.setText(currentTime);
    }

    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void InPayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InPayFieldActionPerformed
        String input = InPayField.getText();
    if (!isNumeric(input)) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ.(ví dụ :12345.05)", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        // Xóa nội dung của InPayField
        InPayField.setText("");
    }
    }//GEN-LAST:event_InPayFieldActionPerformed
    
    private boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) {
        return false;
    }
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
  
   public void GetList() {
        UserDAO userdao = new UserDAO();    
        ArrayList<UsersModel> listUser = userdao.selectAll();

        // Sort users by account_id
        Collections.sort(listUser, new Comparator<UsersModel>() {
            @Override
            public int compare(UsersModel u1, UsersModel u2) {
                return u1.getAccount_id() - u2.getAccount_id();
            }
        });

        DefaultTableModel table = (DefaultTableModel) ListUserTable.getModel();
        table.setRowCount(0);
        int count = 1;

        for (UsersModel user : listUser) {
            if (user.getStatus() == 1 && user.getRole().getRole_id() != 1) {
                Object[] row = {
                    count++,
                    user.getImage() != null ? user.getImage() : "no-image.png",
                    user.getUserName() != null ? user.getUserName() : "",
                    user.getRole() != null ? user.getRole().getName() : "", 
                    user.getPhone() != null ? user.getPhone() : "",
                    user.getEmail() != null ? user.getEmail() : ""     
                };
                table.addRow(row);
            }
        }
        // image
        ListUserTable.setRowHeight(60);
        
        // Đặt ImageRenderer cho cột chứa ảnh
        ListUserTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
    }


 
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
            java.util.logging.Logger.getLogger(AddShift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddShift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddShift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddShift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddShift dialog = new AddShift(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxShift;
    private javax.swing.JLabel CheckInTime;
    private javax.swing.JTextField InPayField;
    private javax.swing.JTable ListUserTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameFiled;
    private javax.swing.JLabel nametest;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel selectStaff;
    private javax.swing.JLabel shiftpanel;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
