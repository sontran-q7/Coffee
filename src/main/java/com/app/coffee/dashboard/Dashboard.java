/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app.coffee.dashboard;
import static com.app.coffee.Coffee.showLoginForm;
import com.app.coffee.Login.*;
import com.app.coffee.Login.Register.ListUsers;
import com.app.coffee.Login.Register.Member;
import com.app.coffee.employee.*;
import com.app.coffee.bill.*;
import com.app.coffee.category.*;
import com.app.coffee.product.*;
import  com.app.coffee.menu.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;


/**
 *
 * @author anhso
 */
public class Dashboard extends javax.swing.JFrame {
    
    private JLabel currentButton;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        setFullScreen();
        initComponents();
        loadPanels();
        startClock();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sidebar = new com.app.coffee.design.GradientPanel();
        SignoutButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JLabel();
        MenuButton = new javax.swing.JLabel();
        BillButton = new javax.swing.JLabel();
        CategoryButton = new javax.swing.JLabel();
        EmployeeButton = new javax.swing.JLabel();
        ProductButton = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        StaffLabel = new javax.swing.JLabel();
        StaffField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        timeLable = new javax.swing.JLabel();
        DislayPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sidebar.setEndColor(new java.awt.Color(102, 102, 102));
        Sidebar.setStartColor(new java.awt.Color(0, 0, 0));

