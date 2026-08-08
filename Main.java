package com.lab2.sinhvien;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<String[]> ds = new ArrayList<>(); 
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Nhap SV | 2. Hien thi | 0. Thoat");
            int chon = Integer.parseInt(sc.nextLine().trim());
            if (chon == 1) nhapSV();
            else if (chon == 2) hienThi();
            else if (chon == 0) break;
        }
    }

    static void nhapSV() {
        System.out.print("Ma SV: "); String ma = sc.nextLine();
        System.out.print("Ho ten: "); String ten = sc.nextLine();
        double cc = nhapDiem("Chuyen can: ");
        double gk = nhapDiem("Giua ky: ");
        double ck = nhapDiem("Cuoi ky: ");

        double tk = cc * 0.1 + gk * 0.3 + ck * 0.6;
        String xl = xepLoai(tk);

        ds.add(new String[]{ma, ten, String.valueOf(cc), String.valueOf(gk),
                String.valueOf(ck), String.format("%.2f", tk), xl});
        System.out.printf("=> %s - %s - %.2f - %s%n", ma, ten, tk, xl);
    }

    static double nhapDiem(String msg) {
        while (true) {
            System.out.print(msg);
            double d = Double.parseDouble(sc.nextLine().trim());
            if (d >= 0 && d <= 10) return d;
            System.out.println("Diem phai trong khoang 0-10, nhap lai!");
        }
    }

    static String xepLoai(double d) {
        if (d >= 8.5) return "A";
        if (d >= 7.0) return "B";
        if (d >= 5.5) return "C";
        if (d >= 4.0) return "D";
        return "F";
    }

    static void hienThi() {
        System.out.printf("%-8s%-20s%-6s%-6s%-6s%-8s%-6s%n",
                "MaSV", "HoTen", "CC", "GK", "CK", "TongKet", "XepLoai");
        for (String[] sv : ds)
            System.out.printf("%-8s%-20s%-6s%-6s%-6s%-8s%-6s%n",
                    sv[0], sv[1], sv[2], sv[3], sv[4], sv[5], sv[6]);
    }
}