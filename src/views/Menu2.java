/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDon_BanHangModel;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
public class Menu2 extends javax.swing.JInternalFrame {

    public BanHangITF banHangITF = new BanHangIML();
    public DefaultTableModel bang;
//    private Executor executor = Executors.newSingleThreadExecutor(this);
    private WebcamPanel pannel = null;
    public static Webcam webcam = null;
    private NumberFormat formatter = new DecimalFormat("#,###");

    /**
     * Creates new form Menu1
     */
    public Menu2() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        LoadTableSanPham();
        LoadTableHoaDon();
        btnthanhtoan.setEnabled(false);
//        initWebcam();
    }

    //Đã sửa menu2
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

    private void LoadTableHoaDon() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getAllHoaDon()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.getTrangThai() == 0 ? "Đã thanh toán" : "Đang chờ", hd.getNgayTao()});
        }
    }

    private void LoadTableHoaDonThanhToan() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getHoaDonThanhToan()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.getTrangThai() == 0 ? "Đã thanh toán" : "Đang chờ", hd.getNgayTao()});
        }
    }

    private void LoadTableHoaDonDangCho() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getHoaDonDangCho()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.getTrangThai() == 0 ? "Đã thanh toán" : "Đang chờ", hd.getNgayTao()});
        }
    }

    private void TinhTongTien() {
        int tien, tongtien = 0;
        int row = tableGioHang.getRowCount();
        for (int i = 0; i < row; i++) {
            tien = Integer.parseInt(tableGioHang.getValueAt(i, 5).toString());
            tongtien += tien;
        }
        txttongtien.setText(formatter.format(tongtien));
    }

