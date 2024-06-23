/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;

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
}
