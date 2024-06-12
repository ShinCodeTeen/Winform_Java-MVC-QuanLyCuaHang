/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import DTO.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duoc Shin
 */
public class Trangchu extends javax.swing.JFrame {
 private Account AccountLG;
    /**
     * Creates new form Trangchu
     */
    public Trangchu(Account ac) {
        initComponents();
        this.AccountLG = ac;
        ktraAC();
        setPanel();
    }



    private Trangchu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
private void ktraAC(){
    lblTenNguoiDung.setText (AccountLG.ten);
    lblChucVu.setText(AccountLG.chucvu);
    int idex = tb_Trangchu.indexOfComponent(TrangChu);
   
    tb_Trangchu.setSelectedIndex(idex);
      loadTrangchu();
    if(AccountLG.type==0){
    bt_QL_DanhMuc.setVisible(false);
    bt_QL_SanPham.setVisible(false);
    bt_QL_NhanVien.setVisible(false);
    }
}
private boolean tt_TC=false;
private boolean tt_QLSP=false;
private boolean tt_QLKH=false;
private boolean tt_QLNV=false;
private boolean tt_QLDM=false;
private boolean tt_QLHD=false;
private boolean tt_DMK=false;
private void setPanel(){
            tt_TC =false;
            tt_QLSP=false;
            tt_QLKH=false;
            tt_QLNV=false;
            tt_QLDM=false;
            tt_QLHD=false;
            tt_DMK=false;
}

///Trang thai them sua
  private boolean tt_them_SP=false;
  private boolean tt_Sua_SP = false;
  private boolean tt_them_KH=false;
  private boolean tt_Sua_KH = false;
  private boolean tt_them_HD=false;
  private boolean tt_Sua_HD = false;
  private boolean tt_them_NV=false;
  private boolean tt_Sua_NV = false;
private void onPanel(String panel){
    switch (panel) {
        case "TC":
            tt_TC =true;
            tt_QLSP=false;
            tt_QLKH=false;
            tt_QLNV=false;
            tt_QLDM=false;
            tt_QLHD=false;
            tt_DMK=false;
            break;
        case "NV":
            tt_TC =false;
            tt_QLSP=false;
            tt_QLKH=false;
            tt_QLNV=true;
            tt_QLDM=false;
            tt_QLHD=false;
            tt_DMK=false;
             break;
        case "SP":
            tt_TC =false;
            tt_QLSP=true;
            tt_QLKH=false;
            tt_QLNV=false;
            tt_QLDM=false;
            tt_QLHD=false;
            tt_DMK=false;
             break;
        case "KH":
            tt_TC =false;
            tt_QLSP=false;
            tt_QLKH=true;
            tt_QLNV=false;
            tt_QLDM=false;
            tt_QLHD=false;
            tt_DMK=false;
             break;
        case "DM":
            tt_TC =false;
            tt_QLSP=false;
            tt_QLKH=false;
            tt_QLNV=false;
            tt_QLDM=true;
            tt_QLHD=false;
            tt_DMK=false;
             break;
        case "HD":
            tt_TC =false;
            tt_QLSP=false;
            tt_QLKH=false;
            tt_QLNV=false;
            tt_QLDM=false;
            tt_QLHD=true;
            tt_DMK=false;
             break;
        case "DMK":
            tt_TC =false;
            tt_QLSP=false;
            tt_QLKH=false;
            tt_QLNV=false;
            tt_QLDM=false;
            tt_QLHD=false;
            tt_DMK=true;
             break;
        
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bt_TrangChu = new javax.swing.JLabel();
        bt_QL_HoaDon = new javax.swing.JLabel();
        bt_QL_KhachHang = new javax.swing.JLabel();
        bt_QL_DanhMuc = new javax.swing.JLabel();
        bt_QL_SanPham = new javax.swing.JLabel();
        bt_QL_NhanVien = new javax.swing.JLabel();
        lblTenNguoiDung = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bt_ChangePassword = new javax.swing.JLabel();
        bt_Logout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tb_Trangchu = new javax.swing.JTabbedPane();
        QL_HoaDon = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_HoaDon = new javax.swing.JTable();
        QL_NhanVIen = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        DoiMK = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        QL_DanhMuc = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TrangChu = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_soKH = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_SPdaban = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_soSP = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_soTH = new javax.swing.JLabel();
        QL_KhachHang = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_QLKhachHang = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        bt_Them_KH = new javax.swing.JButton();
        bt_Sua_KH = new javax.swing.JButton();
        bt_Xoa_KH = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        QL_SanPham = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_SanPham = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txb_QL_tksp = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txb_QLSP_thongso = new javax.swing.JTextField();
        txb_QLSP_masp = new javax.swing.JTextField();
        txb_QLSP_giaban = new javax.swing.JTextField();
        txb_QLSP_tensp = new javax.swing.JTextField();
        txb_QLSP_gianiemyet = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        cbb_QLSP_tkdm = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cbb_QLSP_tkth = new javax.swing.JComboBox<>();
        bt_Them_SP = new javax.swing.JButton();
        bt_Sua_SP = new javax.swing.JButton();
        bt_Xoa_SP = new javax.swing.JButton();
        bt_QLSP_TK = new javax.swing.JButton();
        cbb_QLSP_dm = new javax.swing.JComboBox<>();
        cbb_QLSP_th = new javax.swing.JComboBox<>();
        bt_QLSP_Reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang Chủ");
        setMinimumSize(new java.awt.Dimension(1100, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(90, 178, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(90, 178, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(6, 0));

        bt_TrangChu.setBackground(new java.awt.Color(90, 178, 255));
        bt_TrangChu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_TrangChu.setForeground(new java.awt.Color(255, 255, 255));
        bt_TrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_TrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/building (1).png"))); // NOI18N
        bt_TrangChu.setText("Trang Chủ");
        bt_TrangChu.setOpaque(true);
        bt_TrangChu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bt_TrangChuMouseMoved(evt);
            }
        });
        bt_TrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_TrangChuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_TrangChuMouseExited(evt);
            }
        });
        jPanel3.add(bt_TrangChu);

        bt_QL_HoaDon.setBackground(new java.awt.Color(90, 178, 255));
        bt_QL_HoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_QL_HoaDon.setForeground(new java.awt.Color(255, 255, 255));
        bt_QL_HoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_QL_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/expenses (1).png"))); // NOI18N
        bt_QL_HoaDon.setText("  Quản Lý Hóa Đơn");
        bt_QL_HoaDon.setOpaque(true);
        bt_QL_HoaDon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bt_QL_HoaDonMouseMoved(evt);
            }
        });
        bt_QL_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QL_HoaDonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_QL_HoaDonMouseExited(evt);
            }
        });
        jPanel3.add(bt_QL_HoaDon);

        bt_QL_KhachHang.setBackground(new java.awt.Color(90, 178, 255));
        bt_QL_KhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_QL_KhachHang.setForeground(new java.awt.Color(255, 255, 255));
        bt_QL_KhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_QL_KhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/customer-satisfaction.png"))); // NOI18N
        bt_QL_KhachHang.setText("  Quản Lý Khách Hàng");
        bt_QL_KhachHang.setOpaque(true);
        bt_QL_KhachHang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bt_QL_KhachHangMouseMoved(evt);
            }
        });
        bt_QL_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QL_KhachHangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_QL_KhachHangMouseExited(evt);
            }
        });
        jPanel3.add(bt_QL_KhachHang);

        bt_QL_DanhMuc.setBackground(new java.awt.Color(90, 178, 255));
        bt_QL_DanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_QL_DanhMuc.setForeground(new java.awt.Color(255, 255, 255));
        bt_QL_DanhMuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_QL_DanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/product-range.png"))); // NOI18N
        bt_QL_DanhMuc.setText("   Quản Lý Danh Mục");
        bt_QL_DanhMuc.setOpaque(true);
        bt_QL_DanhMuc.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bt_QL_DanhMucMouseMoved(evt);
            }
        });
        bt_QL_DanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QL_DanhMucMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_QL_DanhMucMouseExited(evt);
            }
        });
        jPanel3.add(bt_QL_DanhMuc);

        bt_QL_SanPham.setBackground(new java.awt.Color(90, 178, 255));
        bt_QL_SanPham.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_QL_SanPham.setForeground(new java.awt.Color(255, 255, 255));
        bt_QL_SanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_QL_SanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/product-selling.png"))); // NOI18N
        bt_QL_SanPham.setText("  Quản Lý Sản Phẩm");
        bt_QL_SanPham.setOpaque(true);
        bt_QL_SanPham.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bt_QL_SanPhamMouseMoved(evt);
            }
        });
        bt_QL_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QL_SanPhamMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_QL_SanPhamMouseExited(evt);
            }
        });
        jPanel3.add(bt_QL_SanPham);

        bt_QL_NhanVien.setBackground(new java.awt.Color(90, 178, 255));
        bt_QL_NhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_QL_NhanVien.setForeground(new java.awt.Color(255, 255, 255));
        bt_QL_NhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_QL_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/management.png"))); // NOI18N
        bt_QL_NhanVien.setText("  Quản Lý Nhân Viên");
        bt_QL_NhanVien.setOpaque(true);
        bt_QL_NhanVien.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bt_QL_NhanVienMouseMoved(evt);
            }
        });
        bt_QL_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QL_NhanVienMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_QL_NhanVienMouseExited(evt);
            }
        });
        jPanel3.add(bt_QL_NhanVien);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 270, 290));

        lblTenNguoiDung.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenNguoiDung.setForeground(new java.awt.Color(255, 255, 255));
        lblTenNguoiDung.setText("Tên Người Dùng");
        jPanel1.add(lblTenNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        lblChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblChucVu.setForeground(new java.awt.Color(255, 255, 255));
        lblChucVu.setText("Chức Vụ");
        jPanel1.add(lblChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 20));

        jPanel2.setBackground(new java.awt.Color(90, 178, 255));
        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        bt_ChangePassword.setBackground(new java.awt.Color(90, 178, 255));
        bt_ChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_ChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        bt_ChangePassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_ChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/password.png"))); // NOI18N
        bt_ChangePassword.setText("Đổi Mật Khẩu");
        bt_ChangePassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 178, 255), 2));
        bt_ChangePassword.setFocusable(false);
        bt_ChangePassword.setOpaque(true);
        bt_ChangePassword.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bt_ChangePasswordMouseMoved(evt);
            }
        });
        bt_ChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ChangePasswordMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_ChangePasswordMouseExited(evt);
            }
        });
        jPanel2.add(bt_ChangePassword);

        bt_Logout.setBackground(new java.awt.Color(90, 178, 255));
        bt_Logout.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_Logout.setForeground(new java.awt.Color(255, 255, 255));
        bt_Logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/user-logout.png"))); // NOI18N
        bt_Logout.setText("Đăng Xuất");
        bt_Logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 178, 255), 2));
        bt_Logout.setOpaque(true);
        bt_Logout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bt_LogoutMouseMoved(evt);
            }
        });
        bt_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_LogoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_LogoutMouseExited(evt);
            }
        });
        jPanel2.add(bt_Logout);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 270, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/profile (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 780));

        tb_Trangchu.setBackground(new java.awt.Color(255, 255, 255));

        QL_HoaDon.setBackground(new java.awt.Color(255, 255, 255));
        QL_HoaDon.setForeground(new java.awt.Color(77, 244, 255));

        jPanel4.setBackground(new java.awt.Color(90, 178, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(153, 102, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quản Lý Hóa Đơn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        tb_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma Hoa Don", "Nhan Vien Thuc Hien", "Ten Khach Hang", "Thoi Gian", "Tong Tien", "Trang Thai"
            }
        ));
        jScrollPane1.setViewportView(tb_HoaDon);

        javax.swing.GroupLayout QL_HoaDonLayout = new javax.swing.GroupLayout(QL_HoaDon);
        QL_HoaDon.setLayout(QL_HoaDonLayout);
        QL_HoaDonLayout.setHorizontalGroup(
            QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        QL_HoaDonLayout.setVerticalGroup(
            QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_HoaDonLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tb_Trangchu.addTab("", QL_HoaDon);

        QL_NhanVIen.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(90, 178, 255));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(153, 102, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout QL_NhanVIenLayout = new javax.swing.GroupLayout(QL_NhanVIen);
        QL_NhanVIen.setLayout(QL_NhanVIenLayout);
        QL_NhanVIenLayout.setHorizontalGroup(
            QL_NhanVIenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        QL_NhanVIenLayout.setVerticalGroup(
            QL_NhanVIenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_NhanVIenLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(771, Short.MAX_VALUE))
        );

        tb_Trangchu.addTab("tab5", QL_NhanVIen);

        jPanel12.setBackground(new java.awt.Color(90, 178, 255));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(153, 102, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Đổi Mật Khẩu");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DoiMKLayout = new javax.swing.GroupLayout(DoiMK);
        DoiMK.setLayout(DoiMKLayout);
        DoiMKLayout.setHorizontalGroup(
            DoiMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DoiMKLayout.setVerticalGroup(
            DoiMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoiMKLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(771, Short.MAX_VALUE))
        );

        tb_Trangchu.addTab("tab6", DoiMK);

        QL_DanhMuc.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(90, 178, 255));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(153, 102, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Quản Lý Danh Mục");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout QL_DanhMucLayout = new javax.swing.GroupLayout(QL_DanhMuc);
        QL_DanhMuc.setLayout(QL_DanhMucLayout);
        QL_DanhMucLayout.setHorizontalGroup(
            QL_DanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        QL_DanhMucLayout.setVerticalGroup(
            QL_DanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_DanhMucLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(771, Short.MAX_VALUE))
        );

        tb_Trangchu.addTab("tab4", QL_DanhMuc);

        TrangChu.setBackground(new java.awt.Color(255, 249, 208));

        jPanel13.setBackground(new java.awt.Color(90, 178, 255));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setBackground(new java.awt.Color(153, 102, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Trang Chủ");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 249, 208));

        jLabel2.setBackground(new java.awt.Color(90, 178, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 178, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Khách Hàng Tiềm Năng");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/khachhang.png"))); // NOI18N

        lbl_soKH.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbl_soKH.setForeground(new java.awt.Color(90, 178, 255));
        lbl_soKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_soKH.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_soKH, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_soKH, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 249, 208));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/daban.png"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(90, 178, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(90, 178, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sản Phẩm Đã Bán");

        lbl_SPdaban.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbl_SPdaban.setForeground(new java.awt.Color(90, 178, 255));
        lbl_SPdaban.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_SPdaban.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(lbl_SPdaban, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(lbl_SPdaban, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 249, 208));

        jLabel9.setBackground(new java.awt.Color(90, 178, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(90, 178, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Mặt Hàng");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/sanpham.png"))); // NOI18N

        lbl_soSP.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbl_soSP.setForeground(new java.awt.Color(90, 178, 255));
        lbl_soSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_soSP.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(lbl_soSP, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbl_soSP, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 249, 208));

        jLabel15.setBackground(new java.awt.Color(90, 178, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(90, 178, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Thương Hiệu Đồng Hành");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/thuonghieu.png"))); // NOI18N

        lbl_soTH.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbl_soTH.setForeground(new java.awt.Color(90, 178, 255));
        lbl_soTH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_soTH.setText("0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(lbl_soTH, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_soTH, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout TrangChuLayout = new javax.swing.GroupLayout(TrangChu);
        TrangChu.setLayout(TrangChuLayout);
        TrangChuLayout.setHorizontalGroup(
            TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TrangChuLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        TrangChuLayout.setVerticalGroup(
            TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangChuLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 408, Short.MAX_VALUE))
        );

        tb_Trangchu.addTab("tab7", TrangChu);

        QL_KhachHang.setBackground(new java.awt.Color(255, 255, 255));
        QL_KhachHang.setEnabled(false);

        jPanel15.setBackground(new java.awt.Color(90, 178, 255));
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setBackground(new java.awt.Color(153, 102, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Quản Lý Khách Hàng");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        tb_QLKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_QLKhachHang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(tb_QLKhachHang);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Mã khách hàng :");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Tìm Kiếm :");

        jTextField9.setText("Nhập tên sản phẩm...");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Tên khách hàng :");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Số điện thoại :");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Số đơn đã mua :");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Số đơn hủy :");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Khách hàng :");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Địa chỉ :");

        jTextField10.setEnabled(false);

        jTextField12.setEnabled(false);

        jTextField13.setEnabled(false);

        jTextField14.setEnabled(false);

        jTextField15.setEnabled(false);

        jTextField16.setEnabled(false);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Danh Mục :");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("Thương Hiệu :");

        bt_Them_KH.setBackground(new java.awt.Color(73, 255, 0));
        bt_Them_KH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Them_KH.setForeground(new java.awt.Color(255, 255, 255));
        bt_Them_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/them.png"))); // NOI18N
        bt_Them_KH.setText("Mới");
        bt_Them_KH.setToolTipText("");

        bt_Sua_KH.setBackground(new java.awt.Color(255, 228, 0));
        bt_Sua_KH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Sua_KH.setForeground(new java.awt.Color(255, 255, 255));
        bt_Sua_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/sua.png"))); // NOI18N
        bt_Sua_KH.setText("Sửa");
        bt_Sua_KH.setToolTipText("");

        bt_Xoa_KH.setBackground(new java.awt.Color(255, 0, 0));
        bt_Xoa_KH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Xoa_KH.setForeground(new java.awt.Color(255, 255, 255));
        bt_Xoa_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/xoa.png"))); // NOI18N
        bt_Xoa_KH.setText("Xóa");
        bt_Xoa_KH.setToolTipText("");

        jTextField17.setEnabled(false);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QL_KhachHangLayout = new javax.swing.GroupLayout(QL_KhachHang);
        QL_KhachHang.setLayout(QL_KhachHangLayout);
        QL_KhachHangLayout.setHorizontalGroup(
            QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(QL_KhachHangLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(QL_KhachHangLayout.createSequentialGroup()
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(QL_KhachHangLayout.createSequentialGroup()
                        .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QL_KhachHangLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(12, 12, 12))
                    .addGroup(QL_KhachHangLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                    .addComponent(bt_Them_KH)
                                    .addGap(227, 227, 227)
                                    .addComponent(bt_Sua_KH)
                                    .addGap(239, 239, 239)
                                    .addComponent(bt_Xoa_KH)
                                    .addGap(25, 25, 25))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QL_KhachHangLayout.createSequentialGroup()
                                    .addGap(540, 540, 540)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                    .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(51, 51, 51)
                                    .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        QL_KhachHangLayout.setVerticalGroup(
            QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_KhachHangLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Them_KH)
                    .addComponent(bt_Sua_KH)
                    .addComponent(bt_Xoa_KH))
                .addGap(66, 66, 66)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QL_KhachHangLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tb_Trangchu.addTab("tab6", QL_KhachHang);

        QL_SanPham.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(90, 178, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(153, 102, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Quản Lý Sản Phẩm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        tb_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_SanPham.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tb_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SanPhamMouseClicked(evt);
            }
        });
        tb_SanPham.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tb_SanPhamInputMethodTextChanged(evt);
            }
        });
        jScrollPane2.setViewportView(tb_SanPham);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Mã sản phẩm :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Tìm Kiếm :");

        txb_QL_tksp.setText("Nhập tên sản phẩm...");
        txb_QL_tksp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txb_QL_tkspFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txb_QL_tkspFocusLost(evt);
            }
        });
        txb_QL_tksp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txb_QL_tkspKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Tên sản phẩm :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Thương hiệu :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Giá niêm yết :");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Giá bán :");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Loại hàng hóa :");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("Thông số :");

        txb_QLSP_thongso.setEnabled(false);

        txb_QLSP_masp.setEnabled(false);

        txb_QLSP_giaban.setEnabled(false);

        txb_QLSP_tensp.setEnabled(false);

        txb_QLSP_gianiemyet.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Danh Mục :");

        cbb_QLSP_tkdm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_QLSP_tkdmItemStateChanged(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Thương Hiệu :");

        cbb_QLSP_tkth.setToolTipText("");
        cbb_QLSP_tkth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_QLSP_tkthItemStateChanged(evt);
            }
        });

        bt_Them_SP.setBackground(new java.awt.Color(73, 255, 0));
        bt_Them_SP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Them_SP.setForeground(new java.awt.Color(255, 255, 255));
        bt_Them_SP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/them.png"))); // NOI18N
        bt_Them_SP.setText("Mới");
        bt_Them_SP.setToolTipText("");
        bt_Them_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Them_SPMouseClicked(evt);
            }
        });

        bt_Sua_SP.setBackground(new java.awt.Color(255, 228, 0));
        bt_Sua_SP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Sua_SP.setForeground(new java.awt.Color(255, 255, 255));
        bt_Sua_SP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/sua.png"))); // NOI18N
        bt_Sua_SP.setText("Sửa");
        bt_Sua_SP.setToolTipText("");
        bt_Sua_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Sua_SPMouseClicked(evt);
            }
        });

        bt_Xoa_SP.setBackground(new java.awt.Color(255, 0, 0));
        bt_Xoa_SP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Xoa_SP.setForeground(new java.awt.Color(255, 255, 255));
        bt_Xoa_SP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/xoa.png"))); // NOI18N
        bt_Xoa_SP.setText("Xóa");
        bt_Xoa_SP.setToolTipText("");

        bt_QLSP_TK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_QLSP_TK.setText("Tìm Kiếm");
        bt_QLSP_TK.setEnabled(false);
        bt_QLSP_TK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QLSP_TKMouseClicked(evt);
            }
        });

        cbb_QLSP_dm.setEnabled(false);

        cbb_QLSP_th.setEnabled(false);

        bt_QLSP_Reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_QLSP_Reset.setText("Reset");
        bt_QLSP_Reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QLSP_ResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout QL_SanPhamLayout = new javax.swing.GroupLayout(QL_SanPham);
        QL_SanPham.setLayout(QL_SanPhamLayout);
        QL_SanPhamLayout.setHorizontalGroup(
            QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(QL_SanPhamLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(QL_SanPhamLayout.createSequentialGroup()
                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txb_QL_tksp, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_QLSP_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QL_SanPhamLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txb_QLSP_thongso))
                                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txb_QLSP_masp, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txb_QLSP_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbb_QLSP_dm, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(139, 139, 139)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbb_QLSP_th, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(QL_SanPhamLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(QL_SanPhamLayout.createSequentialGroup()
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txb_QLSP_gianiemyet, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(108, 108, 108)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txb_QLSP_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(QL_SanPhamLayout.createSequentialGroup()
                                            .addComponent(bt_Them_SP)
                                            .addGap(227, 227, 227)
                                            .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(QL_SanPhamLayout.createSequentialGroup()
                                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cbb_QLSP_tkth, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(QL_SanPhamLayout.createSequentialGroup()
                                                    .addComponent(bt_Sua_SP)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bt_Xoa_SP)
                                                    .addGap(25, 25, 25)))))
                                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                                        .addGap(634, 634, 634)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbb_QLSP_tkdm, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(bt_QLSP_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        QL_SanPhamLayout.setVerticalGroup(
            QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_SanPhamLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txb_QLSP_masp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLSP_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbb_QLSP_dm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_QLSP_th, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txb_QLSP_thongso, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txb_QLSP_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLSP_gianiemyet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Them_SP)
                    .addComponent(bt_Sua_SP)
                    .addComponent(bt_Xoa_SP))
                .addGap(30, 30, 30)
                .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QL_SanPhamLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bt_QLSP_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbb_QLSP_tkth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QL_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txb_QL_tksp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbb_QLSP_tkdm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_QLSP_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tb_Trangchu.addTab("tab6", QL_SanPham);

        getContentPane().add(tb_Trangchu, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, -38, 1230, 820));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_QL_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_NhanVienMouseClicked
        if(tt_QLNV==false){
            onPanel("NV");
            int index =  tb_Trangchu.indexOfComponent(QL_NhanVIen);
            tb_Trangchu.setSelectedIndex(index);  
        }
        else{}
        {
        
        }// TODO add your handling code here:
    }//GEN-LAST:event_bt_QL_NhanVienMouseClicked
    private void LoadHoaDon(){
    Object[] title={"Mã Hoa Don","Nhan Vien Thuc Hien","Ten Khach Hang","Ngay Tao","Tong Tien","Trang Thai"};
    
    }
    private void bt_QL_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_HoaDonMouseClicked
        if(tt_QLHD==false){
            onPanel("HD"); 
        int index =  tb_Trangchu.indexOfComponent(QL_HoaDon);
        tb_Trangchu.setSelectedIndex(index);        // TODO add your handling code here:
        }
        else{}
    }//GEN-LAST:event_bt_QL_HoaDonMouseClicked
    private void LoadKH(){
    
    QLSP_off_txb();
     tt_them_KH=false;
     bt_Them_KH.setText("Mới");
     bt_Sua_KH.setText("Sửa");
    DefaultTableModel model = new DefaultTableModel();
    Object[] title={"Tên Khách Hàng","Địa chỉ","Số điện thoại","Phân loại"};
    model.setColumnIdentifiers(title);
    ArrayList<KhachHang> listKH = new DAO.DAO_KhachHang().List_KH();
    for (KhachHang kh : listKH) {
   
    Object[] row = {kh.getTenkh(),kh.getDiachi(),kh.getSdt(),kh.getType()};
    model.addRow(row);
    tb_QLKhachHang.setModel(model);
    }
    }
    private void bt_QL_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_KhachHangMouseClicked
    if(tt_QLKH==false){
            onPanel("KH");
        int index =  tb_Trangchu.indexOfComponent(QL_KhachHang);
        tb_Trangchu.setSelectedIndex(index); 
        LoadKH();
    }
    else{}
