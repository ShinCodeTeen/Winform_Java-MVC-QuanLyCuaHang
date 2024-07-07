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
import java.util.Random;
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
     public static String RandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        
        return sb.toString();
    }
     
    private String taoMaHD(){
    String mahd = RandomString(4);
    if(new DAO.DAO_HoaDon().ktraMaHD(mahd)>0){
        return taoMaHD();
    }
    return mahd;
    
    }
private void ktraAC(){
    lblTenNguoiDung.setText (AccountLG.ten);
    lblChucVu.setText(AccountLG.chucvu);
    int idex = tb_Trangchu.indexOfComponent(TrangChu);
   
    tb_Trangchu.setSelectedIndex(idex);
      loadTrangchu();
    if(AccountLG.type==0){
  
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
private void resetTableSP(){
     DefaultTableModel model = (DefaultTableModel)tb_SanPham.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<SanPham> listsp = new DAO.DAO_SanPham().getListSP();
        for (SanPham sp : listsp) {
            String tendm = new DAO.DAO_DM_SanPham().getTenDM(sp.getMadm());
            Object[] row = {sp.getTensp(), sp.getThongso(), sp.getGianiemyet(), sp.getGiaban(), tendm};
            model.addRow(row);
        }
    }
private void resetTableKH(){
     DefaultTableModel model = (DefaultTableModel)tb_QLKhachHang.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<KhachHang> listkh = new DAO.DAO_KhachHang().List_KH();
        String pl;
    for (KhachHang kh : listkh) {
    int type  = kh.getType();
    if(type==0){
        pl = "Thường";
    
    }
    else if (type == 1){
        pl = "Thân Thiết";
    }
    else{
        pl = "Danh sách đen";
    }
    Object[] row = {kh.getMakh(),kh.getTenkh(),kh.getDiachi(),kh.getSdt(),pl};
    model.addRow(row);
    }
}
private void resetTableHD(){
     DefaultTableModel model = (DefaultTableModel)tb_QLHoaDon.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
         ArrayList<HoaDon> listHD = new DAO.DAO_HoaDon().List_HD();
    String tt;
         for (HoaDon hd : listHD) {
    String tenkh = new DAO.DAO_KhachHang().getTenKH(hd.getMakh());
        switch (hd.getTrangthai()) {
            case 0:
                tt = "Chưa thanh toán";
                break;
            case 1:
                 tt = "Đã thanh toán";
                break;
            case -1:
                 tt = "Hủy / Hoàn đơn";
                break;       
            default:
                throw new AssertionError();
        }
    Object[] row = {hd.getMahd(),tenkh,hd.getThoigian(),tt};
    model.addRow(row);
    
   
    }
   
    }
private void resetTableNV(){
     DefaultTableModel model = (DefaultTableModel)tb_Nhanvien.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<NhanVien> listnv = new DAO.DAO_NhanVien().getListNV();
        for (NhanVien nv : listnv) {
           
        String cv = new DAO.DAO_NhanVien().getChucvu(nv.macv);
        Object[] row = {nv.getTennv(),nv.getDiachi(),nv.getSdt(),cv};
        model.addRow(row);
        }
    }
private void setPanel(){
            tt_TC =false;
            tt_QLSP=false;
            tt_QLKH=false;
            tt_QLNV=false;
            tt_QLDM=false;
            tt_QLHD=false;
            tt_DMK=false;
            tt_them_SP=false;
            tt_Sua_SP = false;
            tt_them_KH=false;
            tt_Sua_KH = false;
            tt_them_HD=false;
          
            tt_them_NV=false;
            tt_Sua_NV = false;
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
  private boolean tt_ThemDH_ThemKH=false;
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
      private void QLNV_on_txb(){
    cbb_QLNV_cv.setEnabled(true);
    txb_QLNV_manv.setEnabled(true);
    txb_QLNV_tennv.setEnabled(true);
    txb_QLNV_diachi.setEnabled(true);
    txb_QLNV_sdt.setEnabled(true);

    
    }
    private void QLNV_off_txb(){
        cbb_QLNV_cv.setEnabled(false);
    txb_QLNV_manv.setEnabled(false);
    txb_QLNV_tennv.setEnabled(false);
    txb_QLNV_diachi.setEnabled(false);
    txb_QLNV_sdt.setEnabled(false);
    txb_QLNV_ngayvao.setEnabled(false);
    }
    private void clear_txb_QLNV(){
    txb_QLNV_manv.setText("");
    txb_QLNV_tennv.setText("");
    txb_QLNV_diachi.setText("");
    txb_QLNV_sdt.setText("");
    txb_QLNV_ngayvao.setText("");
       
    }
     private void QLKH_on_txb(){
            
    txb_QLKH_makh.setEnabled(true);
    txb_QLKH_tenkh.setEnabled(true);
    txb_QLKH_diachi.setEnabled(true);
    txb_QLKH_sdt.setEnabled(true);
    
    }
    private void QLKH_off_txb(){
    txb_QLKH_makh.setEnabled(false);
    txb_QLKH_tenkh.setEnabled(false);
    txb_QLKH_diachi.setEnabled(false);
    txb_QLKH_sdt.setEnabled(false);
    txb_QLKH_loai.setEnabled(false);
    }
    private void clear_txb_QLKH(){
    txb_QLKH_makh.setText("");
    txb_QLKH_tenkh.setText("");
    txb_QLKH_diachi.setText("");
    txb_QLKH_sdt.setText("");
    txb_QLKH_loai.setText("");
    txb_QLKH_sodonmua.setText("");
    txb_QLKH_sodonhuy.setText("");
    txb_QLKH_sodonchuatt.setText("");
    }
    
    
    private void QLHD_off_txb(){
    
    txb_QLHD_mahd.setEnabled(false);
    txb_QLHD_mahd.setEnabled(false);
    txb_QLHD_sdt.setEnabled(false);
    txb_QLHD_tennv.setEnabled(false);
   
    txb_QLHD_trangthai.setEnabled(false);
    tb_TTDonHang.setEnabled(false);
    }
       private void clear_txb_QLHD(){
    txb_QLHD_mahd.setText("");
    txb_QLHD_mahd.setText("");
    txb_QLHD_sdt.setText("");
    txb_QLHD_tennv.setText("");
    
    txb_QLHD_trangthai.setText(""); 
    
    }
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
        bt_QL_SanPham = new javax.swing.JLabel();
        bt_QL_NhanVien = new javax.swing.JLabel();
        lblTenNguoiDung = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bt_ChangePassword = new javax.swing.JLabel();
        bt_Logout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tb_Trangchu = new javax.swing.JTabbedPane();
        DoiMK = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
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
        txb_QLKH_tkkh = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txb_QLKH_loai = new javax.swing.JTextField();
        txb_QLKH_makh = new javax.swing.JTextField();
        txb_QLKH_sodonhuy = new javax.swing.JTextField();
        txb_QLKH_tenkh = new javax.swing.JTextField();
        txb_QLKH_sodonmua = new javax.swing.JTextField();
        txb_QLKH_sdt = new javax.swing.JTextField();
        bt_Them_KH = new javax.swing.JButton();
        bt_Sua_KH = new javax.swing.JButton();
        txb_QLKH_diachi = new javax.swing.JTextField();
        bt_TimKiemKH = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        txb_QLKH_sodonchuatt = new javax.swing.JTextField();
        bt_QLKH_reset = new javax.swing.JButton();
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
        QL_NhanVien = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_Nhanvien = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txb_QLNV_tknv = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txb_QLNV_diachi = new javax.swing.JTextField();
        txb_QLNV_manv = new javax.swing.JTextField();
        txb_QLNV_tennv = new javax.swing.JTextField();
        txb_QLNV_ngayvao = new javax.swing.JTextField();
        bt_Them_NV = new javax.swing.JButton();
        bt_Sua_NV = new javax.swing.JButton();
        bt_Xoa_NV = new javax.swing.JButton();
        bt_tknv = new javax.swing.JButton();
        cbb_QLNV_cv = new javax.swing.JComboBox<>();
        bt_QLNV_reset = new javax.swing.JButton();
        txb_QLNV_sdt = new javax.swing.JTextField();
        QL_HoaDon = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_QLHoaDon = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txb_QLHD_tkhd = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txb_QLHD_tenkh = new javax.swing.JTextField();
        txb_QLHD_mahd = new javax.swing.JTextField();
        txb_QLHD_trangthai = new javax.swing.JTextField();
        txb_QLHD_tennv = new javax.swing.JTextField();
        txb_QLHD_sdt = new javax.swing.JTextField();
        bt_Them_HD = new javax.swing.JButton();
        bt_Sua_KH1 = new javax.swing.JButton();
        bt_TimKiemHD = new javax.swing.JButton();
        bt_QLHD_reset = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_TTDonHang = new javax.swing.JTable();
        ThemHoaDon = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txb_ThemDH_tksp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ThemHD_SP = new javax.swing.JTable();
        cbb_ThemDH_TH = new javax.swing.JComboBox<>();
        cbb_ThemDH_DM = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txb_ThemDH_Tensp = new javax.swing.JTextField();
        spn_soluong = new javax.swing.JSpinner();
        jLabel63 = new javax.swing.JLabel();
        bt_ThemDH_ThemSP = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txb_ThemDH_diachi = new javax.swing.JTextField();
        txb_ThemDH_tenkh = new javax.swing.JTextField();
        bt_ThemDH_ThemKH = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        txb_ThemDH_tksp3 = new javax.swing.JTextField();
        cbb_ThemDH_KH = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txb_ThemDH_sdt = new javax.swing.JTextField();
        bt_ThemDH_XacNhanKH = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_ThemDH_ttDonHang = new javax.swing.JTable();
        bt_Them_KH1 = new javax.swing.JButton();
        bt_QuayLai = new javax.swing.JButton();

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
        tb_QLKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_QLKhachHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_QLKhachHang);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Mã khách hàng :");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Tìm Kiếm :");

        txb_QLKH_tkkh.setText("Nhập tên hoặc số điện thoại...");
        txb_QLKH_tkkh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txb_QLKH_tkkhFocusGained(evt);
            }
        });
        txb_QLKH_tkkh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txb_QLKH_tkkhKeyTyped(evt);
            }
        });

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

        txb_QLKH_loai.setEnabled(false);

        txb_QLKH_makh.setEnabled(false);

        txb_QLKH_sodonhuy.setEnabled(false);

        txb_QLKH_tenkh.setEnabled(false);

        txb_QLKH_sodonmua.setEnabled(false);
        txb_QLKH_sodonmua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txb_QLKH_sodonmuaActionPerformed(evt);
            }
        });

        txb_QLKH_sdt.setEnabled(false);

        bt_Them_KH.setBackground(new java.awt.Color(73, 255, 0));
        bt_Them_KH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Them_KH.setForeground(new java.awt.Color(255, 255, 255));
        bt_Them_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/them.png"))); // NOI18N
        bt_Them_KH.setText("Mới");
        bt_Them_KH.setToolTipText("");
        bt_Them_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Them_KHMouseClicked(evt);
            }
        });

        bt_Sua_KH.setBackground(new java.awt.Color(255, 228, 0));
        bt_Sua_KH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Sua_KH.setForeground(new java.awt.Color(255, 255, 255));
        bt_Sua_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/sua.png"))); // NOI18N
        bt_Sua_KH.setText("Sửa");
        bt_Sua_KH.setToolTipText("");
        bt_Sua_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Sua_KHMouseClicked(evt);
            }
        });

        txb_QLKH_diachi.setEnabled(false);
        txb_QLKH_diachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txb_QLKH_diachiActionPerformed(evt);
            }
        });

        bt_TimKiemKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_TimKiemKH.setText("Tìm Kiếm");
        bt_TimKiemKH.setEnabled(false);
        bt_TimKiemKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_TimKiemKHMouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Số đơn chưa thanh toán :");

        txb_QLKH_sodonchuatt.setEnabled(false);

        bt_QLKH_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_QLKH_reset.setText("Reset");
        bt_QLKH_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QLKH_resetMouseClicked(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QL_KhachHangLayout.createSequentialGroup()
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QL_KhachHangLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txb_QLKH_tkkh, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_TimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(QL_KhachHangLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bt_Sua_KH)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QL_KhachHangLayout.createSequentialGroup()
                                    .addGap(540, 540, 540)
                                    .addComponent(txb_QLKH_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(txb_QLKH_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_Them_KH)
                                    .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                            .addComponent(txb_QLKH_sodonhuy, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(75, 75, 75)
                                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txb_QLKH_sodonmua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(38, 38, 38)
                                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(45, 45, 45)
                                            .addComponent(txb_QLKH_sodonchuatt))
                                        .addComponent(txb_QLKH_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(QL_KhachHangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QL_KhachHangLayout.createSequentialGroup()
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(txb_QLKH_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(496, 496, 496))
                                .addGroup(QL_KhachHangLayout.createSequentialGroup()
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txb_QLKH_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(419, 419, 419)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QL_KhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(747, 747, 747)))))
                .addGap(59, 59, 59)
                .addComponent(bt_QLKH_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        QL_KhachHangLayout.setVerticalGroup(
            QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_KhachHangLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txb_QLKH_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txb_QLKH_makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLKH_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLKH_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLKH_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLKH_sodonmua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLKH_sodonhuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLKH_sodonchuatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Them_KH)
                    .addComponent(bt_Sua_KH))
                .addGap(66, 66, 66)
                .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QL_KhachHangLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(QL_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txb_QLKH_tkkh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_TimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_QLKH_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        bt_Xoa_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Xoa_SPMouseClicked(evt);
            }
        });

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
            .addGroup(QL_SanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        QL_NhanVien.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(90, 178, 255));
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));

        jLabel18.setBackground(new java.awt.Color(153, 102, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Quản lý nhân viên");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        tb_Nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_Nhanvien.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tb_Nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_NhanvienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_Nhanvien);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Mã nhân viên :");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Tìm Kiếm :");

        txb_QLNV_tknv.setText("Nhập tên nhân viên...");
        txb_QLNV_tknv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txb_QLNV_tknvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txb_QLNV_tknvFocusLost(evt);
            }
        });
        txb_QLNV_tknv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txb_QLNV_tknvKeyTyped(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setText("Tên nhân viên :");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setText(" Số điện thoại :");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setText("Ngày vào làm :");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setText("Chức vụ :");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setText("Địa chỉ :");

        txb_QLNV_diachi.setEnabled(false);

        txb_QLNV_manv.setEnabled(false);

        txb_QLNV_tennv.setEnabled(false);

        txb_QLNV_ngayvao.setEnabled(false);

        bt_Them_NV.setBackground(new java.awt.Color(73, 255, 0));
        bt_Them_NV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Them_NV.setForeground(new java.awt.Color(255, 255, 255));
        bt_Them_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/them.png"))); // NOI18N
        bt_Them_NV.setText("Mới");
        bt_Them_NV.setToolTipText("");
        bt_Them_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Them_NVMouseClicked(evt);
            }
        });

        bt_Sua_NV.setBackground(new java.awt.Color(255, 228, 0));
        bt_Sua_NV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Sua_NV.setForeground(new java.awt.Color(255, 255, 255));
        bt_Sua_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/sua.png"))); // NOI18N
        bt_Sua_NV.setText("Sửa");
        bt_Sua_NV.setToolTipText("");
        bt_Sua_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Sua_NVMouseClicked(evt);
            }
        });

        bt_Xoa_NV.setBackground(new java.awt.Color(255, 0, 0));
        bt_Xoa_NV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Xoa_NV.setForeground(new java.awt.Color(255, 255, 255));
        bt_Xoa_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/xoa.png"))); // NOI18N
        bt_Xoa_NV.setText("Xóa");
        bt_Xoa_NV.setToolTipText("");
        bt_Xoa_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Xoa_NVMouseClicked(evt);
            }
        });

        bt_tknv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_tknv.setText("Tìm Kiếm");
        bt_tknv.setEnabled(false);
        bt_tknv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_tknvMouseClicked(evt);
            }
        });

        cbb_QLNV_cv.setEnabled(false);

        bt_QLNV_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_QLNV_reset.setText("Reset");
        bt_QLNV_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QLNV_resetMouseClicked(evt);
            }
        });

        txb_QLNV_sdt.setEnabled(false);

        javax.swing.GroupLayout QL_NhanVienLayout = new javax.swing.GroupLayout(QL_NhanVien);
        QL_NhanVien.setLayout(QL_NhanVienLayout);
        QL_NhanVienLayout.setHorizontalGroup(
            QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(QL_NhanVienLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(QL_NhanVienLayout.createSequentialGroup()
                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txb_QLNV_tknv, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_tknv, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QL_NhanVienLayout.createSequentialGroup()
                                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txb_QLNV_ngayvao, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                                        .addComponent(bt_Them_NV)
                                        .addGap(227, 227, 227)
                                        .addComponent(bt_Sua_NV)
                                        .addGap(239, 239, 239)
                                        .addComponent(bt_Xoa_NV)))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QL_NhanVienLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txb_QLNV_diachi))
                                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txb_QLNV_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txb_QLNV_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbb_QLNV_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(139, 139, 139)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txb_QLNV_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(130, 130, 130)
                .addComponent(bt_QLNV_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        QL_NhanVienLayout.setVerticalGroup(
            QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_NhanVienLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txb_QLNV_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLNV_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbb_QLNV_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txb_QLNV_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txb_QLNV_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txb_QLNV_ngayvao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Them_NV)
                    .addComponent(bt_Sua_NV)
                    .addComponent(bt_Xoa_NV))
                .addGap(21, 21, 21)
                .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QL_NhanVienLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QL_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bt_tknv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_QLNV_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txb_QLNV_tknv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tb_Trangchu.addTab("tab6", QL_NhanVien);

        QL_HoaDon.setBackground(new java.awt.Color(255, 255, 255));
        QL_HoaDon.setEnabled(false);

        jPanel17.setBackground(new java.awt.Color(90, 178, 255));
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setBackground(new java.awt.Color(153, 102, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Quản Lý Hóa Đơn");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        tb_QLHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_QLHoaDon.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tb_QLHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_QLHoaDonMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_QLHoaDon);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Mã hóa đơn :");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setText("Tìm Kiếm :");

        txb_QLHD_tkhd.setText("Nhập mã hóa đơn hoặc tên khách hàng...");
        txb_QLHD_tkhd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txb_QLHD_tkhdFocusGained(evt);
            }
        });
        txb_QLHD_tkhd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txb_QLHD_tkhdKeyTyped(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Tên khách hàng :");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText("Số điện thoại :");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("Trạng thái :");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel53.setText("Tên Nhân Viên :");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setText("Thông tin sản phẩm :");

        txb_QLHD_tenkh.setEnabled(false);

        txb_QLHD_mahd.setEnabled(false);

        txb_QLHD_trangthai.setEnabled(false);

        txb_QLHD_tennv.setEnabled(false);

        txb_QLHD_sdt.setEnabled(false);

        bt_Them_HD.setBackground(new java.awt.Color(73, 255, 0));
        bt_Them_HD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Them_HD.setForeground(new java.awt.Color(255, 255, 255));
        bt_Them_HD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/them.png"))); // NOI18N
        bt_Them_HD.setText("Tạo Hóa Đơn Mới");
        bt_Them_HD.setToolTipText("");
        bt_Them_HD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Them_HDMouseClicked(evt);
            }
        });

        bt_Sua_KH1.setBackground(new java.awt.Color(255, 228, 0));
        bt_Sua_KH1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Sua_KH1.setForeground(new java.awt.Color(255, 255, 255));
        bt_Sua_KH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/sua.png"))); // NOI18N
        bt_Sua_KH1.setText("Xuất Hóa Đơn");
        bt_Sua_KH1.setToolTipText("");
        bt_Sua_KH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Sua_KH1MouseClicked(evt);
            }
        });

        bt_TimKiemHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_TimKiemHD.setText("Tìm Kiếm");
        bt_TimKiemHD.setEnabled(false);
        bt_TimKiemHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_TimKiemHDMouseClicked(evt);
            }
        });

        bt_QLHD_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_QLHD_reset.setText("Reset");
        bt_QLHD_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QLHD_resetMouseClicked(evt);
            }
        });

        tb_TTDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tb_TTDonHang);

        javax.swing.GroupLayout QL_HoaDonLayout = new javax.swing.GroupLayout(QL_HoaDon);
        QL_HoaDon.setLayout(QL_HoaDonLayout);
        QL_HoaDonLayout.setHorizontalGroup(
            QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5)
            .addGroup(QL_HoaDonLayout.createSequentialGroup()
                .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_HoaDonLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QL_HoaDonLayout.createSequentialGroup()
                                .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(QL_HoaDonLayout.createSequentialGroup()
                                        .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(QL_HoaDonLayout.createSequentialGroup()
                                                .addComponent(txb_QLHD_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(QL_HoaDonLayout.createSequentialGroup()
                                                .addComponent(txb_QLHD_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(83, 83, 83)
                                        .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txb_QLHD_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txb_QLHD_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane7))
                                .addGap(86, 86, 86))
                            .addGroup(QL_HoaDonLayout.createSequentialGroup()
                                .addComponent(txb_QLHD_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 663, Short.MAX_VALUE))))
                    .addGroup(QL_HoaDonLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txb_QLHD_tkhd, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_TimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(bt_QLHD_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QL_HoaDonLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(bt_Them_HD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_Sua_KH1)
                .addGap(245, 245, 245))
        );
        QL_HoaDonLayout.setVerticalGroup(
            QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_HoaDonLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txb_QLHD_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txb_QLHD_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLHD_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLHD_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txb_QLHD_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Sua_KH1)
                    .addComponent(bt_Them_HD))
                .addGap(43, 43, 43)
                .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QL_HoaDonLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(QL_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txb_QLHD_tkhd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_TimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_QLHD_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tb_Trangchu.addTab("tab6", QL_HoaDon);

        ThemHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        ThemHoaDon.setEnabled(false);

        jPanel18.setBackground(new java.awt.Color(90, 178, 255));
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setBackground(new java.awt.Color(153, 102, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Thêm Đơn Hàng");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thông Tin Sản Phẩm");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tìm Kiếm :");

        txb_ThemDH_tksp.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txb_ThemDH_tksp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txb_ThemDH_tkspKeyTyped(evt);
            }
        });

        tb_ThemHD_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_ThemHD_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ThemHD_SPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ThemHD_SP);

        cbb_ThemDH_TH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_ThemDH_THItemStateChanged(evt);
            }
        });

        cbb_ThemDH_DM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_ThemDH_DMItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Thương Hiệu :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Danh Mục :");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel62.setText("Số Lượng :");

        txb_ThemDH_Tensp.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        spn_soluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spn_soluongKeyTyped(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel63.setText("Tên Sản Phẩm :");

        bt_ThemDH_ThemSP.setBackground(new java.awt.Color(73, 255, 0));
        bt_ThemDH_ThemSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_ThemDH_ThemSP.setForeground(new java.awt.Color(255, 255, 255));
        bt_ThemDH_ThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/them.png"))); // NOI18N
        bt_ThemDH_ThemSP.setText("Thêm Sản Phẩm");
        bt_ThemDH_ThemSP.setToolTipText("");
        bt_ThemDH_ThemSP.setEnabled(false);
        bt_ThemDH_ThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ThemDH_ThemSPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbb_ThemDH_TH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txb_ThemDH_tksp)
                                    .addComponent(cbb_ThemDH_DM, 0, 235, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 123, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txb_ThemDH_Tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ThemDH_ThemSP)
                .addGap(146, 146, 146))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txb_ThemDH_tksp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbb_ThemDH_TH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbb_ThemDH_DM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txb_ThemDH_Tensp, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_ThemDH_ThemSP)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Thông Tin Khách Hàng");
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 2, 209, 25));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel56.setText("Địa Chỉ :");
        jPanel5.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 105, 30));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("Tên Khách Hàng :");
        jPanel5.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        txb_ThemDH_diachi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txb_ThemDH_diachi.setEnabled(false);
        jPanel5.add(txb_ThemDH_diachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 220, 30));

        txb_ThemDH_tenkh.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txb_ThemDH_tenkh.setEnabled(false);
        jPanel5.add(txb_ThemDH_tenkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 220, 30));

        bt_ThemDH_ThemKH.setBackground(new java.awt.Color(73, 255, 0));
        bt_ThemDH_ThemKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_ThemDH_ThemKH.setForeground(new java.awt.Color(255, 255, 255));
        bt_ThemDH_ThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/them.png"))); // NOI18N
        bt_ThemDH_ThemKH.setText("Khách Hàng Mới");
        bt_ThemDH_ThemKH.setToolTipText("");
        bt_ThemDH_ThemKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ThemDH_ThemKHMouseClicked(evt);
            }
        });
        jPanel5.add(bt_ThemDH_ThemKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel59.setText("Tìm Kiếm :");
        jPanel5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 73, 30));

        txb_ThemDH_tksp3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jPanel5.add(txb_ThemDH_tksp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 230, 30));

        cbb_ThemDH_KH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));
        cbb_ThemDH_KH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_ThemDH_KHItemStateChanged(evt);
            }
        });
        jPanel5.add(cbb_ThemDH_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 230, 30));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel60.setText("Chọn KH :");
        jPanel5.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 80, 30));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel61.setText("Số Điện Thoại :");
        jPanel5.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 105, 30));

        txb_ThemDH_sdt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txb_ThemDH_sdt.setEnabled(false);
        jPanel5.add(txb_ThemDH_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 220, 30));

        bt_ThemDH_XacNhanKH.setBackground(new java.awt.Color(73, 255, 0));
        bt_ThemDH_XacNhanKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_ThemDH_XacNhanKH.setForeground(new java.awt.Color(255, 255, 255));
        bt_ThemDH_XacNhanKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/check.png"))); // NOI18N
        bt_ThemDH_XacNhanKH.setText("Xác Nhận");
        bt_ThemDH_XacNhanKH.setToolTipText("");
        bt_ThemDH_XacNhanKH.setEnabled(false);
        bt_ThemDH_XacNhanKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ThemDH_XacNhanKHMouseClicked(evt);
            }
        });
        jPanel5.add(bt_ThemDH_XacNhanKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 170, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Thông Tin Đơn Hàng");

        tb_ThemDH_ttDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tb_ThemDH_ttDonHang);

        bt_Them_KH1.setBackground(new java.awt.Color(73, 255, 0));
        bt_Them_KH1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_Them_KH1.setForeground(new java.awt.Color(255, 255, 255));
        bt_Them_KH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/check.png"))); // NOI18N
        bt_Them_KH1.setText("Thanh toán");
        bt_Them_KH1.setToolTipText("");
        bt_Them_KH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Them_KH1MouseClicked(evt);
            }
        });

        bt_QuayLai.setBackground(new java.awt.Color(255, 228, 0));
        bt_QuayLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_QuayLai.setForeground(new java.awt.Color(255, 255, 255));
        bt_QuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/backward_5464039 (1).png"))); // NOI18N
        bt_QuayLai.setText("Quay lại trang quản lý");
        bt_QuayLai.setToolTipText("");
        bt_QuayLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_QuayLaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(bt_QuayLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_Them_KH1)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Them_KH1)
                    .addComponent(bt_QuayLai))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout ThemHoaDonLayout = new javax.swing.GroupLayout(ThemHoaDon);
        ThemHoaDon.setLayout(ThemHoaDonLayout);
        ThemHoaDonLayout.setHorizontalGroup(
            ThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ThemHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        ThemHoaDonLayout.setVerticalGroup(
            ThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThemHoaDonLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ThemHoaDonLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tb_Trangchu.addTab("tab6", ThemHoaDon);

        getContentPane().add(tb_Trangchu, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, -38, 1230, 820));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   private void LoadNV(){
   QLSP_off_txb();
     tt_them_NV=false;
     tt_Sua_NV = false;
     bt_Them_NV.setText("Mới");
     bt_Sua_NV.setText("Sửa");
    ArrayList<ChucVu> listcv = new DAO.DAO_NhanVien().List_CV();
          ArrayList<String> list_tencv = new ArrayList<>();
   
    for (ChucVu chucvu : listcv) {
    list_tencv.add(chucvu.getTencv());
    }
    DefaultComboBoxModel cbbmd1 = new DefaultComboBoxModel<>(list_tencv.toArray(new String[1]));
    cbb_QLNV_cv.setModel(cbbmd1);
 
    DefaultTableModel model = new DefaultTableModel();
    Object[] title={"Tên Nhân Viên","Địa Chỉ","Số Điện Thoại","Chức Vụ"};
    model.setColumnIdentifiers(title);
    ArrayList<NhanVien> listNV = new DAO.DAO_NhanVien().getListNV();
    for (NhanVien nv : listNV) {
    String chucvu = new DAO.DAO_NhanVien().getChucvu(nv.getMacv());
    Object[] row = {nv.getTennv(),nv.getDiachi(),nv.getSdt(),chucvu};
    model.addRow(row);
    tb_Nhanvien.setModel(model);
   
    }
   }
    private void bt_QL_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_NhanVienMouseClicked
        if(tt_QLNV==false){
            onPanel("NV");
            int index =  tb_Trangchu.indexOfComponent(QL_NhanVien);
            tb_Trangchu.setSelectedIndex(index); 
            LoadNV();
        }
        else{}
        {
        
        }// TODO add your handling code here:
    }//GEN-LAST:event_bt_QL_NhanVienMouseClicked
    private void LoadHoaDon(){
     QLHD_off_txb();
     tt_them_HD=false;

     String tt ;
    DefaultTableModel model = new DefaultTableModel();
    Object[] title={"Mã Hóa Đơn","Tên Khách Hàng","Thời Gian","Trạng Thái"};
    model.setColumnIdentifiers(title);
    ArrayList<HoaDon> listHD = new DAO.DAO_HoaDon().List_HD();
    for (HoaDon hd : listHD) {
    String tenkh = new DAO.DAO_KhachHang().getTenKH(hd.getMakh());
        switch (hd.getTrangthai()) {
            case 0:
                tt = "Chưa thanh toán";
                break;
            case 1:
                 tt = "Đã thanh toán";
                break;
            case -1:
                 tt = "Hủy / Hoàn đơn";
                break;       
            default:
                throw new AssertionError();
        }
    Object[] row = {hd.getMahd(),tenkh,hd.getThoigian(),tt};
    model.addRow(row);
    
   
    }
    tb_QLHoaDon.setModel(model);
    }
    private void bt_QL_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QL_HoaDonMouseClicked
        if(tt_QLHD==false){
            onPanel("HD"); 
        int index =  tb_Trangchu.indexOfComponent(QL_HoaDon);
        tb_Trangchu.setSelectedIndex(index);  
        LoadHoaDon();// TODO add your handling code here:
        }
        else{}
    }//GEN-LAST:event_bt_QL_HoaDonMouseClicked
    private void LoadKH(){
    QLSP_off_txb();
    
     tt_them_KH=false;
     tt_Sua_KH = false;
     bt_Them_KH.setText("Mới");
     bt_Sua_KH.setText("Sửa");
    DefaultTableModel model = new DefaultTableModel();
    Object[] title={"Mã KH","Tên Khách Hàng","Địa chỉ","Số điện thoại","Type"};
    model.setColumnIdentifiers(title);
    ArrayList<KhachHang> listKH = new DAO.DAO_KhachHang().List_KH();
    String pl;
    for (KhachHang kh : listKH) {
    int type  = kh.getType();
    if(type==0){
        pl = "Thường";
    
    }
    else if (type == 1){
        pl = "Thân Thiết";
    }
    else{
        pl = "Danh sách đen";
    }
    Object[] row = {kh.getMakh(),kh.getTenkh(),kh.getDiachi(),kh.getSdt(),pl};
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
    
    ///////////Quan ly san pham code///////////
    private void LoadSP(){
     QLSP_off_txb();
     tt_them_SP=false;
     tt_Sua_SP = false;
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
        int sokh =  new DAO.DAO_KhachHang().Sl_KH();
        lbl_soKH.setText(sokh+"");
        int sl_sp = new DAO.DAO_SanPham().sl_spban();
        lbl_SPdaban.setText(sl_sp+"");
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
                      resetTableSP();
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
       
       resetTableSP();
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
                if(tt_Sua_SP==false){
                    QLSP_on_txb();
                    tt_Sua_SP=true;
                    bt_Sua_SP.setText("Xác nhận");
                }
                else{
                    if(txb_QLSP_giaban.getText().isEmpty() || txb_QLSP_gianiemyet.getText().isEmpty() || txb_QLSP_masp.getText().isEmpty() || txb_QLSP_tensp.getText().isEmpty() || txb_QLSP_thongso.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    else{
                    String masp = txb_QLSP_masp.getText();
                    String tensp = txb_QLSP_tensp.getText();
                    String thongso = txb_QLSP_thongso.getText();
                    int gianiemyet =Integer.parseInt( txb_QLSP_gianiemyet.getText());
                    int giaban = Integer.parseInt(txb_QLSP_giaban.getText());
                    String madm = new DAO.DAO_DM_SanPham().getMadm(cbb_QLSP_dm.getSelectedItem().toString());
                    String math = new DAO.DAO_DM_ThuongHieu().getMath(cbb_QLSP_th.getSelectedItem().toString());
                    boolean re_sua = new DAO.DAO_SanPham().UpdateSanPham(masp,tensp, math, madm, thongso, gianiemyet, giaban);
                    if(re_sua){
                    resetTableSP();
                    int option = JOptionPane.showOptionDialog(null, "Sửa sản phẩm thành công !! Tiếp tục sửa ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if(option==JOptionPane.OK_OPTION){
                    
                   }
                   else{
                   clear_txb_QLSP();
                   tt_Sua_SP = false;
                   QLSP_off_txb();
                   bt_Sua_SP.setText("Sửa");
                   }
                }
                    }
           
                }
            }
         }
    }//GEN-LAST:event_bt_Sua_SPMouseClicked

    private void txb_QLKH_diachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txb_QLKH_diachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txb_QLKH_diachiActionPerformed

    private void bt_Xoa_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Xoa_SPMouseClicked
        int selectedRow = tb_SanPham.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trước !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            
        }
        else{
            String masp= txb_QLSP_masp.getText();
            String tensp = txb_QLSP_tensp.getText();
            int option = JOptionPane.showOptionDialog(null, "Xác nhận xóa sản phẩm : "+tensp, "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){
            boolean rs = new DAO.DAO_SanPham().DeleteSanPham(masp);
            if(rs){
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_bt_Xoa_SPMouseClicked

    private void bt_Them_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Them_KHMouseClicked
        if(tt_Sua_KH){
            int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){
                tt_Sua_KH=false;
                bt_Sua_KH.setText("Sửa");
                if(tt_them_KH==false){
                    clear_txb_QLKH();
                    QLKH_on_txb();
                    bt_Them_KH.setText("Xác nhận");
                    tt_them_KH=true;
        
                    }
                
            
            }
        }
        else{
            if(tt_them_KH==false){
                    clear_txb_QLKH();
                    QLKH_on_txb();
                    bt_Them_KH.setText("Xác nhận");
                    tt_them_KH=true;
        
                    }
            else{
                if(txb_QLKH_makh.getText().isEmpty() && txb_QLKH_tenkh.getText().isEmpty() && txb_QLKH_diachi.getText().isEmpty() && txb_QLKH_sdt.getText().isEmpty())
                {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin khách hàng !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                else{
                String makh = txb_QLKH_makh.getText();
                String tenkh = txb_QLKH_tenkh.getText();
                String diachi = txb_QLKH_diachi.getText();
                String sdt = txb_QLKH_sdt.getText();
                boolean re_them = new DAO.DAO_KhachHang().insertKH(makh, tenkh, diachi, sdt);
                if(re_them){
                   int option = JOptionPane.showOptionDialog(null, "Thêm khách hàng thành công !! Tiếp tục thêm ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                   if(option==JOptionPane.OK_OPTION){
                    clear_txb_QLKH();
                   }
                   else{
                   clear_txb_QLKH();
                   tt_them_KH = false;
                   QLKH_off_txb();
                   bt_Them_KH.setText("Mới");
                   }
                }
                }
            }
            
        }
        
                    
    }//GEN-LAST:event_bt_Them_KHMouseClicked

    private void txb_QLKH_tkkhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txb_QLKH_tkkhFocusGained
        txb_QLKH_tkkh.setText("");        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_txb_QLKH_tkkhFocusGained

    private void bt_Sua_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Sua_KHMouseClicked
        int selectedRow = tb_QLKhachHang.getSelectedRow();
         if(selectedRow==-1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng trước !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            
         }
         else{
            if(tt_them_KH){
                int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(option==JOptionPane.OK_OPTION){
                    tt_them_KH=false;
                    bt_Them_KH.setText("Mới");
                    int row = tb_QLKhachHang.getSelectedRow();
                    String makh =tb_QLKhachHang.getValueAt(row, 0).toString();
                    KhachHang kh = new DAO.DAO_KhachHang().getKH(makh);
                    txb_QLKH_makh.setText(kh.makh);
                    txb_QLKH_tenkh.setText(kh.tenkh);              
                    txb_QLKH_diachi.setText(kh.diachi);
                    txb_QLKH_sdt.setText(kh.sdt);
                    int sodonmua  = new DAO.DAO_KhachHang().sodonmua(makh);
                    int sodonhuy  = new DAO.DAO_KhachHang().sodonhuy(makh);
                    int sodonchuatt  = new DAO.DAO_KhachHang().sodonchuatt(makh);
                    txb_QLKH_sodonchuatt.setText(sodonchuatt+"");
                    txb_QLKH_sodonhuy.setText(sodonhuy+"");
                    txb_QLKH_sodonmua.setText(sodonmua+"");
                    txb_QLKH_loai.setText(tb_QLKhachHang.getValueAt(row, 4).toString());
                  
                    QLKH_on_txb();
                    txb_QLKH_makh.setEnabled(false);
                    tt_Sua_KH=true;
                    bt_Sua_KH.setText("Xác nhận");
             }
            }
            else{
                if(tt_Sua_KH==false){
                    QLKH_on_txb();
                    txb_QLKH_makh.setEnabled(false);
                    tt_Sua_KH=true;
                    bt_Sua_KH.setText("Xác nhận");
                }
                else{
                    if(txb_QLKH_tenkh.getText().isEmpty() || txb_QLKH_diachi.getText().isEmpty() || txb_QLKH_sdt.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    else{
                    String makh = txb_QLKH_makh.getText();
                    String tenkh = txb_QLKH_tenkh.getText();
                    String diachi = txb_QLKH_diachi.getText();
                    String sdt = txb_QLKH_sdt.getText();
                    
                    boolean re_sua = new DAO.DAO_KhachHang().UpdateKhachHang(makh, tenkh, diachi, sdt);
                    if(re_sua){
                        int option = JOptionPane.showOptionDialog(null, "Sửa sản phẩm thành công !! Tiếp tục sửa ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                        resetTableKH();
                        if(option==JOptionPane.OK_OPTION){
                        
                        }
                        else{
                        clear_txb_QLKH();
                        tt_Sua_KH = false;
                        QLKH_off_txb();
                        bt_Sua_KH.setText("Sửa");
                            }
                    
                            }
                 else{
                   JOptionPane.showMessageDialog(this, "Lỗi!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
  
                     }    
                    }
           
                }
            }
     } 
    }//GEN-LAST:event_bt_Sua_KHMouseClicked

    private void tb_QLKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_QLKhachHangMouseClicked
         if(tt_them_KH){
            int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){
                QLKH_off_txb();
                tt_them_KH=false;
                bt_Them_KH.setText("Mới");
                 int row = tb_QLKhachHang.getSelectedRow();
                 String makh =tb_QLKhachHang.getValueAt(row, 0).toString();
                KhachHang kh = new DAO.DAO_KhachHang().getKH(makh);
                txb_QLKH_makh.setText(kh.makh);
                txb_QLKH_tenkh.setText(kh.tenkh);              
                txb_QLKH_diachi.setText(kh.diachi);
                txb_QLKH_sdt.setText(kh.sdt);
                txb_QLKH_loai.setText(tb_QLKhachHang.getValueAt(row, 4).toString());
                int sodonmua  = new DAO.DAO_KhachHang().sodonmua(makh);
                int sodonhuy  = new DAO.DAO_KhachHang().sodonhuy(makh);
                int sodonchuatt  = new DAO.DAO_KhachHang().sodonchuatt(makh);
                txb_QLKH_sodonchuatt.setText(sodonchuatt+"");
                txb_QLKH_sodonhuy.setText(sodonhuy+"");
                txb_QLKH_sodonmua.setText(sodonmua+"");
            }
        
       }
       
       else {
        int row = tb_QLKhachHang.getSelectedRow();
                 String makh =tb_QLKhachHang.getValueAt(row, 0).toString();
                KhachHang kh = new DAO.DAO_KhachHang().getKH(makh);
                txb_QLKH_makh.setText(kh.makh);
                txb_QLKH_tenkh.setText(kh.tenkh);              
                txb_QLKH_diachi.setText(kh.diachi);
                txb_QLKH_sdt.setText(kh.sdt);
                int sodonmua  = new DAO.DAO_KhachHang().sodonmua(makh);
                int sodonhuy  = new DAO.DAO_KhachHang().sodonhuy(makh);
                int sodonchuatt  = new DAO.DAO_KhachHang().sodonchuatt(makh);
                txb_QLKH_sodonchuatt.setText(sodonchuatt+"");
                txb_QLKH_sodonhuy.setText(sodonhuy+"");
                txb_QLKH_sodonmua.setText(sodonmua+"");
                txb_QLKH_loai.setText(tb_QLKhachHang.getValueAt(row, 4).toString());
       }
               // TODO add your handling code here:
    }//GEN-LAST:event_tb_QLKhachHangMouseClicked

    private void txb_QLKH_sodonmuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txb_QLKH_sodonmuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txb_QLKH_sodonmuaActionPerformed

    private void bt_TimKiemKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_TimKiemKHMouseClicked
       DefaultTableModel model = (DefaultTableModel)tb_QLKhachHang.getModel();
       model.setRowCount(0); // Xóa tất cả dữ liệu

        String khtk = txb_QLKH_tkkh.getText();
       
        ArrayList<KhachHang> listkh = new DAO.DAO_KhachHang().getKHTK(khtk);
        if(listkh.size()==0){
                        JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin khách hàng !", "Thông báo", JOptionPane.ERROR_MESSAGE);

    }
    else{
        String pl;
        for (KhachHang kh : listkh) 
        {
            int type  = kh.getType();
            if(type==0){
                    pl = "Thường";
    
                }
            else if (type == 1){
                pl = "Thân Thiết";
            }
            else{
            pl = "Danh sách đen";
        }
        Object[] row = {kh.getMakh(),kh.getTenkh(),kh.getDiachi(),kh.getSdt(),pl};
        model.addRow(row);
            }
        }
    }//GEN-LAST:event_bt_TimKiemKHMouseClicked

    private void txb_QLKH_tkkhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txb_QLKH_tkkhKeyTyped
        if(!txb_QLKH_tkkh.getText().isEmpty()){
        bt_TimKiemKH.setEnabled(true);
        }
    }//GEN-LAST:event_txb_QLKH_tkkhKeyTyped

    private void tb_NhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_NhanvienMouseClicked
        if(tt_them_NV){
            int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){
                QLNV_off_txb();
                tt_them_NV=false;
                bt_Them_NV.setText("Mới");
                 int row = tb_Nhanvien.getSelectedRow();
                 String ten =tb_Nhanvien.getValueAt(row, 0).toString();
                NhanVien nv = new DAO.DAO_NhanVien().getnv(ten);
                txb_QLNV_manv.setText(nv.manv);
                txb_QLNV_tennv.setText(nv.tennv);
                cbb_QLNV_cv.setSelectedItem(nv.diachi);
                txb_QLNV_diachi.setText(nv.diachi);
                txb_QLNV_sdt.setText(nv.sdt);
                txb_QLNV_ngayvao.setText(nv.ngayvao);
            }
        
       }
       
       else {
       int row = tb_Nhanvien.getSelectedRow();
                 String ten =tb_Nhanvien.getValueAt(row, 0).toString();
                NhanVien nv = new DAO.DAO_NhanVien().getnv(ten);
                txb_QLNV_manv.setText(nv.manv);
                txb_QLNV_tennv.setText(nv.tennv);
                cbb_QLNV_cv.setSelectedItem(nv.diachi);
                txb_QLNV_diachi.setText(nv.diachi);
                txb_QLNV_sdt.setText(nv.sdt);
                txb_QLNV_ngayvao.setText(nv.ngayvao);
       }
       
    }//GEN-LAST:event_tb_NhanvienMouseClicked

    private void txb_QLNV_tknvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txb_QLNV_tknvFocusGained
        txb_QLNV_tknv.setText("");
    }//GEN-LAST:event_txb_QLNV_tknvFocusGained

    private void txb_QLNV_tknvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txb_QLNV_tknvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txb_QLNV_tknvFocusLost

    private void txb_QLNV_tknvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txb_QLNV_tknvKeyTyped
        if(!txb_QLNV_tknv.getText().isEmpty()){
        bt_tknv.setEnabled(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txb_QLNV_tknvKeyTyped

    private void bt_Them_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Them_NVMouseClicked
    if(tt_Sua_NV){
            int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){
                tt_Sua_NV=false;
                bt_Sua_NV.setText("Sửa");
                if(tt_them_NV==false){
                    clear_txb_QLNV();
                    QLNV_on_txb();
                    bt_Them_NV.setText("Xác nhận");
                    tt_them_NV=true;
        
                    }
                
            
            }
        }
        else{
            if(tt_them_NV==false){
                    clear_txb_QLNV();
                    QLNV_on_txb();
                    bt_Them_NV.setText("Xác nhận");
                    tt_them_NV=true;
        
                    }
            else{
                if(txb_QLNV_manv.getText().isEmpty() && txb_QLNV_tennv.getText().isEmpty() && txb_QLNV_diachi.getText().isEmpty() && txb_QLNV_sdt.getText().isEmpty())
                {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin khách hàng !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                else{
                String manv = txb_QLNV_manv.getText();
                String tennv = txb_QLNV_tennv.getText();
                String diachi = txb_QLNV_diachi.getText();
                String sdt = txb_QLNV_sdt.getText();
                String macv = new DAO.DAO_NhanVien().getMaChucvu(cbb_QLNV_cv.getSelectedItem().toString());
                boolean re_them = new DAO.DAO_NhanVien().insertNV(manv, tennv, diachi, sdt, macv);
                if(re_them){
                    resetTableNV();
                   int option = JOptionPane.showOptionDialog(null, "Thêm nhân viên thành công !! Tiếp tục thêm ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                   
                   if(option==JOptionPane.OK_OPTION){
                    clear_txb_QLNV();
                   }
                   else{
                   clear_txb_QLNV();
                   tt_them_NV = false;
                   QLNV_off_txb();
                   bt_Them_NV.setText("Mới");
                   }
                }
                }
            }
            
        }
        
                    
    }//GEN-LAST:event_bt_Them_NVMouseClicked

    private void bt_Sua_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Sua_NVMouseClicked
        int selectedRow = tb_Nhanvien.getSelectedRow();
         if(selectedRow==-1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên trước !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            
         }
         else{
            if(tt_them_NV){
                int option = JOptionPane.showOptionDialog(null, "Thoát tác vụ hiện tại", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(option==JOptionPane.OK_OPTION){
                    tt_them_NV=false;
                    bt_Them_NV.setText("Mới");
                    int row = tb_Nhanvien.getSelectedRow();
                    
                    String ten =tb_Nhanvien.getValueAt(row, 0).toString();
                    NhanVien nv = new DAO.DAO_NhanVien().getnv(ten);
                    txb_QLNV_manv.setText(nv.manv);
                    txb_QLNV_tennv.setText(nv.tennv);
                    cbb_QLNV_cv.setSelectedItem(nv.diachi);
                    txb_QLNV_diachi.setText(nv.diachi);
                    txb_QLNV_sdt.setText(nv.sdt);
                    txb_QLNV_ngayvao.setText(nv.ngayvao);
                  
                    QLNV_on_txb();
                    txb_QLNV_manv.setEnabled(false);
                   
                    tt_Sua_NV=true;
                    bt_Sua_NV.setText("Xác nhận");
             }
            }
            else{
                if(tt_Sua_NV==false){
                    QLNV_on_txb();
                    txb_QLNV_manv.setEnabled(false);
                    tt_Sua_NV=true;
                    bt_Sua_NV.setText("Xác nhận");
                }
                else{
                    if(txb_QLNV_tennv.getText().isEmpty() || txb_QLNV_diachi.getText().isEmpty() || txb_QLNV_sdt.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    else{
                    String manv = txb_QLNV_manv.getText();
                    String tennv = txb_QLNV_tennv.getText();
                    String diachi = txb_QLNV_diachi.getText();
                    String sdt = txb_QLNV_sdt.getText();
                    String macv = new DAO.DAO_NhanVien().getMaChucvu(cbb_QLNV_cv.getSelectedItem().toString());
                    boolean re_sua = new DAO.DAO_NhanVien().UpdateNhanVien(manv, tennv, diachi, sdt, macv);
                    if(re_sua){
                        resetTableNV();
                        int option = JOptionPane.showOptionDialog(null, "Sửa sản phẩm thành công !! Tiếp tục sửa ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                        resetTableKH();
                        if(option==JOptionPane.OK_OPTION){
                        
                        }
                        else{
                        clear_txb_QLNV();
                        tt_Sua_KH = false;
                        QLNV_off_txb();
                        bt_Sua_KH.setText("Sửa");
                            }
                    
                            }
                 else{
                   JOptionPane.showMessageDialog(this, "Lỗi!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
  
                     }    
                    }
           
                }
            }
     } 
    }//GEN-LAST:event_bt_Sua_NVMouseClicked

    private void bt_Xoa_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Xoa_NVMouseClicked
      int selectedRow = tb_Nhanvien.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên trước !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            
        }
        else{
            String manv= txb_QLNV_manv.getText();
            String tennv = txb_QLNV_tennv.getText();
            int option = JOptionPane.showOptionDialog(null, "Xác nhận xóa nhân viên : "+tennv, "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){
            boolean rs = new DAO.DAO_NhanVien().DeleteNhanvien(manv);
            if(rs){
                resetTableNV();
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            
            }
        }
        }
    }//GEN-LAST:event_bt_Xoa_NVMouseClicked

    private void bt_tknvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_tknvMouseClicked
        DefaultTableModel model = (DefaultTableModel)tb_Nhanvien.getModel();
       model.setRowCount(0); // Xóa tất cả dữ liệu

        String nvtk = txb_QLNV_tknv.getText();
       
        ArrayList<NhanVien> listnv = new DAO.DAO_NhanVien().getNVTK(nvtk);
        if(listnv.size()==0){
                        JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin nhân viên !", "Thông báo", JOptionPane.ERROR_MESSAGE);

    }
    else{
   
        for (NhanVien nv : listnv) 
        {
        
        String cv = new DAO.DAO_NhanVien().getChucvu(nv.macv);
        Object[] row = {nv.getTennv(),nv.getDiachi(),nv.getSdt(),cv};
        model.addRow(row);
            }
        }
    }//GEN-LAST:event_bt_tknvMouseClicked

    private void bt_QLNV_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QLNV_resetMouseClicked
       resetTableNV();
    }//GEN-LAST:event_bt_QLNV_resetMouseClicked

    private void bt_QLKH_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QLKH_resetMouseClicked
              resetTableKH();
    }//GEN-LAST:event_bt_QLKH_resetMouseClicked

    private void tb_QLHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_QLHoaDonMouseClicked
        int row = tb_QLHoaDon.getSelectedRow();
                String mahd =tb_QLHoaDon.getValueAt(row, 0).toString();
                HoaDon hd = new DAO.DAO_HoaDon().getHD(mahd);
                txb_QLHD_mahd.setText(mahd);
                KhachHang kh = new DAO.DAO_KhachHang().getKH(hd.makh);
                txb_QLHD_tenkh.setText(kh.tenkh);              
                txb_QLHD_sdt.setText(kh.sdt);
                txb_QLHD_tennv.setText(new DAO.DAO_NhanVien().getTenNV(hd.manv));
                 DefaultTableModel model = new DefaultTableModel();
                Object[] title={"Tên Sản Phẩm","Số Lượng","Thành Tiền"};
                model.setColumnIdentifiers(title);
                ArrayList<DonHang> listdh = new DAO.DAO_HoaDon().get_TTHD(mahd);
                for (DonHang dh : listdh) {
                String tensp = new DAO.DAO_SanPham().get_Tensp(dh.masp);
                String sl =dh.sl+"";
                String thanhtien =dh.thanhtien+"";
                Object[] rowtb = {tensp,sl,thanhtien};
                model.addRow(rowtb);
                tb_TTDonHang.setModel(model);
                }
                int tongtien = new DAO.DAO_HoaDon().getTongtien(mahd);
                Object[] rowtb_tongtien ={"Tổng tiền :",tongtien};
                model.addRow(rowtb_tongtien);
                txb_QLHD_trangthai.setText(tb_QLHoaDon.getValueAt(row, 3).toString());
               
                
    }//GEN-LAST:event_tb_QLHoaDonMouseClicked

    private void txb_QLHD_tkhdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txb_QLHD_tkhdFocusGained
        txb_QLHD_tkhd.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txb_QLHD_tkhdFocusGained

    private void txb_QLHD_tkhdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txb_QLHD_tkhdKeyTyped
        if(!txb_QLHD_tkhd.getText().isEmpty()){
        bt_TimKiemHD.setEnabled(true);
        }
    }//GEN-LAST:event_txb_QLHD_tkhdKeyTyped
    private void LoadThemHD(){
     ArrayList<DM_SanPham> listdm = new DAO.DAO_DM_SanPham().List_DM();
          ArrayList<String> list_tendm = new ArrayList<>();
   
    for (DM_SanPham danhMuc : listdm) {
    list_tendm.add(danhMuc.getTendm());
    }
    DefaultComboBoxModel cbbmd1 = new DefaultComboBoxModel<>(list_tendm.toArray(new String[1]));
    cbb_ThemDH_DM.setModel(cbbmd1);
    ArrayList<DM_ThuongHieu> listth = new DAO.DAO_DM_ThuongHieu().List_TH();
          ArrayList<String> list_tenth = new ArrayList<>();
        
    for (DM_ThuongHieu thuonghieu : listth) {
    list_tenth.add(thuonghieu.getTenth());
    }
    
     DefaultComboBoxModel cbbmd3 = new DefaultComboBoxModel<>(list_tenth.toArray(new String[1]));
    cbb_ThemDH_TH.setModel(cbbmd3);
   
    
    DefaultTableModel model = new DefaultTableModel();
    Object[] title={"Tên Sản Phẩm","Giá Bán"};
    model.setColumnIdentifiers(title);
    ArrayList<SanPham> listSP = new DAO.DAO_SanPham().getListSP();
    for (SanPham sp : listSP) {
   
        Object[] row = {sp.getTensp(),sp.getGiaban()};
        model.addRow(row);
        tb_ThemHD_SP.setModel(model);
                               }
    }
    
    private void CancelThemHoaDon(String mahd){
    
    
    }
    private String mahd_action;
    private void bt_Them_HDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Them_HDMouseClicked
        
            clear_txb_QLHD();
            int index =  tb_Trangchu.indexOfComponent(ThemHoaDon);
            tb_Trangchu.setSelectedIndex(index); 
            Load_tbSanPhamThem();
         
    }//GEN-LAST:event_bt_Them_HDMouseClicked

    private void bt_Sua_KH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Sua_KH1MouseClicked
        int selectedRow = tb_QLHoaDon.getSelectedRow();
            if(selectedRow==-1){
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            
         }
         else{
        String mahd = txb_QLHD_mahd.getText();
        new DAO.PrintExcelFile().XuatHoaDon(mahd);
            }       // TODO add your handling code here:
    }//GEN-LAST:event_bt_Sua_KH1MouseClicked

    private void bt_TimKiemHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_TimKiemHDMouseClicked
        DefaultTableModel model = (DefaultTableModel)tb_QLHoaDon.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        
        String hdtk = txb_QLHD_tkhd.getText();
        
        ArrayList<HoaDon> listhd = new DAO.DAO_HoaDon().Get_HDTK(hdtk);
        if(listhd.size()==0){
                        JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin hóa đơn !", "Thông báo", JOptionPane.ERROR_MESSAGE);

                            }
        else{
            String tt;
            for (HoaDon hd : listhd) {
            String tenkh = new DAO.DAO_KhachHang().getTenKH(hd.getMakh());
            switch (hd.getTrangthai()) {
                case 0:
                    tt = "Chưa thanh toán";
                    break;
                case 1:
                    tt = "Đã thanh toán";
                    break;
                case -1:
                    tt = "Hủy / Hoàn đơn";
                    break;       
                default:
                    throw new AssertionError();
                                        }
            Object[] row = {hd.getMahd(),tenkh,hd.getThoigian(),tt};
            model.addRow(row);
            tb_QLHoaDon.setModel(model);
   
            }
        }
    }//GEN-LAST:event_bt_TimKiemHDMouseClicked

    private void bt_QLHD_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QLHD_resetMouseClicked
        resetTableHD();
    }//GEN-LAST:event_bt_QLHD_resetMouseClicked

    private void bt_Them_KH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Them_KH1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_Them_KH1MouseClicked

    private void bt_ThemDH_ThemKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ThemDH_ThemKHMouseClicked
        tt_ThemDH_ThemKH=true;
        txb_ThemDH_tenkh.setEnabled(true);
        txb_ThemDH_diachi.setEnabled(true);
        txb_ThemDH_sdt.setEnabled(true);
        bt_ThemDH_ThemKH.setEnabled(false);
        bt_ThemDH_XacNhanKH.setEnabled(true);
        txb_ThemDH_tenkh.setText("");
        txb_ThemDH_diachi.setText("");
        txb_ThemDH_sdt.setText("");
    }//GEN-LAST:event_bt_ThemDH_ThemKHMouseClicked

    private void bt_ThemDH_ThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ThemDH_ThemSPMouseClicked
        if(!tt_them_HD){
           JOptionPane.showMessageDialog(this, "Vui lòng cung cấp thông tin khách hàng trước !", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }
        else{
            
        }
    }//GEN-LAST:event_bt_ThemDH_ThemSPMouseClicked
    private void Load_tbSanPhamThem(){
  
        ArrayList<DM_SanPham> listdm = new DAO.DAO_DM_SanPham().List_DM();
        ArrayList<String> list_tendm = new ArrayList<>();
        for (DM_SanPham danhMuc : listdm) {
            list_tendm.add(danhMuc.getTendm());
            }
        DefaultComboBoxModel cbbmd1 = new DefaultComboBoxModel<>(list_tendm.toArray(new String[1]));
     
        cbb_ThemDH_DM.setModel(cbbmd1);
        
        ArrayList<KhachHang> listkh = new DAO.DAO_KhachHang().List_KH();
        ArrayList<String> list_tenkh = new ArrayList<>();
         for (KhachHang kh : listkh) {
            list_tenkh.add(kh.getTenkh());
            }
         
        DefaultComboBoxModel cbbmd3 = new DefaultComboBoxModel<>(list_tenkh.toArray(new String[1]));
      
        cbb_ThemDH_KH.setModel(cbbmd3);
        
        ArrayList<DM_ThuongHieu> listth = new DAO.DAO_DM_ThuongHieu().List_TH();
        ArrayList<String> list_tenth = new ArrayList<>();
        
        for (DM_ThuongHieu thuonghieu : listth) {
        list_tenth.add(thuonghieu.getTenth());
            }
        DefaultComboBoxModel cbbmd2 = new DefaultComboBoxModel<>(list_tenth.toArray(new String[1]));
        cbb_ThemDH_TH.setModel(cbbmd2);
    
        DefaultTableModel model = new DefaultTableModel();
        Object[] title={"Tên Sản Phẩm","Giá Bán"};
        model.setColumnIdentifiers(title);
        ArrayList<SanPham> listSP = new DAO.DAO_SanPham().getListSP();
        for (SanPham sp : listSP) {
            Object[] row = {sp.getTensp(),sp.getGiaban()};
            model.addRow(row);
            }
        tb_ThemHD_SP.setModel(model);
    }
    private void bt_QuayLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_QuayLaiMouseClicked
        if(tt_them_HD){
         int option = JOptionPane.showOptionDialog(null, "Thoát chế độ tạo hóa đơn !!! ", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option==JOptionPane.OK_OPTION){ 
                CancelThemHoaDon(mahd_action);
                int index =  tb_Trangchu.indexOfComponent(QL_HoaDon);
                tb_Trangchu.setSelectedIndex(index); 
                
            }
        
        }
        else{
        int index =  tb_Trangchu.indexOfComponent(QL_HoaDon);
                tb_Trangchu.setSelectedIndex(index); 
        }
    }//GEN-LAST:event_bt_QuayLaiMouseClicked

    private void tb_ThemHD_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ThemHD_SPMouseClicked
        int row = tb_ThemHD_SP.getSelectedRow();
        txb_ThemDH_Tensp.setText(tb_ThemHD_SP.getValueAt(row, 0).toString())   ;     // TODO add your handling code here:
    }//GEN-LAST:event_tb_ThemHD_SPMouseClicked

    private void bt_ThemDH_XacNhanKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ThemDH_XacNhanKHMouseClicked
       if(tt_ThemDH_ThemKH){
           if(txb_ThemDH_tenkh.getText().isEmpty()||txb_ThemDH_sdt.getText().isEmpty()||txb_ThemDH_diachi.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Thông báo", JOptionPane.ERROR_MESSAGE);
           }
           else{
               
           }
       }
       else{
            tt_them_HD = true;
            String mahd = taoMaHD();
            mahd_action = mahd;
            String manv = AccountLG.getManv();
            String makh = new DAO.DAO_KhachHang().getMaKH(txb_ThemDH_tenkh.getText());
            boolean rs_them = new DAO.DAO_HoaDon().insertHD(mahd, makh, manv);
            if(rs_them){
                bt_ThemDH_XacNhanKH.setEnabled(false);
                bt_ThemDH_ThemKH.setEnabled(false);
                DefaultTableModel model = new DefaultTableModel();
                Object[] title={"Tên Sản Phẩm","Giá Bán","Số Lượng","Thành Tiền"};
                model.setColumnIdentifiers(title);
                tb_ThemDH_ttDonHang.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình tạo đơn hàng !", "Thông báo", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_bt_ThemDH_XacNhanKHMouseClicked

    private void cbb_ThemDH_THItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_ThemDH_THItemStateChanged
       String th = cbb_ThemDH_TH.getSelectedItem().toString();
        String dm = cbb_ThemDH_DM.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel)tb_ThemHD_SP.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<SanPham> listsp = new ArrayList<>();
        String math = new DAO.DAO_DM_ThuongHieu().getMath(th);
        String madm = new DAO.DAO_DM_SanPham().getMadm(dm);
        listsp = new DAO.DAO_SanPham().getSPCbb(madm, math);
        for (SanPham sp : listsp) {
            Object[] row = {sp.getTensp(),sp.getGiaban()};
            model.addRow(row);
            }
    }//GEN-LAST:event_cbb_ThemDH_THItemStateChanged

    private void cbb_ThemDH_DMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_ThemDH_DMItemStateChanged
       String th = cbb_ThemDH_TH.getSelectedItem().toString();
        String dm = cbb_ThemDH_DM.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel)tb_ThemHD_SP.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<SanPham> listsp = new ArrayList<>();
        String math = new DAO.DAO_DM_ThuongHieu().getMath(th);
        String madm = new DAO.DAO_DM_SanPham().getMadm(dm);
        listsp = new DAO.DAO_SanPham().getSPCbb(madm, math);
        for (SanPham sp : listsp) {
            Object[] row = {sp.getTensp(),sp.getGiaban()};
            model.addRow(row);
            }
    }//GEN-LAST:event_cbb_ThemDH_DMItemStateChanged

    private void txb_ThemDH_tkspKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txb_ThemDH_tkspKeyTyped
      DefaultTableModel model = (DefaultTableModel)tb_ThemHD_SP.getModel();
        model.setRowCount(0); // Xóa tất cả dữ liệu
        ArrayList<SanPham> listsp = new ArrayList<>();
       String tensptk = txb_ThemDH_tksp.getText();
        listsp = new DAO.DAO_SanPham().getSPTK(tensptk);
        for (SanPham sp : listsp) {
            Object[] row = {sp.getTensp(),sp.getGiaban()};
            model.addRow(row);
            }
    }//GEN-LAST:event_txb_ThemDH_tkspKeyTyped

    private void spn_soluongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spn_soluongKeyTyped
        if((int)spn_soluong.getValue()>0){
            bt_ThemDH_ThemSP.setEnabled(true);
        }
    }//GEN-LAST:event_spn_soluongKeyTyped
    private void CancelTaoHoaDon(){
    mahd_action=null;
    
    }
    private void cbb_ThemDH_KHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_ThemDH_KHItemStateChanged
        bt_ThemDH_ThemKH.setEnabled(true);
        bt_ThemDH_XacNhanKH.setEnabled(true);
         txb_ThemDH_tenkh.setEnabled(false);
        txb_ThemDH_diachi.setEnabled(false);
        txb_ThemDH_sdt.setEnabled(false);
        KhachHang kh = new DAO.DAO_KhachHang().getKH(new DAO.DAO_KhachHang().getMaKH(cbb_ThemDH_KH.getSelectedItem().toString()));
        txb_ThemDH_tenkh.setText(kh.getTenkh());
        txb_ThemDH_sdt.setText(kh.getSdt());
        txb_ThemDH_diachi.setText(kh.getDiachi());
    }//GEN-LAST:event_cbb_ThemDH_KHItemStateChanged
    
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
    private javax.swing.JPanel QL_HoaDon;
    private javax.swing.JPanel QL_KhachHang;
    private javax.swing.JPanel QL_NhanVien;
    private javax.swing.JPanel QL_SanPham;
    private javax.swing.JPanel ThemHoaDon;
    private javax.swing.JPanel TrangChu;
    private javax.swing.JLabel bt_ChangePassword;
    private javax.swing.JLabel bt_Logout;
    private javax.swing.JButton bt_QLHD_reset;
    private javax.swing.JButton bt_QLKH_reset;
    private javax.swing.JButton bt_QLNV_reset;
    private javax.swing.JButton bt_QLSP_Reset;
    private javax.swing.JButton bt_QLSP_TK;
    private javax.swing.JLabel bt_QL_HoaDon;
    private javax.swing.JLabel bt_QL_KhachHang;
    private javax.swing.JLabel bt_QL_NhanVien;
    private javax.swing.JLabel bt_QL_SanPham;
    private javax.swing.JButton bt_QuayLai;
    private javax.swing.JButton bt_Sua_KH;
    private javax.swing.JButton bt_Sua_KH1;
    private javax.swing.JButton bt_Sua_NV;
    private javax.swing.JButton bt_Sua_SP;
    private javax.swing.JButton bt_ThemDH_ThemKH;
    private javax.swing.JButton bt_ThemDH_ThemSP;
    private javax.swing.JButton bt_ThemDH_XacNhanKH;
    private javax.swing.JButton bt_Them_HD;
    private javax.swing.JButton bt_Them_KH;
    private javax.swing.JButton bt_Them_KH1;
    private javax.swing.JButton bt_Them_NV;
    private javax.swing.JButton bt_Them_SP;
    private javax.swing.JButton bt_TimKiemHD;
    private javax.swing.JButton bt_TimKiemKH;
    private javax.swing.JLabel bt_TrangChu;
    private javax.swing.JButton bt_Xoa_NV;
    private javax.swing.JButton bt_Xoa_SP;
    private javax.swing.JButton bt_tknv;
    private javax.swing.JComboBox<String> cbb_QLNV_cv;
    private javax.swing.JComboBox<String> cbb_QLSP_dm;
    private javax.swing.JComboBox<String> cbb_QLSP_th;
    private javax.swing.JComboBox<String> cbb_QLSP_tkdm;
    private javax.swing.JComboBox<String> cbb_QLSP_tkth;
    private javax.swing.JComboBox<String> cbb_ThemDH_DM;
    private javax.swing.JComboBox<String> cbb_ThemDH_KH;
    private javax.swing.JComboBox<String> cbb_ThemDH_TH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblTenNguoiDung;
    private javax.swing.JLabel lbl_SPdaban;
    private javax.swing.JLabel lbl_soKH;
    private javax.swing.JLabel lbl_soSP;
    private javax.swing.JLabel lbl_soTH;
    private javax.swing.JSpinner spn_soluong;
    private javax.swing.JTable tb_Nhanvien;
    private javax.swing.JTable tb_QLHoaDon;
    private javax.swing.JTable tb_QLKhachHang;
    private javax.swing.JTable tb_SanPham;
    private javax.swing.JTable tb_TTDonHang;
    private javax.swing.JTable tb_ThemDH_ttDonHang;
    private javax.swing.JTable tb_ThemHD_SP;
    private javax.swing.JTabbedPane tb_Trangchu;
    private javax.swing.JTextField txb_QLHD_mahd;
    private javax.swing.JTextField txb_QLHD_sdt;
    private javax.swing.JTextField txb_QLHD_tenkh;
    private javax.swing.JTextField txb_QLHD_tennv;
    private javax.swing.JTextField txb_QLHD_tkhd;
    private javax.swing.JTextField txb_QLHD_trangthai;
    private javax.swing.JTextField txb_QLKH_diachi;
    private javax.swing.JTextField txb_QLKH_loai;
    private javax.swing.JTextField txb_QLKH_makh;
    private javax.swing.JTextField txb_QLKH_sdt;
    private javax.swing.JTextField txb_QLKH_sodonchuatt;
    private javax.swing.JTextField txb_QLKH_sodonhuy;
    private javax.swing.JTextField txb_QLKH_sodonmua;
    private javax.swing.JTextField txb_QLKH_tenkh;
    private javax.swing.JTextField txb_QLKH_tkkh;
    private javax.swing.JTextField txb_QLNV_diachi;
    private javax.swing.JTextField txb_QLNV_manv;
    private javax.swing.JTextField txb_QLNV_ngayvao;
    private javax.swing.JTextField txb_QLNV_sdt;
    private javax.swing.JTextField txb_QLNV_tennv;
    private javax.swing.JTextField txb_QLNV_tknv;
    private javax.swing.JTextField txb_QLSP_giaban;
    private javax.swing.JTextField txb_QLSP_gianiemyet;
    private javax.swing.JTextField txb_QLSP_masp;
    private javax.swing.JTextField txb_QLSP_tensp;
    private javax.swing.JTextField txb_QLSP_thongso;
    private javax.swing.JTextField txb_QL_tksp;
    private javax.swing.JTextField txb_ThemDH_Tensp;
    private javax.swing.JTextField txb_ThemDH_diachi;
    private javax.swing.JTextField txb_ThemDH_sdt;
    private javax.swing.JTextField txb_ThemDH_tenkh;
    private javax.swing.JTextField txb_ThemDH_tksp;
    private javax.swing.JTextField txb_ThemDH_tksp3;
    // End of variables declaration//GEN-END:variables
}
