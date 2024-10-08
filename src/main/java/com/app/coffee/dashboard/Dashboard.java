/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app.coffee.dashboard;

import com.app.coffee.Login.LoginAccount.LoginForm;
import com.app.coffee.Login.LoginAccount.UserSession;
import com.app.coffee.employee.*;
import com.app.coffee.bill.*;
import com.app.coffee.category.*;
import com.app.coffee.product.*;
import com.app.coffee.menu.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
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
 * @author anhson
 */
public class Dashboard extends javax.swing.JFrame {

    private String userName;
    private int roleId;
    private int controlId;
    private JLabel currentButton;
    private ReturnAccount returnAccount;
    private StaffSchedule staffSchedule;
    private EmployeeManager employeeManager;
    private MenuPanel menu;
    private DashboardPage dashboardPage;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        setFullScreen();
        initComponents();
        loadPanels();
        startClock();
    }

    // user login sucssesfull
    public void setUserName(String userName, int roleId, int ControlId) {
        this.userName = userName;
        this.roleId = roleId;
        UserSession.getInstance().setControlId(controlId);
        NameStaff.setText(userName);
        //System.out.println("Name"+userName);
    }

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        StaffLabel = new javax.swing.JLabel();
        NameStaff = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        timeLable = new javax.swing.JLabel();
        timeLable2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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

        jLabel2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" COFFEE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("POS");

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
                    .addComponent(CategoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                        .addComponent(ProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(SignoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))))))
        );
        SidebarLayout.setVerticalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidebarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
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

        NameStaff.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NameStaff.setForeground(new java.awt.Color(102, 102, 102));
        NameStaff.setText("Sontran@gmail.com");
        NameStaff.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Day Time:");

        timeLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        timeLable.setForeground(new java.awt.Color(102, 102, 102));

        timeLable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        timeLable2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addContainerGap(1110, Short.MAX_VALUE)
                        .addComponent(timeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeLable2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(StaffLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(timeLable2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(StaffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(timeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1360, 50));

        DislayPanel.setBackground(new java.awt.Color(255, 255, 255));
        DislayPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DislayPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(DislayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 1360, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignoutButtonActionPerformed
      UserSession session = UserSession.getInstance();
    int controlId = session.getControlId();
    
    // Nếu user chưa tạo ca (controlId == 0) hoặc đã kết ca (session.isShiftEnded() == true)
    if (controlId == 0 || session.isShiftEnded()) {
        // Reset UserSession
        session.reset();
        this.dispose();

        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    } else {
        // Hiển thị cảnh báo nếu user chưa kết ca
        JOptionPane.showMessageDialog(this, "You cannot sign out before your shift ends.", "WARNING", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_SignoutButtonActionPerformed

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        showPanel("dashboard");
        setButtonColor(HomeButton);
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void HomeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseEntered
        if (currentButton != HomeButton) {
            HomeButton.setForeground(new Color(255, 153, 0));
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
            MenuButton.setForeground(new Color(255, 153, 0));
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
            BillButton.setForeground(new Color(255, 153, 0));
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
            CategoryButton.setForeground(new Color(255, 153, 0));
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
            EmployeeButton.setForeground(new Color(255, 153, 0));
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
            ProductButton.setForeground(new Color(255, 153, 0));
        }
    }//GEN-LAST:event_ProductButtonMouseEntered

    private void ProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductButtonMouseExited
        if (currentButton != ProductButton) {
            ProductButton.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_ProductButtonMouseExited

    private void loadPanels() {
    dashboardPage = new DashboardPage();
    employeeManager = new EmployeeManager();
    Bill bill = new Bill();
    ProductForm product = new ProductForm();
    menu = new MenuPanel();
    CategoryForm categoryForm = new CategoryForm();
    returnAccount = new ReturnAccount();
    staffSchedule = new StaffSchedule();

    int roleId = UserSession.getInstance().getRoleId();
    if (roleId != 3) {
        DislayPanel.add(dashboardPage, "dashboard");
        DislayPanel.add(employeeManager, "employee");
        DislayPanel.add(bill, "bill");
        DislayPanel.add(product, "product");
        DislayPanel.add(categoryForm, "category");
        DislayPanel.add(returnAccount, "returnAccount");
        DislayPanel.add(staffSchedule, "staffSchedule");
    }
    DislayPanel.add(menu, "menu");
}


   public void showPanel(String panelName) {
    int roleId = UserSession.getInstance().getRoleId();
    if (roleId == 3 && !panelName.equals("menu")) {
        JOptionPane.showMessageDialog(this, "You do not have permission to access this page.", "WARNING", JOptionPane.WARNING_MESSAGE);
        return;
    }

    switch (panelName) {
        case "dashboard":
            dashboardPage.refresh();
            break;
        case "menu":
            menu.setUserName(UserSession.getInstance().getUserName());
            menu.refresh();
            break;
        case "returnAccount":
            returnAccount.refresh();
            break;
        case "staffSchedule":
            staffSchedule.refresh();
            break;
        case "employee":
            employeeManager.refresh();
            break;
        case "bill":
            Bill billPanel = null;
            Component[] components = DislayPanel.getComponents();
            for (Component component : components) {
                if (component instanceof Bill) {
                    billPanel = (Bill) component;
                    break;
                }
            }
            if (billPanel != null) {
                billPanel.refreshListBill();
            }
            break;
    }
    ((CardLayout) DislayPanel.getLayout()).show(DislayPanel, panelName);
}


    private void setFullScreen() {
        System.out.println("setFullScreen() method called");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        // Loại bỏ khả năng thu nhỏ cửa sổ 
        setUndecorated(true);
    }

    private void setButtonColor(javax.swing.JLabel button) {
        if (currentButton != null) {
            currentButton.setForeground(Color.WHITE);
        }
        currentButton = button;
        currentButton.setForeground(new Color(255, 153, 0));
    }
    // Date time
    private void startClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                timeLable2.setText(sdf.format(now));
            }
        });
        timer.start();
    }
    public static void main(String args[]) {
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
    private javax.swing.JTextField NameStaff;
    private javax.swing.JLabel ProductButton;
    private com.app.coffee.design.GradientPanel Sidebar;
    private javax.swing.JButton SignoutButton;
    private javax.swing.JLabel StaffLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel timeLable;
    private javax.swing.JLabel timeLable2;
    // End of variables declaration//GEN-END:variables

}