/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.GioHang_BanHangModel;
import DomainModel.HoaDonModel;
import DomainModel.HoaDon_BanHangModel;
import DomainModel.KhuyenMai_BanHangModel;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    SimpleDateFormat ftnow = new SimpleDateFormat("yyyy/MM/dd");

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
        cbbKhuyenMai();
        txtmaHoaDon.setEnabled(false);
        txttongtien.setEnabled(false);
        txtthanhtien.setEnabled(false);
        txttienthua.setEnabled(false);
        txtsokhuyenmai.setEnabled(false);
        txttienkhuyenmai.setEnabled(false);
        btnthemsanpham.setEnabled(false);
//        initWebcam();
    }
// Hiện thị sản phẩm lên bảng sản phẩm

    //Đã sửa menu2
    //Sửa tiếp
    private void LoadTableSanPham() {
        DefaultTableModel bang = (DefaultTableModel) tableSanPham.getModel();
        bang.setRowCount(0);
        int stt = 1;
        for (SanPham_BanhangModel sp : banHangITF.getall()) {
            if (Integer.parseInt(sp.getSoLuong()) > 0) {
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
    }

    // Tìm kiếm theo tên sản phẩm
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
// Thêm sản phẩm vào giỏ hàng

    private void LoadTableGioHang(int soLuong) {
        bang = (DefaultTableModel) tableGioHang.getModel();
        int row = tableSanPham.getSelectedRow();
        String tenSP = tableSanPham.getValueAt(row, 1).toString();
        for (GioHang_BanHangModel gh : banHangITF.getAllGioHang(tenSP, null)) {
            bang.addRow(new Object[]{tableGioHang.getRowCount() + 1, gh.getTenSP(), gh.getLoaiSP(), soLuong, gh.getDonGia(), Integer.parseInt(gh.getDonGia()) * soLuong});
        }
    }
// Hiển thị hóa đơn lên bảng hóa đơn

    private void LoadTableHoaDon() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getAllHoaDon()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }
// Lọc hóa đơn đã thanh toán

    private void LoadTableHoaDonThanhToan() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getHoaDonThanhToan()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }
// Lọc hóa đơn đang chờ

    private void LoadTableHoaDonDangCho() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getHoaDonDangCho()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }
//lọc hóa đơn chờ thanh toán

    private void LoadTableHoaDonDangChoThanhToan() {
        bang = (DefaultTableModel) tableHoaDon.getModel();
        bang.setRowCount(0);
        for (HoaDon_BanHangModel hd : banHangITF.getHoaDonDangChoThanhToan()) {
            bang.addRow(new Object[]{tableHoaDon.getRowCount() + 1, hd.getMaHD(), hd.getTenNV(), hd.trangThai(), hd.getNgayTao()});
        }
    }
// Tính tổng tiền trong gio hàng

    private void TinhTongTien() {
        int tien, tongtien = 0;
        int row = tableGioHang.getRowCount();
        for (int i = 0; i < row; i++) {
            tien = Integer.parseInt(tableGioHang.getValueAt(i, 5).toString());
            tongtien += tien;
        }
        txttongtien.setText(formatter.format(tongtien));
    }
