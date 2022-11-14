/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.GioHang_BanHangModel;
import DomainModel.SanPham_BanhangModel;
import ITFService.BanHangITF;
import ServiceIML.BanHangIML;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Menu2 extends javax.swing.JInternalFrame implements Runnable, ThreadFactory{

    public BanHangITF banHangITF = new BanHangIML();
    public DefaultTableModel bang;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private WebcamPanel pannel = null;
    public static Webcam webcam = null;
    /**
     * Creates new form Menu1
     */
    public Menu2() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        LoadTableSanPham();
        initWebcam();
    }

    private void LoadTableSanPham() {
        DefaultTableModel bang = (DefaultTableModel) tableSanPham.getModel();
        bang.setRowCount(0);
        int stt = 1;
        for (SanPham_BanhangModel sp : banHangITF.getall()) {
            bang.addRow(new Object[]{stt++,
                sp.getTenSP(),
                sp.getLoaiSP(),
                sp.getHang(),
                sp.getChatLieu(),
                sp.getKichCo(),
                sp.getMauSac(),
                sp.getDe(),
                sp.getSoLuong(),
                sp.getGiaBan(),
                sp.getBarcode()});
        }
    }

    private void Findten(String ten) {
        DefaultTableModel bang = (DefaultTableModel) tableSanPham.getModel();
        bang.setRowCount(0);
        int stt = 1;
        for (SanPham_BanhangModel sp : banHangITF.FindTen(ten)) {
            bang.addRow(new Object[]{stt++,
                sp.getTenSP(),
                sp.getLoaiSP(),
                sp.getHang(),
                sp.getChatLieu(),
                sp.getKichCo(),
                sp.getMauSac(),
                sp.getDe(),
                sp.getSoLuong(),
                sp.getGiaBan(),
                sp.getBarcode()});
        }
    }

    private void LoadTableGioHang(int soLuong) {
        bang = (DefaultTableModel) tableGioHang.getModel();
        int row = tableSanPham.getSelectedRow();
        String tenSP = tableSanPham.getValueAt(row, 1).toString();
        for (GioHang_BanHangModel gh : banHangITF.getAllGioHang(tenSP, null)) {
            bang.addRow(new Object[]{tableGioHang.getRowCount() + 1, gh.getTenSP(), gh.getLoaiSP(), soLuong, gh.getDonGia(), Integer.parseInt(gh.getDonGia()) * soLuong});
        }
    }

    
        private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        pannel = new WebcamPanel(webcam);
        pannel.setPreferredSize(size);
        pannel.setFPSDisplayed(true);

        cam.add(pannel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 150));
        executor.execute(this);
    }

    @Override
    public void run() {
        try {
            do {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Result result = null;
                BufferedImage image = null;

                if (webcam.isOpen()) {
                    if ((image = webcam.getImage()) == null) {
                        continue;
                    }
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (Exception e) {

                }

                if (result != null) {
                    String ketqua = result.getText();
                    String soluong = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng sản phẩm");
                    int khosoluong = Integer.parseInt(soluong);
//                    int Line = tableGioHang.getRowCount();
//                    int row =tableSanPham.getSelectedRow();
//                    String tenSP = tableSanPham.getValueAt(row, 1).toString();
//                    for (int i = 0; i < Line; i++) {
//                        if (tableGioHang.getValueAt(i, 1).equals(tenSP)) {
//                            int quanCu = (int) tableGioHang.getValueAt(i, 3);
//                            int quanMoi = khosoluong;
//                            int quanCuVaMoi = quanCu + quanMoi;
//                            khosoluong = quanCuVaMoi;
////                soLuong.setValue(quanCuVaMoi);
//                            bang.removeRow(i);
//                            break;
//                        }
//                    }
                    int soluongcuoi = khosoluong;
                    bang = (DefaultTableModel) tableGioHang.getModel();
                    banHangITF.getAllGioHang(null, ketqua).forEach(gh -> {
                        bang.addRow(new Object[]{tableGioHang.getRowCount() + 1, gh.getTenSP(), gh.getLoaiSP(), soluongcuoi, gh.getDonGia(), Integer.parseInt(gh.getDonGia()) * soluongcuoi});
                    });

                }
            } while (true);
        } catch (Exception e) {

        }
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
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
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGioHang = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnthemsanpham = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        txttimkiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cam = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1100, 690));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 690));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang chờ", "Hoàn thành" }));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Tên NV", "Trạng thái", "Ngày tạo"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Xóa");

        tableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số  lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tableGioHang);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        btnthemsanpham.setText("Thêm sản phẩm");
        btnthemsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemsanphamActionPerformed(evt);
            }
        });

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Loại SP", "Hãng", "Chất liệu", "Kích cỡ", "Màu sắc", "Đế", "Số lượng", "Giá bán", "BarCode"
            }
        ));
        jScrollPane2.setViewportView(tableSanPham);

        txttimkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttimkiemCaretUpdate(evt);
            }
        });
        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnthemsanpham)
                        .addGap(33, 33, 33)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthemsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1050, 240));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Mã HD:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 52, -1));

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 160, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Chương trình GG:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 160, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Tổng cộng: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 76, -1));

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 160, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Chiết khấu:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, -1, -1));

        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 35, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("%");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 18, -1));

        jTextField5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 90, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Thành tiền:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 73, -1));

        jTextField6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 160, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Tiền khách đưa:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Tiền trả lại:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, -1, -1));

        jTextField7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 200, 160, -1));

        jTextField8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 160, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("jButton3");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 117, 28));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("jButton3");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, 117, 34));

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("jButton3");
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 117, 34));

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("jButton3");
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, 117, 34));

        cam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 230, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void btnthemsanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemsanphamActionPerformed
        // TODO add your handling code here:
        int Line = tableGioHang.getRowCount();
        int row = tableSanPham.getSelectedRow();
        String tenSP = tableSanPham.getValueAt(row, 1).toString();
        String soluong = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng sản phẩm");
        int sl = Integer.parseInt(soluong);
        for (int i = 0; i < Line; i++) {
            if (tableGioHang.getValueAt(i, 1).equals(tenSP)) {
                int quanCu = (int) tableGioHang.getValueAt(i, 3);
                int quanMoi = sl;
                int quanCuVaMoi = quanCu + quanMoi;
                sl = quanCuVaMoi;
                bang.removeRow(i);
                break;
            }
        }
        LoadTableGioHang(sl);
    }//GEN-LAST:event_btnthemsanphamActionPerformed

    private void txttimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimkiemCaretUpdate
        // TODO add your handling code here:
        Findten(txttimkiem.getText());
    }//GEN-LAST:event_txttimkiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnthemsanpham;
    private javax.swing.JPanel cam;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tableGioHang;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
