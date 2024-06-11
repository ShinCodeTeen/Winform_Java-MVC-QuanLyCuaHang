/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DM_SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Duoc Shin
 */
public class DAO_DM_SanPham {
        public String getTenDM(String madm){
        
        String result = null;
        String sql = "Select * From DM_SanPham Where madm = '"+madm+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              result = rs.getString("tendm");
              }
        }catch (Exception e) {
               e.printStackTrace();
        }
        return result;
        }
        
        public ArrayList<DM_SanPham> List_DM (){
        
        ArrayList<DM_SanPham> result = new ArrayList<DM_SanPham>();
        String sql = "Select * From DM_SanPham ";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              String madm = rs.getString("madm");
              String tendm = rs.getString("tendm");
              DM_SanPham dm = new DM_SanPham(madm, tendm);
              result.add(dm);
              }
        }catch (Exception e) {   
            e.printStackTrace();
        }
        return result;
        }
        
         public String getMadm(String tendm){
        
        String result = null;
        String sql = "Select * From DM_SanPham Where tendm = N'"+tendm+"'";
        try {
            ResultSet rs = DataProvider.executeQuery(sql);
            while(rs.next()){
              result = rs.getString("madm");
              }
        }catch (Exception e) {
               e.printStackTrace();
        }
        return result;
        }
}
