/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.time.LocalTime;

/**
 *
 * @author DAO
 */
public class LichChieu {
    private int maXuatChieu;
    private Date ngayChieu;
    private LocalTime gioChieu;
    private int maPhim;
    private int maPhong;
    

    public LichChieu() {
    }

    public LichChieu(int maXuatChieu, Date ngayChieu, LocalTime gioChieu, int maPhim, int maPhong) {
        this.maXuatChieu = maXuatChieu;
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
        this.maPhim = maPhim;
        this.maPhong = maPhong;
    }

    public LichChieu(Date ngayChieu, LocalTime gioChieu, int maPhim, int maPhong) {
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
        this.maPhim = maPhim;
        this.maPhong = maPhong;
    }

    public LocalTime getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(LocalTime gioChieu) {
        this.gioChieu = gioChieu;
    }

    public int getMaXuatChieu() {
        return maXuatChieu;
    }

    public void setMaXuatChieu(int maXuatChieu) {
        this.maXuatChieu = maXuatChieu;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }
}
