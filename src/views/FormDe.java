/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DomainModel.De_SanPhamModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DomainModel.De_SanPhamModel;
import ServiceIML.DeIML;

/**
 *
 * @author CQTRUONG
 */
public class FormDe extends javax.swing.JFrame {

    private DeIML IMLSame;

    /**
     * Creates new form FormDe
     */
    public FormDe() {
        initComponents();
        this.IMLSame = new DeIML();
        loatble();
        this.setLocationRelativeTo(null);
    }

    public void loatble() {
        DefaultTableModel dmt = (DefaultTableModel) tb1.getModel();
        dmt.setRowCount(0);

        for (De_SanPhamModel same : this.IMLSame.All()) {
            Object[] row = {
                same.getMaDe(),
                same.getTenDe(),
                same.getChatLieu(),
                same.getDoCao(),};
            dmt.addRow(row);
        }
    }

    public De_SanPhamModel getFromdate() {

        String ma = txtma.getText().trim();
        String ten = txtten.getText().trim();
        String chatlieu = txtcl.getText().trim();
        String docao = txtdc.getText().trim();

        De_SanPhamModel M3 = new De_SanPhamModel(ma, ten, chatlieu, docao, null);
        return M3;
    }

    public boolean ktDieuKien() {
//        if (txtchitietMauSac.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "ID không được để trống!!");
//            return false;
//        }
        if (txtma.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống!!");
            return false;
        }
        if (txtten.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống !!");
            return false;
        }
        if (txtcl.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Chất liệu  không được để trống !!");
            return false;
        }
        if (txtdc.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Độ cao không được để trống !!");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtcl = new javax.swing.JTextField();
        txtdc = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Đế");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 32, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Độ cao");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 46, -1));

        txtma.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtma, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 60, 200, -1));

        txtten.setForeground(new java.awt.Color(0, 0, 0));
        txtten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenActionPerformed(evt);
            }
        });
        jPanel1.add(txtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 100, 200, -1));

        txtcl.setForeground(new java.awt.Color(0, 0, 0));
        txtcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclActionPerformed(evt);
            }
        });
        jPanel1.add(txtcl, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 140, 190, -1));

        txtdc.setForeground(new java.awt.Color(0, 0, 0));
        txtdc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdcActionPerformed(evt);
            }
        });
        jPanel1.add(txtdc, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 180, 190, -1));

        btnthem.setBackground(new java.awt.Color(153, 0, 51));
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });
        jPanel1.add(btnthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        btnsua.setBackground(new java.awt.Color(153, 0, 51));
        btnsua.setForeground(new java.awt.Color(255, 255, 255));
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sửa.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 90, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 46, -1));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Chất Liệu", "Độ Cao"
            }
        ));
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 360, 93));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tên");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 46, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Chất liệu");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenActionPerformed

    private void txtclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclActionPerformed

    private void txtdcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdcActionPerformed

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
        int row = tb1.getSelectedRow();

        String ma = tb1.getValueAt(row, 0).toString();
        String ten = tb1.getValueAt(row, 1).toString();
        String cl = tb1.getValueAt(row, 2).toString();
        String dcao = tb1.getValueAt(row, 3).toString();

        this.txtma.setText(ma);
        this.txtten.setText(ten);
        this.txtcl.setText(cl);
        this.txtdc.setText(dcao);

        // TODO add your handling code here:
    }//GEN-LAST:event_tb1MouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if (ktDieuKien()) {
            De_SanPhamModel same = this.getFromdate();
            this.IMLSame.insert(same);
            if (same == null) {
                return;
            }

            JOptionPane.showMessageDialog(this, "Thêm thành công ");
            loatble();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnthemActionPerformed
    

                                      

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed

        int row = tb1.getSelectedRow();

        if(row == -1){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập");
        }
        De_SanPhamModel Same = this.getFromdate();

        this.IMLSame.update(Same.getMaDe(), Same);
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        loatble();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsuaActionPerformed

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
            java.util.logging.Logger.getLogger(FormDe

.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDe

.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDe

.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDe

.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb1;
    private javax.swing.JTextField txtcl;
    private javax.swing.JTextField txtdc;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
