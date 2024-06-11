/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.*;
import com.sun.jdi.IntegerType;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Duoc Shin
 */
public class DAO_SanPham {
    public ArrayList<SanPham> getListSP (){
        ArrayList<SanPham> listSP = new ArrayList<>();
        String sql = "Select * From SanPham";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String masp = rs.getString("masp");
              String tensp= rs.getString("tensp");
              String thongso= rs.getString("thongso");
              int gianiemyet= rs.getInt("gianiemyet");
              int giaban= rs.getInt("giaban");
              String math= rs.getString("math");
              String madm= rs.getString("madm");
              String makm= rs.getString("makm");
              String anh= rs.getString("anh");
              SanPham sp = new SanPham(masp, tensp, thongso, gianiemyet,giaban, math, madm, makm, anh);
              listSP.add(sp);
            }
        } catch (Exception e) {
        }
        return listSP;
    
    }
    
    public int getCountSP(){
        int Sl_SanPham=8;
    String sql = "Select COUNT(masp) as slsp From SanPham ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               Sl_SanPham= rs.getInt("slsp");
               
              
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return Sl_SanPham;
    }
   public SanPham getsp(String tensp1){
   String sql = "Select * From SanPham Where tensp ='"+tensp1+"'";
   SanPham result = null;
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String masp = rs.getString("masp");
              String tensp= rs.getString("tensp");
              String thongso= rs.getString("thongso");
              int gianiemyet= rs.getInt("gianiemyet");
              int giaban= rs.getInt("giaban");
              String math= rs.getString("math");
              String madm= rs.getString("madm");
              String makm= rs.getString("makm");
              String anh= rs.getString("anh");
              result = new SanPham(masp, tensp, thongso, gianiemyet,giaban, math, madm, makm, anh);
                
            }
        }catch (Exception e)
        {
              e.printStackTrace();
        }
        
        return  result;
   }
   
   public ArrayList<SanPham> getSPTK (String tensptk){
      ArrayList<SanPham> listSP = new ArrayList<>();
        String sql = "Select * From SanPham Where tensp like '"+tensptk+"%' ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String masp = rs.getString("masp");
              String tensp= rs.getString("tensp");
              String thongso= rs.getString("thongso");
              int gianiemyet= rs.getInt("gianiemyet");
              int giaban= rs.getInt("giaban");
              String math= rs.getString("math");
              String madm= rs.getString("madm");
              String makm= rs.getString("makm");
              String anh= rs.getString("anh");
              SanPham sp = new SanPham(masp, tensp, thongso, gianiemyet,giaban, math, madm, makm, anh);
              listSP.add(sp);
            }
        } catch (Exception e) {
        }
        return listSP;
   }
   
   public ArrayList<SanPham> getSPCbb (String danhmuc, String thuonghieu){
    
    ArrayList<SanPham> listSP = new ArrayList<>();
    
        String sql = "Select * From SanPham Where madm ='"+danhmuc+"' and math = '"+thuonghieu+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String masp = rs.getString("masp");
              String tensp= rs.getString("tensp");
              String thongso= rs.getString("thongso");
              int gianiemyet= rs.getInt("gianiemyet");
              int giaban= rs.getInt("giaban");
              String math= rs.getString("math");
              String madm= rs.getString("madm");
              String makm= rs.getString("makm");
              String anh= rs.getString("anh");
              SanPham sp = new SanPham(masp, tensp, thongso, gianiemyet,giaban, math, madm, makm, anh);
              listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return listSP;
   }
    
}
