       /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DomainModel.ChatLieu_SanPhamModel;
import ServiceIML.ChatLieuIML;

/**
 *
 * @author PC- ASUS
 */
public class FormChatLieu extends javax.swing.JFrame {
private ChatLieuIML IMLSame;
    /**
     * Creates new form From_NSX
     */
    public FormChatLieu() {
        initComponents();
        this.IMLSame = new ChatLieuIML();
        loatble();
         this.setLocationRelativeTo(null);
    }

    public void loatble(){
        DefaultTableModel dmt  = (DefaultTableModel) tbDisplay.getModel();
        dmt.setRowCount(0);
        
        for (ChatLieu_SanPhamModel same : this.IMLSame.All()) {
              Object[] row ={

              same .getMaCL(),
              same .getTenCL(),
             
            };
            dmt.addRow(row);
        }
    }
    
    public ChatLieu_SanPhamModel getFromdate(){
    
    String ma = txtMa.getText().trim();
    String ten = txtTen.getText().trim();
        
    ChatLieu_SanPhamModel M3  = new ChatLieu_SanPhamModel( ma, ten,null);
        return M3;
    }
     public boolean ktDieuKien() {
//        if (txtchitietMauSac.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "ID không được để trống!!");
//            return false;
//        }
        if (txtMa.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống!!");
            return false;
        }
        if (txtTen.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống !!");
            return false;
        }
        return true;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDisplay = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 69, 34, -1));

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã");

        txtMa.setBackground(new java.awt.Color(255, 255, 255));
        txtMa.setForeground(new java.awt.Color(0, 0, 0));
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        txtTen.setBackground(new java.awt.Color(255, 255, 255));
        txtTen.setForeground(new java.awt.Color(0, 0, 0));
        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tên");

        jScrollPane3.setForeground(new java.awt.Color(0, 0, 0));

        tbDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã", "Tên"
            }
        ));
        tbDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDisplayMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDisplay);

        btnThem.setBackground(new java.awt.Color(153, 0, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 0, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sửa.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Chất Liệu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnThem)
                                .addGap(28, 28, 28)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
     if(ktDieuKien()){
          ChatLieu_SanPhamModel same = this.getFromdate();
        this.IMLSame.insert(same);
        if(same == null){
            return;
        } 
        
        JOptionPane.showMessageDialog(this, "Thêm thành công ");
        loatble();
     }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tbDisplay.getSelectedRow();
        
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập");
        }
        ChatLieu_SanPhamModel Same = this.getFromdate();
       
      
        this.IMLSame.update(Same.getMaCL(), Same);
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        loatble();
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDisplayMouseClicked
 int row = tbDisplay.getSelectedRow();
        
      
        String ma  = tbDisplay.getValueAt(row, 0).toString();
        String ten  = tbDisplay.getValueAt(row, 1).toString();
        
     
        this.txtMa.setText(ma);
        this.txtTen.setText(ten);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDisplayMouseClicked

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    
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
            java.util.logging.Logger.getLogger(FormChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormChatLieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormChatLieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbDisplay;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