// thêm vào hóa đơn chi tiết

    private void InsertHoaDonChiTiet() {
        int row = tableGioHang.getRowCount();
        for (int i = 0; i < row; i++) {
            String TenSP = tableGioHang.getValueAt(i, 1).toString();
            String MaHD = txtmaHoaDon.getText();
            String idChiTietSP = "";
            String idHoaDon = "";
            String idKM = "";
            for (SanPham_BanhangModel sanPham_BanhangModel : banHangITF.TenSPToId(TenSP)) {
                idChiTietSP += sanPham_BanhangModel;
            }
            for (HoaDonModel hoaDonModel : banHangITF.MaHDToIdHD(MaHD)) {
                idHoaDon += hoaDonModel;
            }
            for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.TenKMtoIdKM(cbbkhuyenmai.getSelectedItem().toString())) {
                idKM += khuyenMai_BanHangModel;
            }
            String soLuong = tableGioHang.getValueAt(i, 3).toString();
            String donGia = tableGioHang.getValueAt(i, 5).toString();
            if (cbbkhuyenmai.getSelectedIndex() != 0) {
                banHangITF.insertHoaDonChiTiet(idHoaDon, idChiTietSP, idKM, Integer.parseInt(soLuong), donGia);
            } else {
                banHangITF.insertHoaDonChiTiet(idHoaDon, idChiTietSP, null, Integer.parseInt(soLuong), donGia);
            }
            banHangITF.updateSoLuongSanPham(Integer.parseInt(soLuong), idChiTietSP);
        }
    }

    // Thêm item vào cbb khuyến mại
    private void cbbKhuyenMai() {
        Date now = new Date();
        if (cbbkhuyenmai.getSelectedIndex() == 0) {
            txtthanhtien.setText(txttongtien.getText());
        }
        for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.getCbbTenKM(ftnow.format(now), ftnow.format(now))) {
            cbbkhuyenmai.addItem(khuyenMai_BanHangModel.getTenKM());
        }

    }

    // cập nhật tiền đc khuyến mại
    private void updatetienKM() {
        int Dis;
        NumberFormat formatter = new DecimalFormat("#,###");
        //tính Discount
        String Order = txttongtien.getText().replaceAll(",", "");
        Dis = (Integer.parseInt(txtsokhuyenmai.getText()) * Integer.parseInt(Order)) / 100;
        txttienkhuyenmai.setText(formatter.format(Dis));
        int tienkhuyenmai = Integer.parseInt(Order) - Dis;
        txtthanhtien.setText(formatter.format(tienkhuyenmai));

    }
// Xóa dữ liệu trên bảng giỏ hàng.

    public void ClearAlltableGioHang() {
        bang = (DefaultTableModel) tableGioHang.getModel();
        bang.getDataVector().removeAllElements();
        revalidate();
    }

    // Chuyển mã hóa đơn sang tên km
    public String MaHDtoTenKM(String MaHD) {
        for (HoaDonModel hdm : banHangITF.MouseClickKM()) {
            if (MaHD.equals(hdm.getMaHD().toString())) {
                return hdm.getIdKM();
            }
        }
        return null;
    }
