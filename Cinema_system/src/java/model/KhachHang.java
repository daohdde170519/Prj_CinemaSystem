/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAO
 */
public class KhachHang implements Serializable {
    private String maKH;
    private String hoKhachHang;
    private String tenLotKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String diaChi;
    private char GioiTinh;
    private Date ngaySinh;
    private int userId; 

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoKhachHang, String tenLotKhachHang, String tenKhachHang, String soDienThoai, String diaChi, String GioiTinh, Date ngaySinh, int userId) {
        this.maKH = maKH;
        this.hoKhachHang = hoKhachHang;
        this.tenLotKhachHang = tenLotKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.GioiTinh = GioiTinh.charAt(0);
        this.ngaySinh = ngaySinh;
        this.userId = userId;
    }



    // Getters and setters
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoKhachHang() {
        return hoKhachHang;
    }

    public void setHoKhachHang(String hoKhachHang) {
        this.hoKhachHang = hoKhachHang;
    }

    public String getTenLotKhachHang() {
        return tenLotKhachHang;
    }

    public void setTenLotKhachHang(String tenLotKhachHang) {
        this.tenLotKhachHang = tenLotKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
        public String getGender() {
        switch(GioiTinh){
            case 'M': return "Male";
            case 'F': return "Female";
            case 'L' : return "LGBT";
            default: return "Other";
        }
    }
    
public void setGioiTinh(String GioiTinh) {
    if (GioiTinh != null && !GioiTinh.isEmpty()) {
        this.GioiTinh = GioiTinh.charAt(0);
    } else {
        // Handle the case where gender is not provided or is empty
        this.GioiTinh = ' ';
    }
 }

       public String getDob() {
        SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
        return sd.format(ngaySinh);
    }
    
    public java.sql.Date getDateOB(){
        return ngaySinh;
    }
    
    public void setDob(String dob) {
        SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.ngaySinh = new java.sql.Date(sd.parse(dob).getTime());
        } catch (Exception ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid DOB");
        }
    }
}