// TODO add your handling code here:
    }//GEN-LAST:event_bt_QL_KhachHangMouseClicked

    private void bt_QL_DanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_DanhMucMouseClicked
     if(tt_QLDM==false){
            onPanel("DM");
        int index =  tb_Trangchu.indexOfComponent(QL_DanhMuc);
        tb_Trangchu.setSelectedIndex(index);      // TODO add your handling code here:
     }
     else{}
// TODO add your handling code here:
    }//GEN-LAST:event_bt_QL_DanhMucMouseClicked
    
    ///////////Quan ly san pham code///////////
    private void LoadSP(){
     QLSP_off_txb();
     tt_them_SP=false;
     bt_Them_SP.setText("Mới");
     bt_Sua_SP.setText("Sửa");
    ArrayList<DM_SanPham> listdm = new DAO.DAO_DM_SanPham().List_DM();
          ArrayList<String> list_tendm = new ArrayList<>();
   
    for (DM_SanPham danhMuc : listdm) {
    list_tendm.add(danhMuc.getTendm());
    }
    DefaultComboBoxModel cbbmd1 = new DefaultComboBoxModel<>(list_tendm.toArray(new String[1]));
    cbb_QLSP_tkdm.setModel(cbbmd1);
    ArrayList<DM_ThuongHieu> listth = new DAO.DAO_DM_ThuongHieu().List_TH();
          ArrayList<String> list_tenth = new ArrayList<>();
        
    for (DM_ThuongHieu thuonghieu : listth) {
    list_tenth.add(thuonghieu.getTenth());
    }
    
     DefaultComboBoxModel cbbmd3 = new DefaultComboBoxModel<>(list_tenth.toArray(new String[1]));
    cbb_QLSP_th.setModel(cbbmd3);
    DefaultComboBoxModel cbbmd4 = new DefaultComboBoxModel<>(list_tendm.toArray(new String[1]));
    cbb_QLSP_dm.setModel(cbbmd4);
   
    DefaultComboBoxModel cbbmd2 = new DefaultComboBoxModel<>(list_tenth.toArray(new String[1]));
    cbb_QLSP_tkth.setModel(cbbmd2);
    
    DefaultTableModel model = new DefaultTableModel();
    Object[] title={"Tên Sản Phẩm","Thông Số","Giá Niêm Yết","Giá Bán","Danh Muc",""};
    model.setColumnIdentifiers(title);
    ArrayList<SanPham> listSP = new DAO.DAO_SanPham().getListSP();
    for (SanPham sp : listSP) {
    String tendm = new DAO.DAO_DM_SanPham().getTenDM(sp.getMadm());
    Object[] row = {sp.getTensp(),sp.getThongso(),sp.getGianiemyet(),sp.getGiaban(),tendm};
    model.addRow(row);
    tb_SanPham.setModel(model);
   
    }
    
    }
    
    private void QLSP_on_txb(){
    cbb_QLSP_dm.setEnabled(true);
    txb_QLSP_giaban.setEnabled(true);
    txb_QLSP_gianiemyet.setEnabled(true);
    txb_QLSP_masp.setEnabled(true);
    txb_QLSP_tensp.setEnabled(true);
    txb_QLSP_thongso.setEnabled(true);
    cbb_QLSP_th.setEnabled(true);
    }
    private void QLSP_off_txb(){
    cbb_QLSP_dm.setEnabled(false);
    txb_QLSP_giaban.setEnabled(false);
    txb_QLSP_gianiemyet.setEnabled(false);
    txb_QLSP_masp.setEnabled(false);
    txb_QLSP_tensp.setEnabled(false);
    txb_QLSP_thongso.setEnabled(false);
    cbb_QLSP_th.setEnabled(false);
    }
    private void clear_txb_QLSP(){
    txb_QLSP_giaban.setText("");
    txb_QLSP_gianiemyet.setText("");
    txb_QLSP_masp.setText("");
    txb_QLSP_tensp.setText("");
    txb_QLSP_thongso.setText("");
       
    }

    private void bt_QL_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_SanPhamMouseClicked
        if(tt_QLSP==false){
            onPanel("SP");
        int index =  tb_Trangchu.indexOfComponent(QL_SanPham);
        tb_Trangchu.setSelectedIndex(index); 
        LoadSP();}
        else{}
