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
              String makh = rs.getString("masp");
              String tenkh= rs.getString("tensp");
              String sdt= rs.getString("thongso");
           
              String diachi= rs.getString("math");
              int type = rs.getInt("type");
            
              KhachHang kh = new KhachHang(makh, tenkh, sdt, diachi, type);
              listKH.add(kh);
            }
        } catch (Exception e) {
        }
        return listKH;
    
    }
}