//        private void initWebcam() {
//        Dimension size = WebcamResolution.QVGA.getSize();
//        webcam = Webcam.getWebcams().get(0); //0 is default webcam
//        webcam.setViewSize(size);
//
//        pannel = new WebcamPanel(webcam);
//        pannel.setPreferredSize(size);
//        pannel.setFPSDisplayed(true);
//
//        cam.add(pannel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 150));
//        executor.execute(this);
//    }
//
//    @Override
//    public void run() {
//        try {
//            do {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                Result result = null;
//                BufferedImage image = null;
//
//                if (webcam.isOpen()) {
//                    if ((image = webcam.getImage()) == null) {
//                        continue;
//                    }
//                }
//
//                LuminanceSource source = new BufferedImageLuminanceSource(image);
//                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//
//                try {
//                    result = new MultiFormatReader().decode(bitmap);
//                } catch (Exception e) {
//
//                }
//
//                if (result != null) {
//                    String ketqua = result.getText();
//                    String soluong = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng sản phẩm");
//                    int khosoluong = Integer.parseInt(soluong);
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
//                    int soluongcuoi = khosoluong;
//                    bang = (DefaultTableModel) tableGioHang.getModel();
//                    banHangITF.getAllGioHang(null, ketqua).forEach(gh -> {
//                        bang.addRow(new Object[]{tableGioHang.getRowCount() + 1, gh.getTenSP(), gh.getLoaiSP(), soluongcuoi, gh.getDonGia(), Integer.parseInt(gh.getDonGia()) * soluongcuoi});
//                    });
//
//                }
//            } while (true);
//        } catch (Exception e) {
//
//        }
//    }
//
//    @Override
//    public Thread newThread(Runnable r) {
//        Thread t = new Thread(r, "My Thread");
//        t.setDaemon(true);
//        return t;
//    }
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
        CbbHoaDon = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableHoaDon = new javax.swing.JTable();
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
        txtmaHoaDon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttienkhachdua = new javax.swing.JTextField();
        txttienthua = new javax.swing.JTextField();
        btnthanhtoan = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cam = new javax.swing.JPanel();
        lblthongbao = new javax.swing.JLabel();

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

        CbbHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Hoàn thành", "Đang chờ" }));
        CbbHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbHoaDonActionPerformed(evt);
            }
        });

        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Tên NV", "Trạng thái", "Ngày tạo"
            }
        ));
        jScrollPane3.setViewportView(tableHoaDon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(CbbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        txtmaHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(txtmaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 160, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Chương trình GG:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 160, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Tổng cộng: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 76, -1));

        txttongtien.setBackground(new java.awt.Color(255, 255, 255));
        txttongtien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttongtien.setForeground(new java.awt.Color(255, 0, 51));
        jPanel2.add(txttongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 160, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Chiết khấu:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, -1));

        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 35, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("%");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 18, -1));

        jTextField5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 90, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Thành tiền:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 73, -1));

        txtthanhtien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(txtthanhtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 160, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Tiền khách đưa:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Tiền trả lại:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, -1, -1));

        txttienkhachdua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttienkhachdua.setForeground(new java.awt.Color(51, 51, 255));
        txttienkhachdua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttienkhachduaCaretUpdate(evt);
            }
        });
        jPanel2.add(txttienkhachdua, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 180, 160, -1));

        txttienthua.setBackground(new java.awt.Color(255, 255, 255));
        txttienthua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttienthua.setForeground(new java.awt.Color(255, 0, 51));
        jPanel2.add(txttienthua, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 250, 160, -1));

        btnthanhtoan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnthanhtoan.setText("Thanh Toán");
        jPanel2.add(btnthanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 140, 60));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Tạo hóa đơn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 284, 130, 40));

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Chờ thanh toán");
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, 130, 40));

        cam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 230, 170));

        lblthongbao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblthongbao.setForeground(new java.awt.Color(255, 0, 51));
        jPanel2.add(lblthongbao, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 240, 30));

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
        TinhTongTien();
    }//GEN-LAST:event_btnthemsanphamActionPerformed

    private void txttimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimkiemCaretUpdate
        // TODO add your handling code here:
        Findten(txttimkiem.getText());
    }//GEN-LAST:event_txttimkiemCaretUpdate

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int count = 0;
        count = tableHoaDon.getRowCount();
        String chuoi1 = "";
        int chuoi2 = 0;
        chuoi1 = tableHoaDon.getValueAt(count - 1, 1).toString();
        chuoi2 = Integer.parseInt(chuoi1.substring(3).toString());

        if (chuoi2 + 1 < 10) {
            txtmaHoaDon.setText("HD000" + (chuoi2 + 1));
        } else if (chuoi2 + 1 < 100) {
            txtmaHoaDon.setText("HD00" + (chuoi2 + 1));
        } else if (chuoi2 + 1 < 1000) {
            txtmaHoaDon.setText("HD" + (chuoi2 + 1));
        }

        String MaHD = txtmaHoaDon.getText();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CbbHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbHoaDonActionPerformed
        // TODO add your handling code here:
        if (CbbHoaDon.getSelectedIndex() == 0) {
            LoadTableHoaDon();
        } else if (CbbHoaDon.getSelectedIndex() == 1) {
            LoadTableHoaDonThanhToan();
        } else if (CbbHoaDon.getSelectedIndex() == 2) {
            LoadTableHoaDonDangCho();
        }
    }//GEN-LAST:event_CbbHoaDonActionPerformed

    private void txttienkhachduaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttienkhachduaCaretUpdate
        // TODO add your handling code here:
        int tienthua;
        while (true) {
            if (txttienkhachdua.getText().trim().equals("")) {
                lblthongbao.setText("Khách hàng chưa trả tiền.");
                btnthanhtoan.setEnabled(false);
                return;
            } else if (!txttienkhachdua.getText().trim().matches("\\d+")) {
                lblthongbao.setText("Tiền phải là số.");
                btnthanhtoan.setEnabled(false);
                return;
            } else {
                lblthongbao.setText("");
                btnthanhtoan.setEnabled(false);
                break;
            }
        }
        String tongtien = txttongtien.getText().replaceAll(",", "");
        tienthua = Integer.parseInt(txttienkhachdua.getText()) - Integer.parseInt(tongtien);
        txttienthua.setText(formatter.format(tienthua));

        if (tienthua < 0) {
            lblthongbao.setText("Khách hàng chưa đưa đủ tiền.");
            btnthanhtoan.setEnabled(false);
            txttienthua.setText("0");
        } else if (Integer.parseInt(txttienkhachdua.getText()) == 0) {
            txttienthua.setText("0");
            btnthanhtoan.setEnabled(false);
        } else {
            txttienthua.setText(formatter.format(tienthua));
            btnthanhtoan.setEnabled(true);
        }
    }//GEN-LAST:event_txttienkhachduaCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbHoaDon;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btnthemsanpham;
    private javax.swing.JPanel cam;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblthongbao;
    private javax.swing.JTable tableGioHang;
    private javax.swing.JTable tableHoaDon;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txtmaHoaDon;
    private javax.swing.JTextField txtthanhtien;
    private javax.swing.JTextField txttienkhachdua;
    private javax.swing.JTextField txttienthua;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttongtien;
    // End of variables declaration//GEN-END:variables
}
