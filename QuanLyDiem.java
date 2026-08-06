import java.util.Scanner;

public class QuanLyDiem {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String maSV = nhapChuoi("Nhap ma sinh vien: ");
        String hoTen = nhapChuoi("Nhap ho ten: ");
        double diemChuyenCan = nhapDiemHopLe("Nhap diem chuyen can (0-10): ");
        double diemGiuaKy = nhapDiemHopLe("Nhap diem giua ky (0-10): ");
        double diemCuoiKy = nhapDiemHopLe("Nhap diem cuoi ky (0-10): ");

        double diemTongKet = tinhDiemTongKet(diemChuyenCan, diemGiuaKy, diemCuoiKy);
        String xepLoai = xepLoai(diemTongKet);

        hienThiKetQua(maSV, hoTen, diemTongKet, xepLoai);

        scanner.close();
    }

    public static String nhapChuoi(String thongBao) {
        System.out.print(thongBao);
        return scanner.nextLine();
    }

    public static double nhapDiemHopLe(String thongBao) {
        double diem;
        while (true) {
            System.out.print(thongBao);
            diem = scanner.nextDouble();
            scanner.nextLine();
            if (diem < 0 || diem > 10) {
                System.out.println("Diem khong hop le. Vui long nhap lai (0-10).");
            } else {
                break;
            }
        }
        return diem;
    }

    public static double tinhDiemTongKet(double chuyenCan, double giuaKy, double cuoiKy) {
        return chuyenCan * 0.1 + giuaKy * 0.3 + cuoiKy * 0.6;
    }

    public static String xepLoai(double diemTongKet) {
        if (diemTongKet >= 8.5) {
            return "A";
        } else if (diemTongKet >= 7.0) {
            return "B";
        } else if (diemTongKet >= 5.5) {
            return "C";
        } else if (diemTongKet >= 4.0) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void hienThiKetQua(String maSV, String hoTen, double diemTongKet, String xepLoai) {
        System.out.println();
        System.out.println("KET QUA:");
        System.out.printf("%s - %s - %.2f - %s%n", maSV, hoTen, diemTongKet, xepLoai);
    }
}