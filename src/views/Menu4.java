/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.ChatLieu_SanPhamModel;
import DomainModel.ChiTietSPModel;
import DomainModel.De_SanPhamModel;
import DomainModel.Hang_SanPhamModel;
import DomainModel.KichCo_SanPhamModel;
import DomainModel.MauSac_SanphamModel;
import DomainModel.SanPham_SanPhamModel;
import DomainModel.TheLoai_SanPhamModel;
import ITFService.ChatLieuITF;
import ITFService.ChiTietSpITF;
import ITFService.HangITF;
import ITFService.KichCoITF;
import ITFService.MauSacITF;
import ITFService.SanPhamITF;
import ITFService.TheLoaiITF;
import ServiceIML.ChatLieuIML;
import ServiceIML.ChiTietSPIML;
import ServiceIML.DeIML;
import ServiceIML.HangIML;
import ServiceIML.KichCoIML;
import ServiceIML.MauSacIML;
import ServiceIML.SanPhamIML;
import ServiceIML.TheLoaiIML;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import ITFService.DEITF;
import javax.swing.JFileChooser;

/**
 *
 * @author DELL
 */
public class Menu4 extends javax.swing.JInternalFrame {

    private final ChiTietSpITF ctspitf = new ChiTietSPIML();
    private final SanPhamITF spitf = new SanPhamIML();
    private final KichCoITF kcitf = new KichCoIML();
    private final TheLoaiITF tlitf = new TheLoaiIML();
    private final HangITF hangitf = new HangIML();
    private final DEITF deitf = new DeIML();
    private final MauSacITF mauitf = new MauSacIML();
    private final ChatLieuITF clitf = new ChatLieuIML();

