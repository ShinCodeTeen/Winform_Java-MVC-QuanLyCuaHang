/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import DTO.DonHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Duoc Shin
 */
public class DAO_DonHang {
    public ArrayList<DonHang> get_BillInfo(String mahd){
     ArrayList<DonHang> dh = new ArrayList<>();
       try {
         String query = "SELECT * FROM dbo.DonHang Where mahd ='"+mahd +"'";
            ResultSet result = DataProvider.executeQuery(query);
          
            while(result.next()){
                String masp = result.getString("masp");
                int sl = result.getInt("sl");
                DonHang newdh = new DonHang(mahd, masp, sl);
                dh.add(newdh);
            }
           
        } catch (SQLException e) {
               e.printStackTrace();
        }
       return dh;
    }
      public boolean insertDH(String mahd,String masp,int sl){
        String sql = "insert into DonHang (mahd,masp,sl) Values ('"+mahd+"','"+masp+"',"+sl+")";
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
      public boolean DeleteDonHang(String mahd){
       String sql ="DELETE dbo.DonHang  where mahd ='"+mahd+"'";
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
