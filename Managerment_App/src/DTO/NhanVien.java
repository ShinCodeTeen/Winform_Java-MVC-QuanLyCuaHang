/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duoc Shin
 */
public class NhanVien {
    public String manv;
    public String tennv;
    public String sdt;
    public String diachi;
    public String macv;
    public String ngayvao;

    public NhanVien(String manv, String tennv, String sdt, String diachi, String chucvu, String ngayvao) {
        this.manv = manv;
        this.tennv = tennv;
        this.sdt = sdt;
        this.diachi = diachi;
        this.macv = chucvu;
        this.ngayvao = ngayvao;
    }
//    

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getNgayvao() {
        return ngayvao;
    }

    public void setNgayvao(String ngayvao) {
        this.ngayvao = ngayvao;
    }
    
}