///test
    private void Clearform() {
        txtmaHoaDon.setText("");
        txtsokhuyenmai.setText("0");
        txttongtien.setText("0");
        txttienkhachdua.setText("0");
        txtthanhtien.setText("0");
        txttienthua.setText("0");
        txttienkhuyenmai.setText("0");
        lblthongbao.setText("");
        lblhankm.setText("");
        cbbkhuyenmai.setSelectedIndex(0);
        bang = (DefaultTableModel) tableGioHang.getModel();
        bang.setNumRows(0);
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
////                    int Line = tableGioHang.getRowCount();
////                    int row =tableSanPham.getSelectedRow();
////                    String tenSP = tableSanPham.getValueAt(row, 1).toString();
////                    for (int i = 0; i < Line; i++) {
////                        if (tableGioHang.getValueAt(i, 1).equals(tenSP)) {
////                            int quanCu = (int) tableGioHang.getValueAt(i, 3);
////                            int quanMoi = khosoluong;
////                            int quanCuVaMoi = quanCu + quanMoi;
////                            khosoluong = quanCuVaMoi;
//////                soLuong.setValue(quanCuVaMoi);
////                            bang.removeRow(i);
////                            break;
////                        }
////                    }
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
        btnxoaSanPham = new javax.swing.JButton();
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
        cbbkhuyenmai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtsokhuyenmai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttienkhuyenmai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttienkhachdua = new javax.swing.JTextField();
        txttienthua = new javax.swing.JTextField();
        btnthanhtoan = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        btnChoThanhToan = new javax.swing.JButton();
        cam = new javax.swing.JPanel();
        lblthongbao = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblhankm = new javax.swing.JLabel();

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

        CbbHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Đang chờ", "Chờ thanh toán" }));
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
        tableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHoaDonMouseClicked(evt);
            }
        });
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

        btnxoaSanPham.setText("Xóa");
        btnxoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaSanPhamActionPerformed(evt);
            }
        });

        tableGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Loại SP", "Số  lượng", "Đơn giá", "Thành tiền"
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
                        .addComponent(btnxoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnxoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnthemsanpham)
                        .addGap(27, 27, 27)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 564, Short.MAX_VALUE)))
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
        txtmaHoaDon.setForeground(new java.awt.Color(255, 0, 51));
        txtmaHoaDon.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtmaHoaDon.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txtmaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 160, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Chương trình GG:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));

        cbbkhuyenmai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbbkhuyenmai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Khuyến mại" }));
        cbbkhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbkhuyenmaiActionPerformed(evt);
            }
        });
        jPanel2.add(cbbkhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 160, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Tổng cộng: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 76, -1));

        txttongtien.setBackground(new java.awt.Color(255, 255, 255));
        txttongtien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttongtien.setForeground(new java.awt.Color(255, 0, 51));
        txttongtien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttongtien.setText("0");
        txttongtien.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txttongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 160, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Chiết khấu:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, -1, -1));

        txtsokhuyenmai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsokhuyenmai.setText("0");
        txtsokhuyenmai.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txtsokhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 35, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("%");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 18, -1));

        txttienkhuyenmai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttienkhuyenmai.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttienkhuyenmai.setText("0");
        txttienkhuyenmai.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txttienkhuyenmai, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 90, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Thành tiền:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 73, -1));

        txtthanhtien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtthanhtien.setForeground(new java.awt.Color(255, 0, 51));
        txtthanhtien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtthanhtien.setText("0");
        txtthanhtien.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txtthanhtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 160, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Tiền khách đưa:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Tiền trả lại:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, -1, -1));

        txttienkhachdua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttienkhachdua.setForeground(new java.awt.Color(51, 51, 255));
        txttienkhachdua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttienkhachdua.setText("0");
        txttienkhachdua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttienkhachduaCaretUpdate(evt);
            }
        });
        jPanel2.add(txttienkhachdua, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 180, 160, -1));

        txttienthua.setBackground(new java.awt.Color(255, 255, 255));
        txttienthua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttienthua.setForeground(new java.awt.Color(255, 0, 51));
        txttienthua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttienthua.setText("0");
        txttienthua.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel2.add(txttienthua, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 250, 160, -1));

        btnthanhtoan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnthanhtoan.setText("Thanh Toán");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });
        jPanel2.add(btnthanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 140, 60));

        btnTaoHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });
        jPanel2.add(btnTaoHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, 130, 30));

        btnChoThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnChoThanhToan.setText("Chờ thanh toán");
        btnChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoThanhToanActionPerformed(evt);
            }
        });
        jPanel2.add(btnChoThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, 130, 30));

        cam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 230, 170));

        lblthongbao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblthongbao.setForeground(new java.awt.Color(255, 0, 51));
        jPanel2.add(lblthongbao, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 240, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Khách hàng: ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, -1, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 280, 120, -1));

        jButton1.setText("+");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 40, 40));

        lblhankm.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(lblhankm, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 160, 20));

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
        String soLuongTon = tableSanPham.getValueAt(row, 8).toString();
        if (Integer.parseInt(soLuongTon) < sl) {
            JOptionPane.showMessageDialog(this, "Sản phẩm chỉ còn số lượng là " + soLuongTon + " .");
            return;
        }
        LoadTableGioHang(sl);
        TinhTongTien();
        txtthanhtien.setText(txttongtien.getText());
    }//GEN-LAST:event_btnthemsanphamActionPerformed

    private void txttimkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttimkiemCaretUpdate
        // TODO add your handling code here:
        Findten(txttimkiem.getText());
        updatetienKM();
    }//GEN-LAST:event_txttimkiemCaretUpdate

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        int count = 0;
        count = tableHoaDon.getRowCount();
        String chuoi1 = "";
        int chuoi2 = 0;
        chuoi1 = tableHoaDon.getValueAt(count - 1, 1).toString();
        chuoi2 = Integer.parseInt(chuoi1.substring(3).toString());
        this.Clearform();
        if (chuoi2 + 1 < 10) {
            txtmaHoaDon.setText("HD000" + (chuoi2 + 1));
        } else if (chuoi2 + 1 < 100) {
            txtmaHoaDon.setText("HD00" + (chuoi2 + 1));
        } else if (chuoi2 + 1 < 1000) {
            txtmaHoaDon.setText("HD" + (chuoi2 + 1));
        }
        String MaHD = txtmaHoaDon.getText();
        int TrangThai = 1;
        banHangITF.insertHoaDon("e058575d-33a1-409a-802f-898adc64141a", "57e6a715-9460-4f03-95cd-d66fd7fa5ae9", null, MaHD, TrangThai);
        this.LoadTableHoaDon();
        btnthemsanpham.setEnabled(true);

        JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công.");
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void CbbHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbHoaDonActionPerformed
        // TODO add your handling code here:
        if (CbbHoaDon.getSelectedIndex() == 0) {
            LoadTableHoaDon();
        } else if (CbbHoaDon.getSelectedIndex() == 1) {
            LoadTableHoaDonThanhToan();
        } else if (CbbHoaDon.getSelectedIndex() == 2) {
            LoadTableHoaDonDangCho();
        } else if (CbbHoaDon.getSelectedIndex() == 3) {
            LoadTableHoaDonDangChoThanhToan();
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
        String tongtien = txtthanhtien.getText().replaceAll(",", "");
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

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        // TODO add your handling code here:
        int row = tableHoaDon.getSelectedRow();
        String trangThai = tableHoaDon.getValueAt(row, 3).toString();
        if (trangThai == "Đang chờ") {
            String maHd = txtmaHoaDon.getText();
            int TrangThai = 0;
            banHangITF.updateTrangThaiHoaDon(TrangThai, maHd);
            InsertHoaDonChiTiet();
            String idKM = "";
            for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.TenKMtoIdKM(cbbkhuyenmai.getSelectedItem().toString())) {
                idKM += khuyenMai_BanHangModel;
            }
            if (cbbkhuyenmai.getSelectedIndex() != 0) {
                banHangITF.updateIdKm(idKM, maHd);
            }
            btnthemsanpham.setEnabled(false);
            LoadTableHoaDon();
            LoadTableSanPham();
            Clearform();
            JOptionPane.showMessageDialog(this, "Thanh toán thành công.");
        } else if (trangThai == "Chờ thanh toán") {
            String maHd = txtmaHoaDon.getText();
            int TrangThai = 0;
            banHangITF.updateTrangThaiHoaDon(TrangThai, maHd);
            LoadTableHoaDon();
            LoadTableSanPham();
            Clearform();
            JOptionPane.showMessageDialog(this, "Thanh toán thành công.");
        }
        //
    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void tableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHoaDonMouseClicked
        // TODO add your handling code here:
        ClearAlltableGioHang();
        int row = tableHoaDon.getSelectedRow();
        txtmaHoaDon.setText(tableHoaDon.getValueAt(row, 1).toString());
        String maHD = tableHoaDon.getValueAt(row, 1).toString();
        String TrangThaiGH = tableHoaDon.getValueAt(row, 3).toString();
        String idHd = "";
        for (HoaDonModel hdm : banHangITF.MaHDToIdHD(maHD)) {
            idHd += hdm;
        }
        bang = (DefaultTableModel) tableGioHang.getModel();
        for (GioHang_BanHangModel ghbhm : banHangITF.MouesClickTableHoaDon(idHd)) {
            bang.addRow(new Object[]{tableGioHang.getRowCount() + 1, ghbhm.getTenSP(), ghbhm.getLoaiSP(), ghbhm.getSoLuong(), ghbhm.getDonGia(), ghbhm.getThanhTien()});
        }
        String tenKM = MaHDtoTenKM(maHD);
        for (int i = 0; i < cbbkhuyenmai.getItemCount(); i++) {
            if (cbbkhuyenmai.getItemAt(i).toString().equals(tenKM)) {
                cbbkhuyenmai.setSelectedIndex(i);
            }
        }
        TinhTongTien();
        if (TrangThaiGH == "Chờ thanh toán" || TrangThaiGH == "Đang chờ") {
            btnthemsanpham.setEnabled(true);
            btnthanhtoan.setEnabled(true);
        } else if (TrangThaiGH == "Đã thanh toán") {
            btnthemsanpham.setEnabled(false);
            btnthanhtoan.setEnabled(false);
        }

    }//GEN-LAST:event_tableHoaDonMouseClicked

    private void cbbkhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbkhuyenmaiActionPerformed
        // TODO add your handling code here:
        if (cbbkhuyenmai.getSelectedIndex() == 0) {
            txtthanhtien.setText(txttongtien.getText());
            txtsokhuyenmai.setText("0");
            txttienkhuyenmai.setText("0");
        }
        for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.getKhuyenMai(cbbkhuyenmai.getSelectedItem().toString())) {
            txtsokhuyenmai.setText(khuyenMai_BanHangModel.getGiamGia());
            lblhankm.setText(khuyenMai_BanHangModel.getNgayBD() + " - " + khuyenMai_BanHangModel.getNgayKT());
            updatetienKM();
        }
    }//GEN-LAST:event_cbbkhuyenmaiActionPerformed

    private void btnChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoThanhToanActionPerformed
        // TODO add your handling code here:
        String maHd = txtmaHoaDon.getText();
        int TrangThai = 2;
        banHangITF.updateTrangThaiHoaDon(TrangThai, maHd);
        InsertHoaDonChiTiet();
        String idKM = "";
        for (KhuyenMai_BanHangModel khuyenMai_BanHangModel : banHangITF.TenKMtoIdKM(cbbkhuyenmai.getSelectedItem().toString())) {
            idKM += khuyenMai_BanHangModel;
        }
        if (cbbkhuyenmai.getSelectedIndex() != 0) {
            banHangITF.updateIdKm(idKM, maHd);
        }
        btnthemsanpham.setEnabled(false);
        LoadTableHoaDon();
        LoadTableSanPham();
        Clearform();
        JOptionPane.showMessageDialog(this, "Chờ thanh toán thành công.");
    }//GEN-LAST:event_btnChoThanhToanActionPerformed

    private void btnxoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaSanPhamActionPerformed
        // TODO add your handling code here:
        int row = tableGioHang.getSelectedRow();
        bang.removeRow(row);
        TinhTongTien();
        txtthanhtien.setText(txttongtien.getText());
    }//GEN-LAST:event_btnxoaSanPhamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbHoaDon;
    private javax.swing.JButton btnChoThanhToan;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btnthemsanpham;
    private javax.swing.JButton btnxoaSanPham;
    private javax.swing.JPanel cam;
    private javax.swing.JComboBox<String> cbbkhuyenmai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblhankm;
    private javax.swing.JLabel lblthongbao;
    private javax.swing.JTable tableGioHang;
    private javax.swing.JTable tableHoaDon;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txtmaHoaDon;
    private javax.swing.JTextField txtsokhuyenmai;
    private javax.swing.JTextField txtthanhtien;
    private javax.swing.JTextField txttienkhachdua;
    private javax.swing.JTextField txttienkhuyenmai;
    private javax.swing.JTextField txttienthua;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttongtien;
    // End of variables declaration//GEN-END:variables
}
