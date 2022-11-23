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
    private final ChiTietSpITF ctspitf=new ChiTietSPIML();
    private final SanPhamITF spitf=new SanPhamIML();
    private final KichCoITF kcitf=new KichCoIML();
    private final TheLoaiITF tlitf=new TheLoaiIML();
    private final HangITF hangitf=new HangIML();
    private final DEITF deitf=new DeIML();
    private final MauSacITF mauitf=new MauSacIML();
    private final ChatLieuITF clitf=new ChatLieuIML();
    /**
     * Creates new form Menu1
     */
    public Menu4() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
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
    
    public void loadData(){
        DefaultTableModel tblModel = (DefaultTableModel) tblChitietsp.getModel();
        tblModel.setRowCount(0);
        List<ChiTietSPModel> list=ctspitf.getListCTSP();
        for(ChiTietSPModel ctsp : list ){
            Object[] row = new Object[]{ctsp.getId(),ctsp.getIdSP(),ctsp.getIdSize(),ctsp.getIdMau(),ctsp.getIdLoaiSP(),ctsp.getIdChatLieu(),ctsp.getIdHang(),ctsp.getIdDE(),ctsp.getGiaNhap(),ctsp.getGiaBan(),ctsp.getSoLuong(),ctsp.getBarCode(),ctsp.getMoTa(),ctsp.getTrangThai() == 0 ? "Còn bán" : "Không còn bán" ,ctsp.getAnh()};
            tblModel.addRow(row);
        }
        
    }
    
    public void ConHang(){
        DefaultTableModel tblModel = (DefaultTableModel) tblChitietsp.getModel();
        tblModel.setRowCount(0);
        List<ChiTietSPModel> list=ctspitf.getListCTSP();
        for(ChiTietSPModel ctsp : list ){
            if(ctsp.getSoLuong()>0){
            Object[] row = new Object[]{ctsp.getId(),ctsp.getIdSP(),ctsp.getIdSize(),ctsp.getIdMau(),ctsp.getIdLoaiSP(),ctsp.getIdChatLieu(),ctsp.getIdHang(),ctsp.getIdDE(),ctsp.getGiaNhap(),ctsp.getGiaBan(),ctsp.getSoLuong(),ctsp.getBarCode(),ctsp.getMoTa(),ctsp.getTrangThai() == 0 ? "Còn bán" : "Không còn bán" ,ctsp.getAnh()};
            tblModel.addRow(row);
            }
        }
        
    }
    
    public void HetHang(){
        DefaultTableModel tblModel = (DefaultTableModel) tblChitietsp.getModel();
        tblModel.setRowCount(0);
        List<ChiTietSPModel> list=ctspitf.getListCTSP();
        for(ChiTietSPModel ctsp : list ){
            if(ctsp.getSoLuong()==0){
            Object[] row = new Object[]{ctsp.getId(),ctsp.getIdSP(),ctsp.getIdSize(),ctsp.getIdMau(),ctsp.getIdLoaiSP(),ctsp.getIdChatLieu(),ctsp.getIdHang(),ctsp.getIdDE(),ctsp.getGiaNhap(),ctsp.getGiaBan(),ctsp.getSoLuong(),ctsp.getBarCode(),ctsp.getMoTa(),ctsp.getTrangThai() == 0 ? "Còn bán" : "Không còn bán" ,ctsp.getAnh()};
            tblModel.addRow(row);
            }
        }
        
    }
    
    
    private void CbxSanPham() {
        cbxTenSp.removeAllItems();
        for (SanPham_SanPhamModel sp : spitf.CbxSanPham()){
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
        for (KichCo_SanPhamModel kc : kcitf.CbxKichCo()){
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
        for (MauSac_SanphamModel ms : mauitf.CbxMauSac()){
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
        for (Hang_SanPhamModel hang : hangitf.CbxHang()){
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
        for (TheLoai_SanPhamModel tl : tlitf.CbxTheLoai()){
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
        for (ChatLieu_SanPhamModel tl : clitf.CbxChatLieu()){
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
        for (De_SanPhamModel tl : deitf.CbxDe()){
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
    
    public void add(){
        ChiTietSPModel ctsp = new ChiTietSPModel();
        String TenSanPham=cbxTenSp.getSelectedItem().toString();
        ctsp.setIdSP(getIdSanPham(TenSanPham));
        String Size=cbxSize.getSelectedItem().toString();
        ctsp.setIdSize(getIdKichCo(Size));
        String MauSac=cbxMau.getSelectedItem().toString();
        ctsp.setIdMau(getIdMauSac(MauSac));
        String Loai=cbxLoaiSp.getSelectedItem().toString();
        ctsp.setIdLoaiSP(getIdTheLoai(Loai));
        String ChatLieu=cbxChatLieu.getSelectedItem().toString();
        ctsp.setIdChatLieu(getIdChatLieu(ChatLieu));
        String Hang=cbxHang.getSelectedItem().toString();
        ctsp.setIdHang(getIdHang(Hang));
        String De=cbxDe.getSelectedItem().toString();
        ctsp.setIdDE(getIdDe(De));
        ctsp.setGiaNhap(Integer.parseInt(txtGiaNhap.getText()));
        ctsp.setGiaBan(Integer.parseInt(txtGiaBan.getText()));
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        ctsp.setBarCode(txtBarcode.getText());
        ctsp.setMoTa(txtMoTa.getText());
        ctsp.setAnh(lblAnhSp.getName());
        int TrangThai;
        if(cbxTrangThai.getSelectedIndex()==0){
            TrangThai=0;
        }else{
            TrangThai=1;
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
    
    public void Update(){
        ChiTietSPModel ctsp = new ChiTietSPModel();
        String Size=cbxSize.getSelectedItem().toString();
        ctsp.setIdSize(getIdKichCo(Size));
        String MauSac=cbxMau.getSelectedItem().toString();
        ctsp.setIdMau(getIdMauSac(MauSac));
        String Loai=cbxLoaiSp.getSelectedItem().toString();
        ctsp.setIdLoaiSP(getIdTheLoai(Loai));
        String ChatLieu=cbxChatLieu.getSelectedItem().toString();
        ctsp.setIdChatLieu(getIdChatLieu(ChatLieu));
        String Hang=cbxHang.getSelectedItem().toString();
        ctsp.setIdHang(getIdHang(Hang));
        String De=cbxDe.getSelectedItem().toString();
        ctsp.setIdDE(getIdDe(De));
        ctsp.setGiaNhap(Integer.parseInt(txtGiaNhap.getText()));
        ctsp.setGiaBan(Integer.parseInt(txtGiaBan.getText()));
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        ctsp.setBarCode(txtBarcode.getText());
        ctsp.setMoTa(txtMoTa.getText());
        ctsp.setAnh(lblAnhSp.getName());
        int TrangThai;
        if(cbxTrangThai.getSelectedIndex()==0){
            TrangThai=0;
        }else{
            TrangThai=1;
        }
        ctsp.setTrangThai(TrangThai);
        String id=txtId.getText();
        try {
            
            ctspitf.Update(id,ctsp);
            loadData();
            JOptionPane.showMessageDialog(this, " thành công");   
            
        } catch (RuntimeException re) {
            JOptionPane.showMessageDialog(this, "Lỗi");              
        }
    }
    
    public void selectRow(int i){
        ChiTietSPModel ctsp = new ChiTietSPModel();
        DefaultTableModel tblModel=(DefaultTableModel) tblChitietsp.getModel();
        
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

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 690));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 690));

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

        jLabel13.setText("Tìm Kiếm tên sản phẩm");

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        cbxSoLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn hàng", "Hết hàng" }));
        cbxSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSoLuongActionPerformed(evt);
            }
        });

        lblAnhSp.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblAnhSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhSpMouseClicked(evt);
            }
        });

        jLabel1.setText("Tên sản phẩm");

        jLabel2.setText("Kích cỡ");

        jLabel3.setText("Màu sắc");

        jLabel4.setText("Loại sản phẩm");

        cbxTenSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSizeActionPerformed(evt);
            }
        });

        cbxMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxLoaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Để");

        jLabel6.setText("Giá nhập");

        jLabel7.setText("Giá bán");

        jLabel8.setText("Số lượng");

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        cbxDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Barcode");

        jLabel10.setText("Chất liệu");

        jLabel11.setText("Hãng");

        cbxChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jLabel12.setText("Trạng Thái");

        cbxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn bán", "Không còn bán" }));

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel14.setText("ID");

        txtId.setText("--");

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(lblAnhSp, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSize, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMau, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxDe, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxChatLieu, 0, 132, Short.MAX_VALUE)
                            .addComponent(cbxHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3))
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jButton5)))
                    .addComponent(lblAnhSp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cbxHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd)
                                        .addComponent(btnSua)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(cbxSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblChitietspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChitietspMouseClicked
        int i = tblChitietsp.getSelectedRow();
        selectRow(i);
    }//GEN-LAST:event_tblChitietspMouseClicked

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate

    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void cbxSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSoLuongActionPerformed
        if(cbxSoLuong.getSelectedIndex()==0){
            loadData();
        }else if(cbxSoLuong.getSelectedIndex()==1){
            ConHang();
        }else if(cbxSoLuong.getSelectedIndex()==2){
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
        FormSanPham fsp=new FormSanPham();
        fsp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormKichCo fkc=new FormKichCo();
        fkc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormMauSac fkc=new FormMauSac();
        fkc.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FormTheLoai ftl=new FormTheLoai();
        ftl.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FormDe fde=new FormDe();
        fde.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        FormChatLieu fcl=new FormChatLieu();
        fcl.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        FormHang fhang=new FormHang();
        fhang.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed


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
