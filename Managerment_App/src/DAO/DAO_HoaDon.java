/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DonHang;
import DTO.HoaDon;
import DTO.SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duoc Shin
 */
public class DAO_HoaDon {
    public int Sl_DonTC(){
      int sl=0;
        String sql = "Select COUNT(mahd) as slhd From DM_HoaDon Where trangthai = 1 ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               sl= rs.getInt("slhd");
               
              
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return sl;
    }
    public int ktraMaHD(String mahd){
        int sl =0;
        String sql = "Select COUNT(mahd) as slhd From DM_HoaDon Where mahd = '"+mahd+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               sl= rs.getInt("slhd");
               
              
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return sl;
    }
    public int Sl_DonHuy(){
        int sl=0;
        String sql = "Select COUNT(mahd) as slhd From DM_HoaDon Where trangthai = -1 ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               sl= rs.getInt("slhd");
               
              
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return sl;
    }
     public ArrayList<HoaDon> List_HD(){
    ArrayList<HoaDon> listHD = new ArrayList<>();
        String sql = "Select * From HoaDon";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String mahd = rs.getString("mahd");
              String makh= rs.getString("makh");
              String manv= rs.getString("manv");
           
              String thoigian= rs.getString("thoigian");
              int trangthai = rs.getInt("trangthai");
            
              HoaDon hd = new HoaDon(mahd, makh, manv, thoigian, trangthai);
              listHD.add(hd);
            }
        } catch (Exception e) {
        }
        return listHD;
    
    }
    public ArrayList<HoaDon> Get_HDTK(String hdtk){
    ArrayList<HoaDon> listHD = new ArrayList<>();
        String sql = "Select * From HoaDon hd JOIN KhachHang kh ON hd.makh = kh.makh Where hd.mahd = '"+hdtk+"' OR kh.tenkh = N'"+hdtk+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String mahd = rs.getString("mahd");
              String makh= rs.getString("makh");
              String manv= rs.getString("manv");
           
              String thoigian= rs.getString("thoigian");
              int trangthai = rs.getInt("trangthai");
            
              HoaDon hd = new HoaDon(mahd, makh, manv, thoigian, trangthai);
              listHD.add(hd);
            }
        } catch (Exception e) {
        }
        return listHD;
    
    }
    
     public HoaDon getHD(String mahd){
        HoaDon hd =null;
        String sql = "Select * From HoaDon Where mahd ='"+mahd+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
             
              String makh= rs.getString("makh");
              String manv= rs.getString("manv");
           
              String thoigian= rs.getString("thoigian");
              int trangthai = rs.getInt("trangthai");
            
              hd = new HoaDon(mahd, makh, manv, thoigian, trangthai);
             
            }
        } catch (Exception e) {
        }
        return hd;
    
    }
     
    public int getTongtien(String mahd){
        int tongtien=0;
        String sql = "Select Sum(sp.giaban*dh.sl) as tongtien From SanPham sp Join DonHang dh ON dh.masp=sp.masp Join HoaDon hd On hd.mahd = dh.mahd And hd.mahd ='"+mahd+"' ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               tongtien= rs.getInt("tongtien");
               
              
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return tongtien;
    }
    
    public ArrayList<DonHang> get_TTHD(String mahd){
    ArrayList<DonHang> listDH = new ArrayList<>();
        String sql = "Select * From DonHang Where mahd ='"+mahd+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               
                String masp = rs.getString("masp");
                int sl = rs.getInt("sl");
                SanPham sp = new DAO_SanPham().getsp(masp);
                int thanhtien = sp.giaban*sl;
                DonHang dh = new DonHang(mahd,masp,sl,thanhtien);
              listDH.add(dh);
            }
        } catch (Exception e) {
        }
        return listDH;
    
    }
      public boolean insertHD(String mahd,String makh,String manv){
        String sql = "insert into HoaDon (mahd,makh,manv,thoigian,trangthai) Values ('"+mahd+"','"+makh+"','"+manv+"',Getdate(),0)";
        try {
            int rs = DataProvider.executeUpdate(sql);
            if(rs>0){
            return true;
        }
        else{
            return false;
        }
    
            
        }catch(Exception e){
        
            e.printStackTrace();
            return false;
        }
     }
       public boolean UpdateHoaDon(String mahd){
       String sql ="UPDATE dbo.HoaDon SET trangthai = 1 where mahd ='"+mahd+"'";
        try {
        int rs = DataProvider.executeUpdate(sql);
        if(rs>0){
        return true;
        }
        else{
        return false;
        }
    
            
    }catch(Exception e){
        
      e.printStackTrace();
      return false;
    }  
   
   }
    
}