    /**
     * Creates new form Menu1
     */
    public Menu4() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        loadData();
        CbxHang();
        CbxKickCo();
        CbxSanPham();
        CbxMauSac();;
        CbxTheLoai();
        CbxChatLieu();
        CbxDe();

    }

    public void loadData() {
        DefaultTableModel tblModel = (DefaultTableModel) tblChitietsp.getModel();
        tblModel.setRowCount(0);
        List<ChiTietSPModel> list = ctspitf.getListCTSP();
        for (ChiTietSPModel ctsp : list) {
            Object[] row = new Object[]{ctsp.getId(), ctsp.getIdSP(), ctsp.getIdSize(), ctsp.getIdMau(), ctsp.getIdLoaiSP(), ctsp.getIdChatLieu(), ctsp.getIdHang(), ctsp.getIdDE(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.getSoLuong(), ctsp.getBarCode(), ctsp.getMoTa(), ctsp.getTrangThai() == 0 ? "Còn bán" : "Không còn bán", ctsp.getAnh()};
            tblModel.addRow(row);
        }

    }

    public void Timten(String ten) {
        DefaultTableModel tblModel = (DefaultTableModel) tblChitietsp.getModel();
        tblModel.setRowCount(0);
        List<ChiTietSPModel> list = ctspitf.TimTenSP(ten);
        for (ChiTietSPModel ctsp : list) {
            Object[] row = new Object[]{ctsp.getId(), ctsp.getIdSP(), ctsp.getIdSize(), ctsp.getIdMau(), ctsp.getIdLoaiSP(), ctsp.getIdChatLieu(), ctsp.getIdHang(), ctsp.getIdDE(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.getSoLuong(), ctsp.getBarCode(), ctsp.getMoTa(), ctsp.getTrangThai() == 0 ? "Còn bán" : "Không còn bán", ctsp.getAnh()};
            tblModel.addRow(row);
        }

    }

    public void ConHang() {
        DefaultTableModel tblModel = (DefaultTableModel) tblChitietsp.getModel();
        tblModel.setRowCount(0);
        List<ChiTietSPModel> list = ctspitf.getListCTSP();
        for (ChiTietSPModel ctsp : list) {
            if (ctsp.getSoLuong() > 0) {
                Object[] row = new Object[]{ctsp.getId(), ctsp.getIdSP(), ctsp.getIdSize(), ctsp.getIdMau(), ctsp.getIdLoaiSP(), ctsp.getIdChatLieu(), ctsp.getIdHang(), ctsp.getIdDE(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.getSoLuong(), ctsp.getBarCode(), ctsp.getMoTa(), ctsp.getTrangThai() == 0 ? "Còn bán" : "Không còn bán", ctsp.getAnh()};
                tblModel.addRow(row);
            }
        }

    }

    public void HetHang() {
        DefaultTableModel tblModel = (DefaultTableModel) tblChitietsp.getModel();
        tblModel.setRowCount(0);
        List<ChiTietSPModel> list = ctspitf.getListCTSP();
        for (ChiTietSPModel ctsp : list) {
            if (ctsp.getSoLuong() == 0) {
                Object[] row = new Object[]{ctsp.getId(), ctsp.getIdSP(), ctsp.getIdSize(), ctsp.getIdMau(), ctsp.getIdLoaiSP(), ctsp.getIdChatLieu(), ctsp.getIdHang(), ctsp.getIdDE(), ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.getSoLuong(), ctsp.getBarCode(), ctsp.getMoTa(), ctsp.getTrangThai() == 0 ? "Còn bán" : "Không còn bán", ctsp.getAnh()};
                tblModel.addRow(row);
            }
        }

    }

    private void CbxSanPham() {
        cbxTenSp.removeAllItems();
        for (SanPham_SanPhamModel sp : spitf.CbxSanPham()) {
            cbxTenSp.addItem(String.valueOf(sp));
        }
    }

    private String getIdSanPham(String ten) {
        for (SanPham_SanPhamModel sp : spitf.CbxSanPham()) {
            if (sp.getTen().equals(ten)) {
                return sp.getId();
            }
        }
        return null;
    }

    private void CbxKickCo() {
        cbxSize.removeAllItems();
        for (KichCo_SanPhamModel kc : kcitf.CbxKichCo()) {
            cbxSize.addItem(String.valueOf(kc));
        }
    }

    private String getIdKichCo(String tenkc) {
        for (KichCo_SanPhamModel kc : kcitf.CbxKichCo()) {
            if (kc.getTenKC().equals(tenkc)) {
                return kc.getId();
            }
        }
        return null;
    }

    private void CbxMauSac() {
        cbxMau.removeAllItems();
        for (MauSac_SanphamModel ms : mauitf.CbxMauSac()) {
            cbxMau.addItem(String.valueOf(ms));
        }
    }

    private String getIdMauSac(String tenms) {
        for (MauSac_SanphamModel ms : mauitf.CbxMauSac()) {
            if (ms.getTenMS().equals(tenms)) {
                return ms.getId();
            }
        }
        return null;
    }

    private void CbxHang() {
        cbxHang.removeAllItems();
        for (Hang_SanPhamModel hang : hangitf.CbxHang()) {
            cbxHang.addItem(String.valueOf(hang));
        }
    }

    private String getIdHang(String tenHang) {
        for (Hang_SanPhamModel hang : hangitf.CbxHang()) {
            if (hang.getTen().equals(tenHang)) {
                return hang.getId();
            }
        }
        return null;
    }

    private void CbxTheLoai() {
        cbxLoaiSp.removeAllItems();
        for (TheLoai_SanPhamModel tl : tlitf.CbxTheLoai()) {
            cbxLoaiSp.addItem(String.valueOf(tl));
        }
    }

    private String getIdTheLoai(String TenTL) {
        for (TheLoai_SanPhamModel tl : tlitf.CbxTheLoai()) {
            if (tl.getTenTL().equals(TenTL)) {
                return tl.getId();
            }
        }
        return null;
    }

    private void CbxChatLieu() {
        cbxChatLieu.removeAllItems();
        for (ChatLieu_SanPhamModel tl : clitf.CbxChatLieu()) {
            cbxChatLieu.addItem(String.valueOf(tl));
        }
    }

    private String getIdChatLieu(String TenCl) {
        for (ChatLieu_SanPhamModel tl : clitf.CbxChatLieu()) {
            if (tl.getTenCL().equals(TenCl)) {
                return tl.getId();
            }
        }
        return null;
    }

    private void CbxDe() {
        cbxDe.removeAllItems();
        for (De_SanPhamModel tl : deitf.CbxDe()) {
            cbxDe.addItem(String.valueOf(tl));
        }
    }

    private String getIdDe(String TenDe) {
        for (De_SanPhamModel de : deitf.CbxDe()) {
            if (de.getTenDe().equals(TenDe)) {
                return de.getId();
            }
        }
        return null;
    }

    public void add() {
        ChiTietSPModel ctsp = new ChiTietSPModel();
        String TenSanPham = cbxTenSp.getSelectedItem().toString();
        ctsp.setIdSP(getIdSanPham(TenSanPham));
        String Size = cbxSize.getSelectedItem().toString();
        ctsp.setIdSize(getIdKichCo(Size));
        String MauSac = cbxMau.getSelectedItem().toString();
        ctsp.setIdMau(getIdMauSac(MauSac));
        String Loai = cbxLoaiSp.getSelectedItem().toString();
        ctsp.setIdLoaiSP(getIdTheLoai(Loai));
        String ChatLieu = cbxChatLieu.getSelectedItem().toString();
        ctsp.setIdChatLieu(getIdChatLieu(ChatLieu));
        String Hang = cbxHang.getSelectedItem().toString();
        ctsp.setIdHang(getIdHang(Hang));
        String De = cbxDe.getSelectedItem().toString();
        ctsp.setIdDE(getIdDe(De));
        ctsp.setGiaNhap(Integer.parseInt(txtGiaNhap.getText()));
        ctsp.setGiaBan(Integer.parseInt(txtGiaBan.getText()));
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        ctsp.setBarCode(txtBarcode.getText());
        ctsp.setMoTa(txtMoTa.getText());
        ctsp.setAnh(lblAnhSp.getName());
        int TrangThai;
        if (cbxTrangThai.getSelectedIndex() == 0) {
            TrangThai = 0;
        } else {
            TrangThai = 1;
        }
        ctsp.setTrangThai(TrangThai);
        try {

            ctspitf.Add(ctsp);
            loadData();
            JOptionPane.showMessageDialog(this, "Thêm thành công");

        } catch (RuntimeException re) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }

    public void Update() {
        ChiTietSPModel ctsp = new ChiTietSPModel();
        String Size = cbxSize.getSelectedItem().toString();
        ctsp.setIdSize(getIdKichCo(Size));
        String MauSac = cbxMau.getSelectedItem().toString();
        ctsp.setIdMau(getIdMauSac(MauSac));
        String Loai = cbxLoaiSp.getSelectedItem().toString();
        ctsp.setIdLoaiSP(getIdTheLoai(Loai));
        String ChatLieu = cbxChatLieu.getSelectedItem().toString();
        ctsp.setIdChatLieu(getIdChatLieu(ChatLieu));
        String Hang = cbxHang.getSelectedItem().toString();
        ctsp.setIdHang(getIdHang(Hang));
        String De = cbxDe.getSelectedItem().toString();
        ctsp.setIdDE(getIdDe(De));
        ctsp.setGiaNhap(Integer.parseInt(txtGiaNhap.getText()));
        ctsp.setGiaBan(Integer.parseInt(txtGiaBan.getText()));
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        ctsp.setBarCode(txtBarcode.getText());
        ctsp.setMoTa(txtMoTa.getText());
        ctsp.setAnh(lblAnhSp.getName());
        int TrangThai;
        if (cbxTrangThai.getSelectedIndex() == 0) {
            TrangThai = 0;
        } else {
            TrangThai = 1;
        }
        ctsp.setTrangThai(TrangThai);
        String id = txtId.getText();
        try {

            ctspitf.Update(id, ctsp);
            loadData();
            JOptionPane.showMessageDialog(this, " thành công");

        } catch (RuntimeException re) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }

    public void selectRow(int i) {
        ChiTietSPModel ctsp = new ChiTietSPModel();
        DefaultTableModel tblModel = (DefaultTableModel) tblChitietsp.getModel();

        txtId.setText(tblModel.getValueAt(i, 0).toString());
        cbxTenSp.setSelectedItem(tblModel.getValueAt(i, 1).toString());
        cbxSize.setSelectedItem(tblModel.getValueAt(i, 2).toString());
        cbxMau.setSelectedItem(tblModel.getValueAt(i, 3).toString());
        cbxLoaiSp.setSelectedItem(tblModel.getValueAt(i, 4).toString());
        cbxChatLieu.setSelectedItem(tblModel.getValueAt(i, 5).toString());
        cbxHang.setSelectedItem(tblModel.getValueAt(i, 6).toString());
        cbxDe.setSelectedItem(tblModel.getValueAt(i, 7).toString());
        txtGiaNhap.setText(tblModel.getValueAt(i, 8).toString());
        txtGiaBan.setText(tblModel.getValueAt(i, 9).toString());
        txtSoLuong.setText(tblModel.getValueAt(i, 10).toString());
        txtBarcode.setText(tblModel.getValueAt(i, 11).toString());
        txtMoTa.setText(tblModel.getValueAt(i, 12).toString());
        cbxTrangThai.setSelectedItem(tblModel.getValueAt(i, 13).toString());
        String path = tblModel.getValueAt(i, 14).toString();
        // Tạo file từ đường dẫn ảnh
        File file = new File(path);
        int imgW = lblAnhSp.getWidth();
        int imgH = lblAnhSp.getHeight();
        // Tạo file ảnh tư file ở trên
        Image img = new ImageIcon(file.getAbsolutePath())
                .getImage()
                .getScaledInstance(imgW, imgH, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(img);
        lblAnhSp.setIcon(icon);
        lblAnhSp.setHorizontalAlignment(JLabel.CENTER);
        lblAnhSp.setVerticalAlignment(JLabel.CENTER);
        lblAnhSp.setName(file.getAbsolutePath());

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChitietsp = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        cbxSoLuong = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblAnhSp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxTenSp = new javax.swing.JComboBox<>();
        cbxSize = new javax.swing.JComboBox<>();
        cbxMau = new javax.swing.JComboBox<>();
        cbxLoaiSp = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        cbxDe = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxChatLieu = new javax.swing.JComboBox<>();
        cbxHang = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        cbxTrangThai = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1270, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1270, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblChitietsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên sản phẩm", "Size", "Màu sắc", "Loại sản phẩm", "Chất liệul", "Hãng", "Đê", "Giá nhập", "Giá bán", "Số lượng", "BarCode", "Mô tả", "Trạng Thái", "Ảnh"
            }
        ));
        tblChitietsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChitietspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChitietsp);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1220, 180));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tìm kiếm tên sản phẩm");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 290, 30));

        cbxSoLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn hàng", "Hết hàng" }));
        cbxSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSoLuongActionPerformed(evt);
            }
        });
        jPanel1.add(cbxSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 220, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnhSp.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblAnhSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhSpMouseClicked(evt);
            }
        });
        jPanel2.add(lblAnhSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tên sản phẩm:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Kích cỡ:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Màu sắc:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Loại sản phẩm:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, 40));

        cbxTenSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxTenSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 180, 30));

        cbxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSizeActionPerformed(evt);
            }
        });
        jPanel2.add(cbxSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 220, 30));

        cbxMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxMau, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 220, 30));

        cbxLoaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxLoaiSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 180, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Đế:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Giá nhập:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, -1, -1));

        txtGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapActionPerformed(evt);
            }
        });
        jPanel2.add(txtGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 240, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Giá bán:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Số lượng:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, -1, -1));

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });
        jPanel2.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, 240, 30));
        jPanel2.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 150, 240, 30));

        cbxDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 250, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Mô tả:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));
        jPanel2.add(txtBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 200, 240, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Chất liệu:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 70, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Hãng:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, -1));

        cbxChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxChatLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 220, 30));

        cbxHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 230, 30));

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 260, 90));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Trạng Thái:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, -1, 20));

        cbxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn bán", "Không còn bán" }));
        cbxTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTrangThaiActionPerformed(evt);
            }
        });
        jPanel2.add(cbxTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 240, 160, 30));

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 100, 30));

        btnSua.setBackground(new java.awt.Color(0, 0, 0));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sửa.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 280, 100, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("ID");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        txtId.setForeground(new java.awt.Color(0, 0, 0));
        txtId.setText("--");
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 10, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 30, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 30, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 30, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 30, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 30, 30));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 30, 30));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, 30, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Barcode:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 180, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 1220, 320));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Trạng thái");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblChitietspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChitietspMouseClicked
        int i = tblChitietsp.getSelectedRow();
        selectRow(i);
    }//GEN-LAST:event_tblChitietspMouseClicked

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        Timten(txtTimKiem.getText());
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void cbxSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSoLuongActionPerformed
        if (cbxSoLuong.getSelectedIndex() == 0) {
            loadData();
        } else if (cbxSoLuong.getSelectedIndex() == 1) {
            ConHang();
        } else if (cbxSoLuong.getSelectedIndex() == 2) {
            HetHang();
        }
    }//GEN-LAST:event_cbxSoLuongActionPerformed

    private void lblAnhSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhSpMouseClicked
        JFileChooser fileChooser = new JFileChooser("images");

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Khởi tạo file với giá trị = file đã chọn ở khung chọn file
            File selectedFile = fileChooser.getSelectedFile();
            // Lấy kích thước khung ảnh
            int imgW = lblAnhSp.getWidth();
            int imgH = lblAnhSp.getHeight();
            ImageIcon icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage().getScaledInstance(imgW, imgH, Image.SCALE_DEFAULT));
            lblAnhSp.setName(selectedFile.getAbsolutePath());
            lblAnhSp.setIcon(icon);
            lblAnhSp.setHorizontalAlignment(JLabel.CENTER);
            lblAnhSp.setVerticalAlignment(JLabel.CENTER);
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_lblAnhSpMouseClicked

    private void cbxSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSizeActionPerformed

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        Update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormSanPham fsp = new FormSanPham();
        fsp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormKichCo fkc = new FormKichCo();
        fkc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormMauSac fkc = new FormMauSac();
        fkc.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FormTheLoai ftl = new FormTheLoai();
        ftl.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FormDe fde = new FormDe();
        fde.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        FormChatLieu fcl = new FormChatLieu();
        fcl.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        FormHang fhang = new FormHang();
        fhang.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapActionPerformed

    private void cbxTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSua;
    private javax.swing.JComboBox<String> cbxChatLieu;
    private javax.swing.JComboBox<String> cbxDe;
    private javax.swing.JComboBox<String> cbxHang;
    private javax.swing.JComboBox<String> cbxLoaiSp;
    private javax.swing.JComboBox<String> cbxMau;
    private javax.swing.JComboBox<String> cbxSize;
    private javax.swing.JComboBox<String> cbxSoLuong;
    private javax.swing.JComboBox<String> cbxTenSp;
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnhSp;
    private javax.swing.JTable tblChitietsp;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
