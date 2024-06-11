/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.Account;
import java.sql.*;

/**
 *
 * @author Duoc Shin
 */
public class DAO_Account {
    public boolean Login(String username, String password){
        int rows=0;
        try {
         String query = "SELECT * FROM dbo.Account Where username = '"+username+"' and password ='"+password+"'";
            ResultSet result = DataProvider.executeQuery(query);
          
            while(result.next()){
            rows++;
            }
           
        } catch (SQLException e) {
               e.printStackTrace();
        }
         if(rows>0) return true;
            else return false;
        }
   public Account getAccount(String username, String password){
       Account AC_Login = null;
       try {
         String query = "SELECT * FROM dbo.Account Where username = '"+username+"' and password ='"+password+"'";
            ResultSet result = DataProvider.executeQuery(query);
          
            while(result.next()){
                String AC_username = result.getString("username");
                String AC_password = result.getString("password");
                String AC_manv = result.getString("manv");
                String AC_ten = result.getString("ten");
                String AC_chucvu = result.getString("chucvu");
                int AC_type = result.getInt("type");
                AC_Login = new Account(username, password, AC_ten, AC_manv, AC_chucvu, AC_type);
            }
           
        } catch (SQLException e) {
               e.printStackTrace();
        }
       return AC_Login;
   }
          
     
    
}
