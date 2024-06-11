/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.sql.*;
/**
 *
 * @author Duoc Shin
 */
public class DM_SanPham {
    public String madm;
    public String tendm;

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }

    public DM_SanPham(String madm, String tendm) {
        this.madm = madm;
        this.tendm = tendm;
    }
  
}
