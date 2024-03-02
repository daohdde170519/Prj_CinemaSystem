/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DAO
 */
import java.sql.Date;

public class Movie {
    private int maPhim;
    private String maLP;
    private String maDP;
    private String tenPhim;
    private String nhaSX;
    private Date ngaySX;

    public Movie() {
    }

    public Movie(String maLP, String maDP, String tenPhim, String nhaSX, Date ngaySX) {
        this.maLP = maLP;
        this.maDP = maDP;
        this.tenPhim = tenPhim;
        this.nhaSX = nhaSX;
        this.ngaySX = ngaySX;
    }
    
    public Movie(int maPhim, String maLP, String maDP, String tenPhim, String nhaSX, Date ngaySX) {
        this.maPhim = maPhim;
        this.maLP = maLP;
        this.maDP = maDP;
        this.tenPhim = tenPhim;
        this.nhaSX = nhaSX;
        this.ngaySX = ngaySX;
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public String getMaLP() {
        return maLP;
    }

    public void setMaLP(String maLP) {
        this.maLP = maLP;
    }

    public String getMaDP() {
        return maDP;
    }

    public void setMaDP(String maDP) {
        this.maDP = maDP;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }
}

