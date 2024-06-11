/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duoc Shin
 */
public class SanPham {
    public String masp;
    public String tensp;
    public String thongso;
    public int gianiemyet;
    public int giaban;


    public String math;
    public String madm;
    public String makm;
    public String anh;

    public SanPham(String masp, String tensp, String thongso, int gianiemyet,int giaban, String math, String madm, String makm, String anh) {
        this.masp = masp;
        this.tensp = tensp;
        this.thongso = thongso;
        this.gianiemyet = gianiemyet;
        this.giaban = giaban;
        this.math = math;
        this.madm = madm;
        this.makm = makm;
        this.anh = anh;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getThongso() {
        return thongso;
    }

    public void setThongso(String thongso) {
        this.thongso = thongso;
    }

    public int getGianiemyet() {
        return gianiemyet;
    }

    public void setGianiemyet(int gianiemyet) {
        this.gianiemyet = gianiemyet;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }
}
