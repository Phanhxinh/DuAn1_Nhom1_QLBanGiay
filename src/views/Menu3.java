/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDonModel;
import DomainModel.HoaDonView;
import DomainModel.KhuyenMai_BanHangModel;
import ITFService.BanHangITF;
import ITFService.HoadonITF;
import ServiceIML.BanHangIML;
import ServiceIML.HoaDonIML;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Menu3 extends javax.swing.JInternalFrame {
    
    private HoadonITF hoadonITF = new HoaDonIML();
    DefaultTableModel bang;
    private BanHangITF banHangITF = new BanHangIML();
    private NumberFormat formatter = new DecimalFormat("#,###");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * Creates new form Menu1
     */
    public Menu3() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        LoadTableHoaDon();
    }
    
    private void LoadTableHoaDon() {
        DefaultTableModel bang = (DefaultTableModel) tablehoadon.getModel();
        bang.setRowCount(0);
        for (HoaDonView hdv : hoadonITF.getall()) {
            bang.addRow(new Object[]{tablehoadon.getRowCount() + 1, hdv.getMaHD(), hdv.getTenNV(), hdv.getTenKH(), hdv.getNgayTao(), hdv.trangThai()});
        }
    }
    
    private void LocNgay(String ngayBD, String ngayKT) {
        DefaultTableModel bang = (DefaultTableModel) tablehoadon.getModel();
        bang.setRowCount(0);
        for (HoaDonView hdv : hoadonITF.LocNgay(ngayBD, ngayKT)) {
            bang.addRow(new Object[]{tablehoadon.getRowCount() + 1, hdv.getMaHD(), hdv.getTenNV(), hdv.getTenKH(), hdv.getNgayTao(), hdv.trangThai()});
        }
    }
    
    private void FinmaHD(String ten) {
        DefaultTableModel bang = (DefaultTableModel) tablehoadon.getModel();
        bang.setRowCount(0);
        for (HoaDonView hdv : hoadonITF.FindMaNV(ten)) {
            bang.addRow(new Object[]{tablehoadon.getRowCount() + 1, hdv.getMaHD(), hdv.getTenNV(), hdv.getTenKH(), hdv.getNgayTao(), hdv.trangThai()});
        }
    }
    
    private void ClearAlltableGioHang() {
        bang = (DefaultTableModel) tablegiohang.getModel();
        bang.getDataVector().removeAllElements();
        revalidate();
    }
    
    private void TinhTongTien() {
        int tien, tongtien = 0;
        int row = tablegiohang.getRowCount();
        for (int i = 0; i < row; i++) {
            tien = Integer.parseInt(tablegiohang.getValueAt(i, 7).toString());
            tongtien += tien;
        }
        lbltongcong.setText(formatter.format(tongtien));
    }
    
    private String MaHDtoTenKM(String MaHD) {
        for (HoaDonModel hdm : banHangITF.MouseClickKM()) {
            if (MaHD.equals(hdm.getMaHD().toString())) {
                return hdm.getIdKM();
            }
        }
        return null;
    }
    
    private void updatetienKM() {
        int Dis;
        NumberFormat formatter = new DecimalFormat("#,###");
        //tính Discount
        String Order = lbltongcong.getText().replaceAll(",", "");
        Dis = (Integer.parseInt(lblsokhuyenmai.getText()) * Integer.parseInt(Order)) / 100;
        lbltienkm.setText(formatter.format(Dis));
        int tienkhuyenmai = Integer.parseInt(Order) - Dis;
        lblthanhtien.setText(formatter.format(tienkhuyenmai));
        
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
        txttim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ngaybd = new com.toedter.calendar.JDateChooser();
        ngaykt = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablehoadon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablegiohang = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblmahd = new javax.swing.JLabel();
        lblchuongtrinhkm = new javax.swing.JLabel();
        lbltongcong = new javax.swing.JLabel();
        lblsokhuyenmai = new javax.swing.JLabel();
        lblthanhtien = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbltienkm = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 690));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 690));

        txttim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttimCaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tìm mã HD:");

        ngaybd.setDate(new java.util.Date(1669125429000L));
        ngaybd.setDateFormatString("dd/MM/yyyy");

        ngaykt.setDate(new java.util.Date(1669125429000L));
        ngaykt.setDateFormatString("dd/MM/yyyy");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Từ ngày:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Đến ngày:");

        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        tablehoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Tên NV", "Tên KH", "Ngày Tạo", "Trạng Thái"
            }
        ));
        tablehoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablehoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablehoadon);

        tablegiohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Loại SP", "Size", "Màu sắc", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        jScrollPane2.setViewportView(tablegiohang);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mã HD :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tổng cộng: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Chiếu khấu:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Thành tiền:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Chương trình KM: ");

        lblmahd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblmahd.setForeground(new java.awt.Color(255, 0, 51));

        lblchuongtrinhkm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblchuongtrinhkm.setForeground(new java.awt.Color(255, 0, 51));

        lbltongcong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltongcong.setForeground(new java.awt.Color(255, 0, 51));
        lbltongcong.setText("0");

        lblsokhuyenmai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblsokhuyenmai.setForeground(new java.awt.Color(255, 0, 51));
        lblsokhuyenmai.setText("0");

        lblthanhtien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblthanhtien.setForeground(new java.awt.Color(255, 0, 51));
        lblthanhtien.setText("0");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("%");

        lbltienkm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltienkm.setForeground(new java.awt.Color(255, 0, 51));
        lbltienkm.setText("0");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("VND");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("VND");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbltongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblchuongtrinhkm, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblsokhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbltienkm, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngaybd, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ngaykt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(39, 39, 39)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jComboBox1))
                    .addComponent(ngaykt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ngaybd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttim))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblmahd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(lblchuongtrinhkm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbltongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblsokhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(lbltienkm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(72, 72, 72))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimCaretUpdate
        // TODO add your handling code here:
        FinmaHD(txttim.getText());
    }//GEN-LAST:event_txttimCaretUpdate

    private void tablehoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehoadonMouseClicked
        // TODO add your handling code here:
        ClearAlltableGioHang();
        int row = tablehoadon.getSelectedRow();
        String maHD = tablehoadon.getValueAt(row, 1).toString();
        String idHd = "";
        for (HoaDonModel hdm : banHangITF.MaHDToIdHD(maHD)) {
            idHd += hdm;
        }
        bang = (DefaultTableModel) tablegiohang.getModel();
        for (GioHang_BanHangModel ghbhm : banHangITF.MouesClickTableHoaDon(idHd)) {
            bang.addRow(new Object[]{tablegiohang.getRowCount() + 1, ghbhm.getTenSP(), ghbhm.getLoaiSP(),ghbhm.getSize(),ghbhm.getMauSac(), ghbhm.getSoLuong(), ghbhm.getDonGia(), ghbhm.getThanhTien()});
        }
        String tenKM = MaHDtoTenKM(maHD);
        lblchuongtrinhkm.setText(tenKM);
        lblmahd.setText(maHD);
        TinhTongTien();
        for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.getKhuyenMai(lblchuongtrinhkm.getText())) {
            lblsokhuyenmai.setText(khuyenMai_BanHangModel.getGiamGia());
//            lblhankm.setText(khuyenMai_BanHangModel.getNgayBD() + " - " + khuyenMai_BanHangModel.getNgayKT());
        }
        if (lblchuongtrinhkm.getText() == null) {
            lblthanhtien.setText(lbltongcong.getText());
            lblsokhuyenmai.setText("0");
            lbltienkm.setText("0");
        } else {
            updatetienKM();
        }
    }//GEN-LAST:event_tablehoadonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ngaybd = sdf.format(this.ngaybd.getDate());
        String ngaykt = sdf.format(this.ngaybd.getDate());
        LocNgay(ngaybd, ngaykt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblchuongtrinhkm;
    private javax.swing.JLabel lblmahd;
    private javax.swing.JLabel lblsokhuyenmai;
    private javax.swing.JLabel lblthanhtien;
    private javax.swing.JLabel lbltienkm;
    private javax.swing.JLabel lbltongcong;
    private com.toedter.calendar.JDateChooser ngaybd;
    private com.toedter.calendar.JDateChooser ngaykt;
    private javax.swing.JTable tablegiohang;
    private javax.swing.JTable tablehoadon;
    private javax.swing.JTextField txttim;
    // End of variables declaration//GEN-END:variables
}
