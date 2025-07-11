/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.akamsa.view.ui;

import com.mycompany.akamsa.common.ClickListener;
import com.mycompany.akamsa.view.LandingPageView;
import com.mycompany.akamsa.view.SidebarView;

/**
 *
 * @author ASUS
 */
public class LandingPage extends javax.swing.JFrame implements SidebarView, LandingPageView {

    /**
     * Creates new form nitip
     */
    public LandingPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        navigateTransaksiButton = new javax.swing.JButton();
        navigateSewaButton = new javax.swing.JButton();
        namaLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnHomePage = new javax.swing.JButton();
        btnPurchaseCart = new javax.swing.JButton();
        btnSewa = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(240, 247, 247));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Dashboard");

        navigateTransaksiButton.setBackground(new java.awt.Color(6, 119, 95));
        navigateTransaksiButton.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        navigateTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        navigateTransaksiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-transaction-100.png"))); // NOI18N
        navigateTransaksiButton.setText("Transaksi");
        navigateTransaksiButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navigateTransaksiButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navigateTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateTransaksiButtonActionPerformed(evt);
            }
        });

        navigateSewaButton.setBackground(new java.awt.Color(6, 119, 95));
        navigateSewaButton.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        navigateSewaButton.setForeground(new java.awt.Color(255, 255, 255));
        navigateSewaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-lease-96.png"))); // NOI18N
        navigateSewaButton.setText("Sewa");
        navigateSewaButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navigateSewaButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navigateSewaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateSewaButtonActionPerformed(evt);
            }
        });

        namaLabel.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaLabel.setText("Welcome, ?namakasir");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("\"Niatkan Bekerjamu Sebagai Ibadah\"");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(namaLabel)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(navigateSewaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(navigateTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(namaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navigateTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navigateSewaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 0, 900, 600));

        jPanel2.setBackground(new java.awt.Color(5, 54, 44));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoBig.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Akamsa");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        btnHomePage.setBackground(new java.awt.Color(5, 54, 44));
        btnHomePage.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnHomePage.setForeground(new java.awt.Color(255, 255, 255));
        btnHomePage.setText("Home Page");
        jPanel2.add(btnHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 40));

        btnPurchaseCart.setBackground(new java.awt.Color(5, 54, 44));
        btnPurchaseCart.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnPurchaseCart.setForeground(new java.awt.Color(255, 255, 255));
        btnPurchaseCart.setText("Purchase Cart");
        btnPurchaseCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseCartActionPerformed(evt);
            }
        });
        jPanel2.add(btnPurchaseCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, 40));

        btnSewa.setBackground(new java.awt.Color(5, 54, 44));
        btnSewa.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnSewa.setForeground(new java.awt.Color(255, 255, 255));
        btnSewa.setText("Sewa");
        btnSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSewaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 200, 40));

        btnLogOut.setBackground(new java.awt.Color(5, 54, 44));
        btnLogOut.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 200, 40));

        btnTransaksi.setBackground(new java.awt.Color(5, 54, 44));
        btnTransaksi.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnTransaksi.setText("Transaksi");
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        jPanel2.add(btnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void navigateTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateTransaksiButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navigateTransaksiButtonActionPerformed

    private void navigateSewaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateSewaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_navigateSewaButtonActionPerformed

    private void btnPurchaseCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseCartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPurchaseCartActionPerformed

    private void btnSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSewaActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransaksiActionPerformed

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
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LandingPage ui = new LandingPage();
                ui.setLocationRelativeTo(null);
                ui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHomePage;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPurchaseCart;
    private javax.swing.JButton btnSewa;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JButton navigateSewaButton;
    private javax.swing.JButton navigateTransaksiButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addHomePageClickListener(ClickListener listener) {
        this.btnHomePage.addActionListener(e -> listener.onClick());
    }

    @Override
    public void addRentPageClickListener(ClickListener listener) {
        this.btnSewa.addActionListener(e -> listener.onClick());
    }

    @Override
    public void addCartPageClickListener(ClickListener listener) {
        this.btnPurchaseCart.addActionListener(e -> listener.onClick());
    }

    @Override
    public void addTransactionPageClickListener(ClickListener listener) {
        this.btnTransaksi.addActionListener(e -> listener.onClick());
    }
    
    @Override
    public void addButtonLogOutClickListener(ClickListener listener) {
        this.btnLogOut.addActionListener(e -> listener.onClick());
    }

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public void open() {
        this.setVisible(true);
    }

    @Override
    public void addSewaClickListener(ClickListener listener) {
        this.navigateSewaButton.addActionListener(e -> listener.onClick());
    }

    @Override
    public void setLoggedUsername(String username) {
        this.namaLabel.setText("Welcome " + username);
    }

    @Override
    public void addTransactionClickListener(ClickListener listener) {
        this.navigateTransaksiButton.addActionListener(e -> listener.onClick());
    }
}
