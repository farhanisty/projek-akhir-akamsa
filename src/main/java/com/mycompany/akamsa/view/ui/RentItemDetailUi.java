/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.akamsa.view.ui;

import com.mycompany.akamsa.common.ClickListener;
import com.mycompany.akamsa.entity.Item;
import com.mycompany.akamsa.view.RentItemDetailView;
import com.mycompany.akamsa.view.SidebarView;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class RentItemDetailUi extends javax.swing.JFrame implements RentItemDetailView, SidebarView {

    /**
     * Creates new form nitip
     */
    public RentItemDetailUi() {
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
        namaLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        beliTextField = new javax.swing.JTextField();
        stokLabel = new javax.swing.JLabel();
        hargaLabel = new javax.swing.JLabel();
        addKeranjangButton = new javax.swing.JButton();
        kategoriLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
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
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namaLabel.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaLabel.setText("?Nama Barang");
        jPanel3.add(namaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 150, -1));

        imageLabel.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        imageLabel.setForeground(new java.awt.Color(0, 0, 0));
        imageLabel.setText("?Image");
        jPanel3.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 250, 250));

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Sewa");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 471, -1, -1));

        beliTextField.setBackground(new java.awt.Color(255, 255, 255));
        beliTextField.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel3.add(beliTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 472, 46, -1));

        stokLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        stokLabel.setForeground(new java.awt.Color(0, 0, 0));
        stokLabel.setText("Stok : ?");
        jPanel3.add(stokLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 471, -1, -1));

        hargaLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        hargaLabel.setForeground(new java.awt.Color(0, 0, 0));
        hargaLabel.setText("Harga per Hari : ?");
        jPanel3.add(hargaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 443, -1, -1));

        addKeranjangButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        addKeranjangButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addKeranjangButton.setForeground(new java.awt.Color(255, 255, 255));
        addKeranjangButton.setText("+ Keranjang");
        jPanel3.add(addKeranjangButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 533, 120, 35));

        kategoriLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        kategoriLabel.setForeground(new java.awt.Color(0, 0, 0));
        kategoriLabel.setText("?Kategori");
        jPanel3.add(kategoriLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        idLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("Id : ?");
        jPanel3.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Detail Barang");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

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
            java.util.logging.Logger.getLogger(RentItemDetailUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentItemDetailUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentItemDetailUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentItemDetailUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                RentItemDetailUi ui = new RentItemDetailUi();
                ui.setLocationRelativeTo(null);
                ui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addKeranjangButton;
    private javax.swing.JTextField beliTextField;
    private javax.swing.JButton btnHomePage;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPurchaseCart;
    private javax.swing.JButton btnSewa;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JLabel hargaLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel kategoriLabel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JLabel stokLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void open() {
        this.setVisible(true);
    }

    @Override
    public void setItem(Item item) {
        idLabel.setText("Id Barang : " + String.valueOf(item.getId()));
        namaLabel.setText(item.getName());
        hargaLabel.setText("Harga per Hari : Rp. " + item.getPrice());
        stokLabel.setText("Stok : " + String.valueOf(item.getStock()));
        kategoriLabel.setText(item.getCategory());
// testing : update at dan satunya di edit..

        // testing

        // jika image dalam bentuk path atau URL
//        ImageIcon icon = new ImageIcon(item.getImage()); // pastikan path valid
//        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        imageLabel.setIcon(new ImageIcon(scaledImage));
    }

    @Override
    public int getCountBeliInput() {
        return Integer.parseInt(this.beliTextField.getText());
    }

    @Override
    public void setCartClickListener(ClickListener listener) {
        this.addKeranjangButton.addActionListener(e -> listener.onClick());
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void close() {
        this.dispose();
    }

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
}
