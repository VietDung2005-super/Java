package com.lab2.sinhvien;

/**
 * Class SinhVien - luu tru thong tin va diem cua mot sinh vien.
 * Ung voi chuc nang "Nhap du lieu" va "Tinh diem tong ket" trong dac ta.
 */
public class SinhVien {

    private String maSV;
    private String hoTen;
    private double diemChuyenCan;
    private double diemGiuaKy;
    private double diemCuoiKy;
    private double diemTongKet;
    private String xepLoai;

    // Trong so tinh diem tong ket theo dac ta
    private static final double TRONG_SO_CHUYEN_CAN = 0.1;
    private static final double TRONG_SO_GIUA_KY = 0.3;
    private static final double TRONG_SO_CUOI_KY = 0.6;

    public SinhVien(String maSV, String hoTen, double diemChuyenCan,
                     double diemGiuaKy, double diemCuoiKy) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemChuyenCan = diemChuyenCan;
        this.diemGiuaKy = diemGiuaKy;
        this.diemCuoiKy = diemCuoiKy;
        tinhDiemTongKet();
        xepLoaiHocLuc();
    }

    /**
     * Chuc nang "Tinh diem tong ket":
     * Diem tong ket = chuyen can x 10% + giua ky x 30% + cuoi ky x 60%
     */
    private void tinhDiemTongKet() {
        double tong = diemChuyenCan * TRONG_SO_CHUYEN_CAN
                    + diemGiuaKy * TRONG_SO_GIUA_KY
                    + diemCuoiKy * TRONG_SO_CUOI_KY;
        // Lam tron den 1 chu so thap phan, giong vi du 8.3
        this.diemTongKet = Math.round(tong * 10.0) / 10.0;
    }

    /**
     * Chuc nang "Xep loai":
     * A: tu 8.5 | B: tu 7.0 | C: tu 5.5 | D: tu 4.0 | F: duoi 4.0
     */
    private void xepLoaiHocLuc() {
        if (diemTongKet >= 8.5) {
            xepLoai = "A";
        } else if (diemTongKet >= 7.0) {
            xepLoai = "B";
        } else if (diemTongKet >= 5.5) {
            xepLoai = "C";
        } else if (diemTongKet >= 4.0) {
            xepLoai = "D";
        } else {
            xepLoai = "F";
        }
    }

    // ===== Getters =====
    public String getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public double getDiemChuyenCan() { return diemChuyenCan; }
    public double getDiemGiuaKy() { return diemGiuaKy; }
    public double getDiemCuoiKy() { return diemCuoiKy; }
    public double getDiemTongKet() { return diemTongKet; }
    public String getXepLoai() { return xepLoai; }

    /**
     * Chuc nang "Hien thi ket qua":
     * Vi du dinh dang: SV001 - Nguyen Van A - 8.30 - B
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %.2f - %s", maSV, hoTen, diemTongKet, xepLoai);
    }
}