// TODO add your handling code here:

    }//GEN-LAST:event_bt_QL_SanPhamMouseClicked

    private void bt_ChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ChangePasswordMouseClicked
        if(tt_DMK==false){
            onPanel("DMK");
            int index =  tb_Trangchu.indexOfComponent(DoiMK);
            tb_Trangchu.setSelectedIndex(index); 
        }
        else{}// TODO add your handling code here:
    }//GEN-LAST:event_bt_ChangePasswordMouseClicked

    private void bt_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_LogoutMouseClicked
        Login lg  = new Login();
        this.dispose();
        lg.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_LogoutMouseClicked

    private void bt_TrangChuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_TrangChuMouseMoved
       Color cl = new Color(160,222,255);
       bt_TrangChu.setBackground(cl);
       
    }//GEN-LAST:event_bt_TrangChuMouseMoved

    private void bt_TrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_TrangChuMouseExited
       Color cl = new Color(90,178,255);
       bt_TrangChu.setBackground(cl);
    }//GEN-LAST:event_bt_TrangChuMouseExited

    private void bt_QL_HoaDonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_HoaDonMouseMoved
     Color cl = new Color(160,222,255);
       bt_QL_HoaDon.setBackground(cl);
    }//GEN-LAST:event_bt_QL_HoaDonMouseMoved

    private void bt_QL_HoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_HoaDonMouseExited
            Color cl = new Color(90,178,255);
       bt_QL_HoaDon.setBackground(cl);
    }//GEN-LAST:event_bt_QL_HoaDonMouseExited

    private void bt_QL_KhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_KhachHangMouseExited
        Color cl = new Color(90,178,255);
       bt_QL_KhachHang.setBackground(cl);
    }//GEN-LAST:event_bt_QL_KhachHangMouseExited

    private void bt_QL_KhachHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_KhachHangMouseMoved
       Color cl = new Color(160,222,255);
       bt_QL_KhachHang.setBackground(cl);
    }//GEN-LAST:event_bt_QL_KhachHangMouseMoved

    private void bt_QL_DanhMucMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_DanhMucMouseMoved
    Color cl = new Color(160,222,255);
       bt_QL_DanhMuc.setBackground(cl);
    }//GEN-LAST:event_bt_QL_DanhMucMouseMoved

    private void bt_QL_DanhMucMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_DanhMucMouseExited
        Color cl = new Color(90,178,255);
       bt_QL_DanhMuc.setBackground(cl);
    }//GEN-LAST:event_bt_QL_DanhMucMouseExited

    private void bt_QL_SanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_SanPhamMouseExited
             Color cl = new Color(90,178,255);
       bt_QL_SanPham.setBackground(cl);
    }//GEN-LAST:event_bt_QL_SanPhamMouseExited

    private void bt_QL_SanPhamMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_SanPhamMouseMoved
  Color cl = new Color(160,222,255);
       bt_QL_SanPham.setBackground(cl);
    }//GEN-LAST:event_bt_QL_SanPhamMouseMoved

    private void bt_QL_NhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_NhanVienMouseExited
            Color cl = new Color(90,178,255);
       bt_QL_NhanVien.setBackground(cl);
    }//GEN-LAST:event_bt_QL_NhanVienMouseExited

    private void bt_QL_NhanVienMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_NhanVienMouseMoved
        Color cl = new Color(160,222,255);
       bt_QL_NhanVien.setBackground(cl);
    }//GEN-LAST:event_bt_QL_NhanVienMouseMoved

    private void bt_ChangePasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ChangePasswordMouseExited
        Color cl = new Color(90,178,255);
    bt_ChangePassword.setBackground(cl);
    }//GEN-LAST:event_bt_ChangePasswordMouseExited

    private void bt_ChangePasswordMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ChangePasswordMouseMoved
        // TODO add your handling code here:
         Color cl = new Color(160,222,255);
       bt_ChangePassword.setBackground(cl);
    }//GEN-LAST:event_bt_ChangePasswordMouseMoved

    private void bt_LogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_LogoutMouseMoved
       Color cl = new Color(160,222,255);
       bt_Logout.setBackground(cl);
    }//GEN-LAST:event_bt_LogoutMouseMoved

    private void bt_LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_LogoutMouseExited
            Color cl = new Color(90,178,255);
            bt_Logout.setBackground(cl);
    }//GEN-LAST:event_bt_LogoutMouseExited
    private void loadTrangchu(){
        int sosp = new DAO.DAO_SanPham().getCountSP();
        lbl_soSP.setText(sosp+"");
        int soth = new DAO.DAO_DM_ThuongHieu().getSoTH();
         lbl_soTH.setText(soth+"");
    }
    private void bt_TrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_TrangChuMouseClicked
        if(tt_TC==false){
            onPanel("TC"); 
        int index =  tb_Trangchu.indexOfComponent(TrangChu);
        tb_Trangchu.setSelectedIndex(index);  
        loadTrangchu();
        }
        else{}
    }//GEN-LAST:event_bt_TrangChuMouseClicked
     
    private void bt_Them_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Them_SPMouseClicked
        if(tt_Sua_SP){
            int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){
                tt_Sua_SP=false;
                bt_Sua_SP.setText("Sửa");
                if(tt_them_SP==false){
                    clear_txb_QLSP();
                    QLSP_on_txb();
                    bt_Them_SP.setText("Xác nhận");
                    tt_them_SP=true;
        
                    }
                
            
            }
        }
        else{
            if(tt_them_SP==false){
                    clear_txb_QLSP();
                    QLSP_on_txb();
                    bt_Them_SP.setText("Xác nhận");
                    tt_them_SP=true;
        
                    }
            else{
                if(txb_QLSP_giaban.getText().isEmpty() && txb_QLSP_gianiemyet.getText().isEmpty() && txb_QLSP_masp.getText().isEmpty() && txb_QLSP_tensp.getText().isEmpty() && txb_QLSP_thongso.getText().isEmpty())
                {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin sản phẩm !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                else{
                String masp = txb_QLSP_masp.getText();
                String tensp = txb_QLSP_tensp.getText();
                String thongso = txb_QLSP_thongso.getText();
                int gianiemyet =Integer.parseInt( txb_QLSP_gianiemyet.getText());
                int giaban = Integer.parseInt(txb_QLSP_giaban.getText());
                String madm = new DAO.DAO_DM_SanPham().getMadm(cbb_QLSP_dm.getSelectedItem().toString());
                String math = new DAO.DAO_DM_ThuongHieu().getMath(cbb_QLSP_th.getSelectedItem().toString());
                boolean re_them = new DAO.DAO_SanPham().InsertSanPham(masp,tensp, math, madm, thongso, gianiemyet, giaban);
                if(re_them){
                   int option = JOptionPane.showOptionDialog(null, "Thêm sản phẩm thành công !! Tiếp tục thêm ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                   if(option==JOptionPane.OK_OPTION){
                    clear_txb_QLSP();
                   }
                   else{
                   clear_txb_QLSP();
                   tt_them_SP = false;
                   QLSP_off_txb();
                   bt_Them_SP.setText("Mới");
                   }
                }
                }
            }
            
        }
        
           
    }//GEN-LAST:event_bt_Them_SPMouseClicked

    private void tb_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SanPhamMouseClicked
       if(tt_them_SP){
            int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){
                QLSP_off_txb();
                tt_them_SP=false;
                bt_Them_SP.setText("Mới");
                 int row = tb_SanPham.getSelectedRow();
                 String ten =tb_SanPham.getValueAt(row, 0).toString();
                SanPham sp = new DAO.DAO_SanPham().getsp(ten);
                txb_QLSP_masp.setText(sp.masp);
                txb_QLSP_tensp.setText(sp.tensp);
                cbb_QLSP_dm.setSelectedItem(sp.madm);
                cbb_QLSP_th.setSelectedItem(sp.math);
                txb_QLSP_thongso.setText(sp.thongso);
                txb_QLSP_gianiemyet.setText(tb_SanPham.getValueAt(row, 2).toString());
                txb_QLSP_giaban.setText(tb_SanPham.getValueAt(row, 3).toString());
            }
        
       }
       
       else {
        int row = tb_SanPham.getSelectedRow();
        String ten =tb_SanPham.getValueAt(row, 0).toString();
        SanPham sp = new DAO.DAO_SanPham().getsp(ten);
        txb_QLSP_masp.setText(sp.masp);
        txb_QLSP_tensp.setText(sp.tensp);
        cbb_QLSP_dm.setSelectedItem(tb_SanPham.getValueAt(row, 3));
        cbb_QLSP_th.setSelectedItem(tb_SanPham.getValueAt(row, 4));
        txb_QLSP_thongso.setText(sp.thongso);
        txb_QLSP_gianiemyet.setText(tb_SanPham.getValueAt(row, 2).toString());
        txb_QLSP_giaban.setText(tb_SanPham.getValueAt(row, 3).toString());
       }
       
        
       
     
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_SanPhamMouseClicked

    private void txb_QL_tkspFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txb_QL_tkspFocusGained
        
        txb_QL_tksp.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txb_QL_tkspFocusGained

    private void txb_QL_tkspFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txb_QL_tkspFocusLost
        if(txb_QL_tksp.getText()==""){
        txb_QL_tksp.setText("Nhập tên sản phẩm..."); 
        }
        else{}// TODO add your handling code here:
    }//GEN-LAST:event_txb_QL_tkspFocusLost

    private void tb_SanPhamInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tb_SanPhamInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_SanPhamInputMethodTextChanged

    private void bt_QLSP_TKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QLSP_TKMouseClicked
    DefaultTableModel model = (DefaultTableModel)tb_SanPham.getModel();
    model.setRowCount(0); // Xóa tất cả dữ liệu

    String tensp = txb_QL_tksp.getText();
       
    ArrayList<SanPham> listsp = new DAO.DAO_SanPham().getSPTK(tensp);
    
    for (SanPham sp : listsp) {
    String tendm = new DAO.DAO_DM_SanPham().getTenDM(sp.getMadm());
    Object[] row = {sp.getTensp(), sp.getThongso(), sp.getGianiemyet(), sp.getGiaban(), tendm};
    model.addRow(row);
    }
    
    }//GEN-LAST:event_bt_QLSP_TKMouseClicked

    private void txb_QL_tkspKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txb_QL_tkspKeyTyped
        if(txb_QL_tksp.getText()!=""){
        bt_QLSP_TK.setEnabled(true);
        }
        else{
        bt_QL_DanhMuc.setEnabled(false);
        }
    }//GEN-LAST:event_txb_QL_tkspKeyTyped

    private void cbb_QLSP_tkthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_QLSP_tkthItemStateChanged

        String th = cbb_QLSP_tkth.getSelectedItem().toString();
        String dm = cbb_QLSP_tkdm.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel)tb_SanPham.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<SanPham> listsp = new ArrayList<>();
        String math = new DAO.DAO_DM_ThuongHieu().getMath(th);
        String madm = new DAO.DAO_DM_SanPham().getMadm(dm);
        listsp = new DAO.DAO_SanPham().getSPCbb(madm, math);
        for (SanPham sp : listsp) {
            String tendm = new DAO.DAO_DM_SanPham().getTenDM(sp.getMadm());
            Object[] row = {sp.getTensp(), sp.getThongso(), sp.getGianiemyet(), sp.getGiaban(), tendm};
            model.addRow(row);
        }
    }//GEN-LAST:event_cbb_QLSP_tkthItemStateChanged

    private void cbb_QLSP_tkdmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_QLSP_tkdmItemStateChanged
       String th = cbb_QLSP_tkth.getSelectedItem().toString();
        String dm = cbb_QLSP_tkdm.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel)tb_SanPham.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<SanPham> listsp = new ArrayList<>();
        String math = new DAO.DAO_DM_ThuongHieu().getMath(th);
        String madm = new DAO.DAO_DM_SanPham().getMadm(dm);
        listsp = new DAO.DAO_SanPham().getSPCbb(madm, math);
        for (SanPham sp : listsp) {
            String tendm = new DAO.DAO_DM_SanPham().getTenDM(sp.getMadm());
            Object[] row = {sp.getTensp(), sp.getThongso(), sp.getGianiemyet(), sp.getGiaban(), tendm};
            model.addRow(row);
        }
    }//GEN-LAST:event_cbb_QLSP_tkdmItemStateChanged

    private void bt_QLSP_ResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QLSP_ResetMouseClicked
       
        DefaultTableModel model = (DefaultTableModel)tb_SanPham.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<SanPham> listsp = new DAO.DAO_SanPham().getListSP();
        for (SanPham sp : listsp) {
            String tendm = new DAO.DAO_DM_SanPham().getTenDM(sp.getMadm());
            Object[] row = {sp.getTensp(), sp.getThongso(), sp.getGianiemyet(), sp.getGiaban(), tendm};
            model.addRow(row);
        }
    }//GEN-LAST:event_bt_QLSP_ResetMouseClicked

    private void bt_Sua_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Sua_SPMouseClicked
         int selectedRow = tb_SanPham.getSelectedRow();
         if(selectedRow==-1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trước !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            
         }
         else{
            if(tt_them_SP){
                int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(option==JOptionPane.OK_OPTION){
                    tt_them_SP=false;
                    bt_Them_SP.setText("Mới");
                    int row = tb_SanPham.getSelectedRow();
                    String ten =tb_SanPham.getValueAt(row, 0).toString();
                    SanPham sp = new DAO.DAO_SanPham().getsp(ten);
                    txb_QLSP_masp.setText(sp.masp);
                    txb_QLSP_tensp.setText(sp.tensp);
                    cbb_QLSP_dm.setSelectedItem(tb_SanPham.getValueAt(row, 3));
                    cbb_QLSP_th.setSelectedItem(tb_SanPham.getValueAt(row, 4));
                    txb_QLSP_thongso.setText(sp.thongso);
                    txb_QLSP_gianiemyet.setText(tb_SanPham.getValueAt(row, 2).toString());
                    txb_QLSP_giaban.setText(tb_SanPham.getValueAt(row, 3).toString());
                    QLSP_on_txb();
                    tt_Sua_SP=true;
                    bt_Sua_SP.setText("Xác nhận");
             }
            }
            else{
                
                    bt_Them_SP.setText("Mới");
                    int row = tb_SanPham.getSelectedRow();
                    String ten =tb_SanPham.getValueAt(row, 0).toString();
                    SanPham sp = new DAO.DAO_SanPham().getsp(ten);
                    txb_QLSP_masp.setText(sp.masp);
                    txb_QLSP_tensp.setText(sp.tensp);
                    cbb_QLSP_dm.setSelectedItem(tb_SanPham.getValueAt(row, 3));
                    cbb_QLSP_th.setSelectedItem(tb_SanPham.getValueAt(row, 4));
                    txb_QLSP_thongso.setText(sp.thongso);
                    txb_QLSP_gianiemyet.setText(tb_SanPham.getValueAt(row, 2).toString());
                    txb_QLSP_giaban.setText(tb_SanPham.getValueAt(row, 3).toString());
                    QLSP_on_txb();
                    tt_Sua_SP=true;
                    bt_Sua_SP.setText("Xác nhận");
            }
         }
    }//GEN-LAST:event_bt_Sua_SPMouseClicked

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed
    
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
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trangchu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DoiMK;
    private javax.swing.JPanel QL_DanhMuc;
    private javax.swing.JPanel QL_HoaDon;
    private javax.swing.JPanel QL_KhachHang;
    private javax.swing.JPanel QL_NhanVIen;
    private javax.swing.JPanel QL_SanPham;
    private javax.swing.JPanel TrangChu;
    private javax.swing.JLabel bt_ChangePassword;
    private javax.swing.JLabel bt_Logout;
    private javax.swing.JButton bt_QLSP_Reset;
    private javax.swing.JButton bt_QLSP_TK;
    private javax.swing.JLabel bt_QL_DanhMuc;
    private javax.swing.JLabel bt_QL_HoaDon;
    private javax.swing.JLabel bt_QL_KhachHang;
    private javax.swing.JLabel bt_QL_NhanVien;
    private javax.swing.JLabel bt_QL_SanPham;
    private javax.swing.JButton bt_Sua_KH;
    private javax.swing.JButton bt_Sua_SP;
    private javax.swing.JButton bt_Them_KH;
    private javax.swing.JButton bt_Them_SP;
    private javax.swing.JLabel bt_TrangChu;
    private javax.swing.JButton bt_Xoa_KH;
    private javax.swing.JButton bt_Xoa_SP;
    private javax.swing.JComboBox<String> cbb_QLSP_dm;
    private javax.swing.JComboBox<String> cbb_QLSP_th;
    private javax.swing.JComboBox<String> cbb_QLSP_tkdm;
    private javax.swing.JComboBox<String> cbb_QLSP_tkth;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblTenNguoiDung;
    private javax.swing.JLabel lbl_SPdaban;
    private javax.swing.JLabel lbl_soKH;
    private javax.swing.JLabel lbl_soSP;
    private javax.swing.JLabel lbl_soTH;
    private javax.swing.JTable tb_HoaDon;
    private javax.swing.JTable tb_QLKhachHang;
    private javax.swing.JTable tb_SanPham;
    private javax.swing.JTabbedPane tb_Trangchu;
    private javax.swing.JTextField txb_QLSP_giaban;
    private javax.swing.JTextField txb_QLSP_gianiemyet;
    private javax.swing.JTextField txb_QLSP_masp;
    private javax.swing.JTextField txb_QLSP_tensp;
    private javax.swing.JTextField txb_QLSP_thongso;
    private javax.swing.JTextField txb_QL_tksp;
    // End of variables declaration//GEN-END:variables
}
