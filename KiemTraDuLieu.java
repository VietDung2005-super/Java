package com.lab2.sinhvien;


public class KiemTraDuLieu {

    public static final double DIEM_MIN = 0.0;
    public static final double DIEM_MAX = 10.0;

    public static boolean laDiemHopLe(double diem) {
        return diem >= DIEM_MIN && diem <= DIEM_MAX;
    }


    public static boolean laMaSVHopLe(String maSV) {
        return maSV != null && !maSV.trim().isEmpty();
    }

    public static boolean laHoTenHopLe(String hoTen) {
        return hoTen != null && !hoTen.trim().isEmpty();
    }
}
