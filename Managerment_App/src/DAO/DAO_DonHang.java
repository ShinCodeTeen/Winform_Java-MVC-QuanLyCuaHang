/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import DTO.DonHang;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Duoc Shin
 */
public class DAO_DonHang {
    public DonHang get_BillInfo(String mahd){
     DonHang dh = null;
       try {
         String query = "SELECT * FROM dbo.DonHang Where mahd ='"+mahd +"'";
            ResultSet result = DataProvider.executeQuery(query);
          
            while(result.next()){
                String masp = result.getString("masp");
                int sl = result.getInt("sl");
                dh = new DonHang(mahd, masp, sl);
                
            }
           
        } catch (SQLException e) {
               e.printStackTrace();
        }
       return dh;
    }
}
