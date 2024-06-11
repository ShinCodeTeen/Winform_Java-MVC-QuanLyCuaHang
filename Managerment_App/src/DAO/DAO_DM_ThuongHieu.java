/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DM_SanPham;
import DTO.DM_ThuongHieu;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duoc Shin
 */
public class DAO_DM_ThuongHieu {
    public String getTenTH(String math){
        
        String result = null;
        String sql = "Select * From DM_ThuongHieu Where madm = '"+math+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              result = rs.getString("tenth");
              }
        }catch (Exception e) {
        }
        return result;
        }
    
     public int getSoTH(){
        int Sl_SanPham=0;
    String sql = "Select COUNT(math) as slth From DM_ThuongHieu ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
               Sl_SanPham= rs.getInt("slth");
               
              
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return Sl_SanPham;
    }
     
    public ArrayList<DM_ThuongHieu> List_TH (){
        
        ArrayList<DM_ThuongHieu> result = new ArrayList<>();
        String sql = "Select * From DM_ThuongHieu ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String math = rs.getString("math");
              String tenth = rs.getString("tenth");
              String madm = rs.getString("madm");
              DM_ThuongHieu dm = new DM_ThuongHieu(math, tenth,madm);
              result.add(dm);
              }
        }catch (Exception e) {
               e.printStackTrace();
        }
        return result;
        }
    
    public String getMath(String tenth){
    String result = null;
        String sql = "Select * From DM_ThuongHieu Where tenth = N'"+tenth+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              result = rs.getString("math");
              }
        }catch (Exception e) {
        }
        return result;
    }
}
