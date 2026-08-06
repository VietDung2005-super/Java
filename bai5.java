import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n nguyen duong: ");
        int n = scanner.nextInt();

        while (n <= 0) {
            System.out.print("n phai la so nguyen duong. Nhap lai n: ");
            n = scanner.nextInt();
        }

        long truoc = 0, sau = 1;
        StringBuilder ketQua = new StringBuilder();

        for (int i = 0; i < n; i++) {
            ketQua.append(truoc);
            if (i < n - 1) {
                ketQua.append(" ");
            }
            long tiep = truoc + sau;
            truoc = sau;
            sau = tiep;
        }

        System.out.println("Day Fibonacci gom " + n + " so dau tien:");
        System.out.println(ketQua.toString());

        scanner.close();
    }
}