        SignoutButton.setBackground(new java.awt.Color(255, 102, 0));
        SignoutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SignoutButton.setForeground(new java.awt.Color(255, 255, 255));
        SignoutButton.setText("Sign out");
        SignoutButton.setBorder(null);
        SignoutButton.setPreferredSize(new java.awt.Dimension(120, 40));
        SignoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignoutButtonActionPerformed(evt);
            }
        });

        HomeButton.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        HomeButton.setForeground(new java.awt.Color(255, 255, 255));
        HomeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HomeButton.setText("Home");
        HomeButton.setPreferredSize(new java.awt.Dimension(40, 16));
        HomeButton.setVerifyInputWhenFocusTarget(false);
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeButtonMouseExited(evt);
            }
        });

        MenuButton.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(255, 255, 255));
        MenuButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuButton.setText("Menu");
        MenuButton.setPreferredSize(new java.awt.Dimension(40, 16));
        MenuButton.setVerifyInputWhenFocusTarget(false);
        MenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuButtonMouseExited(evt);
            }
        });

        BillButton.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        BillButton.setForeground(new java.awt.Color(255, 255, 255));
        BillButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BillButton.setText("Bill");
        BillButton.setPreferredSize(new java.awt.Dimension(40, 16));
        BillButton.setVerifyInputWhenFocusTarget(false);
        BillButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BillButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BillButtonMouseExited(evt);
            }
        });

        CategoryButton.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        CategoryButton.setForeground(new java.awt.Color(255, 255, 255));
        CategoryButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CategoryButton.setText("Category");
        CategoryButton.setPreferredSize(new java.awt.Dimension(40, 16));
        CategoryButton.setVerifyInputWhenFocusTarget(false);
        CategoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CategoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CategoryButtonMouseExited(evt);
            }
        });

        EmployeeButton.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        EmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EmployeeButton.setText("Employee");
        EmployeeButton.setPreferredSize(new java.awt.Dimension(40, 16));
        EmployeeButton.setVerifyInputWhenFocusTarget(false);
        EmployeeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EmployeeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EmployeeButtonMouseExited(evt);
            }
        });

        ProductButton.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        ProductButton.setForeground(new java.awt.Color(255, 255, 255));
        ProductButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProductButton.setText("Product");
        ProductButton.setPreferredSize(new java.awt.Dimension(40, 16));
        ProductButton.setVerifyInputWhenFocusTarget(false);
        ProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProductButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SidebarLayout = new javax.swing.GroupLayout(Sidebar);
        Sidebar.setLayout(SidebarLayout);
        SidebarLayout.setHorizontalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidebarLayout.createSequentialGroup()
                        .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(SidebarLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(EmployeeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(SignoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addComponent(CategoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                        .addComponent(ProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        SidebarLayout.setVerticalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(SignoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        getContentPane().add(Sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 860));

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        Header.setPreferredSize(new java.awt.Dimension(1350, 100));

        StaffLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        StaffLabel.setForeground(new java.awt.Color(255, 102, 0));
        StaffLabel.setText("Staff : ");

        StaffField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        StaffField.setForeground(new java.awt.Color(102, 102, 102));
        StaffField.setText("Sontran@gmail.com");
        StaffField.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Day Time:");

        timeLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        timeLable.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap(725, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258)
                .addComponent(StaffLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StaffField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StaffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StaffField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(timeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1360, 50));

        DislayPanel.setBackground(new java.awt.Color(255, 255, 255));
        DislayPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DislayPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(DislayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 1350, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignoutButtonActionPerformed
         this.dispose(); // Close the current dashboard
        showLoginForm(); // Show the login form again
    }//GEN-LAST:event_SignoutButtonActionPerformed

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        showPanel("dashboard");
        setButtonColor(HomeButton);
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void HomeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseEntered
         if (currentButton != HomeButton) {
         HomeButton.setForeground(new Color(255,153,0));
       }
    }//GEN-LAST:event_HomeButtonMouseEntered

    private void HomeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseExited
        if (currentButton != HomeButton) {
          HomeButton.setForeground(Color.white);
        }
    }//GEN-LAST:event_HomeButtonMouseExited

    private void MenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuButtonMouseClicked
        showPanel("menu");
         setButtonColor(MenuButton);
    }//GEN-LAST:event_MenuButtonMouseClicked

    private void MenuButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuButtonMouseEntered
        if (currentButton != MenuButton) {
         MenuButton.setForeground(new Color(255,153,0));
       }
    }//GEN-LAST:event_MenuButtonMouseEntered

    private void MenuButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuButtonMouseExited
          if (currentButton != MenuButton) {
          MenuButton.setForeground(Color.white);
        }
    }//GEN-LAST:event_MenuButtonMouseExited

    private void BillButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillButtonMouseClicked
        showPanel("bill");
        setButtonColor(BillButton);
    }//GEN-LAST:event_BillButtonMouseClicked

    private void BillButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillButtonMouseEntered
        if (currentButton != BillButton) {
         BillButton.setForeground(new Color(255,153,0));
       }
    }//GEN-LAST:event_BillButtonMouseEntered

    private void BillButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillButtonMouseExited
        if (currentButton != BillButton) {
          BillButton.setForeground(Color.white);
        }
    }//GEN-LAST:event_BillButtonMouseExited

    private void CategoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryButtonMouseClicked
        showPanel("category");
        setButtonColor(CategoryButton);
    }//GEN-LAST:event_CategoryButtonMouseClicked

    private void CategoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryButtonMouseEntered
        if (currentButton != CategoryButton) {
         CategoryButton.setForeground(new Color(255,153,0));
       }
    }//GEN-LAST:event_CategoryButtonMouseEntered

    private void CategoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryButtonMouseExited
        if (currentButton != CategoryButton) {
          CategoryButton.setForeground(Color.white);
        }
    }//GEN-LAST:event_CategoryButtonMouseExited

    private void EmployeeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeButtonMouseClicked
       showPanel("employee");
       setButtonColor(EmployeeButton);
    }//GEN-LAST:event_EmployeeButtonMouseClicked

    private void EmployeeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeButtonMouseEntered
       if (currentButton != EmployeeButton) {
        EmployeeButton.setForeground(new Color(255,153,0));
       }
    }//GEN-LAST:event_EmployeeButtonMouseEntered

    private void EmployeeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeButtonMouseExited
         
          if (currentButton != EmployeeButton) {
        EmployeeButton.setForeground(Color.white);
          }
    }//GEN-LAST:event_EmployeeButtonMouseExited

    private void ProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseClicked
        showPanel("product");
        setButtonColor(ProductButton);
    }//GEN-LAST:event_ProductButtonMouseClicked

    private void ProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseEntered
         if (currentButton != ProductButton) {
        ProductButton.setForeground(new Color(255,153,0));
    }
    }//GEN-LAST:event_ProductButtonMouseEntered

    private void ProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseExited
       if (currentButton != ProductButton) {
        ProductButton.setForeground(Color.WHITE);
    }
    }//GEN-LAST:event_ProductButtonMouseExited

    // setup Panel của các package khác 
  private void loadPanels() {
        DashboardPage dashboardPage = new DashboardPage();
        EmployeeManager employeeManager = new EmployeeManager();
        Bill bill = new Bill();
        ProductForm product = new ProductForm();
        MenuPanel menu = new MenuPanel();
        ListUsers user = new ListUsers();
        CategoryForm categoryForm = new CategoryForm();
        ReturnAccount returnAccount = new ReturnAccount();
        StaffSchedule staffSchedule = new StaffSchedule();
        
        DislayPanel.add(dashboardPage, "dashboard");
        DislayPanel.add(employeeManager, "employee"); 
        //DislayPanel.add(user,"member");
        DislayPanel.add(bill, "bill");
        DislayPanel.add(product, "product"); 
        DislayPanel.add(categoryForm, "category"); 
        DislayPanel.add(menu,"menu");
        DislayPanel.add(returnAccount, "returnAccount");
        DislayPanel.add(staffSchedule, "staffSchedule");
    }
    public void showPanel(String panelName) {
        ((CardLayout)DislayPanel.getLayout()).show(DislayPanel, panelName);
    }
    
    private void setFullScreen() {
    // Kiểm tra xem phương thức có được gọi không
    System.out.println("setFullScreen() method called");
    // Thiết lập JFrame ở chế độ toàn màn hình
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    // Vô hiệu hóa khả năng thay đổi kích thước của JFrame
    setResizable(false);
    // Loại bỏ khả năng thu nhỏ cửa sổ bằng cách đặt undecorated
    setUndecorated(true);
}
    private void setButtonColor(javax.swing.JLabel button) {
    if (currentButton != null) {
        currentButton.setForeground(Color.WHITE); // Set the previous button to white
    }
    currentButton = button;
    currentButton.setForeground(new Color(255,153,0)); // Set the current button to orange
}


        // chỉnh day time
     private void startClock() {
        // Định dạng ngày giờ
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        // Tạo Timer để cập nhật mỗi giây
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thời gian hiện tại
                Date now = new Date();
                // Định dạng và đặt vào timeLabel
                timeLable.setText(sdf.format(now));
            }
        });
        // Bắt đầu Timer
        timer.start();
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        FlatLaf.registerCustomDefaultsSource("com.app.coffee.employee");
        //FlatMacDarkLaf.setup();
        FlatIntelliJLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BillButton;
    private javax.swing.JLabel CategoryButton;
    private javax.swing.JPanel DislayPanel;
    private javax.swing.JLabel EmployeeButton;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel HomeButton;
    private javax.swing.JLabel MenuButton;
    private javax.swing.JLabel ProductButton;
    private com.app.coffee.design.GradientPanel Sidebar;
    private javax.swing.JButton SignoutButton;
    private javax.swing.JTextField StaffField;
    private javax.swing.JLabel StaffLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel timeLable;
    // End of variables declaration//GEN-END:variables
}
