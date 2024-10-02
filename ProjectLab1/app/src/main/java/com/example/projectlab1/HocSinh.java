package com.example.projectlab1;

public class HocSinh {
    String hoTen;
    String soDienThoai;
    String gioiTinh;
    String queQuan;

    public HocSinh(String hoTen, String soDienThoai, String gioiTinh, String queQuan) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
    }

    @Override
    public String toString() {
        return hoTen + " - " + gioiTinh + " - " + soDienThoai + " - " + queQuan;
    }
}
