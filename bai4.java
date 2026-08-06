import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap canh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap canh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap canh c: ");
        double c = scanner.nextDouble();

        if (!laTamGiac(a, b, c)) {
            System.out.println("a, b, c khong tao thanh tam giac.");
        } else {
            System.out.println("a, b, c tao thanh tam giac.");
            System.out.println("Loai tam giac: " + phanLoaiTamGiac(a, b, c));
        }

        scanner.close();
    }

    public static boolean laTamGiac(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0
                && a + b > c
                && a + c > b
                && b + c > a;
    }

    public static String phanLoaiTamGiac(double a, double b, double c) {
        boolean vuong = kiemTraVuong(a, b, c);
        boolean deu = (a == b) && (b == c);
        boolean can = (a == b) || (b == c) || (a == c);

        if (deu) {
            return "Tam giac deu";
        }
        if (vuong && can) {
            return "Tam giac vuong can";
        }
        if (vuong) {
            return "Tam giac vuong";
        }
        if (can) {
            return "Tam giac can";
        }
        return "Tam giac thuong";
    }

    public static boolean kiemTraVuong(double a, double b, double c) {
        double max = Math.max(a, Math.max(b, c));
        double sumSqOther = a * a + b * b + c * c - max * max;
        return Math.abs(max * max - sumSqOther) < 1e-9;
    }
}