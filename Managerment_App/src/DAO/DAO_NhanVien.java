/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChucVu;
import DTO.NhanVien;
import DTO.SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duoc Shin
 */
public class DAO_NhanVien {
     public ArrayList<NhanVien> getListNV (){
        ArrayList<NhanVien> listNV = new ArrayList<>();
        String sql = "Select * From NhanVien";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String manv = rs.getString("manv");
              String tensp= rs.getString("tennv");
              String macv= rs.getString("macv");
              String diachi= rs.getString("diachi");
              String sdt= rs.getString("sdt");
              String ngayvao= rs.getString("ngayvaolam");
             
              
      
              NhanVien nv = new NhanVien(manv, tensp, sdt, diachi, macv, ngayvao);
              listNV.add(nv);
            }
        } catch (Exception e) {
        }
        return listNV;
    
    }
     public ArrayList<ChucVu> List_CV (){
        
        ArrayList<ChucVu> result = new ArrayList<ChucVu>();
        String sql = "Select * From ChucVu ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String macv = rs.getString("machucvu");
              String tencv = rs.getString("tencv");
              ChucVu dm = new ChucVu(macv, tencv);
              result.add(dm);
              }
        }catch (Exception e) {   
            e.printStackTrace();
        }
        return result;
        }
     
     public String getChucvu(String macv){
        String chucvu = "";
    String sql = "Select tencv  From ChucVu Where machucvu = '"+macv+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               chucvu= rs.getString("tencv");
               
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return chucvu;
    }
      public String getMaChucvu(String cv){
        String macv = "";
        String sql = "Select machucvu  From ChucVu Where tencv = N'"+cv+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               macv= rs.getString("machucvu");
               
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return macv;
    }
       public NhanVien getnv(String tennv1){
   String sql = "Select * From NhanVien Where tennv =N'"+tennv1+"'";
   NhanVien result = null;
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String manv = rs.getString("manv");
              String tennv= rs.getString("tennv");
              String macv= rs.getString("macv");
             
              String diachi= rs.getString("diachi");
              String sdt= rs.getString("sdt");
              String ngayvaolam= rs.getString("ngayvaolam");
        
              result = new NhanVien(manv, tennv, sdt, diachi, macv, ngayvaolam);
                
            }
        }catch (Exception e)
        {
              e.printStackTrace();
        }
        
        return  result;
   }
       
     public ArrayList<NhanVien> getNVTK (String tennvtk){
      ArrayList<NhanVien> listNV = new ArrayList<>();
        String sql = "Select * From NhanVien Where tennv like N'%"+tennvtk+"%' ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
            String manv = rs.getString("manv");
              String tensp= rs.getString("tennv");
              String macv= rs.getString("macv");
              String diachi= rs.getString("diachi");
              String sdt= rs.getString("sdt");
              String ngayvao= rs.getString("ngayvaolam");
             
    
              NhanVien nv = new NhanVien(manv, tensp, sdt, diachi, macv, ngayvao);
              listNV.add(nv);
            }
        } catch (Exception e) {
        }
        return listNV;
   }
      public boolean insertNV(String manv,String tennv,String diachi,String sdt,String macv){
        String sql = "insert into NhanVien (manv,tennv,macv,diachi,sdt,ngayvaolam) Values ('"+manv+"',N'"+tennv+"','"+macv+"',N'"+diachi+"','"+sdt+"',GetDate())";
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
       public boolean UpdateNhanVien(String manv,String tennv, String diachi, String sdt,String macv){
       String sql ="UPDATE dbo.NhanVien SET tennv = N'"+tennv+"' ,macv = '"+macv+"' , diachi = N'"+diachi+"', sdt= '"+sdt+"' where manv ='"+manv+"'";
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
       public boolean DeleteNhanvien(String manv){
       String sql ="DELETE dbo.NhanVien  where manv ='"+manv+"'";
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
       
    public String getTenNV(String manv){
        String tennv = "";
        String sql = "Select tennv  From NhanVien Where manv = '"+manv+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               tennv= rs.getString("tennv");
               
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return tennv;
    }
}
