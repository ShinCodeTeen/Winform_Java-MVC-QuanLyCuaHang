/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHang;
import DTO.SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duoc Shin
 */
public class DAO_KhachHang {
    public int Sl_KH(){
    int Sl_KH=0;
    String sql = "Select COUNT(makh) as slkh From KhachHang Where loai<>-1 ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               Sl_KH= rs.getInt("slkh");
               
              
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return Sl_KH;
    }
    
    public ArrayList<KhachHang> List_KH(){
    ArrayList<KhachHang> listKH = new ArrayList<>();
        String sql = "Select * From KhachHang";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String makh = rs.getString("makh");
              String tenkh= rs.getString("tenkh");
              String sdt= rs.getString("sdt");
           
              String diachi= rs.getString("diachi");
              int type = rs.getInt("loai");
            
              KhachHang kh = new KhachHang(makh, tenkh, sdt, diachi, type);
              listKH.add(kh);
            }
        } catch (Exception e) {
        }
        return listKH;
    
    }
    
    public KhachHang getKH(String makhtk){
        KhachHang kh = null;
     String sql = "Select * From KhachHang where makh ='"+makhtk+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String makh = rs.getString("makh");
              String tenkh= rs.getString("tenkh");
              String sdt= rs.getString("sdt");
           
              String diachi= rs.getString("diachi");
              int type = rs.getInt("loai");
            
             kh = new KhachHang(makh, tenkh, sdt, diachi, type);
              
            }
        } catch (Exception e) {
        }
        return kh;
    }
    
    public int sodonhuy(String makh){
        int sodonhuy=0;
        String sql = "Select COUNT(mahd) as donhuy FROM HoaDon hd JOIN KhachHang kh on hd.makh = kh.makh AND hd.trangthai = -1 And hd.makh = '"+makh+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
                sodonhuy = rs.getInt("donhuy");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sodonhuy;
    }
    public int sodonchuatt(String makh){
        int sodonchuatt=0;
        String sql = "Select COUNT(mahd) as donchuatt FROM HoaDon hd JOIN KhachHang kh on hd.makh = kh.makh AND hd.trangthai = 0 And hd.makh = '"+makh+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
                sodonchuatt = rs.getInt("donchuatt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sodonchuatt;
    }
     public int sodonmua(String makh){
        int sodonmua=0;
        String sql = "Select COUNT(mahd) as donchuatt FROM HoaDon hd JOIN KhachHang kh on hd.makh = kh.makh AND hd.trangthai = 1 And hd.makh = '"+makh+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
                sodonmua = rs.getInt("donchuatt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sodonmua;
    }
     public boolean insertKH(String makh,String tenkh,String diachi,String sdt){
        String sql = "insert into KhachHang (makh,tenkh,diachi,sdt,loai) Values ('"+makh+"',N'"+tenkh+"',N'"+diachi+"','"+sdt+"',0)";
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
       public boolean UpdateKhachHang(String makh,String tenkh, String diachi, String sdt){
       String sql ="UPDATE dbo.KhachHang SET tenkh = N'"+tenkh+"' , diachi = N'"+diachi+"', sdt= '"+sdt+"' where makh ='"+makh+"'";
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
       public boolean DeleteKhachHang(String makh){
       String sql ="DELETE dbo.KhachHang  where makh ='"+makh+"'";
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
   public ArrayList<KhachHang> getKHTK (String khtk){
      ArrayList<KhachHang> listKH = new ArrayList<>();
        String sql = "Select * From KhachHang Where tenkh like N'%"+khtk+"%' or sdt like '%"+khtk+"%' ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String makh = rs.getString("makh");
              String tenkh= rs.getString("tenkh");
              String sdt= rs.getString("sdt");
           
              String diachi= rs.getString("diachi");
              int type = rs.getInt("loai");
            
              KhachHang kh = new KhachHang(makh, tenkh, sdt, diachi, type);
              listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
   }
     public String getTenKH(String makh){
        String ten = null;
     String sql = "Select * From KhachHang where makh ='"+makh+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              
              ten= rs.getString("tenkh");
              
    
              
            }
        } catch (Exception e) {
        }
        return ten;
    }
     public String getMaKH(String tenkh){
        String ma = null;
     String sql = "Select makh From KhachHang where tenkh =N'"+tenkh+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              
              ma= rs.getString("makh");
              
    
              
            }
        } catch (Exception e) {
        }
        return ma;
    }
}
