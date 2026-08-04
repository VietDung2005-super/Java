import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n nguyen duong: ");
        int n = scanner.nextInt();

        while (n <= 0) {
            System.out.print("n phai la so nguyen duong. Nhap lai n: ");
            n = scanner.nextInt();
        }

        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += 1.0 / i;
        }

        System.out.println("Tong s = " + s);

        scanner.close();
    }
}