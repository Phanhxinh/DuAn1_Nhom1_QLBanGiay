/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import ITFService.ChucVuITF;
import ITFService.NhanVienITF;
import ServiceIML.ChucVuIML;
import ServiceIML.NhanVienIML;
import ViewModel.NhanVienViewModel;
import views.FormChucVu;
import java.awt.Image;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import views.FormChucVu;

/**
 *
 * @author DELL
 */
public class Menu7 extends javax.swing.JInternalFrame {

    private final NhanVienITF nvitf = new NhanVienIML();
    private final ChucVuITF cvitf = new ChucVuIML();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form Menu1
     */
    public Menu7() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        loadData();
        CbxChucVu();
    }

    public void loadData() {
        DefaultTableModel tblModel = (DefaultTableModel) tblNhanVien.getModel();
        tblModel.setRowCount(0);
        List<NhanVienViewModel> list = nvitf.getListNV();
        for (NhanVienViewModel ctnv : list) {
            Object[] row = new Object[]{ctnv.getMaNv(), ctnv.getHoTen(), ctnv.getGioiTinh(), ctnv.getNgaySinh(), ctnv.getEmail(), ctnv.getDiaChi(), ctnv.getMatKhau(), ctnv.getSdt(), ctnv.getChucVu(), ctnv.getTrangThai() == 0 ? "Đang làm" : "Nghỉ làm", ctnv.getAnh()};
            tblModel.addRow(row);
        }

    }

    public void clearForm() {
        txtManv.setText("");
        txtHotennv.setText("");
        gruopGioiTinh.clearSelection();
        txtNgaySinh.setDate(null);
        txtEmail.setText("");
        txtSdt.setText("");
        txtMatKhau.setText("");
    }

    private void CbxChucVu() {
        cbxChucVu.removeAllItems();
        for (ChucVu chucVu : cvitf.CbxChucVu()) {
            cbxChucVu.addItem(String.valueOf(chucVu));
        }
    }

    private String getIdChucVu(String ten) {
        for (ChucVu chucVu : cvitf.CbxChucVu()) {
            if (chucVu.getTenCV().equals(ten)) {
                return chucVu.getIdCV();
            }
        }
        return null;
    }

    public void add() {
        NhanVien nv = new NhanVien();
        nv.setMaNv(txtManv.getText());
        nv.setHoTen(txtHotennv.getText());
        nv.setEmail(txtEmail.getText());
        nv.setNgaySinh(sdf.format(txtNgaySinh.getDate()));
        if (rdoNam.isSelected()) {
            nv.setGioiTinh("Nam");
        } else {
            nv.setGioiTinh("Nữ");
        }
        nv.setDiaChi(txtDiachi.getText());
        nv.setMatKhau(txtMatKhau.getText());
        nv.setAnhNv(lblImgNv.getName());
        nv.setSdt(txtSdt.getText());
        String TenChucVu = cbxChucVu.getSelectedItem().toString();
        nv.setIdCV(getIdChucVu(TenChucVu));
        int TrangThai;
        if (cbbTrangThai.getSelectedIndex() == 0) {
            TrangThai = 0;
        } else {
            TrangThai = 1;
        }
        try {
            nvitf.Add(nv);
            loadData();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (RuntimeException re) {
            JOptionPane.showMessageDialog(this, re.getMessage());
        }
    }

    public void Update() {
        NhanVien nv = new NhanVien();
        nv.setMaNv(txtManv.getText());
        nv.setHoTen(txtHotennv.getText());
        nv.setEmail(txtEmail.getText());
        nv.setNgaySinh(sdf.format(txtNgaySinh.getDate()));
        if (rdoNam.isSelected()) {
            nv.setGioiTinh("Nam");
        } else {
            nv.setGioiTinh("Nữ");
        }
        nv.setDiaChi(txtDiachi.getText());
        nv.setMatKhau(txtMatKhau.getText());
        nv.setAnhNv(lblImgNv.getName());
        nv.setSdt(txtSdt.getText());
        String TenChucVu = cbxChucVu.getSelectedItem().toString();
        nv.setIdCV(getIdChucVu(TenChucVu));
        int TrangThai;
        if (cbbTrangThai.getSelectedIndex() == 0) {
            TrangThai = 0;
        } else {
            TrangThai = 1;
        }
        try {
            nvitf.Update(txtManv.getText(), nv);
            loadData();
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } catch (RuntimeException re) {
            JOptionPane.showMessageDialog(this, re.getMessage());
        }
    }

    public void selectRow(int i) {
        try {
            NhanVien nv = new NhanVien();
            DefaultTableModel tblModel = (DefaultTableModel) tblNhanVien.getModel();
            txtManv.setText(tblModel.getValueAt(i, 0).toString());
            txtHotennv.setText(tblModel.getValueAt(i, 1).toString());
            System.out.println(tblModel.getValueAt(i, 2));
            if (tblModel.getValueAt(i, 2).equals("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            Date NgaySinh = sdf.parse(tblModel.getValueAt(i, 3).toString());
            txtNgaySinh.setDate(NgaySinh);
            txtEmail.setText(tblModel.getValueAt(i, 4).toString());
            txtDiachi.setText(tblModel.getValueAt(i, 5).toString());
            txtMatKhau.setText(tblModel.getValueAt(i, 6).toString());
            txtSdt.setText(tblModel.getValueAt(i, 7).toString());
            cbxChucVu.setSelectedItem(tblModel.getValueAt(i, 8).toString());
            cbbTrangThai.setSelectedItem(tblModel.getValueAt(i, 9).toString());
            String path = tblModel.getValueAt(i, 10).toString();
            // Tạo file từ đường dẫn ảnh
            File file = new File(path);
            int imgW = lblImgNv.getWidth();
            int imgH = lblImgNv.getHeight();
            // Tạo file ảnh tư file ở trên
            Image img = new ImageIcon(file.getAbsolutePath())
                    .getImage()
                    .getScaledInstance(imgW, imgH, Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(img);
            lblImgNv.setIcon(icon);
            lblImgNv.setHorizontalAlignment(JLabel.CENTER);
            lblImgNv.setVerticalAlignment(JLabel.CENTER);
            lblImgNv.setName(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FindNhanVien(String manv, String tennv) {
        DefaultTableModel tblModel = (DefaultTableModel) tblNhanVien.getModel();
        tblModel.setRowCount(0);
        List<NhanVienViewModel> list = nvitf.FindNhanVien(manv);
        for (NhanVienViewModel ctnv : list) {
            Object[] row = new Object[]{ctnv.getMaNv(), ctnv.getHoTen(), ctnv.getGioiTinh(), ctnv.getNgaySinh(), ctnv.getEmail(), ctnv.getDiaChi(), ctnv.getMatKhau(), ctnv.getSdt(), ctnv.getChucVu(), ctnv.getTrangThai() == 0 ? "Đang làm" : "Nghỉ làm", ctnv.getAnh()};
            tblModel.addRow(row);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gruopGioiTinh = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtManv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHotennv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxChucVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnFormChucVu = new javax.swing.JButton();
        txtDiachi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        lblImgNv = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1270, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(1270, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtFind.setBackground(new java.awt.Color(255, 255, 255));
        txtFind.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFind.setForeground(new java.awt.Color(0, 0, 0));
        txtFind.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindCaretUpdate(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null, null, null, null, null, null},
                {"", null, null, null, null, null, null, null, null, null, null},
                {"", null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "Email", "Địa chỉ", "Mật khẩu", "Số điện thoại", "Chức vụ", "Trạng thái", "Ảnh"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel11)
                        .addGap(45, 45, 45)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mã NV");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        txtManv.setBackground(new java.awt.Color(255, 255, 255));
        txtManv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtManv.setForeground(new java.awt.Color(0, 0, 0));
        txtManv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManvActionPerformed(evt);
            }
        });
        jPanel2.add(txtManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 280, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ và tên");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        txtHotennv.setBackground(new java.awt.Color(255, 255, 255));
        txtHotennv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHotennv.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(txtHotennv, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 280, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Giới tính");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ngày sinh");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        gruopGioiTinh.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(0, 0, 0));
        rdoNam.setText("Nam");
        jPanel2.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        gruopGioiTinh.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(0, 0, 0));
        rdoNu.setText("Nữ");
        jPanel2.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 290, 30));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("SDT");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        txtSdt.setBackground(new java.awt.Color(255, 255, 255));
        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSdt.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 290, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mật khẩu");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        txtMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 290, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Chức vụ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, -1));

        cbxChucVu.setBackground(new java.awt.Color(255, 255, 255));
        cbxChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxChucVu.setForeground(new java.awt.Color(0, 0, 0));
        cbxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 140, 30));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Trạng thái");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 100, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sửa.png"))); // NOI18N
        jButton2.setText("Cập nhật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 130, 30));

        btnFormChucVu.setBackground(new java.awt.Color(255, 255, 255));
        btnFormChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add (1).png"))); // NOI18N
        btnFormChucVu.setBorder(null);
        btnFormChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormChucVuActionPerformed(evt);
            }
        });
        jPanel2.add(btnFormChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, 61, 30));

        txtDiachi.setBackground(new java.awt.Color(255, 255, 255));
        txtDiachi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiachi.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(txtDiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 290, 30));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Địa chỉ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        cbbTrangThai.setBackground(new java.awt.Color(255, 255, 255));
        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbTrangThai.setForeground(new java.awt.Color(0, 0, 0));
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Đã nghỉ" }));
        jPanel2.add(cbbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 150, 30));

        txtNgaySinh.setDate(new java.util.Date(1669125429000L));
        txtNgaySinh.setDateFormatString("yyyy/MM/dd");
        jPanel2.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 205, 30));

        lblImgNv.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblImgNv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImgNvMouseClicked(evt);
            }
        });
        jPanel2.add(lblImgNv, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 38, 160, 180));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFormChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormChucVuActionPerformed
        FormChucVu fcv = new FormChucVu();
        fcv.setVisible(true);

    }//GEN-LAST:event_btnFormChucVuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtManvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManvActionPerformed

    private void lblImgNvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgNvMouseClicked
        JFileChooser fileChooser = new JFileChooser("images");

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Khởi tạo file với giá trị = file đã chọn ở khung chọn file
            File selectedFile = fileChooser.getSelectedFile();
            // Lấy kích thước khung ảnh
            int imgW = lblImgNv.getWidth();
            int imgH = lblImgNv.getHeight();
            ImageIcon icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage().getScaledInstance(imgW, imgH, Image.SCALE_DEFAULT));
            lblImgNv.setName(selectedFile.getAbsolutePath());
            lblImgNv.setIcon(icon);
            lblImgNv.setHorizontalAlignment(JLabel.CENTER);
            lblImgNv.setVerticalAlignment(JLabel.CENTER);
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_lblImgNvMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int i = tblNhanVien.getSelectedRow();
        selectRow(i);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void txtFindCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindCaretUpdate
        FindNhanVien(txtFind.getText(), txtFind.getText());
    }//GEN-LAST:event_txtFindCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFormChucVu;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cbxChucVu;
    private javax.swing.ButtonGroup gruopGioiTinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImgNv;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtHotennv;
    private javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
